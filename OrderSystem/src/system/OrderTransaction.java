package system;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderTransaction extends Order {
	
	private DateFormat saleDate;
	private float amount;
	private String paymentMethod;
	
	public OrderTransaction(Order currentOrder) {
		super(currentOrder.getCustomerID(), currentOrder.getItemList(), currentOrder.getDelivery(), 
				currentOrder.getGrandTotal());
		saleDate = DateFormat.getDateInstance();
		amount = currentOrder.getGrandTotal();
	}
	
	public void processPayment(){
		// place holder
	}
	
	public static int addOrderTransactionToDB(OrderTransaction newOrderTransaction){		
		return SystemDAOOracleImpl.writeTransactionToTable(SystemDAOOracleImpl.saveOrderTransaction(newOrderTransaction));
	}
	
	public static void addOrderItemsToDB(int orderId, ArrayList<OrderItem> orderItems){		
		SystemDAOOracleImpl.writeToTable(SystemDAOOracleImpl.saveOrderItems(orderId, orderItems));
	}
	
}
