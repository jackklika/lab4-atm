
public class CashDispenser {
	
	private int onHand = 10000;
	
	public void dispense(int c){
		onHand -= c;
	}
	
	public void deposit(int c){
		onHand += c;
	}
	
	
}
