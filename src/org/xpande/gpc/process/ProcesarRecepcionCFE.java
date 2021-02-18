package org.xpande.gpc.process;

import com.sun.mail.imap.IMAPStore;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_2.AttachedDocumentType;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MEMailConfig;
import org.compiere.process.SvrProcess;
import org.xpande.gpc.model.MZGPCCFEConfig;
import org.xpande.gpc.model.MZGPCCFEConfigBP;
import uy.gub.dgi.cfe.EnvioCFEEntreEmpresas;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
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
                                //String filePathName = "C:\\Adempiere\\emails\\" + fileName;
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

                                            this.getXMLInfo(xmlFilePathName);
                                        }
                                        zip.closeEntry();
                                    }

                                }
                                else if (fileName.endsWith(".xml")){

                                    this.getXMLInfo(filePathName);
                                }



                                /*
                                File fileAdjunto = new File("C:\\Adempiere\\emails\\" + fileName);

                                Path sourcePath = Paths.get("C:\\Adempiere\\emails\\" + fileName);
                                //Path targetPath = Paths.get("C:\\Adempiere\\emails\\dest\\" + fileName);
                                Path targetPath = Paths.get(attachConfRem.getFolder().trim() + fileName);

                                try{
                                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                                    messagesProcessedList.add(message);
                                }
                                catch (Exception e){
                                    messagesErrorsList.add(message);
                                }
                                */
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


    private void getXMLInfo(String xmlFileName){

        try{

            File fileCFEXml = new File(xmlFileName);

            //OutputStream out = new FileOutputStream(fileCFEXml);
            //out.close();

            JAXBContext jaxbContext = JAXBContext.newInstance(AttachedDocumentType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            AttachedDocumentType attachedDocumentType = (AttachedDocumentType) jaxbUnmarshaller.unmarshal(fileCFEXml);

            System.out.println("Vamossss");

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }
    }

}
