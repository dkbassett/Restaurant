public class Order {
	
	private int id;
	private int customerID;
	private OrderItem[1..*] itemList;
	private boolean confirmationStatus;
	private DeliveryType delivery
	private float grandTotal;
	private int cnt=0; // counter for current itemlist element
	
	public Order(int newId,int newCustomerID, DeliveryType newDelivery){
		id=newId;
		customerID=newCustomerID;
		delivery=newDelivery;
	}
	
	public OrderItem addItemToOrder(MenuItem newMenuItem, int newQuantity){
		itemList[cnt]=OrderItem(newMenuItem,newQuantity);
	}
	
	public void confirmOrder{
		confirmationStatus = true ;
	}
}
