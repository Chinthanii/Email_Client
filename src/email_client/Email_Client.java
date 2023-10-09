package email_client;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

class Email_Client {

    public static void main(String[] args) throws ParseException {

        RecipientFactory RFactory = new RecipientFactory();

        ArrayList<Email> SentEmails = Serialization.deserializeEmail();


        ArrayList<Recipient> Recipients;
        Recipients = RecipientLoder.loadRecipient(RFactory);


        ArrayList<Wishable> BithdayRecipients;
        BithdayRecipients = RFactory.getBirthdayRecipientList();
        for(Wishable BRC : BithdayRecipients ){
            Email em = BRC.wishOnBirthday();
            if(em != null){
                SentEmails.add(em);
            }
        }


        boolean status = true;
        while(status){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter option type: \n"
                    + "1 - Adding a new recipient\n"
                    + "2 - Sending an email\n"
                    + "3 - Printing out all the recipients who have birthdays\n"
                    + "4 - Printing out details of all the emails sent\n"
                    + "5 - Printing out the number of recipient objects in the application\n"
                    + "99 - Exit");

            int option = scanner.nextInt();

            switch(option){
                case 1:
                    // input format - Official: nimal,nimal@gmail.com,ceo
                    // Use a single input to get all the details of a recipient
                    // code to add a new recipient
                    // store details in clientList.txt file
                    // Hint: use methods for reading and writing files

                    System.out.println("Enter Recipient details");

                    Scanner scanner2 = new Scanner(System.in);
                    String recipientdata = scanner2.nextLine();

                    Recipient rc = RFactory.getRecipient(recipientdata);
                    Recipients.add(rc);
                    if(rc!=null){
                        FileHandling myFile = new FileHandling();
                        myFile.writeFile("clientList.txt", recipientdata);
                    }

                    break;

                case 2:
                    // input format - email, subject, content
                    // code to send an email

                    System.out.println("Enter email details");
                    Scanner scanner3 = new Scanner(System.in);
                    String emailData = scanner3.nextLine();
                    Email em = new Email();
                    if(em.createEmail(emailData)){
                        em.sendMail();
                        SentEmails.add(em);
                    }

                    break;

                case 3:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print recipients who have birthdays on the given date

                    System.out.println("Enter Birthday ");
                    Scanner scanner4 = new Scanner(System.in);
                    String birthday = scanner4.nextLine();
                    BithdayRecipients = RFactory.getBirthdayRecipientList();

                    for(Wishable BRC : BithdayRecipients ){
                        if(BRC.CheckBirthday(birthday)){
                            BRC.getDetails();
                        }
                    }



                    break;

                case 4:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print the details of all the emails sent on the input date

                    System.out.println("Enter Date ");
                    Scanner scanner5 = new Scanner(System.in);
                    String date = scanner5.nextLine();

                    try {
                        Date dt = new SimpleDateFormat("yyyy/MM/dd").parse(date);

                        for (Email em2 : SentEmails){
                            if(em2.getSendDate().compareTo(dt)==0)
                            {
                                System.out.println(em2.getEmial()+ " , "+em2.getSubject());
                            }
                        }
                    }
                    catch(ParseException ex) {
                        System.out.println("Error , Please use the correct input
                                format!!");
                    }

                    break;

                case 5:
                    // code to print the number of recipient objects in the application

                    System.out.println("Number of Recipients : ");
                    int tot = Recipient.getTotalRecipient();
                    System.out.println(tot);

                    break;

                case 99:
                    // Exit the programm

                    Serialization.Serialize(SentEmails,"SentEmail.ser");
                    status = false;
                    scanner.close();

                    break;
            }


            System.out.println("\n \n");
            // start email client
            // code to create objects for each recipient in clientList.txt
            // use necessary variables, methods and classes
        }
    }
}
    // create more classes needed for the implementation (remove the public access
    modifier from classes when you submit your code