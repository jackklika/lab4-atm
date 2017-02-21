import java.util.*;
import java.time.*;


public class ATM {

	// User's account number
	private int accountNum = 0;
	
	
	
	// User's pin
	private int pin = 0;
	
	private Account userAccount;

	private Bank myBank;
	
	private Printer myPrinter;
	
	private Customer currentCustomer = null;
	
	// Validation Exceptions
	public ATM() {
		myBank = new Bank();
		myPrinter = new Printer();
		
	}
	
	
	// Returns true if withdrawal works, false if it doesn't and no operations occur
	// Assumes the pin was correct
	public boolean withdraw(double amount){
		// account.validate (not bank.validate(account))				
		return (myBank.withdraw(amount, userAccount));		
	}
	
	// Returns true if deposit works, false if it doesn't and no operations occur
	// Assumes the pin was correct
	public boolean deposit(double amount){		
		return myBank.deposit(amount, userAccount);
	}
	
	
	// Reads the card and stores the account number.
	// CARDREAD <num>
	public void cardRead(int accountNum){
		currentCustomer = new Customer(accountNum);
		//curCustomer.c.accountNumber;
	}
	
	// Numbers are entered into the PIN pad. Returns the numbers.
	public int num(int numbers){
		return 0;
	}
	
	// A string is displayed on the screen to the viewer
	public void display(String str){
		
	}
	
	// A string is sent to the printer to be printed. 
	// FORMAT: "[TIMESTAMP]\t TRANSACTIONTYPE AMOUNT
	
	public void print(String str){
		myPrinter.print("[" + Instant.now() + "]\t" + " -- "); //WIP
	}
	
	// Clears everything from the ATM after a user exits.
	public void clear(){
		currentCustomer = null;
	}
	
	// A button of of name <name> has been touched
	// 0: CANCEL
	// 1: W (withdraw)
	// 2: CB (check balance)
	public void buttonPress(int buttonID){
		
		switch(buttonID){
		case 0:
			clear();
			break;
		case 1: 
			//withdraw things
			break;
		case 2:
			//check balance
			break;
		default:
			//invalid input thing
			break;
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(Instant.now());
	}
	
}
