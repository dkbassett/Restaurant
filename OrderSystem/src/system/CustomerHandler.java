package system;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

public abstract class CustomerHandler {
	
	private static Customer currentCustomer;
	
	public CustomerHandler (Customer newCurrentCustomer) {
		currentCustomer=newCurrentCustomer;		
	}
	
	public static Customer getCustByPhone (String phone){
		Customer cust = new Customer();
		try {
			CachedRowSet crs = new CachedRowSetImpl();
			crs = SystemDAOOracleImpl.readFromTable(SystemDAOOracleImpl.findCustomerByPhone(phone));
			while (crs.next()) {
				int id = crs.getInt("id");
				String name = crs.getString("name");
				String address = crs.getString("address");
				String phoneNo = crs.getString("phone_no");
				cust = new Customer(id, name, address, phoneNo);
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		} 
		currentCustomer = cust;
		return cust;
	}
	
	public void addNewCustomer(int Id,String name, String Address, String phoneNumber, CreditCard creditCard){
		Customer newCustomer = new Customer(Id,name,Address,phoneNumber,creditCard);
		SystemDAOOracleImpl.writeToTable(SystemDAOOracleImpl.createNewCustomer(newCustomer));
		currentCustomer = newCustomer;
	}
	
}
