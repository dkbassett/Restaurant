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
		id=newId;
		customerID=newCustomerID;
		delivery=newDelivery; 
	}
	
	public void addItemToOrder(MenuItem newMenuItem, int newQuantity){
		OrderItem currentItem = new OrderItem(newMenuItem,newQuantity);
		itemList.add(currentItem);
	}
	
	public void confirmOrder(){
		confirmationStatus = true ;
	}
}
