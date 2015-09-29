public class OrderItem {
	
	private MenuItem item;
	private int quantity;
	private boolean confirmed;
	
	public OrderItem(MenuItem newItem, int newQuantity) {
		item=newItem;
		quantity=newQuantity;
	}
	
	public void updateQuantity(int updateQuantity){
	quantity=newQuantity;
	}
	
	public void confirmItem() {
	confirmed = true;
	}	
}
