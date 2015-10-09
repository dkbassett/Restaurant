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
	
	public static void addNewCustomer(int Id,String name, String Address, String phoneNumber){
		Customer cust = Customer.addNewCustomerToDB(Id, name, Address, phoneNumber);
		currentCustomer = cust;
	}
	
}
