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
abstract class Recipient {
 
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
 
}
