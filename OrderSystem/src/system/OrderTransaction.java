package system;

import java.util.ArrayList;

public class OrderTransaction extends Order {
	
	private int id;
	private int saleDate;
	private float amount;
	private String paymentMethod;
	
	public OrderTransaction(int id, int customerId, int newSaleDate, 
			ArrayList<OrderItem> orderItems, String delivery, float newAmount) {
		super(id, customerId, orderItems, delivery, newAmount);
		saleDate=newSaleDate;
		amount=newAmount;
	}
	
	public void processPayment(){
		// place holder
	}
	
}
