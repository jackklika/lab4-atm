import java.util.LinkedList;

public class Bank {
	LinkedList<Account> Accounts;

	public Bank() {
		Account a = new Account(80, 6789, 1234); // initial values as described
		Account b = new Account(60, 4321, 6789); // initial values as described
	}

	public boolean addAccount(double balance, int pin, int account) {
		for (Account i : Accounts) {
			if (i.account == account) {
				return false;
			}
		}
		Accounts.add(new Account(balance, pin, account));
		return true;
	}

	public boolean validate(Account r) {

		// loop to validate account, changed by kaitlyn
		for (Account i : Accounts) {
			if (r.account == i.account) {
				return (r.pin == i.pin);
			}

		}
		return false;
		/*
		 * commenting out Johns code if(r.account == a.account){ if(r.pin ==
		 * a.pin){ return true; }else{ return false; } }else if(r.account ==
		 * b.account){ if(r.pin == b.pin){ return true; }else{ return false; }
		 * }else{ return false; }
		 */
	}

	
	public boolean withdraw(double amount, Account r){
		for (Account i : Accounts) {
			if (r.account == i.account){ // Does the account have the same ID?
				if (i.validate(amount) == true) { // Does the account have the balance to withdraw from?
					i.balance -= amount;
					return true;
				}				
			}
		}
		return false;
	}
	
	public boolean deposit(double amount, Account r){
		for (Account i : Accounts) {
			if (r.account == i.account){ // Does the account have the same ID?
				i.balance += amount; // Just add it.
				return true;			
			}
		}
		return false;
	}

}
