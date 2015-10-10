package system;

import java.text.DateFormat;

public class CreditCard {
	private String cardHolder;
	private String type;	// credit provider
	private int number;
	private String expiry;
	
	public CreditCard(String newCardHolder,String newType, 
			int newNumber, String newExpiry){
		setCardHolder(newCardHolder);
		setType(newType); 	
		setNumber(newNumber);
		setExpiry(newExpiry);
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}


}
