public class CreditCard {
	private String cardHolder;
	private String type;	// credit provider
	private int number;
	
	public CreditCard(String newCardHolder,String newtype, int newNumber){
		cardHolder=newCardHolder;
		type=newType; 	
		number=newNumber;
	}
}
