package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import system.MenuItem;
import system.OrderItem;

public class MenuTableModel extends AbstractTableModel {
	
	private List<MenuItem> menuItems;
	private boolean[] editableColumns = new boolean[3];
	
	public MenuTableModel(List<MenuItem> menuItems) {
		this.setMenuItems(menuItems);
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return getMenuItems().size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
        case 0: return "ID";
        case 1: return "Name";
        case 2: return "Price";
        }
		return null;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		
		switch (columnIndex) {
		case 0: return editableColumns[0];
		case 1: return editableColumns[1];
		case 2: return editableColumns[2];
		default: return false;
		}
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		MenuItem menuItem = getMenuItems().get(rowIndex);
		
		switch (columnIndex) {
		case 0: return menuItem.getId();
		case 1: return menuItem.getName();
		case 2: return menuItem.getPrice();
		}
		
		return menuItem;
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		MenuItem menuItem = getMenuItems().get(rowIndex);
		
		if (columnIndex == 1) {
			menuItem.setName((String)value);
			fireTableCellUpdated(rowIndex, columnIndex);
		}
		if (columnIndex == 2) {
			String valueString = (String)value;
			menuItem.setPrice(Float.parseFloat(valueString));
			fireTableCellUpdated(rowIndex, columnIndex);
		}
	}
	
	public void setEditableColumn(int index, boolean value) {
		this.editableColumns[index] = value;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
}
