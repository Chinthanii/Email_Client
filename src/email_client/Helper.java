/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cipla 1
 */
public class Helper {
    
    public Recipient createRecipient(String recipientData){
        
    String str = recipientData;
    String rsData[] = str.split(" ");
    String data[] = rsData[1].split(",");
    
    if(rsData[0].equals("Official:")){
        Official_recipient Ors = new Official_recipient("Official",data[0],data[1],data[2]);
        return Ors;  
    }
    if(rsData[0].equals("Office_friend:")){
        String sDate1 = data[3];
        Date date1;
        try {
            date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
            Close_friend Ors = new Close_friend("Office_friend",data[0],data[1],data[2],date1);
            return Ors; 
        } catch (ParseException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    if(rsData[0].equals("Personal:")){
        
        String sDate2 = data[3];
        Date date2;
        try {
            date2 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate2);
            Personal_recipient Ors = new Personal_recipient("Personal",data[0],data[1],data[2],date2);
            return Ors;  
        } catch (ParseException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Official_recipient Ors = new Official_recipient();
    return Ors ;  
    }
    
    public ArrayList<Recipient> loadRecipient()
    {
            ArrayList<Recipient> Recipients;
            Recipients = new ArrayList<>();
        try{
            File myfile = new File("clientList.txt");
                try (Scanner myReader = new Scanner(myfile)) {
                    while(myReader.hasNextLine()){
                        String data = myReader.nextLine();
                        Helper hp = new Helper();
                        Recipient Rc ;
                        Rc = hp.createRecipient(data);
                        Recipients.add(Rc);
                    }   }
        }catch(IOException e){
            System.out.println("An error occurred.");
        }
        
        return Recipients;
    }
    
    public ArrayList<Wishable> checkBirthday(ArrayList<Recipient> Recipients , String birthday) throws ParseException{
        
        ArrayList<Wishable> BithdayRecipients;
        BithdayRecipients = new ArrayList<>();
        
        for(Recipient RCS : Recipients){
         if(RCS.getType().equals("Personal"))
         {
             Personal_recipient prc = (Personal_recipient)RCS;
             Date date;
             date = new SimpleDateFormat("yyyy/MM/dd").parse(birthday);
             
             
             Calendar cal = Calendar.getInstance();
             cal.setTime(date);
             int month = cal.get(Calendar.MONTH);
             int dd = cal.get(Calendar.DAY_OF_MONTH);
             
             Calendar cal2 = Calendar.getInstance();
             cal2.setTime(prc.getBirthday());
             int month2 = cal2.get(Calendar.MONTH);
             int dd2 = cal2.get(Calendar.DAY_OF_MONTH);
            
             if(month ==month2 && dd == dd2){
                 Wishable BRC = (Wishable)RCS;
                 BithdayRecipients.add(BRC);
             }
         }  
     }
     
     for(Recipient RCS : Recipients){
         if(RCS.getType().equals("Office_friend"))
         {
             Close_friend prc = (Close_friend)RCS;
             Date date;
             date = new SimpleDateFormat("yyyy/MM/dd").parse(birthday);
             
             
             Calendar cal = Calendar.getInstance();
             cal.setTime(date);
             int month = cal.get(Calendar.MONTH);
             int dd = cal.get(Calendar.DAY_OF_MONTH);
             
             Calendar cal2 = Calendar.getInstance();
             cal2.setTime(prc.getBirthday());
             int month2 = cal2.get(Calendar.MONTH);
             int dd2 = cal2.get(Calendar.DAY_OF_MONTH);
            
             if(month ==month2 && dd == dd2){
                 Wishable BRC = (Wishable)RCS;
                 BithdayRecipients.add(BRC);
             }
         }  
     }
     
     return  BithdayRecipients;
    }
    
}
