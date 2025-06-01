/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import environnement.Env;
public class MailSender {
    public static void mcain(String[] args) {

    /*    // Informations de l'expéditeur
        final String username = Env.email; // Remplace par ton adresse Gmail
        final String password = Env.passwordEmail; // Remplace par ton mot de passe ou app password

        // Configuration SMTP pour Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Création de la session
        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            // Création du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("votre.email@gmail.com"));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(Env.email)
            );
            message.setSubject("Sujet du message");
            message.setText("Bonjour,\n\n Ceci est un message envoyé depuis Java!");

            // Envoi du message
            Transport.send(message);

            System.out.println("Message envoyé avec succès!");

        } catch (MessagingException e) {
            System.out.println("error email");
            System.out.println("=========================");
            e.printStackTrace();
        }*/
    
        sendEmail(Env.email,"test fonction","Hello my friends");
    }
    
       public static void sendEmail(String destinataire,String subject,String Text) {

        // Informations de l'expéditeur
        final String username = Env.email; // Remplace par ton adresse Gmail
        final String password = Env.passwordEmail; // Remplace par ton mot de passe ou app password

        // Configuration SMTP pour Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Création de la session
        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            // Création du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Env.email));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(destinataire)
            );
            message.setSubject(subject);
            message.setText(Text);

            // Envoi du message
            Transport.send(message);

            System.out.println("Message envoyé avec succès!");

        } catch (MessagingException e) {
            System.out.println("error email");
            System.out.println("=========================");
            e.printStackTrace();
        }
    }
}
