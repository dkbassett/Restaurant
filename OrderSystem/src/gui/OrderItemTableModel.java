package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import system.OrderItem;

public class OrderItemTableModel extends AbstractTableModel {
	
	private List<OrderItem> orderItems;
	
	public OrderItemTableModel(List<OrderItem> orderItems) {
		this.setOrderItems(orderItems);
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return getOrderItems().size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
        case 0: return "Name";
        case 1: return "Price";
        case 2: return "Quantity";
        }
		return null;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		int size = getRowCount();
		getOrderItems().add(orderItem);
		fireTableRowsInserted(size, size);
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OrderItem orderItem = getOrderItems().get(rowIndex);
		
		switch (columnIndex) {
		case 0: return orderItem.getMenuItem().getName();
		case 1: return orderItem.getMenuItem().getPrice();
		case 2: return orderItem.getQuantity();
		}
		
		return orderItem;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: return false;
		case 1: return false;
		case 2: return true;
		default: return false;
		}
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		OrderItem orderItem = getOrderItems().get(rowIndex);
		
		if (columnIndex == 2) {
			orderItem.setQuantity((Integer.valueOf((String)value)));
		}
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
