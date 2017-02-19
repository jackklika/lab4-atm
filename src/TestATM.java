import org.junit.*;
import static org.junit.Assert.*;

public class TestATM {
	
	
	//ATM a1 = new ATM();
	Bank myBank = new Bank();
	
	@Test 
	public void testWithdraw(){
	System.out.println("TestWithdraw:");
	//validate account 1 with pin 6789
	Account userAccount = myBank.validate(1234, 6789);
	//attempt to withdraw 20$ (valid)
	assertTrue(myBank.withdraw(20, userAccount));
	//validate that new balance is 60?
	assertTrue(userAccount.balance == 60);
	//attempt to withdraw 80$ (invalid)
	assertFalse(myBank.withdraw(80, userAccount));
	}
	
	
	@Test
	public void testIncorrect(){
		System.out.println("TestIncorrect:");
		assertTrue(myBank.validate(6789, 4444) == null);
	}
	
	@Test
	public void testDeposit(){
		System.out.println("TestDeposit:");
		Account userAccount = myBank.validate(6789, 4321);
		//attempt to deposit 20
		 assertTrue(myBank.deposit(20, userAccount));
		//validate that new balance is 80
		assertTrue(userAccount.balance == 80);
	}

}

