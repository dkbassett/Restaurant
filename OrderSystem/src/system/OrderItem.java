package system;

public class OrderItem {
	
	private MenuItem menuItem;
	private int quantity;
	private boolean confirmed;
	
	public OrderItem() {
		
	}
	
	public OrderItem(MenuItem newItem, int newQuantity, boolean confirmed) {
		menuItem=newItem;
		quantity=newQuantity;
		this.confirmed = confirmed;
	}
	
	public void updateQuantity(int updatedQuantity){
	quantity=updatedQuantity;
	}
	
	public void confirmItem() {
	confirmed = true;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}	
}
