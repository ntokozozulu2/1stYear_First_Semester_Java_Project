/*
    ST10487205
    NTOKOZO NHLAKANIPHO ZULU
    PROG5121 PoE
    Login() Testing
 */
package progpoe;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class LoginTest {
    
    public LoginTest() {
     }
   

    /**
      Test of validUsername method, of class Login.
     */
    @Test
    public void testValidUsername() {
        System.out.println("validUsername");
        String username = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.validUsername(username);
        assertEquals(expResult, result);
        
    }
    
    /*
      Test of validUsername method, of class Login.
     
    @Test
    public void testValidUsername() {
        System.out.println("validUsername");
        String username = "kyle!!!!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.validUsername(username);
        assertEquals(expResult, result);
        
    }*/

    /**
      Test of validPhoneNumber method, of class Login.
     */
    @Test
    public void testValidPhoneNumber() {
        System.out.println("validPhoneNumber");
        String phoneNumber = "+27838968976";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.validPhoneNumber(phoneNumber);
        assertEquals(expResult, result);

    }
    
    /*
      Test of validPhoneNumber method, of class Login.
     
    @Test
    public void testValidPhoneNumber() {
        System.out.println("validPhoneNumber");
        String phoneNumber = "08966553";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.validPhoneNumber(phoneNumber);
        assertEquals(expResult, result);

    }*/

    /**
      Test of validPasswordComplexity method, of class Login.
     */
    @Test
    public void testValidPasswordComplexity() {
        System.out.println("validPasswordComplexity");
        String Password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.validPasswordComplexity(Password);
        assertEquals(expResult, result);

    }

    
    /*
      Test of validPasswordComplexity method, of class Login.
     
    @Test
    public void testValidPasswordComplexity() {
        System.out.println("validPasswordComplexity");
        String Password = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.validPasswordComplexity(Password);
        assertEquals(expResult, result);

    }*/

    /**
      Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String userName = "kyl_";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUserName(userName);
        assertEquals(expResult, result);

    }
    
    /*
      Test of checkUserName method, of class Login.
     
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String userName = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(userName);
        assertEquals(expResult, result);

    }*/

    /**
      Test of checkPassword method, of class Login.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String Password = "ch&&seC@ke99!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPassword(Password);
        assertEquals(expResult, result);

    }
    
    /*
      Test of checkPassword method, of class Login.
     
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String Password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPassword(Password);
        assertEquals(expResult, result);

    }*/

}
