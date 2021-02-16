package org.xpande.gpc.process;

import com.sun.mail.imap.IMAPStore;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MEMailConfig;
import org.compiere.process.SvrProcess;
import org.xpande.gpc.model.MZGPCCFEConfig;
import org.xpande.gpc.model.MZGPCCFEConfigBP;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
                emailStore.connect(eMailConfig.getSMTPHost(), configBP.getEMail(), configBP.getEMailUserPW());

                //3) create the folder object and open it
                Folder emailFolder = emailStore.getFolder("INBOX");
                emailFolder.open(Folder.READ_WRITE);

                String backupFolderName = "Backup";
                Folder backupFolder = emailFolder.getFolder(backupFolderName);
                if ((backupFolder == null) || (!backupFolder.exists())){
                    backupFolder = emailStore.getFolder(backupFolderName);
                    if ((backupFolder == null) || (!backupFolder.exists())){
                        return "No se encontró la carpeta de respaldo de correo : " + backupFolderName;
                    }
                }

                String errorFolderName = "Errores";
                Folder errorFolder = emailFolder.getFolder(errorFolderName);
                if ((errorFolder == null) || (!errorFolder.exists())){
                    errorFolder = emailStore.getFolder(errorFolderName);
                    if ((errorFolder == null) || (!errorFolder.exists())){
                        return "No se encontró la carpeta para mails no procesados : " + errorFolderName;
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

                                String fileName = part.getFileName();
                                part.saveFile("C:\\Adempiere\\emails\\" + fileName);

                                if (fileName.endsWith(".zip")){



                                }
                                else if (fileName.endsWith(".xml")){

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

                // Abro de nuevo inbox y borro los mensajes
                emailFolder.open(Folder.READ_WRITE);
                for (int i = 0; i < messages.length; i++) {
                    Message message = messages[i];
                    message.setFlag(Flags.Flag.DELETED, true);
                }
                emailFolder.close(true);

                emailStore.close();
            }

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return null;
    }

}
