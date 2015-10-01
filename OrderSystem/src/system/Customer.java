package system;

public class Customer{
	
	private int id;
	private String name;
	private String address;
	private int phoneNumber;
	private CreditCard creditCard;
	
	
	public Customer(int newId, String newName, String newAddress, int newPhoneNumber, CreditCard newCreditCard){
		setId(newId);
		name=newName;
		address=newAddress;
		phoneNumber=newPhoneNumber;
		creditCard=newCreditCard;
	}
	
	public void updateAddress(String updatedAddress){
			address=updatedAddress;
	}
	
	public void updateCreditCard(CreditCard updatedCreditCard){
		creditCard=updatedCreditCard;
	}
	public int getPhoneNumber(){
		return (int) (phoneNumber);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
