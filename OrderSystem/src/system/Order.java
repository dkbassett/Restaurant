package system;

import java.util.* ;

public class Order {
	
	private int id;
	private int customerID;
	private ArrayList<OrderItem> itemList = new ArrayList<OrderItem>(1);
	private boolean confirmationStatus;
	private String delivery; 	// delivery type	
	private float grandTotal;
	private int cnt=0; // counter for current itemlist element
	
	public Order(int newId,int newCustomerID , String newDelivery){ 
		setId(newId);
		setCustomerID(newCustomerID);
		setDelivery(newDelivery); 
	}
	
	public void addItemToOrder(MenuItem newMenuItem, int newQuantity){
		OrderItem currentItem = new OrderItem(newMenuItem,newQuantity);
		itemList.add(currentItem);
	}
	
	public void confirmOrder(){
		confirmationStatus = true ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
}
