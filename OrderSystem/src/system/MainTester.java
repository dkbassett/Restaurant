package system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SystemDAOOracleImpl.printFromTable(SystemDAOOracleImpl.selectAllCustomers());
		
//		Customer cust = new Customer();
//		
//		cust = CustomerHandler.getCustByPhone("5566");
//		System.out.println("Customer id is: " + cust.getId());
//		System.out.println("Customer name is: " + cust.getName());
		
		
//		List<MenuItem> menuItemList = MenuItem.getMenuItemsFromDB();
		
		DateFormat currentDate = DateFormat.getDateInstance();
		String pattern = ((SimpleDateFormat)currentDate).toPattern();
		String localPattern = ((SimpleDateFormat)currentDate).toLocalizedPattern();
		
		System.out.println(currentDate);
		System.out.println(pattern);
		System.out.println(localPattern);
	}

}
