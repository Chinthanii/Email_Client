/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

/**
 *
 * @author Cipla 1
 */
class Official_recipient extends Recipient{
 private String designation;
 
 public Official_recipient(){
 }
 
 Official_recipient(String type , String name, String Email , String 
designation){
 super(type, name,Email);
 this.designation = designation;
 }
 
 public void SetDesignation(String designation)
 {
 this.designation=designation ;
 }
 public String getDesignation()
 {
 return designation;
 }
 
}
