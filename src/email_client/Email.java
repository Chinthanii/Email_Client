import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class Email implements Serializable {
 private String Subject;
 private String email;
 private String body;
 private Date sendDate;
 
 public Email(){
 
 }
 
 public Email(String Email,String Subject, String body ) {
 this.Subject = Subject;
 this.body = body;
 this.email = Email;
 }
 
 public void setSubject(String Subject){
 this.Subject = Subject;
 }
 public void setEmial(String emial){
 this.email = emial;
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
 return email;
 }
 public String getBody(){
 return body;
 }
 public Date getSendDate(){
 return sendDate;
 }
 
 public boolean createEmail(String str){
 try{
 String mailData[] = str.split(", ");
 this.email = mailData[0];
 this.Subject = mailData[1];
 this.body = mailData[2];
 return true;
 }
 catch(ArrayIndexOutOfBoundsException e){
 System.out.println("Error , Please use the correct input format!!");
 return false;
 
 }
 }
 
 public void sendMail() {
 
 try{
 SendEmailTLS.sendMail(email, Subject, body);
 
 if(email!=null && Subject != null && body!=null){
 Date now = new Date(); 
 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
 String formattedDate = simpleDateFormat.format(now);
 Date dt = simpleDateFormat.parse(formattedDate);
 this.sendDate = dt;
 }
 }
 catch( IOException| ParseException e){
 
 }
 }
 
}
