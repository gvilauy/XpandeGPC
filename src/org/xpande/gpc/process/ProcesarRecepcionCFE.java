package org.xpande.gpc.process;

import com.sun.mail.imap.IMAPStore;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_2.AttachedDocumentType;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MEMailConfig;
import org.compiere.process.SvrProcess;
import org.xpande.gpc.model.MZGPCCFEConfig;
import org.xpande.gpc.model.MZGPCCFEConfigBP;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 2/15/21.
 */
public class ProcesarRecepcionCFE extends SvrProcess {

    private MZGPCCFEConfig mzgpccfeConfig = null;

    @Override
    protected void prepare() {
    }

    @Override
    protected String doIt() throws Exception {

        try{

            this.mzgpccfeConfig = MZGPCCFEConfig.getDefault(getCtx(), null);

            // Leer emails, obtener archivos xmls y procesarlos
            String message = this.getEmails();
            if (message != null){
                return "@Error@ " + message;
            }

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return "OK";
    }

    /***
     * Lee bandeja de mails y procesa los archivos adjuntos.
     * Luego mueve los emails a una carpeta de backup en el servidor de correo.
     * Xpande. Created by Gabriel Vila on 11/2/20.
     * @return
     */
    private String getEmails(){

        String resultado = null;

        try{
            MEMailConfig eMailConfig = (MEMailConfig) this.mzgpccfeConfig.getAD_EMailConfig();

            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            Session emailSession = Session.getDefaultInstance(properties, null);

            // Recorro casillas de email de los socios de negocio configurados
            List<MZGPCCFEConfigBP> configBPList = this.mzgpccfeConfig.getConfigBPartners();
            for (MZGPCCFEConfigBP configBP: configBPList){

                IMAPStore emailStore = (IMAPStore) emailSession.getStore("imaps");
                emailStore.connect(eMailConfig.getSMTPHost(), configBP.getEMailRecipient(), configBP.getEMailUserPW());

                //3) create the folder object and open it
                Folder emailFolder = emailStore.getFolder("INBOX");
                emailFolder.open(Folder.READ_WRITE);

                String backupFolderName = "Backup";
                Folder backupFolder = emailFolder.getFolder(backupFolderName);
                if ((backupFolder == null) || (!backupFolder.exists())){
                    backupFolder = emailStore.getFolder(backupFolderName);
                    if ((backupFolder == null) || (!backupFolder.exists())){
                        if (backupFolder.create(Folder.HOLDS_MESSAGES)) {
                            backupFolder.setSubscribed(true);
                            System.out.println("Folder was created successfully");
                        }
                    }
                }

                String errorFolderName = "Errores";
                Folder errorFolder = emailFolder.getFolder(errorFolderName);
                if ((errorFolder == null) || (!errorFolder.exists())){
                    errorFolder = emailStore.getFolder(errorFolderName);
                    if ((errorFolder == null) || (!errorFolder.exists())){
                        if (errorFolder.create(Folder.HOLDS_MESSAGES)) {
                            errorFolder.setSubscribed(true);
                            System.out.println("Folder was created successfully");
                        }
                    }
                }

                // Arraylist para ir guardando los mensajes correctos de los incorrectos
                List<Message> messagesProcessedList = new ArrayList<Message>();
                List<Message> messagesErrorsList = new ArrayList<Message>();

                // Obtengo mensajes del folder Inbox
                Message[] messages = emailFolder.getMessages();
                for (int i = 0; i < messages.length; i++) {

                    Message message = messages[i];

                    System.out.println("Mensaje " + i + " de " + messages.length);

                    String contentType = message.getContentType();

                    // Si el mensaje contiene multi-partes, es porque puede tener adjuntos
                    if (contentType.contains("multipart")) {
                        Multipart multiPart = (Multipart) message.getContent();

                        int numberOfParts = multiPart.getCount();

                        for (int partCount = 0; partCount < numberOfParts; partCount++) {
                            MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);

                            // Si esta parte leida es un adjunto
                            if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {

                                String property = "java.io.tmpdir";
                                String tempDir = System.getProperty(property);

                                String fileName = part.getFileName();
                                String filePathName = tempDir + fileName;

                                part.saveFile(filePathName);

                                if (fileName.endsWith(".zip")){

                                    ZipInputStream zip = new ZipInputStream(new FileInputStream(filePathName));
                                    ZipEntry entry;

                                    while (null != (entry=zip.getNextEntry()) ){
                                        System.out.println(entry.getName());

                                        String xmlFilePathName = "/tmp/" + entry.getName().trim();

                                        if (entry.getName().endsWith(".xml")){
                                            System.out.println("Encontramos un archivo .xml");
                                            FileOutputStream fos = new FileOutputStream(xmlFilePathName);
                                            int leido;
                                            byte [] buffer = new byte[1024];
                                            while (0<(leido=zip.read(buffer))){
                                                fos.write(buffer,0,leido);
                                            }
                                            fos.close();

                                            this.getXMLInfo(xmlFilePathName, configBP, filePathName);
                                        }
                                        zip.closeEntry();
                                    }

                                }
                                else if (fileName.endsWith(".xml")){
                                    this.getXMLInfo(filePathName, configBP, null);
                                }
                            }
                        }
                    }
                    messagesProcessedList.add(message);
                }

                // Copio mensajes procesados a folder de backup
                Message[] arrMessProcessed = new Message[]{};
                arrMessProcessed = messagesProcessedList.toArray(arrMessProcessed);
                emailFolder.copyMessages(arrMessProcessed, backupFolder);

                // Copio mensajes no procesados a folder de errores
                Message[] arrMessErrors = new Message[]{};
                arrMessErrors = messagesErrorsList.toArray(arrMessErrors);
                emailFolder.copyMessages(arrMessErrors, errorFolder);

                //5) close the store and folder objects
                if (emailFolder.isOpen()){
                    emailFolder.close(true);
                }
                if (backupFolder.isOpen()){
                    backupFolder.close(true);
                }
                if (errorFolder.isOpen()){
                    errorFolder.close(true);
                }

                /*
                // Abro de nuevo inbox y borro los mensajes
                emailFolder.open(Folder.READ_WRITE);
                for (int i = 0; i < messages.length; i++) {
                    Message message = messages[i];
                    message.setFlag(Flags.Flag.DELETED, true);
                }
                emailFolder.close(true);
                */

                emailStore.close();
            }

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return null;
    }

    /***
     * Valida archivo xml contra schema de la DIAN (xsd).
     * Copia archivo en carpeta destino según sea válido o no.
     * Xpande. Created by Gabriel Vila on 2/18/21.
     * @param xmlFileName
     * @param configBP
     * @param zipFileName
     */
    private void getXMLInfo(String xmlFileName, MZGPCCFEConfigBP configBP, String zipFileName){

        try{

            File fileCFEXml = new File(xmlFileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(AttachedDocumentType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Abro xml contra schema de la DIAN para saber si es válido o no.
            boolean archivoValido = true;
            try{
                AttachedDocumentType attachedDocumentType = (AttachedDocumentType) jaxbUnmarshaller.unmarshal(fileCFEXml);
            }
            catch (Exception e){
                archivoValido = false;
            }

            // Carpeta destino según sea válido o no.
            String pathDestino = configBP.getFolderOk();
            if (!archivoValido){
                pathDestino = configBP.getFolderError();
            }

            // Archivo destino xml o zip
            File archivoDestino = fileCFEXml;
            if (zipFileName != null){
                archivoDestino = new File((zipFileName));
            }

            // Copio archivo destino en carpeta destino
            Path sourcePath = Paths.get(archivoDestino.getPath());
            Path targetPath = Paths.get(pathDestino + archivoDestino.getName());
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }
    }

}
