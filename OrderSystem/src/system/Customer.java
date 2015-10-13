package system;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class Customer{
	
	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	private CreditCard creditCard;
	
	public Customer() {
	}
	
	public Customer(String newName, String newAddress, String newPhoneNumber){ // non ID Instantiated version
		setName(newName);
		setAddress(newAddress);
		phoneNumber=newPhoneNumber;		
		System.out.println("Logic Level: " + name);
		System.out.println("Logic Level: " + address);
		System.out.println("Logic Level: " + phoneNumber);
	}
	
	public Customer(int newId, String newName, String newAddress, String newPhoneNumber){
		setId(newId);
		setName(newName);
		setAddress(newAddress);
		phoneNumber=newPhoneNumber;
	}
	
	public Customer(int newId, String newName, String newAddress, String newPhoneNumber, CreditCard newCreditCard){
		setId(newId);
		setName(newName);
		setAddress(newAddress);
		phoneNumber=newPhoneNumber;
		creditCard=newCreditCard;
	}
	
	public void updateAddress(String updatedAddress){
			setAddress(updatedAddress);
	}
	
	public void updateCreditCard(CreditCard updatedCreditCard){
		creditCard=updatedCreditCard;
	}
	public String getPhoneNumber(){
		return (String) (phoneNumber);
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public static Customer getCustByPhoneFromDB (String phone){
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
			e.printStackTrace();
		} 
		return cust;
	}
	
	public static List<Customer> getCustomersFromDB() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		try {
			CachedRowSet crs = new CachedRowSetImpl();
			crs = SystemDAOOracleImpl.readFromTable(SystemDAOOracleImpl.selectAllCustomers());		
			ResultSetMetaData rsmd = crs.getMetaData();
            int columnsNum = rsmd.getColumnCount();
            
            System.out.println("About to start while loop of customers");
			while(crs.next()) {				
				Customer customer = new Customer();
				customer.setId(crs.getInt("ID"));
				customer.setName(crs.getString("Name"));
				customer.setAddress(crs.getString("Address"));
				customer.setPhoneNumber(crs.getString("Phone_No"));
				
				customerList.add(customer);			
				System.out.println("Customer Name: " + customer.getName());
			}
			
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		return customerList;
	}
	
	public static Customer addNewCustomerToDB(String name, String address, String phoneNumber){
		Customer newCustomer = new Customer(name, address, phoneNumber);
		SystemDAOOracleImpl.writeToTable(SystemDAOOracleImpl.createNewCustomer(newCustomer));
		return newCustomer;
	}
	
	
}
