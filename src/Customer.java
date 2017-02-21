public class Customer {
	
	public Card c;
	
	public Customer(int account){
		this.c = new Card(account);
	}

	public Customer(Card tmp) {
		// TODO Auto-generated constructor stub
		tmp = c;
	}
}