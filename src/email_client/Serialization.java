/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
abstract class Serialization {
 
 static void Serialize(Object obj , String FileName) {
 
 try{
 FileOutputStream fileStream2 = new FileOutputStream(FileName);
 try (ObjectOutputStream os = new ObjectOutputStream(fileStream2)) {
 os.writeObject(obj);
 os.close();
 }
 }
 catch(IOException e){
 
 }
 }
static public Object deserialize(String FileName){
 
 
 try{
 FileInputStream fileStream = new FileInputStream(FileName);
 try (ObjectInputStream os = new ObjectInputStream(fileStream)) {
 Object obj = os.readObject();
 return obj;
 }
 
 } 
 catch(IOException|ClassNotFoundException e){
 }
 return null;
 
 }
 
 static public ArrayList<Email> deserializeEmail(){
 ArrayList<Email> SentEmails ;
 Object obj = Serialization.deserialize("SentEmail.ser");
 if(obj == null){
 SentEmails =new ArrayList<>();
 }
 else{
 SentEmails = (ArrayList<Email>) obj;
 }
 
 return SentEmails;
 }
}