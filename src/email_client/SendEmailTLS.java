import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
class SendEmailTLS {
 public static void sendMail(String Reciver,String Subject , String Body ) 
throws FileNotFoundException, IOException, ParseException {
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
 
 
 } catch (MessagingException e) {
 System.out.println("Cannot send Email ");
 }
 }
 
}
