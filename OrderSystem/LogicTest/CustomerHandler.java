public class CustomerHandler {
	
	private Customer currentCustomer;
	
	public CustomerHandler (Customer newCurrentCustomer) {
		currentCustomer=newCurrentCustomer;		
	}
	
	public Customer getCustByPhone (){
		return (int) (currentCustomer.phoneNumber)
	}
	public void addNewCustomer(Customer newCustomer){
		currentCustomer=newCustomer; // Verify this is what UML intended
	}
	
}
