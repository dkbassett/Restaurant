package system;

import java.text.DateFormat;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.SQLException;
import javax.naming.NamingException;

import com.sun.rowset.*; // for making a dataset, need to implement
import javax.sql.rowset.CachedRowSet; // for making a dataset, need to implement

public class SystemDAOOracleImpl {
	
	private static final String DB_URL = ""; //need to find out how to get db url
	private static final String USER = ""; //need to set up user
	private static final String PASS = ""; //need to set password
	
	// Problems with naming, need to research more.
	public static Connection getConnection() {
		Connection conn = null;	
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setDatabaseName("ORDER_SYSTEM");
			Context ctx = new InitialContext();
			ctx.bind("jdbc/RestaurantDB", ods);
			
			OracleDataSource ds = (OracleDataSource)ctx.lookup("jdbc/RestaurantDB");
			
			conn = ds.getConnection(USER, PASS);
			System.out.println("Database connected");
		} catch (NamingException e) {
			System.err.println("Naming Exception: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
			return null;
		}
        return conn;
	}
	
	// Find a customer by phone. This should return a customer object
	// when extracted from data set.
	public String findCustomerByPhone(int phone) {		
		String statement = 
				"SELECT C.id, C.name, C.address, C.phone_no " +
				"FROM customer C " +
				"WHERE C.phone_no = " + phone + ";";	
		return statement;
	}
	
	// Add a credit card to database. Two tables need to be inserted into.
	public String addCreditCard(CreditCard card, Customer cust) {
		int custId = cust.getId();
		int number = card.getNumber();
		DateFormat expiry = card.getExpiry();
		String holder = card.getCardHolder();
		String provider = card.getType();
		String statement = 
				"INSERT INTO credit_card " +
				"VALUES ( " + number + "," + expiry + "," 
							+ holder + "," + provider + ");" +
				"INSERT INTO uses_card " +
				"VALUES ( " + custId + "," + number + ","
							+ expiry + ");";
		return statement;
	}
	
	// Find a menu item by number. This should return a menu item
	// when extracted from data set.
	public String findMenuItemByNumber(int number) {
		String statement =
				"SELECT M.id, M.name, M.price " +
				"FROM menu_item M " +
				"WHERE M.id = " + number + ";";
		return statement;
	}
	
	// Select all menu items. This should return menu items in an
	// array or list when extracted from data set.
	public String selectAllMenuItems() {
		String statement =
				"SELECT * " +
				"FROM menu_item;";
		return statement;
	}
	
	// Updates menu item in database.
	public String updateMenuItem(MenuItem item) {
		int id = item.getId();
		String name = item.getName();
		float price = item.getPrice();
		String statement =
				"UPDATE menu_item " +
				"SET name = " + name + ", price = " + price +
				"WHERE id = " + id + ";";		
		return statement;
	}
	
	// Inserts order into database.
	public String saveOrder(Order order) {
		int ordId = order.getId();
		int custId = order.getCustomerID();
		String delivery = order.getDelivery();
		DateFormat date = DateFormat.getDateInstance();
		float total = order.getGrandTotal();
		String statement = 
				"INSERT INTO order_transaction " +
				"VALUES ( " + ordId + "," + custId + ","
							+ delivery + "," + date + ","
							+ total + ";";
		return statement;
	}
}
