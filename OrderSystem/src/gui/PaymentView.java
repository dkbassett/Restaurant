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

import system.CreditCard;
import system.CreditCardHandler;
import system.CustomerHandler;
import system.Customer;
import system.Order;
import system.OrderHandler;
import system.OrderItem;
import system.OrderTransaction;
import system.SystemDAOOracleImpl;

public class PaymentView extends JFrame implements ActionListener{

	DefaultTableModel dtm = new DefaultTableModel();
	JTable tbl = new JTable(dtm);
	JTable tblOrder;
	JLabel Title,Customer,Name,Address, DeliveryType, CCNumber, Order, OrderTotal,
		lblCustomerName, lblCustomerAddress, lblDeliveryType, lblCreditCardNumber, lblTotalTitle,lblTotalValue;
    JButton btnCancel,btnSubmit;
    JPanel pnlOrder, pnlConfirmation;
    private OrderItemTableModel orderItemTableModel;
    private JScrollPane jsOrder;
    private ArrayList<OrderItem> orderItemList;
    private Order currentOrder = OrderHandler.getCurrentOrder();
    private Customer customer = CustomerHandler.getCurrentCustomer();
    private CreditCard creditCard = CreditCardHandler.getSelectedCreditCard();
    private float total = 0.00f;
	
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
	    lblCustomerName.setFont(lblCustomerName.getFont().deriveFont(Font.PLAIN));
	    add(lblCustomerName).setBounds(110,90,120,20);
	    
	    Address = new JLabel("Address:");
	    add(Address).setBounds(20,110,120,20);
	    lblCustomerAddress = new JLabel(customer.getAddress());
	    lblCustomerAddress.setFont(lblCustomerAddress.getFont().deriveFont(Font.PLAIN));
	    add(lblCustomerAddress).setBounds(110,110,220,20);
	    
	    DeliveryType = new JLabel("Delivery Type:");
	    add(DeliveryType).setBounds(20,130,120,20);
	    lblDeliveryType = new JLabel(currentOrder.getDelivery());
	    lblDeliveryType.setFont(lblDeliveryType.getFont().deriveFont(Font.PLAIN));
	    add(lblDeliveryType).setBounds(110,130,120,20);
	    
	    CCNumber = new JLabel("CC Number:");
	    add(CCNumber).setBounds(20,150,120,20);
	    lblCreditCardNumber = new JLabel(creditCard.getNumber());
	    lblCreditCardNumber.setFont(lblCreditCardNumber.getFont().deriveFont(Font.PLAIN));
	    add(lblCreditCardNumber).setBounds(110,150,220,20);
	    
		 lblTotalTitle = new JLabel("Total:");
		 add(lblTotalTitle).setBounds(330, 680, 80, 30);
		 lblTotalValue = new JLabel(String.valueOf(total));
		 add(lblTotalValue).setBounds(370, 680, 80, 30);
		 
		  	total = currentOrder.calculateTotal();
		  	String totalValue = String.format("$%.2f", total);
		  	lblTotalValue.setText(totalValue);
		  	lblTotalValue = new JLabel(String.valueOf(total));
	    
	    /**
	     * Order Panel and components
	     */
	  	pnlOrder = new JPanel();
	  	pnlOrder.setLayout(null);
	  	pnlOrder.setBorder(BorderFactory.createTitledBorder("Order"));
	  	pnlOrder.setBounds(20,200,450,240);
	  	
	  	// Order item table
	  	orderItemTableModel = new OrderItemTableModel(orderItemList);
	  	tblOrder = new JTable(orderItemTableModel);	  	
	  	tblOrder.setFillsViewportHeight(true);
	  	tblOrder.getColumnModel().getColumn(0).setPreferredWidth(280);
	  	tblOrder.getColumnModel().getColumn(2).setPreferredWidth(80);
	  	jsOrder = new JScrollPane(tblOrder);
	  	pnlOrder.add(jsOrder).setBounds(20,20,400,180);
	  	System.out.println(total);
	  	

	  	add(pnlOrder);
	  	
	  	/**
	    * Confirmation Panel and components
	    */
	  	pnlConfirmation = new JPanel();
//	  	pnlConfirmation.setLayout(null);
	  	pnlConfirmation.setBounds(20,500,450,100);
	  	
	  	// Confirm button
	  	btnSubmit = new JButton("Submit");
	  	btnSubmit.setPreferredSize(new Dimension(80, 20));
	  	pnlConfirmation.add(btnSubmit);
	  	btnSubmit.addActionListener(this);
	  	
	  	// Cancel button
	  	btnCancel = new JButton("Cancel");
	  	btnCancel.setPreferredSize(new Dimension(80, 20));
	  	pnlConfirmation.add(btnCancel);
	  	btnCancel.addActionListener(this);
	   
	  	add(pnlConfirmation);
	    
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
	    } else if(e.getSource()== btnSubmit){
	    	
	    	// set order transaction from current order and store in database
	    	OrderTransaction newOrderTransaction = new OrderTransaction(currentOrder);
	    	int orderId = OrderHandler.storeOrderTransaction(newOrderTransaction);
	    	
	    	// get order items from current order and store items in database based on order Id
	    	ArrayList<OrderItem> orderItems = currentOrder.getItemList();
	    	OrderHandler.storeOrderItems(orderId, orderItems);
   
    	}

	}	
}
