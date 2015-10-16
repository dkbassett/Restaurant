package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import system.CustomerHandler;
import system.Customer;
import system.Order;
import system.OrderHandler;
import system.OrderItem;

public class PaymentView extends JFrame implements ActionListener{

	DefaultTableModel dtm = new DefaultTableModel();
	JTable tbl = new JTable(dtm);
	JTable tblOrder;
	JLabel Title,Customer,Name,Address, DeliveryType, CCNumber, Order, OrderTotal,
		lblCustomerName;
    JButton btnCancel,btnSubmit;
    JPanel pnlOrder;
    private OrderItemTableModel orderItemTableModel;
    private JScrollPane jsOrder;
    private ArrayList<OrderItem> orderItemList;
    private Order currentOrder = OrderHandler.getCurrentOrder();
    private Customer customer = CustomerHandler.getCurrentCustomer();
	
	public PaymentView(){
		setLayout(null);
		
		System.out.println("Current customer name: " + customer.getName());
		
		orderItemList = currentOrder.getItemList();
		
	    Title = new JLabel("Payment");
	    add(Title).setBounds(20,20,120,20);
	    
	    Customer = new JLabel("Customer");
	    add(Customer).setBounds(20,60,120,20);
	    Font font = Customer.getFont();
	    Map attributes = font.getAttributes();
	    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    Customer.setFont(font.deriveFont(attributes)); 
	    
	    Name = new JLabel("Name:");
	    add(Name).setBounds(20,90,80,20);
	    lblCustomerName = new JLabel(customer.getName());
	    add(lblCustomerName).setBounds(60,90,120,20);
	    
	    Address = new JLabel("Address:");
	    add(Address).setBounds(20,110,120,20);
	    
	    DeliveryType = new JLabel("Delivery Type:");
	    add(DeliveryType).setBounds(20,130,120,20);
	    
	    CCNumber = new JLabel("CC Number:");
	    add(CCNumber).setBounds(20,150,120,20);
	    
	    /**
	     * Order Panel and components
	     */
	  	pnlOrder = new JPanel();
	  	pnlOrder.setLayout(null);
	  	pnlOrder.setBorder(BorderFactory.createTitledBorder("Order"));
//	  	pnlOrder.setPreferredSize(new Dimension(400, 350));
	  	pnlOrder.setBounds(20,200,450,400);
	  	
	  	// Order item table
	  	orderItemTableModel = new OrderItemTableModel(orderItemList);
	  	tblOrder = new JTable(orderItemTableModel);	  	
	  	tblOrder.setFillsViewportHeight(true);
	  	tblOrder.getColumnModel().getColumn(0).setPreferredWidth(280);
	  	tblOrder.getColumnModel().getColumn(2).setPreferredWidth(80);
	  	jsOrder = new JScrollPane(tblOrder);
	  	pnlOrder.add(jsOrder).setBounds(20,20,400,180);
	  	
	  	add(pnlOrder);
	    
        setVisible(true);
        setTitle("Payment");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,800);
        
        System.out.println("PaymentView");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
    if(e.getSource()== btnCancel){
       dispose();
    }else if(e.getSource()== btnSubmit){
    	
   
    	}

	}	
}
