package system;

public class OrderTransaction {
	
	private int id;
	private int saleDate;
	private float amount;
	private String paymentMethod;
	
	public OrderTransaction(int newId, int newSaleDate,float newAmount){
		id=newId;
		saleDate=newSaleDate;
		amount=newAmount;
	}
	public void processPayment(){
		// place holder
	}
}