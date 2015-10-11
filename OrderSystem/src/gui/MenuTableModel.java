package gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import system.MenuItem;

public class MenuTableModel extends AbstractTableModel {
	
	private List<MenuItem> menuItems;
	
	public MenuTableModel(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return menuItems.size();
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		MenuItem menuItem = menuItems.get(rowIndex);
		
		switch (columnIndex) {
		case 0: return menuItem.getId();
		case 1: return menuItem.getName();
		case 2: return menuItem.getPrice();
		}
		
		return menuItem;
	}
	
}
