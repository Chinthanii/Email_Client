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
public class Personal_recipient extends Recipient implements Wishable {
    private Date birthday;
    private String nickName;
    
    
    public Personal_recipient(String type,String name, String nickName, String email , Date birthday ){
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
        String Eaddress = this.getEmail();
        String Body = "hugs and love on your birthday "+this.getName();
        String Subject = "Birthday Greeting ";
        
        try {
            Email em = Email.sendMail(Eaddress, Subject, Body);
            return em;
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Personal_recipient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Email NullEm = new Email();
        return NullEm;
        
    }
}
