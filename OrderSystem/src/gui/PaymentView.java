package gui;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

public class PaymentView extends JFrame implements ActionListener{

	DefaultTableModel dtm = new DefaultTableModel();
	JTable tbl = new JTable(dtm);
	JLabel Title,Customer,Name,Address, DeliveryType, CCNumber, Order, OrderTotal;
    JButton   btnCancel,btnSubmit;
	
	public PaymentView(){
		setLayout(null);
		
	    Title = new JLabel("Payment");
	    add(Title).setBounds(20,20,120,20);
	    
	    Customer = new JLabel("Customer");
	    add(Customer).setBounds(20,60,120,20);
	    Font font = Customer.getFont();
	    Map attributes = font.getAttributes();
	    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    Customer.setFont(font.deriveFont(attributes)); 
	    
	    Name = new JLabel("Name:");
	    add(Name).setBounds(20,90,120,20);
	    
	    Address = new JLabel("Address:");
	    add(Address).setBounds(20,110,120,20);
	    
	    DeliveryType = new JLabel("Delivery Type:");
	    add(DeliveryType).setBounds(20,130,120,20);
	    
	    CCNumber = new JLabel("CC Number:");
	    add(CCNumber).setBounds(20,150,120,20);
	    
        setVisible(true);
        setTitle("Payment Method");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,800);
        getTableData();
        
        System.out.println("PaymentView");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
    if(e.getSource()== btnCancel){
       dispose();
    }else if(e.getSource()== btnSubmit){
    	
   
    	}

	}	

	private void getTableData() {
		dtm.addColumn("Number");
		dtm.addColumn("Expiry");
		dtm.addColumn("Card Holder");
		dtm.addColumn("Card Provider");
    
		JScrollPane js = new JScrollPane(tbl);
		add(js).setBounds(30,220,400,200);

	}
}
