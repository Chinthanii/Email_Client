import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
class Office_friend extends Official_recipient implements Wishable{
 private Date birthday;
 
 public Office_friend(String type , String name , String email, String 
designation , Date birthday){
 super(type , name, email, designation);
 this.birthday=birthday;
 }
 
 public void setBirthday(Date birthday){
 this.birthday = birthday;
 }
 public Date getBirthday(){
 return birthday;
 }
 
 /**
 *
 * @return
 */
 @Override
 public Email wishOnBirthday()
 { 
 Date now = new Date();
 
 Calendar cal = Calendar.getInstance();
 cal.setTime(now);
 int month = cal.get(Calendar.MONTH);
 int date = cal.get(Calendar.DAY_OF_MONTH);
 Calendar cal2 = Calendar.getInstance();
 cal2.setTime(this.birthday);
 int month2 = cal2.get(Calendar.MONTH);
 int date2 = cal2.get(Calendar.DAY_OF_MONTH);
 if(month ==month2 && date == date2){
 String EAddress = this.getEmail();
 String Body = "Wish you a Happy Birthday "+this.getName();
 String Subject = "Birthday Greeting ";
 Email em = new Email(EAddress, Subject, Body);
 em.sendMail();
 return em;
 }
 return null;
 
 }
 
 @Override
 public boolean CheckBirthday(String birthday){
 try {
 Date date;
 date = new SimpleDateFormat("yyyy/MM/dd").parse(birthday);
 
 Calendar cal = Calendar.getInstance();
 cal.setTime(date);
 int month1 = cal.get(Calendar.MONTH);
 int date1 = cal.get(Calendar.DAY_OF_MONTH);
 
 Calendar cal2 = Calendar.getInstance();
 cal2.setTime(this.birthday);
 int month2 = cal2.get(Calendar.MONTH);
 int date2 = cal2.get(Calendar.DAY_OF_MONTH);
 
 return month1 ==month2 && date1 == date2;
 
 } catch (ParseException ex) {
 return false;
 }
 }
 
 @Override
 public void getDetails(){
 System.out.println(this.getName());
 }
}