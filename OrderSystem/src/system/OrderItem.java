package system;

public class OrderItem {
	
	private MenuItem menuItem;
	private int quantity;
	private boolean confirmed;
	
	public OrderItem() {
		
	}
	
	public OrderItem(MenuItem newItem, int newQuantity, boolean confirmed) {
		menuItem=newItem;
		setQuantity(newQuantity);
		this.confirmed = confirmed;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
