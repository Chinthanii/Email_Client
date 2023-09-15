/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

/**
 *
 * @author Cipla 1
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailTLS {

    public Email sendMail(String Reciver,String Subject , String Body  ) throws FileNotFoundException, IOException, ParseException {

        final String username = "chinthaniii2022@gmail.com";
        final String password = "slyifdtsemsuwjas";

        Properties prop = new Properties();
	
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(Reciver)
            );
            message.setSubject(Subject);
            message.setText(Body);

            Transport.send(message);
            
            System.out.println("Sent messages sucessfully!");
            
            Email Em =new Email(Reciver,Subject,Body);
            return Em;
            
        } catch (MessagingException e) {
        }
        Email em2 = new Email();
        return em2;
    }

    public Email sendMail(String str ) throws IOException, FileNotFoundException, ParseException{
        
        String mailData[] = str.split(", ");
        Email em  =  sendMail(mailData[0],mailData[1],mailData[2]);
        return em;
    }
    
}

