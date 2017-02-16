import java.util.LinkedList;

public class Bank {
	LinkedList<Account> Accounts;

	public Bank() {
		Account a = new Account(80, 6789, 1234); // initial values as described
		Account b = new Account(60, 4321, 6789); // initial values as described
	}
<<<<<<< HEAD

	public boolean addAccount(int balance, int pin, int account) {
		for (Account i : Accounts) {
			if (i.account == account) {
=======
	Accounts.add(new Account(balance, pin, account));
	return true;
}
public boolean validate(Account r){
	if(r.account == a.account){
		if(r.pin == a.pin){
			return true;
		}else{
			return false;
		}
	}else if(r.account == b.account){
			if(r.pin == b.pin){
				return true;
			}else{
>>>>>>> branch 'master' of https://github.com/jackklika/lab4-atm
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

	private boolean withdraw(double amount, Account r) {
		for (Account i : Accounts) {
			if (r.account == i.account) {
				if (i.balance > amount) {
					i.balance -= amount;
					return true;
				}
			}

		}
		return false;
	}

}
