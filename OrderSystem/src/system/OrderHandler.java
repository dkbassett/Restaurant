package system;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

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
	
	public static int storeOrderTransaction(OrderTransaction newOrderTransaction){
		return OrderTransaction.addOrderTransactionToDB(newOrderTransaction);
	}
	
	public static void storeOrderItems(int orderId, ArrayList<OrderItem> orderItems) {	
		OrderTransaction.addOrderItemsToDB(orderId, orderItems);
	}
	
	public static float getDaysTakingsFromDB() {
		
		float daysTakings = 0.00f;
		
		try {
			CachedRowSet crs = new CachedRowSetImpl();
			crs = SystemDAOOracleImpl.readFromTable(SystemDAOOracleImpl.getDaysTakings());		
			ResultSetMetaData rsmd = crs.getMetaData();
            int columnsNum = rsmd.getColumnCount();
			while(crs.next()) {				
				daysTakings = crs.getFloat(1);	
				System.out.println("Days takings: " + daysTakings);
			}
			
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		return daysTakings;
	}
	
}
