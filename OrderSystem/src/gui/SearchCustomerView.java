package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import system.OrderItem;


public class SearchCustomerView extends JFrame implements ActionListener{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel dtm = new DefaultTableModel();
//    JTable tbl = new JTable(dtm);
    JTable tblCustomers;
    JTextField txtSearch;
    JLabel lblPhone, lblError;
    JButton btnSearch, btnCancel, btnConfirm,btnNewCustomer,btnUpdate;
    Customer selectedCustomer = new Customer();
    JScrollPane js;
    List<Customer> customerList;
    private ListSelectionModel listSelectionModel;

    public SearchCustomerView(){
        setLayout(null);
        
        customerList = Customer.getCustomersFromDB();
        tblCustomers = new JTable(new CustomerTableModel(customerList));
        tblCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel = tblCustomers.getSelectionModel();
        js = new JScrollPane(tblCustomers);
      	add(js).setBounds(20,100,900,500);
        
        lblPhone = new JLabel("Phone Number:");
        add(lblPhone).setBounds(20,20,100,20);
        
        txtSearch = new JTextField();
        add(txtSearch).setBounds(120,20,100,20);
        
        btnNewCustomer = new JButton("New Customer");
        add(btnNewCustomer).setBounds(20,60,150,30);
        btnNewCustomer.addActionListener(this);
                
        btnSearch = new JButton("Search");
        add(btnSearch).setBounds(230, 20, 100, 20);
        btnSearch.addActionListener(this);
        
        lblError = new JLabel("Please enter a valid phone number");
        lblError.setForeground(Color.red);
        add(lblError).setBounds(340, 20, 200, 20);
        lblError.setVisible(false);
        
        btnConfirm = new JButton("Confirm");
        add(btnConfirm).setBounds(20,620,80,20);
        btnConfirm.addActionListener(this);
        
      	btnUpdate = new JButton("Update");
      	add(btnUpdate).setBounds(190,60,80,20);
      	btnUpdate.addActionListener(this);
        
        btnCancel = new JButton("Cancel");
        add(btnCancel).setBounds(120,620,80,20);
        btnCancel.addActionListener(this);
        
        setVisible(true);
        setTitle("Search Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,1000);
//        getTableData();
        System.out.println("SearchCustomerView");
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	boolean found = false;
        if(e.getSource()== btnSearch){
        	if (Validator.isType(txtSearch.getText(), "int")) {
        		textFieldChange();
        		System.out.println("has been validated");
        		for (int i= 0; i < customerList.size(); i++) {
        			System.out.println("in for loop");
        			if (customerList.get(i).getPhoneNumber().equals(txtSearch.getText())) {
        				found = true;
        			}
        		}
        		if (!found) {
        			System.out.println("found customer");
        			new NewCustomerView();
        		}
        	} else {
        		lblError.setVisible(true);
        		System.out.println("incorrect input");
        	}
        }
        if(e.getSource()== btnConfirm) {
        	int selectedRowIndex = tblCustomers.getSelectedRow();  
        	System.out.println("Selected Row Index: " + selectedRowIndex);
     		
        	selectedCustomer = customerList.get(selectedRowIndex);
        	
     	   	System.out.println("Selected customer name: " + selectedCustomer.getName());
        	CustomerHandler.setCurrentCustomer(selectedCustomer);	
        	
        	new NewOrderView();
        	dispose();
        }
        if(e.getSource()== btnCancel) {
        	dispose();
        }
        if(e.getSource()== btnNewCustomer){
        	new NewCustomerView();
        
        }else if (e.getSource()== btnUpdate){
            remove(js);
            customerList = Customer.getCustomersFromDB();
            tblCustomers = new JTable(new CustomerTableModel(customerList));
            tblCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelectionModel = tblCustomers.getSelectionModel();
            js = new JScrollPane(tblCustomers);
          	add(js).setBounds(20,100,900,500);
          	tblCustomers.repaint();

            }
    	}
        
    
    

    private void textFieldChange() {
    	System.out.println("textField change fired");
		if (!txtSearch.getText().equals(null) && !txtSearch.getText().equals("")) {
			System.out.println("in if statement");
				String phoneNumber = txtSearch.getText();
				int index = getRowByValue(phoneNumber);	
				listSelectionModel.setSelectionInterval(index, index);
		} else {
			System.out.println("didn't work");
		}
	}
    
    private int getRowByValue(String value) {
    	int index = 0;

    	for (int i = 0; i < tblCustomers.getRowCount(); i++) {
            for (int j = 0; j < tblCustomers.getColumnCount(); j++) {
                if (tblCustomers.getValueAt(i, j).equals(value)) {
                	System.out.println("i is: " + i);
                    return i;
                }
            }
        }
	    return index;
    }
}
