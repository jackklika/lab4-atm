public class Customer {
	
	public Card card;
	public int pin;
	
	public Customer(int account){
		this.card = new Card(account);
	}
}