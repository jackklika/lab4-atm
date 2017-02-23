import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;


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
	private int amount; // the amount of money withdrawn
	
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
		output("CARDREAD " + accountNum);
		currentCustomer = new Customer(new Card(accountNum));
		atmState = state.PIN;
		//DIS "Enter PIN";
	}
	
	// Numbers are entered into the PIN pad. Returns the numbers.
	public void num(int numbers){
		switch (atmState) {
			case PIN:
				userAccount = myBank.validate(currentCustomer.card.accountNumber, numbers);
				if (userAccount == null){ // failed validation -- account doesn't exist or pin is incorrect
					clear(); // Reset ATM
				} else { // Account exists and matches with pin
					
				}
				break;
			
			case CASH:
				if (userAccount != null){
					if (withdraw(numbers)){ // performs this function. If it's true, it prints.
						// Withdraw money
					} else {
						// failed withdrawal -- not enough cash
					}
				} else {
					// account not valid
				}
				
				break;
				
			case NOINPUT:
				// Nothing should happen. No input is expected.				
		}
	}
	
	// A string is displayed on the screen to the viewer
	public void display(String str){
		System.out.println(str); // "Prints it out to the screen"
	}
	
	// A string is sent to the printer to be printed. 
	// FORMAT: "[TIMESTAMP]\t TRANSACTIONTYPE [AMOUNT IN ACCOUNT]
	
	public void print(String transactionType){
		myPrinter.print("[" + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())
				+ "]\t" + " -- " + transactionType + "  $" + amount); //WIP
	}
	
	// Prints to standard console
	public void output(String str){
		System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + " " + str);
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
			output("BUTTON CANCEL");
			break;
		case 1: 
			atmState = state.CASH;
			output("BUTTON W");
			break;
		case 2:
			//check balance
			output("BUTTON CB");
			break;
		default:
			//invalid input thing
			break;
		}
	}
	

	
	
	
	public static void main(String[] args) {

	}
}
