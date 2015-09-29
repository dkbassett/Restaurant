public class CustomerHandler {
	
	private Customer currentCustomer;
	
	public CustomerHandler (Customer newCurrentCustomer) {
		currentCustomer=newCurrentCustomer;		
	}
	
	public int getCustByPhone (){
		return (int) (currentCustomer.getPhoneNumber());
	}
	public void addNewCustomer(Customer newCustomer){
		currentCustomer=newCustomer; // Verify this is what UML intended
	}
	
}
