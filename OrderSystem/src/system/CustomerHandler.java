package system;

public abstract class CustomerHandler {
	
	private static Customer currentCustomer;
	
	public CustomerHandler (Customer newCurrentCustomer) {
		setCurrentCustomer(newCurrentCustomer);		
	}
	
	public static Customer getCustByPhone (String phone){
		Customer cust = Customer.getCustByPhoneFromDB(phone);
		setCurrentCustomer(cust);
		return cust;
	}
	
	public static void addNewCustomer(String name, String address, String phoneNumber){
		Customer cust = Customer.addNewCustomerToDB(name, address, phoneNumber);
		setCurrentCustomer(cust);
	}

	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public static void setCurrentCustomer(Customer currentCustomer) {
		CustomerHandler.currentCustomer = currentCustomer;
	}
	
}
