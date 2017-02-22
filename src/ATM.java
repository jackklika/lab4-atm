import java.util.*;
import java.time.*;


public class ATM {
	
	
	// This indicates the state of this application in regards to user input handling.
	// NOINPUT: Not accepting input.
	// PIN: User can enter pin
	// CASH: User entering cash amount
	
	public enum state{
		NOINPUT, PIN, CASH;
	}

	// User's state
	public state atmState;
	
	// NOt sure if we need this
	private int pin = 0;
	
	private Customer currentCustomer = null;
	private Account userAccount;

	private Bank myBank;
	
	// Peripherals
	private Printer myPrinter;
	private CashDispenser myDispenser;
	
	
	// Validation Exceptions?
	public ATM() {
		myBank = new Bank();
		myPrinter = new Printer();	
		myDispenser = new CashDispenser();
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
		currentCustomer = new Customer(new Card(accountNum));
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
	
	public void print(String transactionType){
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
			atmState = state.CASH;
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
	
	}
	
}
