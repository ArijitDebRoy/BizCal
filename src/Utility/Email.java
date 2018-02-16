/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Crypto.DecryptionManager;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author RUH
 */
public class Email {
private static String subject,msg;

    public Email(String subject, String msg) {
        this.subject = subject;
        this.msg = msg;
    }

    
    public static void send(String to) {
        // Sender's email ID needs to be mentioned
        String from = SharedRes.EmailFrom;
        final String username = SharedRes.EmailFrom;
        String password = new DecryptionManager(SharedRes.EmailPass).decrypt();

        // Assuming you are sending email through gmail
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Get the Session object.
        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,
                                password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(mailSession);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject);
            //Set Content: HTML body of the email
            message.setContent(msg, "text/html");

            // Now set the actual message
            //message.setText(msg);

            // Send message
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Message has been sent to your registered email address\n" + to);
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Check your network connection or your email address");
        }
    }

}
