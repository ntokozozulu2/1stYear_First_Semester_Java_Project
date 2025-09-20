/*
    ST10487205
    NTOKOZO NHLAKANIPHO ZULU
    PROG5121 PoE PART 2
    Message() Testing
 */
package progpoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    /**     
    * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        long MessageID = 0L;
        int MessageNumber = 0;
        String Message = "00:0:HITONIGHT";
        Message instance = new Message();
        String expResult = "00:0:HITONIGHT";
        String result = instance.createMessageHash(MessageID, MessageNumber, Message);
        assertEquals(expResult, result);

    }
   
    
    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        String messageToPrint = "Hi Mike, can you join us for dinner tonight";
        Message instance = new Message();
        String expResult = "Hi Mike, can you join us for dinner tonight";
        String result = instance.printMessages(messageToPrint);
        assertEquals(expResult, result);

    }

    
    /**
     * Test of returnTotalMessages method, of class Message.
    */ 
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int MessageNumber = 3;
        Message instance = new Message();
        int expResult = 3;
        int result = instance.returnTotalMessages(MessageNumber);
        assertEquals(expResult, result);

    }
    
   
 
    /**
     * Test of validMessage method, of class Message.
     */
    @Test
    public void testValidMessage() {
        System.out.println("validMessage");
        String Message = "Hi Mike, can you join us for dinner tonight";
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.validMessage(Message);
        assertEquals(expResult, result);

    }

    /*
     * Test of validMessage method, of class Message.
     
    @Test
    public void testValidMessage() {
        System.out.println("validMessage");
        String Message = "Hi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonightHi Mike, can you join us for dinner tonight";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.validMessage(Message);
        assertEquals(expResult, result);

    } 
    */  


    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        long MessageID = 6749825;
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.checkMessageID(MessageID);
        assertEquals(expResult, result);

    }
    
    /*
     * Test of checkMessageID method, of class Message.
     
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        long MessageID = 16385970546738;
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkMessageID(MessageID);
        assertEquals(expResult, result);

    }*/

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String phoneNumber = "+27718693002";
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.checkRecipientCell(phoneNumber);
        assertEquals(expResult, result);

    }
    
   /*
     * Test of checkRecipientCell method, of class Message.
     
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String phoneNumber = "0718693002";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkRecipientCell(phoneNumber);
        assertEquals(expResult, result);

    }*/

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        long MessageID = 0L;
        String MessageHash = "00:2:HITONIGHT";
        int MessageNumber = 2;
        String Message = "Hi MIke, can you join us for dinner tonight";
        String RecipientCell = "+27718693002";
        Message instance = new Message();
        instance.storeMessage(MessageID, MessageHash, MessageNumber, Message, RecipientCell);

    }
}
