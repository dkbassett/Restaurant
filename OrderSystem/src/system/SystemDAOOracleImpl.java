package system;

import java.sql.*;
import java.text.DateFormat;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import oracle.jdbc.pool.OracleDataSource;
import oracle.sql.*;

import java.sql.SQLException;
import javax.naming.NamingException;

import com.sun.rowset.*;
import javax.sql.rowset.CachedRowSet; 

public class SystemDAOOracleImpl {
	
	private static final String DB_URL = "jdbc:oracle:thin:DEV/group2@//localhost:1521/XE";
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// Gets connection to database
	public static Connection getConnection() {
		Connection conn = null;	
		try {
			OracleDataSource ds = new OracleDataSource();			
			ds.setURL(DB_URL);
			
			conn = ds.getConnection();
			
//			System.out.println("Database connected? " + ds.getConnection());
			
			System.out.println("Database connected");
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
        return conn;
	}
	
	public static void printFromTable(String sqlString) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlString);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNum = rsmd.getColumnCount();
            System.out.println("Column count is: " + columnsNum);          
            System.out.println("Reading from database");
            
            while(rs.next()) {
            	
//            	System.out.println("while loop executing");
                for(int i = 1; i <= columnsNum; i++) {
//                	System.out.println("for loop executing");
                    String columnValue = rs.getString(i);
                    System.out.println(rsmd.getColumnName(i) + ": " + columnValue);
                }
            }
            
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("closed connection");
        } catch(SQLException e) {
            System.err.println("Print SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }
	
	 public static CachedRowSet readFromTable(String sqlString) {        
        try {
            CachedRowSet crs = new CachedRowSetImpl();
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlString);            
            System.out.println("Reading from database"); 
            crs.populate(rs);
            rs.close();
            stmt.close();
            conn.close();
            return crs;
        } catch(SQLException e) {
            System.err.println("Read SQLException: " + e.getMessage());
            return null;
        }
	}
	 
	 public static void writeToTable(String sqlString) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlString);
            System.out.println("Statement written to database");
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            System.err.println("Write SQLException: " + e.getMessage()
            + e.getErrorCode());
             e.printStackTrace();
        } 
    }
	
	public static String selectAllCustomers() {		
		return 	"SELECT * " +
				"FROM customer";
	}
	
	// Inserts a new customer in database by a customer object
	public static String createNewCustomer(Customer newCustomer) {
		String name = newCustomer.getName();
		String address = newCustomer.getAddress();
		String phone = newCustomer.getPhoneNumber();
		return 	"INSERT INTO Customer C " +
				"VALUES (NULL, '" + name + ", '" 
						+ address + "' ,'" + phone + "')";
	}
	
	// Find a customer by phone. This should return a customer object
	// when extracted from data set.
	public static String findCustomerByPhone(String phone) {		
		return 	"SELECT C.id, C.name, C.address, C.phone_no " +
				"FROM customer C " +
				"WHERE C.phone_no = " + phone;	
	}
	
	// Add a credit card to database. Two tables need to be inserted into.
	public String addCreditCard(CreditCard card, Customer cust) {
		int custId = cust.getId();
		int number = card.getNumber();
		DateFormat expiry = card.getExpiry();
		String holder = card.getCardHolder();
		String provider = card.getType();
		return	"BEGIN TRANSACTION " +
				"INSERT INTO credit_card " +
				"VALUES ( " + number + "," + expiry + "," 
							+ holder + "," + provider + ");" +
				"INSERT INTO uses_card " +
				"VALUES ( " + custId + "," + number + ","
							+ expiry + ");" +
				"COMMIT";
	}
	
	// Find a menu item by number. This should return a menu item
	// when extracted from data set.
	public String findMenuItemByNumber(int number) {
		return	"SELECT M.id, M.name, M.price " +
				"FROM menu_item M " +
				"WHERE M.id = " + number;
	}
	
	// Select all menu items. This should return menu items in an
	// array or list when extracted from data set.
	public String selectAllMenuItems() {
		return	"SELECT * " +
				"FROM menu_item";
	}
	
	// Updates menu item in database.
	public String updateMenuItem(MenuItem item) {
		int id = item.getId();
		String name = item.getName();
		float price = item.getPrice();
		return	"UPDATE menu_item " +
				"SET name = " + name + ", price = " + price +
				"WHERE id = " + id;
	}
	
	// Inserts order into database.
	public String saveOrder(Order order) {
		int ordId = order.getId();
		int custId = order.getCustomerID();
		String delivery = order.getDelivery();
		DateFormat date = DateFormat.getDateInstance();
		float total = order.getGrandTotal();
		return	"INSERT INTO order_transaction " +
				"VALUES ( " + ordId + "," + custId + ","
							+ delivery + "," + date + ","
							+ total;
	}
}
