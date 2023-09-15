/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cipla 1
 */
public abstract class Recipient {
    
    //Official: nimal,nimal@gmail.com,ceo
     private String type;
     private String name ;
     private String email ;
     private static int tot_recipient;
     
    public Recipient(){
    }
    
    public Recipient(String type , String name,String email){
        this.type = type;
        this.name = name;
        this.email = email;
        tot_recipient+=1;
    }
    
    public String getName(){
        return name;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getType(){
        return type;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public static int getTotalRecipient()
    {
        return tot_recipient;
    }
    
    
    
    /**
     *
     * @return
     */
    public static ArrayList<Recipient> loadRecipient()
    {
            ArrayList<Recipient> Recipients;
            Recipients = new ArrayList<>();
        try{
            File myfile = new File("clientList.txt");
                try (Scanner myReader = new Scanner(myfile)) {
                    while(myReader.hasNextLine()){
                        String data = myReader.nextLine();
                        Recipient Rc ;
                        Rc = Recipient.createRecipient(data);
                        Recipients.add(Rc);
                    }   }
        }catch(IOException e){
            System.out.println("An error occurred.");
        }
        
        return Recipients;
    }
    
    public static ArrayList<Wishable> checkBirthday(ArrayList<Recipient> Recipients , String birthday) throws ParseException{
        
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
