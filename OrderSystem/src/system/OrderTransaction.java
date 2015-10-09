package system;

public class OrderTransaction extends Order {
	
	private int id;
	private int saleDate;
	private float amount;
	private String paymentMethod;
	
	public OrderTransaction(int id, int customerId, int newSaleDate, String delivery, float newAmount){
		super(id, customerId, delivery);
		saleDate=newSaleDate;
		amount=newAmount;
	}
	
	public void processPayment(){
		// place holder
	}
}
