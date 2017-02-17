import java.util.LinkedList;

public class Bank {
	LinkedList<Account> accounts = new LinkedList<Account>();

	public Bank() {		
		addAccount(80, 6789, 1234); // initial values as described
		addAccount(60, 4321, 6789); // initial values as described
	}

	public boolean addAccount(double balance, int pin, int account) {
		for (Account i : accounts) {
			if (i.account == account) {
				System.out.println("[ERR]\t Account already exists" );
				return false;
			}
		}
		accounts.add(new Account(balance, pin, account));
		System.out.println("[SUCCESS] Account added: " + " AccountID: " + account +  " Pin: " + pin + " Balance " + balance);
		return true;
	}

	public Account validate(int accountNum, int pin) {

		// loop to validate account, changed by kaitlyn
		// Returns account if the account is validated, null otherwise.
		for (Account i : accounts) {
			if (accountNum == i.account && pin == i.pin) {
				return i;
			}

		}
		return null;
		/*
		 * commenting out Johns code if(r.account == a.account){ if(r.pin ==
		 * a.pin){ return true; }else{ return false; } }else if(r.account ==
		 * b.account){ if(r.pin == b.pin){ return true; }else{ return false; }
		 * }else{ return false; }
		 */
	}

	
	public boolean withdraw(double amount, Account r){
		for (Account i : accounts) {
			if (r.account == i.account){ // Does the account have the same ID?
				if (i.validate(amount) == true) { // Does the account have the balance to withdraw from?
					i.balance -= amount;
					System.out.println("[SUCCESS]\t " + amount + " added to " + r.account + " Current Balance: " + r.balance);
					return true;
				}				
			}
		}
		System.out.println("[ERR]\t " + amount + " not added to " + r.account + " -- INSUFFICIENT FUNDS! Balance: " + r.balance);
		return false;
	}
	
	public boolean deposit(double amount, Account r){
		for (Account i : accounts) {
			if (r.account == i.account){ // Does the account have the same ID?
				i.balance += amount; // Just add it.
				return true;			
			}
		}
		return false;
	}

}
