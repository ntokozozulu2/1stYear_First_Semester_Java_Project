/*
    ST10487205
    NTOKOZO NHLAKANIPHO ZULU
    PROG5121 PoE PART 3
    Login Class
 */
package progpoe;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
   
  private String name;
  private String surname;
  private String username;
  private String password;
  private String phoneNumber;


  //set method for name
    public void setName(String name) {
        this.name = name;
    }
  //get method for name
    public String getName() {
        return name;
    }

   //set method for surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

  //get method for surname
    public String getSurname() {
        return surname;
    }

   //set username method
    public void setUsername(String username) {
        this.username = username;
    }
   //get username method
    public String getUsername() {
        return username;
    }

  //set password method
    public void setPassword(String password) {
        this.password = password;
    }

  //get password method
    public String getPassword() {
        return password;
    }

  //set phone number method
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   //get phone number method
    public String getPhoneNumber() {
        return phoneNumber;
    }

   //testing if the username is 5 characters and includes an underscore
    public boolean validUsername(String username){
        return (username.length() <= 5 && username.contains("_"));
    }  

    //testing if the username is 5 characters and includes an underscore
    public boolean validPhoneNumber(String phoneNumber){
        return phoneNumber.contains("+27") && phoneNumber.length() == 12 && !(phoneNumber.matches(".*[A-Za-z].*")) ;
    } 

    //testing if password meets requirements
    public boolean validPasswordComplexity(String Password){
      return (Password.length()>=8 && Password.chars().anyMatch(Character:: isUpperCase) &&  Password.chars().anyMatch(Character::isDigit)
               && (Password.contains("@") || Password.contains("#") || Password.contains("&") || Password.contains("%") && Password.length() < 20));  
    }


   //testing if the username entered to login is correct
     public boolean checkUserName(String userName){        
        return userName.equals(getUsername());        
        }

   //testing if the password entered to login is correct
     public boolean checkPassword(String Password){        
        return Password.equals(getPassword());         
        }


}