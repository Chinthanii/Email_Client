import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class FileHandling {
 
 public void createFile(String fileName){ 
 try{
 File myObj = new File(fileName);
 if(myObj.createNewFile()){
 // System.out.println("File created "+ myObj.getName());
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
