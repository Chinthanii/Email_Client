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
public class Close_friend extends Official_recipient implements Wishable{
    private Date birthday;
    
    public Close_friend(String type , String name , String email, String designation , Date birthday){
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
        String EAddress = this.getEmail();
        String Body = "Wish you a Happy Birthday "+this.getName();
        String Subject = "Birthday Greeting ";
        
        try {
            Email em = Email.sendMail(EAddress, Subject, Body);
            return em;
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Close_friend.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Email NullEm = new Email();
        return NullEm;
    }
}