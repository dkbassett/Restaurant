package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class PaymentMethodView extends JFrame implements ActionListener{

	DefaultTableModel dtm = new DefaultTableModel();
	JTable tbl = new JTable(dtm);
	JLabel Title,ID;
    JButton   btnCancel,btnSelect,btnAddCard;
	
	public PaymentMethodView(){
		setLayout(null);
	
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
	    
	    
        setVisible(true);
        setTitle("Order Transaction");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450,350);
        getTableData();
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnCancel){
           dispose();
        }else if(e.getSource()== btnAddCard){
        	new CreditCardView();
       
        }

    }	
	
	
	
	
    private void getTableData() {
        dtm.addColumn("Number          ");
        dtm.addColumn("Expiry");
        dtm.addColumn("Card Holder");
        dtm.addColumn("Card Provider");
        
        JScrollPane js = new JScrollPane(tbl);
        add(js).setBounds(20,100,400,100);
	
    }
}
