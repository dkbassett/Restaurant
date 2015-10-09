package system;

import java.sql.SQLException;

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
		} 
		return cust;
	}
	
	public static Customer addNewCustomerToDB(int Id,String name, String Address, String phoneNumber){
		Customer newCustomer = new Customer(Id,name,Address,phoneNumber);
		SystemDAOOracleImpl.writeToTable(SystemDAOOracleImpl.createNewCustomer(newCustomer));
		return newCustomer;
	}
	
	
}
