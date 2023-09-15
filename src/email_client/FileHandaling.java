/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Cipla 1
 */
public class FileHandaling {
    
    public void createFile(String fileName){ 
        try{
            File myObj = new File(fileName);
            if(myObj.createNewFile()){
                System.out.println("File created "+ myObj.getName());
            }
            else{
                System.out.println("File already exist.");
            }
            
        }catch(IOException e){
            System.out.println("Error occurred");
        }
        
    }
    
    public void writeFile(String fileName, String Message)
    {   
        try{
            try (FileWriter myfile = new FileWriter(fileName,true)) {
                myfile.write(Message);
                myfile.write(System.lineSeparator());
            }
            System.out.println("successfully wrote to the file.");
        
        }catch(IOException e){
            System.out.println("An error occurred.");
        }
        
    }
    
    
    public void readFile(String fileName)
    {
        try{
            File myfile = new File(fileName);
            try (Scanner myReader = new Scanner(myfile)) {
                while(myReader.hasNextLine()){
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
        }
    }
    
    
}
