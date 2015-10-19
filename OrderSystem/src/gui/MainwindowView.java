
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import system.OrderHandler;
import system.SystemDAOOracleImpl;


public class MainwindowView extends JFrame implements ActionListener  {

    JMenuBar menu; // Declaring Jmenubar
    JMenu staffMember,customers,Rmenu, addCustomer;  // Declaring Jmenu for Jmenubar
    JMenuItem menuItems, orderItems, addStaff, Customer_Details, customerList, orderHistory, staffList ; //Declaring Jmenuitem for Jmenu
    JButton btnOrder, btnUpdate;
    JLabel lblTotalTitle,lblTotalValue ;
    
    private String total = Float.toString(OrderHandler.getDaysTakingsFromDB());
    
    public MainwindowView(){
    	
        setLayout(null);
        menu = new JMenuBar();
        add(menu);
        staffMember = new JMenu("Staff Member");
        menu.add(staffMember).setBounds(20,20,40,40);
       
        staffList = new JMenuItem("Staff Lists");
        staffMember.add(staffList).setBounds(20,30,40,40);
        staffList.addActionListener(this);
        
        addStaff = new JMenuItem("Add Staff");
        staffMember.add(addStaff).setBounds(20,20,40,40);

        customers = new JMenu("Customers");
        menu.add(customers).setBounds(70,20,40,40);
        

        
        Customer_Details = new JMenuItem("New Customer");
        customers.add(Customer_Details).setBounds(20,30,40,40);
        
        customerList = new JMenuItem("Customer List");
        customers.add(customerList).setBounds(20,40,40,40);
        
	    btnUpdate = new JButton("Update");
	    add(btnUpdate).setBounds(200,285,80,20);
	    btnUpdate.addActionListener(this);	   
        
        addStaff.addActionListener(this);
        Customer_Details.addActionListener(this);
        customerList.addActionListener(this);
        
        Rmenu = new JMenu("Menu");
        menu.add(Rmenu).setBounds(80,20,40,40);
        
        menuItems = new JMenuItem("Menu Items ");
        Rmenu.add(menuItems).setBounds(70,30,40,40);
        menuItems.addActionListener(this);
       
//        Orderitem = new  JMenuItem("Order Item");
//        Rmenu.add(Orderitem).setBounds(70,30,40,40);
//        Orderitem.addActionListener(this);
        
        orderHistory = new  JMenuItem("Order History");
        Rmenu.add(orderHistory).setBounds(70,40,40,40);
        orderHistory.addActionListener(this);
        
        btnOrder = new JButton("Start New Order");
        add(btnOrder).setBounds(150,100,300,100);
        btnOrder.addActionListener(this);
        
	  	lblTotalTitle = new JLabel("Day's Total Earnings:");
	  	add(lblTotalTitle).setBounds(300, 280, 160, 30);
	  	String Value = String.format("$%s", total);
	  	lblTotalValue = new JLabel(Value);
	  	add(lblTotalValue).setBounds(430, 280, 80, 30);
	  	
        try {
          setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Images\\LOGO.jpg"))))); //setting background screen
        }
        catch(IOException e){
            System.out.println("Image not found");
        }
        setSize(600,400);
        setVisible(true);
        setJMenuBar(menu);
    }
    public static void main(String args[]){
    	new LoginView();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==customerList){
         new CustomerListView();
       }
       if (e.getSource()==Customer_Details){
         new NewCustomerView();
       }
       if(e.getSource()==addStaff){
          new StaffListView();
       }
//       if(e.getSource()== Orderitem){
//           new OrderView();
//        }
       if(e.getSource()==menuItems){
    	   new MenuItemView();
       }       
       if(e.getSource()==btnUpdate){
    	   remove(lblTotalValue);
    	   total=Float.toString(OrderHandler.getDaysTakingsFromDB());
    	   String Value = String.format("$%s", total);
   	  		lblTotalValue = new JLabel(Value);
   	  		add(lblTotalValue).setBounds(430, 280, 80, 30);
    	   
       }
       if(e.getSource()==orderHistory){
    	   new OrderHistoryView();
       }
       if(e.getSource()==staffList){
    	   new StaffListView();
       }
       if(e.getSource()==btnOrder){
//        	   new OrderItemView();
    	   new CustomerView();
       }
          
    }
}
