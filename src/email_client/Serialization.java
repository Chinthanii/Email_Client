/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Cipla 1
 */
public class Serialization {
    
   static void Serialize(ArrayList<Email> Emails) throws FileNotFoundException, IOException{
        FileOutputStream fileStream2 = new FileOutputStream("SentEmail.ser");
 
 try (ObjectOutputStream os2 = new ObjectOutputStream(fileStream2)) {
         os2.writeObject(Emails);
         os2.close();
     }
    }
    
    static public ArrayList<Email> deserialize(){
        
        ArrayList<Email> Emails;
        try{
     FileInputStream fileStream = new FileInputStream("SentEmail.ser");
     ObjectInputStream os = new ObjectInputStream(fileStream);
     
     Object objArray= os.readObject();
     Emails = (ArrayList<Email>)objArray;
     return Emails;
     }
     
     catch(IOException | ClassNotFoundException e){
         Emails = new ArrayList<>();
     }
        return Emails;
        
    }
}

    

