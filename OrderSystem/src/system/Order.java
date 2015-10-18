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
	
	// constructor without Id
	public Order(int newCustomerID, ArrayList<OrderItem> orderItems, 
			String newDelivery, float total){ 
		setCustomerID(newCustomerID);
		setItemList(orderItems);
		setDelivery(newDelivery);
		setGrandTotal(total);
	}	
	
	// constructor with Id
	public Order(int newId, int newCustomerID, ArrayList<OrderItem> orderItems, 
			String newDelivery, float total) { 
		setId(newId);
		setCustomerID(newCustomerID);
		setItemList(orderItems);
		setDelivery(newDelivery);
		setGrandTotal(total);
	}
	
	public void addItemToOrder(OrderItem orderItem){
		getItemList().add(orderItem);
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

	public ArrayList<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<OrderItem> itemList) {
		this.itemList = itemList;
	}
	
	public float calculateTotal() {
		float total = 0.00F;
		for (int i = 0; i < itemList.size(); i++) {
			float menuItemPrice = itemList.get(i).getMenuItem().getPrice();			
			float orderItemPrice = menuItemPrice * itemList.get(i).getQuantity();
			total += orderItemPrice;
		}
		return total;
	}
	
	
}
