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

	private boolean validate(Account r) {

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

	private boolean changeBalance(double amount, Account r) {
		for (Account i : Accounts) {
			if (r.account == i.account) {
				//check positive or negative
				if(amount > 0){
					//if positive, deposit
					i.balance += amount;
					return true;
				}
				else{
					//withdraw, make sure there is enough money in account
					if (i.balance > Math.abs(amount)) { 
						//withdraw
						i.balance += amount;
						return true;
					}
				}
			}

		} 
		return false;
	}

}
