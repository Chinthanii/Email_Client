import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
class RecipientFactory {
 
 ArrayList<Wishable> BirthdayRecipients;
 
 public RecipientFactory(){
 BirthdayRecipients = new ArrayList<>();
 }
 
 public Recipient getRecipient(String recipientData){
 
 try{
 String str = recipientData;
 String rsData[] = str.split(" ");
 String data[] = rsData[1].split(",");
 
 
 if(rsData[0].equals("Official:")){
 Official_recipient rcs = new 
Official_recipient("Official",data[0],data[1],data[2]);
 return rcs;
 }
 else if(rsData[0].equals("Office_friend:")){
 String sDate1 = data[3];
 Date date1;
 try {
 date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
 Office_friend rcs = new 
Office_friend("Office_friend",data[0],data[1],data[2],date1);
 BirthdayRecipients.add(rcs);
 return rcs;
 } catch (ParseException ex) {
 } 
 }
 else if(rsData[0].equals("Personal:")){
 String sDate2 = data[3];
 Date date2;
 try {
 date2 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate2);
 Personal_recipient rcs = new 
Personal_recipient("Personal",data[0],data[1],data[2],date2);
 BirthdayRecipients.add(rcs);
 return rcs;
 } catch (ParseException ex) {
 }
 }
 else{
 System.out.println("Error , Please use the correct input format!!");
 return null;
 }
 }
 catch(ArrayIndexOutOfBoundsException e){
 System.out.println("Error , Please use the correct input format!!");
 }
 return null;
 }
 
 public ArrayList<Wishable> getBirthdayRecipientList(){
 return BirthdayRecipients;
 }
 
}