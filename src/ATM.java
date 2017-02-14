import java.util.*;


public class ATM {

	// User's account number
	int accountNum = 0;
	
	// User's pin
	int pin = 0;
	

	
	// Validation Exceptions
	
	Bank myBank = new Bank();
	
	// Takes accountNumber which is validated by the Bank object against the pin
	public void start(int accountNumber, int pin){
		
		Account userAccount = new Account(pin, accountNumber);
		myBank.validate(userAccount);
		
	}
	
	
	// Returns true if withdrawal works, false if it doesn't and no operations occur
	// Assumes the pin was correct
	public boolean withdraw(int amount){
		myBank.validate(userAccount);
		
		
		
		
	}
	
	// Returns true if deposit works, false if it doesn't and no operations occur
	// Assumes the pin was corruect
	public boolean deposit(int amount){
		myBank.validate(userAccount);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		
		
		int userAccount = reader.nextInt();
		
		
		
	}

}