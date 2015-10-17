package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import system.CreditCard;
import system.OrderItem;

public class CreditCardTableModel extends AbstractTableModel {
	
	private List<CreditCard> creditCards;
	
	public CreditCardTableModel(List<CreditCard> creditCards) {
		this.setCreditCards(creditCards);
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return getCreditCards().size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
        case 0: return "Type";
        case 1: return "Number";
        case 2: return "Expiry";
        case 3: return "Card Holder";
        }
		return null;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CreditCard creditCard = getCreditCards().get(rowIndex);
		
		switch (columnIndex) {
		case 0: return creditCard.getType();
		case 1: return creditCard.getNumber();
		case 2: return creditCard.getExpiry();
		case 3: return creditCard.getCardHolder();
		}
		
		return creditCard;
	}
	
	public void addCreditCard(CreditCard creditCard) {
		int size = getRowCount();
		getCreditCards().add(creditCard);
		fireTableRowsInserted(size, size);
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	
}
