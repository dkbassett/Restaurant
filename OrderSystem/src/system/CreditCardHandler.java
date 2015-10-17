package system;

public abstract class CreditCardHandler {
	
	private static CreditCard selectedCreditCard;
	
	public CreditCardHandler (CreditCard newCreditCard) {
		setSelectedCreditCard(newCreditCard);		
	}
	
	public static void addNewCreditCard(CreditCard card, Customer cust){
		CreditCard.addNewCreditCardToDB(card, cust);
		CustomerHandler.getCurrentCustomer().addCreditCard(card);
		setSelectedCreditCard(card);
	}

	public static CreditCard getSelectedCreditCard() {
		return selectedCreditCard;
	}

	public static void setSelectedCreditCard(CreditCard selectedCreditCard) {
		CreditCardHandler.selectedCreditCard = selectedCreditCard;
	}
}
