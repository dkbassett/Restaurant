public class CustomerHandler {
	
	private Customer currentCustomer;
	
	public CustomerHandler (Customer newCurrentCustomer) {
		currentCustomer=newCurrentCustomer;		
	}
	
	public int getCustByPhone (){
		return (int) (currentCustomer.getPhoneNumber());
	}
	public void addNewCustomer(int Id,String name, String Address, int phoneNumber, CreditCard creditCard){
		Customer newCustomer = new Customer(Id,name,Address,phoneNumber,creditCard);
		currentCustomer=newCustomer;
	}
	
}
