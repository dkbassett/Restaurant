package system;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class CreditCard {
	private String cardHolder;
	private String type;	// credit provider
	private String number;
	private String expiry;
	
	public CreditCard() {
		
	}
	
	public CreditCard(String newCardHolder,String newType, 
			String newNumber, String newExpiry){
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	
	public static ArrayList<CreditCard> getCreditCardsFromDB(Customer cust) {
		
		ArrayList<CreditCard> creditCardList = new ArrayList<CreditCard>();
		
		try {
			CachedRowSet crs = new CachedRowSetImpl();
			crs = SystemDAOOracleImpl.readFromTable(SystemDAOOracleImpl.findCreditCardsByCustomer(cust));		
			ResultSetMetaData rsmd = crs.getMetaData();
            int columnsNum = rsmd.getColumnCount();

			while(crs.next()) {				
				CreditCard creditCard = new CreditCard();
				creditCard.setNumber(crs.getString("cr_number"));
				creditCard.setExpiry(crs.getString("exp"));
				creditCard.setCardHolder(crs.getString("cr_holder"));
				creditCard.setType(crs.getString("cr_provider"));
				
				creditCardList.add(creditCard);			
				System.out.println("Credit Card number: " + creditCard.getNumber());
			}
			
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		return creditCardList;
	}


}
