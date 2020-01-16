package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 1000;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "company.com";

    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase()+ "@" + department + "." + companySuffix;
    }

    //ask user for department
    private String setDepartment(){
        System.out.println("Enter Employee Department Code:\n 1 for Sales \n 2 for Development \n 3 for Accounting \n 0 for none");
        Scanner in = new Scanner(System.in);
        int dept = in.nextInt();
        if(dept == 1)
            return "Sales";
        else if(dept == 2) return "Development";
        else if(dept == 3) return "Accounting";
        else return "";
    }

    // generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDFFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[]password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int) (Math.random()* passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set mailbox capacity
    private void setCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set alternate email
    private void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //change password
    private void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){ return mailboxCapacity;}

    public String getAlternateEmail(){return alternateEmail;}

    public String getPassword(){return password;}

    public String showInfo(){
        return "Display Name: " + firstName + " "+ lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + " mb";
    }
}
