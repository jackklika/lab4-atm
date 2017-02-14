import org.junit.*;
import static org.junit.Assert.*;

public class TestATM {
	//customer with account number 1234
	Customer c1 = new Customer(1234);
	//customer with account number 6789
	Customer c2 = new Customer(6789);
	
	ATM a1 = new ATM();
	
	@Test 
	public void testWithdrawl(){
	//validate account 1 with pin 6789
	a1.start(c1.Card, 6789);
	//attempt to withdrawl 20$ (valid)
	//check for successful withdrawl/validate
	
	//validate that new balance is 60?
	
	//validate again
		a1.start(c1.Card, 6789);	
		//attempt to withdrawl 80$ (invalid)
	}
	
	
	@Test
	public void testIncorrect(){
		a1.start(c2.Card, 4444);
		//invalid
	}
	
	@public void testDeposit(){
		a1.start(c2.Card, 4321);
		
		//attempt to deposit 20
		 
		//validate that new balance is 80
		
	}

}

