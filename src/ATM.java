import java.util.*;


public class ATM {

	// User's account number
	private static int accountNum = 0;
	
	// User's pin
	private static int pin = 0;
	
	private static Account userAccount;

	private static Bank myBank = new Bank();
	
	
	// Validation Exceptions
	
	
	
	// Takes accountNumber which is validated by the Bank object against the pin
	public static void start(int accountNumber, int pin){
		
		userAccount = new Account(pin, accountNumber);
		myBank.validate(userAccount);
		
	}
	
	
	// Returns true if withdrawal works, false if it doesn't and no operations occur
	// Assumes the pin was correct
	public static boolean withdraw(int amount){
		// account.validate (not bank.validate(account))
				
		
		
		
	}
	
	// Returns true if deposit works, false if it doesn't and no operations occur
	// Assumes the pin was corruect
	public static boolean deposit(int amount){
		// account.validate (not bank.validate(account))
				
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean userExit = false;
		
		
		Scanner reader = new Scanner(System.in);
		
		while (userExit){
			System.out.println("Welcome to LLM Banking!");
			System.out.print("Please enter your account number: ");
			accountNum = reader.nextInt();
			
			System.out.print("Thank you. Now please enter your PIN: (Type 0 to exit)");
			pin = reader.nextInt();
			
			System.out.println("Valdating account...");
			if (myBank.validate(userAccount) == true){
				
				System.out.println("You're in!");
				
				while (userExit){
					
					System.out.println("Please provide a function: (W)ithdraw, (D)eposit, or (E)xit");
					String input = reader.next().toUpperCase();
					
					if (input == "W"){ // Withdraw
						System.out.println("How much would you like to withdraw?");
						int wAmount = reader.nextInt();
						withdraw(wAmount);
						
					} else if (input == "D") { // Deposit
						System.out.println("How much would you like to deposit?");
						int dAmount = reader.nextInt();						
						deposit(dAmount);
						
					} else if (input == "E") { // Exit
						userExit = true;
						System.out.println("Goodbye!");
						System.exit(0);
					} else { // invalid input!
						
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
