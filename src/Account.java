public class Account {
public int pin, account;
public double balance;

	Account(double balance, int pin, int account){
		this.account = account;
		this.balance = balance;
		this.pin = pin;
		
	}
	
	// Switch to card
	Account(int pin, int account){
		this.account = account;
		this.pin = pin;		
	}
	
	// Is there enough money in this account to withdraw
	public boolean validate(double withdrawalAmount){
		return (withdrawalAmount <= balance);
	}
	
}
