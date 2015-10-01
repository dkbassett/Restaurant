package system;

public class OrderItem {
	
	private MenuItem item;
	private int quantity;
	private boolean confirmed;
	
	public OrderItem(MenuItem newItem, int newQuantity) {
		item=newItem;
		quantity=newQuantity;
	}
	
	public void updateQuantity(int updatedQuantity){
	quantity=updatedQuantity;
	}
	
	public void confirmItem() {
	confirmed = true;
	}	
}
