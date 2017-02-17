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
		
	}
	
	
	// Returns true if withdrawal works, false if it doesn't and no operations occur
	// Assumes the pin was correct
	public static boolean withdraw(double amount){
		// account.validate (not bank.validate(account))
				
		
		return (myBank.withdraw(amount, userAccount));
		
		
	}
	
	// Returns true if deposit works, false if it doesn't and no operations occur
	// Assumes the pin was correct
	public static boolean deposit(double amount){
		
		return myBank.deposit(amount, userAccount);
	}
	
	
	
	public static void main(String[] args) {
		
		boolean userExit = false;
		
		
		Scanner reader = new Scanner(System.in);
		
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
