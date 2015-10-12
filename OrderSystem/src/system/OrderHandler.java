package system;

import java.util.ArrayList;

public abstract class OrderHandler {
	
	private static Order currentOrder;
	
	public OrderHandler (Order order) {
		setCurrentOrder(order);	
	}
	
	public static void updateCurrentOrderItemList(ArrayList<OrderItem> orderItems) {
		getCurrentOrder().setItemList(orderItems);
	}

	public static Order getCurrentOrder() {
		return currentOrder;
	}

	public static void setCurrentOrder(Order currentOrder) {
		OrderHandler.currentOrder = currentOrder;
	}
	
}