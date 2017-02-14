import java.util.LinkedList;

public class Bank  {
LinkedList <Account> Accounts; 
public Bank(){
Account a = new Account(80, 6789, 1234); //initial values as described
Account b = new Account(60, 4321, 6789); //initial values as described 
}
public boolean addAccount(int balance, int pin, int account){
	for(Account i : Accounts){
		if(i.account == account){
			return false;
		}
	}
	Accounts.add(new Account(balance, pin, account));
	return true;
}
private boolean validate(Account r){
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
				return false;
			}
		}else{
			return false;
		}
	}
	
}
