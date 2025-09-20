/*
    ST10487205
    NTOKOZO NHLAKANIPHO ZULU
    PROG5121 PoE PART 3
    Message Class
 */

package progpoe;

import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
import java.io.FileWriter;
import javax.swing.JOptionPane;


public class Message {

   //Method to check if the message ID exceeds 10 characters
    public boolean checkMessageID(long MessageID){
        String number = Long.toString(Math.abs(MessageID));

        return number.length() <= 10 && !number.matches(".*[A-Za-z].*");
    }
    
   //Method to check if the recipient's number meets the requirements
    public boolean checkRecipientCell(String phoneNumber){
        return phoneNumber.contains("+27") && phoneNumber.length() == 12 && !(phoneNumber.matches(".*[A-Za-z].*")) ;
    } 
    
   //Method to create a message hash
    public String createMessageHash(long MessageID, int MessageNumber, String Message){
         String firstWord = "", lastWord = "";

         String ID = Long.toString(Math.abs(MessageID));

         String[] words = Message.trim().split("\\s+");


        if (words.length > 0) {
            firstWord = words[0];
            lastWord = words[words.length - 1];
        }

        String messageHash = ID.substring(0,2) + ":" + MessageNumber + ":" + firstWord.toUpperCase() + lastWord.toUpperCase();

        return messageHash;
    }  

   //Method to display all the messages sent
    public String printMessages(String messageToPrint){    
        return messageToPrint;
    }   
    
   //Method to return the number of all the messages sent
    public int returnTotalMessages(int MessageNumber){
        return MessageNumber;
    }
   //Method to store the message(JSON)
    public void storeMessage(long MessageID, String MessageHash, int MessageNumber, String Message, String RecipientCell) {
        String filePath = "MessageStored.json";
        
        File file = new File(filePath);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating file : " + e.getMessage());
            return;
        }
        JSONObject json = new JSONObject();
        json.put("messageID", MessageID);
        json.put("messageHash", MessageHash);
        json.put("messageNumber", MessageNumber);
        json.put("message", Message);
        json.put("recipient", RecipientCell);

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(json.toString());
            writer.write(System.lineSeparator());
            JOptionPane.showMessageDialog(null, "Message stored successfully in file\nMessage ID : " + MessageID);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file : " + e.getMessage());
        }
    }

   //Method to check if the message doesn't exceeds 250 characters
    public boolean validMessage(String Message){
        return Message.length() <= 250;
    } 

}
