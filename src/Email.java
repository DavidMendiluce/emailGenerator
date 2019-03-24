package EmailAdmin;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 8;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//constructor for first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		//Call method ask department - return department
		this.department = setDepartment();
		
		
		//Call method that return password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
		
	}
	
	//Ask for department
	private String setDepartment() {
	System.out.print("New worker: " + firstName + "Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department");
	Scanner in = new Scanner(System.in);
	int depChoice = in.nextInt();
	if(depChoice == 1) {return "sales";}
	else if (depChoice == 2) {return "dev";}
	else if (depChoice == 3) {return "Acct";}
	else {return "";  }
	}

	//Generate a random password
	private String randomPassword(int length) {
	  String passwordSet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789!@#~%";
	  char[] password = new char[length];
	  for (int i=0; i<length; i++) {
		  int rand = (int) (Math.random() * passwordSet.length());
		  password[i] = passwordSet.charAt(rand);
	  }
	  return new String(password);
	}
	
	//Set the mailbox capacity
	public void setmailboxCpacaity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set the alternate email 
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	//get methods
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	
	// Show info
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOC CAPACITY: " + mailboxCapacity + "mb";
	}
}

