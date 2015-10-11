package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import system.Customer;

public class CustomerTableModel extends AbstractTableModel {
	
	private List<Customer> customers;
	
	public CustomerTableModel(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return customers.size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
        case 0: return "ID";
        case 1: return "Name";
        case 2: return "Address";
        case 3: return "Phone Number";
        }
		return null;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer customer = customers.get(rowIndex);
		
		switch (columnIndex) {
		case 0: return customer.getId();
		case 1: return customer.getName();
		case 2: return customer.getAddress();
		case 3: return customer.getPhoneNumber();
		}
		
		return customer;
	}
	
}
