package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import system.CreditCard;
import system.Customer;
import system.CustomerHandler;
import system.MenuItem;

public class PaymentMethodView extends JFrame implements ActionListener{

	DefaultTableModel dtm = new DefaultTableModel();
	JTable tbl = new JTable(dtm);
	JTable tblCreditCards;
	JLabel Title,ID;
    JButton   btnCancel,btnSelect,btnAddCard;
    JScrollPane js;
    
    private ListSelectionModel listSelectionModel;
    private CreditCardTableModel creditCardTableModel;
    private ArrayList<CreditCard> creditCardList;
    private Customer currentCustomer;
	
	public PaymentMethodView(){
		setLayout(null);
		
		currentCustomer = CustomerHandler.getCurrentCustomer();
//		Customer customer = new Customer(2, "Jane Doe", "33 Riverside Avenue, Sunnybank, QLD", "111222333");
		
		creditCardList = CreditCard.getCreditCardsFromDB(currentCustomer);
	
	    Title = new JLabel("Payment Method");
	    add(Title).setBounds(20,20,120,20);
	    
	    Title = new JLabel("Name:");
	     add(Title).setBounds(20,70,120,20);
	     
	     btnAddCard = new JButton("Add Card");
	     add(btnAddCard).setBounds(20,210,90,20);
	     btnAddCard.addActionListener(this);	  
	     
	     btnSelect = new JButton("Select Card");
	     add(btnSelect).setBounds(20,275,110,20);
	     btnSelect.addActionListener(this);	   
	     
	     btnCancel = new JButton("Cancel");
	     add(btnCancel).setBounds(140,275,80,20);
	     btnCancel.addActionListener(this);
	     
	     // Credit card table
	     tblCreditCards = new JTable(new CreditCardTableModel(creditCardList));
	     tblCreditCards.setFillsViewportHeight(true);

	     js = new JScrollPane(tblCreditCards);
	     add(js).setBounds(20,100,400,100);
	    
	    
        setVisible(true);
        setTitle("Order Transaction");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450,350);
//        getTableData();
        
        System.out.println("PaymentMethodView");
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnCancel){
           dispose();
        }else if(e.getSource()== btnAddCard){
        	new CreditCardView();
        }else if (e.getSource()== btnSelect){
        	new PaymentView();
        }

    }	
	
	
	
	
//    private void getTableData() {
//        dtm.addColumn("Number          ");
//        dtm.addColumn("Expiry");
//        dtm.addColumn("Card Holder");
//        dtm.addColumn("Card Provider");
//        
//        JScrollPane js = new JScrollPane(tbl);
//        add(js).setBounds(20,100,400,100);
//	
//    }
}
