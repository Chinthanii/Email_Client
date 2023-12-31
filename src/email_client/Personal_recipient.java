/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cipla 1
 */
class Personal_recipient extends Recipient implements Wishable {
 private Date birthday;
 private String nickName;
 
 
 public Personal_recipient(String type,String name, String nickName, String email
, Date birthday ){
 super(type,name , email);
 this.birthday = birthday;
 this.nickName = nickName;
 }
 
 public void setBirthday(Date birthday)
 {
 this.birthday = birthday;
 }
 
 public Date getBirthday(){
 return birthday;
 }
 
 public void setNickName(String nickName)
 {
 this.nickName = nickName;
 }
 
 public String getNickName(){
 return nickName;
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
 String Eaddress = this.getEmail();
 String Body = "hugs and love on your birthday "+this.getName();
 String Subject = "Birthday Greeting ";
 Email em = new Email(Eaddress, Subject, Body);
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
