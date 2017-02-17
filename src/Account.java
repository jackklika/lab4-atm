public class Account {
public int account, pin;
public double balance;
	Account(double Balance, int pin, int account){
		this.account = account;
		this.balance =Balance;
		this.pin = pin;
		
	}
	Account( int pin, int account){
		this.account = account;
		this.pin = pin;
		
	}
	
	// Vaidates the amount could be withdrawn from the account
	// Returns true if the amount can be withdrawn. Returns false if the amount cannot.
	public boolean validate(double amountWithdrawn){
		return (Math.abs(amountWithdrawn) <= balance);
	}
	
}
