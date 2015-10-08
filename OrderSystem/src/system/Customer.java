package system;

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
		address=newAddress;
		phoneNumber=newPhoneNumber;
	}
	
	public Customer(int newId, String newName, String newAddress, String newPhoneNumber, CreditCard newCreditCard){
		setId(newId);
		setName(newName);
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
	
	
}
