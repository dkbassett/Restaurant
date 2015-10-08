package system;

public class MainTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SystemDAOOracleImpl.printFromTable(SystemDAOOracleImpl.selectAllCustomers());
		
		Customer cust = new Customer();
		
		cust = CustomerHandler.getCustByPhone("5566");
		System.out.println("Customer id is: " + cust.getId());
		System.out.println("Customer name is: " + cust.getName());
		
	}

}
