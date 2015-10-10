package system;

public abstract class CustomerHandler {
	
	private static Customer currentCustomer;
	
	public CustomerHandler (Customer newCurrentCustomer) {
		currentCustomer = newCurrentCustomer;		
	}
	
	public static Customer getCustByPhone (String phone){
		Customer cust = Customer.getCustByPhoneFromDB(phone);
		currentCustomer = cust;
		return cust;
	}
	
	public static void addNewCustomer(String name, String address, String phoneNumber){
		Customer cust = Customer.addNewCustomerToDB(name, address, phoneNumber);
		currentCustomer = cust;
	}
	
}
