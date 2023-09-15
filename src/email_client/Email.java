/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Cipla 1
 */
public class Email implements Serializable {
    private String Subject;
    private String emial;
    private String body;
    private Date sendDate;
    
    public Email(){
        
    }
    public Email(String Email,String Subject, String body ) throws ParseException{
        this.Subject = Subject;
        this.body = body;
        this.emial = Email;
        
        Date now = new Date(); 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = simpleDateFormat.format(now);
        Date dt = simpleDateFormat.parse(formattedDate);
       // Date dt = new SimpleDateFormat("yyyy/MM/dd").format(now);
        this.sendDate = dt;
    }
    
    public void setSubject(String Subject){
        this.Subject = Subject;
    }
    public void setEmial(String emial){
        this.emial = emial;
    }
    public void setBody(String body){
        this.body = body;
    }
    public void setSendDate(Date sendDate){
        this.sendDate = sendDate;
    }
    
    public String getSubject(){
        return Subject;
    }
    public String getEmial(){
        return emial;
    }
    public String getBody(){
        return body;
    }
    public Date getSendDate(){
        return sendDate;
    }
    
    public static Email sendMail(String Reciver,String Subject , String Body  ) throws FileNotFoundException, IOException, ParseException {

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

    public static Email sendMail(String str ) throws IOException, FileNotFoundException, ParseException{
        
        String mailData[] = str.split(", ");
        Email em  =  sendMail(mailData[0],mailData[1],mailData[2]);
        return em;
    }
    
}
