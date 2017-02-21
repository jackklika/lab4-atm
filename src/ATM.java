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
	public void cardRead(int accountNum){
		
	}
	
	// Numbers are entered into the PIN pad. Returns the numbers
	public int num(int numbers){
		return 0;
	}
	
	// A string is displayed on the screen to the viewer
	public void display(String str){
		
	}
	
	// A string is sent to the printer to be printed. 
	public void print(String str){
		myPrinter.print();
	}
	
	// A button of of name <name> has been touched
	// 0: CANCEL
	// 1: W (withdraw)
	// 2: CB (check balance)
	public void buttonPress(int buttonID){
		
		switch(buttonID){
		case 0:
			//cancel things
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
	
	
	
	public void main(String[] args) {
		
		boolean userExit = false;
		
		
		Scanner reader = new Scanner(System.in);
		
		while (userExit == false){
			System.out.println("BOOT::");
			System.out.println("DO YOU WANT TO READ FROM THE (T)EXT FILE /transactions.txt OR (S)TDIN OR (E)XIT?");
			String answer = reader.next();
			if (answer == "T") {
				// goto text loop
			} else if (answer == "S") {
				// move on
			} else if (answer == "E") {
				userExit = true;
				System.out.println("Goodbye!");
				System.exit(0);
			} else {
				System.out.println("INVALID INPUT");
			}
		}
		
		while (userExit == false){
			System.out.println("Welcome to LLM Banking!");
			System.out.print("Please enter your account number: ");
			accountNum = reader.nextInt();
			
			System.out.print("Thank you. Now please enter your PIN: (Type 0 to exit)");
			pin = reader.nextInt();
			
			System.out.println("Valdating account...");
			
			userAccount = myBank.validate(accountNum, pin);
			if (userAccount != null){				
				System.out.println("Welcome!");
				
				
				
				while (userExit == false){
					
					System.out.println("AccountID: " + accountNum + " --- Balance: " + userAccount.balance);
					System.out.println("Please provide a function: (W)ithdraw, (D)eposit, or (E)xit");
					String input = reader.next().toUpperCase();
					
					if (input.equals("W")){ // Withdraw
						System.out.println("How much would you like to withdraw?");
						double wAmount = reader.nextDouble();
						withdraw(wAmount);						
					} else if (input.equals("D")) { // Deposit
						System.out.println("How much would you like to deposit?");
						double dAmount = reader.nextDouble();						
						deposit(dAmount);
						
					} else if (input.equals("E")) { // Exit
						userExit = true;
						System.out.println("Goodbye!");
						System.exit(0);
					} else { // invalid input!
						System.out.println("!!! " + input + " is invalid input");
					}
				}
				
				
				
				
				
			} else if ( pin == 0 ){
				System.out.println("Goodbye!");
				System.exit(0);
			} else { // Not validated
				System.out.println("Sorry, cannot validate account. Please try again.");
			}
			
		
		}
		reader.close();
		
	}

}
