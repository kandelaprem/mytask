package mypack;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {

	String Address;
	String custname;
	String ph_number;
	String gender;
	String Ac_type;
	double Ac_balance;
	double withdrawl;
	double totalWithdraws;
    double totalInterest;
    double monthlyInterestRate;
	String dob;
	String savings;
	String current;
	float interestrate;
	double Last_interest;
	double monthlyinterestrate;
	long acc_number;
	
	void input()
	
	{
		 int CMAX_LENGHT=30;
		 int AMAX_LENGTH=200;
		Scanner i = new Scanner(System.in);
	   System.out.println("Enter Customer name[below 30 char]:");
	      custname=i.nextLine();
	  
	   if (custname.length() > CMAX_LENGHT) { // VALIDATING LENGTH OF NAME 
		   custname = custname.substring(0, CMAX_LENGHT);
		   System.out.println("Please enter name with-in 30 characters..");
		   System.exit(0);
		  
	   }
	   
	   String regx = "^[A-Za-z\\s]+$"; // VALIDATING ONLY SPACES AND CHARACTERS IN NAME
	    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(custname);
	     boolean valid= matcher.find();
	      if(!valid)   //IF NAME CONSISTS NUMBERS
	      {
	      System.out.println("Given name containts numbers also..");
	      System.exit(0);
	      }
	     
	   
		   System.out.println("Enter Customer address[below 200 characters]:");
		   Address=i.nextLine();
			  
		   if (Address.length() > AMAX_LENGTH) {     //VALIDATING ADDRESS LENGTH
			   Address = Address.substring(0, AMAX_LENGTH);
			   System.out.println("Please enter Address with-in 200 characters..");
			   System.exit(0);
		   }
		 
		   System.out.println("Enter Customer Gender [M/F]:");
		   gender = i.nextLine();
		  
		    if(!gender.equals("m") && !gender.equals("f")) // VALIDATING MALE AND FEMALE
		    {
		    		System.out.println("Please enter a valid Gender...");
		            System.exit(0);
		    }
		    
	     	    
		    System.out.println("Enter Customer Date of Birht [dd-mm-yy]:");
		    dob=i.nextLine();
		  
		    System.out.println("Enter Customer phone number :");
		    ph_number=i.nextLine();
		    
	
		//   WORKING WITH CASA : CURRENT ACCOUNT AND SAVING ACCOUNT.		    
		    
		    
		    System.out.println("Enter Bank account type :");
		    Ac_type=i.nextLine();
		    
		     if(! Ac_type.equals("savings") && ! Ac_type.equals("current"))
		    {
		    	  System.out.println("Please  input valid account[only savings/current allowed..");
			      System.exit(0);		    
		    }	    
		    
		     
		     System.out.println("Enter bank account balance:");
			    Ac_balance=i.nextDouble();
			    
			    
			     System.out.println("Enter with draw amount:");
			     withdrawl=i.nextDouble();
			     
			     if (withdrawl>=Ac_balance && Ac_balance<=500) // VALIDATING WITHDRAW AND ACCOUNT BALANACE
				    {
				    	System.out.println("insufficient amount");
				    }
					Ac_balance -= withdrawl; 
				       totalWithdraws += withdrawl;
				       System.out.println("Total Account Balance:"+Ac_balance);
				       
				       
		     
		     System.out.println("Enter customer age :");
		     byte age=i.nextByte();
		     
		     
		     if (Ac_type.equals("savings")) // INTEREST IS APPLICABLE ONLY FOR SAVINGS ACCOUNT
		    	 
		          {
		     
					      if (age>=60)             //VALIDATING SENIOR CITIZEN INTEREST
					      {  
					    	  System.out.println("senior citizen interest  applicable");
					    	  interestrate=9;
					      }
					      else if(gender.equals("f")) // VALIDATING FEMALE INTEREST
					      {
					    	  System.out.println("women interest rate applicaable");
					    	  interestrate=(float) 0.5;
					      }
					     
					      else if(age>=60 && (gender.equals("f")))
					      {
					    	  System.out.println("senior citizen  + women interest rate applicaable");
					    	  interestrate=(float) 9.5;
					      }
					      
					      else
					      {
					    	  interestrate=6;  // DEFAULT INTEREST APPLICAABLE
					      }
		      
		                      monthlyinterestrate = interestrate/12;
		  
		                      Last_interest = monthlyinterestrate * Ac_balance;
		   
		                    Ac_balance = Ac_balance + Last_interest;
			 
		     
		          }
		     
		     else
		    	 System.out.println("current account interest is not applicable....");
		     
		     
		  // GENERATE 10 DIGIT RANDOM NUMBER LESS THAN 10 DIGITS;   
		 	String s1 = "33333";
			double d = Math.random();
			d=d*100000.0;
			int k = (int) d;
			String s2 = String.valueOf(k);
			String s3=s1+s2;
			acc_number = Long.parseLong(s3);
		
			System.out.println("Account created successfully, Please check the Text file..");    
		 		     
		     
		    try
		    {
		    	PrintWriter writers = new PrintWriter("savings.txt", "UTF-8");
			    PrintWriter writerc = new PrintWriter("current.txt", "UTF-8");
			    
			    
			    if(Ac_type.equals("savings"))
			    {
			    	    writers.print("Customer name: "+custname+", ");
			    	    writers.println("Cust Address: "+Address+", ");   	   
					    writers.print("Account Type:"+Ac_type+", ");
					    writers.print("Age: "+age+", ");
					    writers.print("Account Balance: "+Ac_balance+", ");
					    writers.print("Phone number: "+ph_number+", ");
					    writers.print("Account Number: "+acc_number+", ");
					    writers.close();
			    
			    }	    
			 
			    if(Ac_type.equals("current"))
			    {
			    
			    	 writerc.print("Customer name: "+custname+", ");
			    	    writerc.println("Cust Address: "+Address+", ");   	   
					    writerc.print("Account Type:"+Ac_type+", ");
					    writerc.print("Age: "+age+", ");
					    writerc.print("Account Balance: "+Ac_balance+", ");
					    writerc.print("Phone number: "+ph_number+", ");
					    writerc.print("Account Number: "+acc_number+", ");
					    writerc.close();
			    
			    
			    }	    

		    }
		    catch ( IOException e)
		    {
		    	System.out.println("files are not able to create/location missing..");
		    }
		   	    
		}
	   


		

	
	   
	
	public static void main(String[] args) {
		
		Bank b = new Bank();
		b.input();

	}

}
