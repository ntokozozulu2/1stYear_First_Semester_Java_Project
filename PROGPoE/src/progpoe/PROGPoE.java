/*
    ST10487205
    NTOKOZO NHLAKANIPHO ZULU
    PROG5121 PoE PART 3
    Main Class
 */
package progpoe;

import java.util.Random;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class PROGPoE {


    public static void main(String[] args) {
      //Variables
        String name, surname, username, password, phoneNumber, loginUsername, loginPassword;
        
      //external classes that will be used/called 
        Login userDetails = new Login();
        Message messages = new Message();
        

  /*CREATING A PROFILE*/  

      //prompt user for name and surname
        name = JOptionPane.showInputDialog("Enter your first name:");
        userDetails.setName(name);

        surname = JOptionPane.showInputDialog("Enter your surname:");
        userDetails.setSurname(surname);

      //prompt user and check username requirements
        username = JOptionPane.showInputDialog("Enter your username:");

        while(!userDetails.validUsername(username)){
            JOptionPane.showMessageDialog(null,"Username is not correctly formatted, please ensure that"
               + " your username contains an underscore and is no more than 5 characters long.");
            username = JOptionPane.showInputDialog("Re-enter username:"); 

        }
        userDetails.setUsername(username);


      //prompt user and check password requirements
        password = JOptionPane.showInputDialog("Enter your password:");


        while(!userDetails.validPasswordComplexity(password)){
           JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please ensure that"
               + " your password includes a capital letter, number, special character and at least 8 characters long.");
           password = JOptionPane.showInputDialog("Re-enter password: ");

        }  
        userDetails.setPassword(password);

      //prompt user and check phone number requirements
        phoneNumber = JOptionPane.showInputDialog("Enter your phone number:");

        while(!userDetails.validPhoneNumber(phoneNumber)){
            JOptionPane.showMessageDialog(null,"Cellphone number incorrectly formatted or does not contain "
               + "(+27) international code and should not contain any letter(s).");
            phoneNumber = JOptionPane.showInputDialog("Re-enter phone number: ");

        }
        userDetails.setPhoneNumber(phoneNumber);

    //Profile successfully created message
      if(userDetails.validPasswordComplexity(password) && userDetails.validPhoneNumber(phoneNumber)){
        JOptionPane.showMessageDialog(null,"\nProfile successfully created! \n===================\nProceed and enter your Login details.");
      }

    /*LOGIN*/
    //prompt user for username
      loginUsername = JOptionPane.showInputDialog("Enter your username to login: ");

    //checking if the username is correct 
      while(!userDetails.checkUserName(loginUsername)){
        JOptionPane.showMessageDialog(null,"Username incorrect, try again.");      
        loginUsername = JOptionPane.showInputDialog("Re-enter username to login:");
      }

    //prompt user for password if username is correct  
      loginPassword = JOptionPane.showInputDialog("Enter your password to login:");

    //checking if the username is correct       
      while(!userDetails.validPasswordComplexity(loginPassword)){
        JOptionPane.showMessageDialog(null,"Password incorrect, try again.");        
        loginPassword = JOptionPane.showInputDialog("Re-enter password to login: ");        
      }

    //successful log in message
      if (userDetails.checkUserName(username) && userDetails.checkPassword(password)){
         JOptionPane.showMessageDialog(null,"Welcome " + userDetails.getName() + ", " + userDetails.getSurname() + " it is great "
            + "to see you again."); 
      } 

   //welcome message
     JOptionPane.showMessageDialog(null,"Welcome to QuickChat");


   /*SENDING MESSAGES*/    
     boolean quit = false;
     

       //declaration of all the arrays to be used
        ArrayList<Long> messageID = new ArrayList<>();
        ArrayList<String> messageHash = new ArrayList<>();
        ArrayList<String> message = new ArrayList<>();
        ArrayList<String> recipientPhoneNumber = new ArrayList<>();
        
        ArrayList<String> sentMessages = new ArrayList<>();
        ArrayList<String> disregardedMessages = new ArrayList<>();  
        ArrayList<String> storedMessages = new ArrayList<>();
        
    while(!quit){     
        int selection = Integer.parseInt(JOptionPane.showInputDialog("Select only one option:\n1) Send messages\n2) Show recently sent messages\n3) Quit"));
        

    //switch to prompt user 
     switch(selection)
     {
         case 1:
       //Prompts user for the number of messages they want so send
        int numberOfMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));

        
       //declaring and setting sent messages to zero
        int messageSent = 0;
        Random random = new Random();
       //declaration of the string builder to store all the messages sent
        String build = "****************";
           //loop for the number of messages the user wants to send 
            for(int z = 0; z < numberOfMessages; z++){
             //generating a message ID
              long messageId = random.nextInt(1_000_000_000);              
             //checking if MessageID doesn't exceed 10 characters and regenerating if it does
              while(!messages.checkMessageID(messageId)){
                 messageId = random.nextInt(1_000_000_000);   
              }
             // messageID.add(messageId);
              
             //increment messages sent
              messageSent = z + 1;
              
             //prompt user to enter the recipient number and checking if it meets the requirements
              String recipient = (JOptionPane.showInputDialog("Enter the cellphone number of the recipient"));
              while(!messages.checkRecipientCell(recipient)){
                recipient = JOptionPane.showInputDialog("Recipent number incorrectly formatted.\nRe-enter the cellphone number of the recipient and make sure it contains +27...");
              }
             // recipientPhoneNumber.add(recipient);
              
              
             //prompting user to type a message and checking if it doesn't exceed 250 characters
              String enteredMessage = JOptionPane.showInputDialog("Type the mesage you want to send.\nMessage should not exceed 250 characters:");
              while(!messages.validMessage(enteredMessage)){
                enteredMessage = JOptionPane.showInputDialog("Re-type the mesage you want to send.\nMessage should not exceed 250 characters:");  
              }
              
            //creating the message hash  
             String messagehash = messages.createMessageHash(messageId, messageSent, enteredMessage);
            // messageHash.add(messagehash);
             
            //prompting the user to ask what they want to do with the message the just typed
              int messageDecision = Integer.parseInt(JOptionPane.showInputDialog("Select one option\n1) Send message\n2) Disregard Message\n3) Store message to send later"));
                switch(messageDecision){
                  //Send message to recipient
                    case 1:
                        messageID.add(messageId);
                        messageHash.add(messagehash);
                        message.add(enteredMessage);
                        recipientPhoneNumber.add(recipient);

                        sentMessages.add("\nMessage ID : " + messageId +
                         "\nMessage Hash : " + messagehash +
                         "\nRecipient Phonenumber : " + recipient +
                         "\nMessage : " + enteredMessage);
                        
                        JOptionPane.showMessageDialog(null, "Message sent successfully to " + recipient);                   
                        break;
                  //message will be disregarded
                    case 2:
                        JOptionPane.showMessageDialog(null, "The message that was supposed to be sent to " + recipient + " has been disregarded.");
                        disregardedMessages.add("\nMessage ID : " + messageId +
                         "\nMessage Hash : " + messagehash +
                         "\nRecipient Phonenumber : " + recipient +
                         "\nMessage : " + enteredMessage);
                        break;
                  //message will be stored in a JSON File
                    case 3:
                        /*Store message in JSON File*/
                        messages.storeMessage(messageId, messagehash, messageSent, enteredMessage, recipient);
                        storedMessages.add("\nMessage ID : " + messageId +
                         "\nMessage Hash : " + messagehash +
                         "\nRecipient Phonenumber : " + recipient +
                         "\nMessage : " + enteredMessage);
                        
                        JOptionPane.showMessageDialog(null,"Message successfully stored to be sent later.\nMessage ID : " + messageId);
                        break;

                   default:
                      JOptionPane.showMessageDialog(null, "No number selected.");
                      
                      break;
                }
             //adding the most recent message to all the other messages sent
              build = build + "\nMessage " + messageSent +  "\nMessage ID : " + messageId + "\nMessage Hash : " +  messagehash + "\nRecipient Phonenumber : "+ recipient + "\nMessage : "+ enteredMessage + "\n****************";
                       
            }
            //display of all the messages sent with other information
             JOptionPane.showMessageDialog(null, messages.printMessages(build) + "\n\nTotal messages sent : " + messages.returnTotalMessages(messageSent));
                         
            break;

        //Show recently sent mssages      
         case 2:
             
             int recentMessages = Integer.parseInt(JOptionPane.showInputDialog("Select one option\n1) Display the sender and recipient of all the messages \n2) Display the longest messages \n3) Search for a message using MessageID"
                     + "\n4) Search for all messages for a particular recipient \n5) Delete a message using its message hash \n6) Display report that list the details of the messages sent"));
            
            
            switch(recentMessages){
                case 1:
                   //display sender and recipient of sent messages 
                    String displayDetails = "************* Sender and Recipients *************";
                    for (int i = 0; i < sentMessages.size(); i++) {
                      displayDetails += "\nSender : " + userDetails.getPhoneNumber()
                                        + "  Recipient : " + recipientPhoneNumber.get(i);
                    }
                    JOptionPane.showMessageDialog(null, displayDetails);                   
                     break;
                     
                case 2:
                 //display longest sent message
                  //check if theres anything in the array   
                   if (sentMessages.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No messages have been sent yet.");
                    } else {
                        String longestMessage = sentMessages.get(0);
                        
                  //looping through the sent messages array to look for the longest message
                    for (String msg : sentMessages){
                            if (msg.length() > longestMessage.length()) {
                                longestMessage = msg;
                            }
                        }
                      //displays the longest message sent
                        JOptionPane.showMessageDialog(null, "Longest Sent Message:\n" + longestMessage);
                    }
                     break;
                     
                case 3:
                  //search for message id and then display recipient along with message
                   //check if theres anything in the array
                    if (sentMessages.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No messages have been sent yet.");
                    } else {
                        String inputMessageID = JOptionPane.showInputDialog("Enter the Message ID to search for:");
                        boolean found = false;

                        for (String msg : sentMessages) {
                          if (msg.contains("Message ID : " + inputMessageID)) {
                            // Display the full message with recipient and content
                              JOptionPane.showMessageDialog(null, "Message found:\n" + msg);
                              found = true;
                              //break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null, "No message found with ID: " + inputMessageID);
                        }
                    }
                    break;
                    
              case 4:
                //search for all the messages sent to a particular recipient
                 //checking if there were any messages sent
                  if (sentMessages.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No messages have been sent yet.");
                    } else {
                      //prompt user to enter the recipient cell to search
                        String searchRecipient = JOptionPane.showInputDialog("Enter the recipient phone number to search for:");
                        StringBuilder results = new StringBuilder("Messages sent to " + searchRecipient + ":\n\n");
                        boolean foundAny = false;
                       
                      //looping through the array and adding all the messages that were sent the entered recipient
                        for (String msg : sentMessages) {
                            if (msg.contains("Recipient Phonenumber : " + searchRecipient)) {
                                results.append(msg).append("\n------------------------\n");
                                foundAny = true;
                            }
                        }
                        
                      //display messages for the entered recipient if there are any
                        if (foundAny) {
                            JOptionPane.showMessageDialog(null, results.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "No messages were found for recipient: " + searchRecipient);
                        }
                    }
                    break;
                    
                  case 5:
                   //delete a message using message hash
                    //checking if there were any messages sent
                      if (sentMessages.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No sent messages to delete.");
                        } else {
                            String enteredMessageHash = JOptionPane.showInputDialog("Enter the message hash to delete:");

                            boolean found = false;

                            for (int i = 0; i < messageHash.size(); i++) {
                                if (messageHash.get(i).equals(enteredMessageHash)) {
                                    int confirm = JOptionPane.showConfirmDialog(null,
                                            "Message found:\n" + sentMessages.get(i) +
                                            "\n\nAre you sure you want to delete this message?",
                                            "Confirm Delete",
                                            JOptionPane.YES_NO_OPTION);

                                    if (confirm == JOptionPane.YES_OPTION) {
                                      // Remove corresponding elements from all relevant lists
                                        sentMessages.remove(i);
                                        messageID.remove(i);
                                        messageHash.remove(i);
                                        message.remove(i);
                                        recipientPhoneNumber.remove(i);

                                        JOptionPane.showMessageDialog(null, "Message deleted successfully.");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "The deleting of the message has been cancelled.");
                                    }

                                    found = true;
                                }
                            }
                          //message to display if no messeage has been found with entered message hash
                            if (!found) {
                                JOptionPane.showMessageDialog(null, "No message found with the provided hash.");
                            }
                        }
                    break;
                    
              case 6:
                  //display report that list the details of the messages sent
                   //checking if there were any messages sent
                    if (sentMessages.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No messages have been sent yet.");
                    } else {
                        StringBuilder report = new StringBuilder("************ Sent Messages Report ************\n");

                      //looping through the array and adding all the required details for the report
                        for (int i = 0; i < sentMessages.size(); i++) {
                            report.append("Message ").append(i + 1).append(":\n")
                                  .append(sentMessages.get(i)).append("\n----------------------------------\n");
                        }

                        report.append("Total messages sent: ").append(sentMessages.size());
                      //displaying the final report
                        JOptionPane.showMessageDialog(null, report.toString());
                        }

                    break;
                    
                
                default:
                  JOptionPane.showMessageDialog(null, "No number selected.");
                  break;
             }

             break;
             
        //Quit and stop the program
         case 3:
             JOptionPane.showMessageDialog(null,"Thank you for using QuickChat, hope to see you again!");
             quit = true;
             break;

         default:
             JOptionPane.showMessageDialog(null, "No number selected.");
             break;
             
            }
      } 
    }
  }

