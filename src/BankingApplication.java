package javaProjects;

import java.util.Scanner;
//creating a bank account class for storing and performing operations on the account
class BankAccount{
	
	//attributes of a bank account
	String customerName; //account holder name
	String customerID; //account holder ID
	int balance; //account holder's balance i.e money present
	int previousTransaction; // account holder's previous transaction or history of transaction
	
	// Constructor which assigns accountholder name and account id from the user entered values 
	BankAccount(String  cname,String cID)
	{
	   customerName = cname;
	   customerID = cID;
	}
	// method which performs deposit of money to account 
	public void deposit(int amount)
	{
		if(amount>0)
		{
			balance = balance+amount; // when money is deposited, amount is added to the balance
			previousTransaction = amount; //storing the transaction amount for transaction history purpose
		}
		
	}
	//method which performs withdraw actions
	public void withdraw(int amount)
	{
		if(amount>0)
		{
			// condition to check whether the withdraw amount is more than balance
			if(amount>balance)
			{
				// if withdraw amount is more than balance we cannot perform that operation
				// this message will get displayed to the user that withdraw amount is insufficient
				System.out.println("Cannot withdraw insufficient funds");
			}	
			else
			{
				// withdraw means deducting amount from the balance present, performing subtraction operation
				balance = balance - amount;
				//storing the withdrawn amount for transaction history
				previousTransaction = -amount;
			}
			
		}
	}
	//method which manages transaction history
	public void getPrevousTransaction()
	{
		//conditional statement to check whether the transaction amount is less than 0
		// if the amount is negative then it means withdrawn
		if(previousTransaction<0)
		{ 
			// here we are using "math.abs()" to get positive of the negative value i.e absolute value 
			System.out.println("Amount withdrawn from account "+Math.abs(previousTransaction)); 
		}
		else if(previousTransaction>0)
		{
			// if amount is positive then it means deposited
			System.out.println("Amount deposited to account "+previousTransaction);
		}
		else
		{
			// this statement is displayed if any transaction history is not present
			System.out.println("No transaction occured");
		}
	}	
	//This display method is created for user to perform actions externally on the account and display's
	// what type of actions can be performed
	public void display()
	{
		Scanner sc = new Scanner(System.in);
		char option;
		
		System.out.println("Welcome :)"+customerName); // greeting for user
		System.out.println("Your bank account ID is " + customerID +"\n"); // displaying account id associated to user 
		
		System.out.println("A -> Balance");
		System.out.println("B -> Deposit");
		System.out.println("C -> Withdraw");
		System.out.println("D -> Previous Transaction");
		System.out.println("E -> Exit \n");
		
		do 
		{
		//to seperate 
		System.out.println("--------------------------------------------------------------");
		System.out.println("Enter an option to perform action on account");
		System.out.println("--------------------------------------------------------------");
		// user entered option is stored in the option variable
		option = sc.next().charAt(0);
		
		// Here we are using switch case to jump directly to the user entered option and perform 
		// required action on the account
		switch(option)
		{
		case 'A':
			System.out.println("Your Balance is \n"+balance);
			break;
			
		case 'B':
			System.out.println("Enter an amount to deposit");
			int amount = sc.nextInt();
			// calls the deposit function and performs required action
			deposit(amount);
			break;
			
		case 'C':
			System.out.println("Enter an amount to withdraw");
			int amount2 = sc.nextInt();
			// calls the withdraw function and performs required action
			withdraw(amount2);
			break;
			
		case 'D':
			// calls the getPrevousTransaction function and performs required action
			getPrevousTransaction();
			break;
			
		case 'E':
			// closing message to user
			System.out.println("********** Thank you for using our services **********");
			System.exit(0);
			break;
			
		default:
			// this message is displayed when user enters option which is not part of the option list
			System.out.println("Invalid option selected --> Please enter again");
		}
		}while(option!='E');
	sc.close();
	}
}

public class BankingApplication {

	public static void main(String[] args) {
	
		// creating an object of the BankAccount class
		BankAccount ba = new BankAccount("JAVA","11");
		// calling display function which is to be visible for the user to perform operations on bank account
		ba.display();
	}
}

