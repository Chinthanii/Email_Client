import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class RecipientLoder {
 public static ArrayList<Recipient> loadRecipient(RecipientFactory Fc)
 {
 ArrayList<Recipient> Recipients;
 Recipients = new ArrayList<>();
 try{
 File myfile = new File("clientList.txt");
 try (Scanner myReader = new Scanner(myfile)) {
 while(myReader.hasNextLine()){
 String data = myReader.nextLine();
 
 Recipient Rc ;
 Rc = Fc.getRecipient(data);
 
 Recipients.add(Rc); 
 } 
 }
 
 }catch(IOException e){
 }
 
 return Recipients;
 }
}
