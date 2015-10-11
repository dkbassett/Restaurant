package system;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class MenuItem {
	
	private int id;
	private String name;
	private float price;
	
	public MenuItem() { 		
	}
	
	public MenuItem(String newId, String newName, String newPrice){
		System.out.println("MenuItem-Logic");
		id = Integer.parseInt(newId);
		setName(newName);
		price = Float.parseFloat(newPrice);
		System.out.println("Logic Level: " + id);
		System.out.println("Logic Level: " + name);
		System.out.println("Logic Level: " + price);
		
	}
	
	public void updatePrice(float updatedPrice){
		setPrice(updatedPrice);
	}
	
	
	public static List<MenuItem> getMenuItemsFromDB() {
		
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		
		try {
			CachedRowSet crs = new CachedRowSetImpl();
			crs = SystemDAOOracleImpl.readFromTable(SystemDAOOracleImpl.selectAllMenuItems());		
			ResultSetMetaData rsmd = crs.getMetaData();
            int columnsNum = rsmd.getColumnCount();

			while(crs.next()) {				
				MenuItem menuItem = new MenuItem();
				menuItem.setId(crs.getInt("ID"));
				menuItem.setName(crs.getString("Name"));
				menuItem.setPrice(crs.getFloat("Price"));
				
				menuItemList.add(menuItem);			
				System.out.println("Menu Item ID: " + menuItem.getId());
			}
			
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		return menuItemList;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
