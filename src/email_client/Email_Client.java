package email_client;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Email_Client {
 public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
     
 ArrayList<Email> Emails = Serialization.deserialize();
        
 Scanner scanner = new Scanner(System.in);
 ArrayList<Recipient> Recipients;

 Recipients = Recipient.loadRecipient();
 
 SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
 Date now = new Date();  
 
 ArrayList<Wishable> BithdayRecipients;
 BithdayRecipients = Recipient.checkBirthday(Recipients,formatter.format(now));
 
 BithdayRecipients.stream().map(BRC -> BRC.wishOnBirthday()).forEachOrdered(em -> {
     Emails.add(em);
     });
 
 
 FileHandaling myFile = new FileHandaling();
 myFile.createFile("clientList.txt");
 
 
 
 System.out.println("Enter option type: \n"
 + "1 - Adding a new recipient\n"
 + "2 - Sending an email\n"
 + "3 - Printing out all the recipients who have birthdays\n"
 + "4 - Printing out details of all the emails sent\n"
 + "5 - Printing out the number of recipient objects in the application");
 int option = scanner.nextInt();
 
 switch(option){
 case 1:
     System.out.println("Enter Recipient details");
     
     Scanner scannerobj = new Scanner(System.in);
     String recipientdata = scannerobj.nextLine();
     
     
     myFile.writeFile("clientList.txt", recipientdata);
     
     Recipient rc = Recipient.createRecipient(recipientdata);
     Recipients.add(rc);
     
     
 break;
 case 2:
     System.out.println("Enter email details");
     Scanner scannerobj2 = new Scanner(System.in);
     String emailData = scannerobj2.nextLine();
     Emails.add(Email.sendMail(emailData));  
     
 break;
 case 3:
     System.out.println("Enter Birthday ");
     Scanner scannerobj3 = new Scanner(System.in);
     String birthday = scannerobj3.nextLine();
     
     Recipient.checkBirthday(Recipients, birthday);   
 
 break;
 case 4:
     System.out.println("Enter Date ");
     Scanner scannerobj4 = new Scanner(System.in);
     String date = scannerobj4.nextLine();
     Date dt = new SimpleDateFormat("yyyy/MM/dd").parse(date);
     
     Emails.stream().filter(em -> (em.getSendDate().compareTo(dt)==0)).forEachOrdered(em -> {
         System.out.println(em.getSubject());
     });
     
     
     
     
 break;

 case 5:
     
     System.out.println("Number of Recipients : ");
     int tot = Recipient.getTotalRecipient();
     System.out.println(tot);
      
 break;
 }
 
     Serialization.Serialize(Emails);
 
 }

}
