public class CreditCard {
	private String cardHolder;
//	private CreditCardProvider type;	Need clarification on how to implement 
	private int number;
	
	public CreditCard(String newCardHolder, /* newCreditCardProvider newType,*/ int newNumber){
		cardHolder=newCardHolder;
//		type=newType; 	Needs Clarification
		number=newNumber;
	}
	
}
