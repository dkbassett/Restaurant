package gui;

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

import system.Customer;
import system.CustomerHandler;
import system.MenuItem;
import system.OrderItem;


public class CustomerListView extends JFrame implements ActionListener{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel dtm = new DefaultTableModel();
//    JTable tbl = new JTable(dtm);
    JTable tblCustomers;
    JTextField txtSearch;
    JLabel lblPhone;
    JButton btnSearch, btnCancel, btnConfirm,btnAddCustomer,btnUpdate;
    Customer selectedCustomer = new Customer();
    JScrollPane js;
    List<Customer> customerList;

    public CustomerListView(){
        setLayout(null);
        
        customerList = Customer.getCustomersFromDB();
        tblCustomers = new JTable(new CustomerTableModel(customerList));
        tblCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        js = new JScrollPane(tblCustomers);
      	add(js).setBounds(20,100,900,500);
        
        lblPhone = new JLabel("Phone Number:");
        add(lblPhone).setBounds(20,20,100,20);
        
        txtSearch = new JTextField();
        add(txtSearch).setBounds(120,20,100,20);
                
        btnSearch = new JButton("Search");
        add(btnSearch).setBounds(230, 20, 100, 20);
        btnSearch.addActionListener(this);
        
        btnConfirm = new JButton("Confirm");
        add(btnConfirm).setBounds(20,660,80,20);
        btnConfirm.addActionListener(this);
        
        btnAddCustomer = new JButton("Add Customer");
        add(btnAddCustomer).setBounds(20,620,120,20);
        btnAddCustomer.addActionListener(this);
        
        btnCancel = new JButton("Cancel");
        add(btnCancel).setBounds(120,660,80,20);
        btnCancel.addActionListener(this);
        
	    btnUpdate = new JButton("Update");
	    add(btnUpdate).setBounds(160,620,80,20);
	    btnUpdate.addActionListener(this);	  
        
        setVisible(true);
        setTitle("Customer List");
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,1000);
//        getTableData();
        System.out.println("SearchCustomerView");
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnSearch){
//            String a = tbl.getValueAt(tbl.getSelectedRow(),0).toString();
//            String b = tbl.getValueAt(tbl.getSelectedRow(),1).toString();
//            String c = tbl.getValueAt(tbl.getSelectedRow(),2).toString();
//            String d = tbl.getValueAt(tbl.getSelectedRow(),3).toString();
        }
        if(e.getSource()== btnConfirm) {
        	dispose();
        }
        if(e.getSource()== btnAddCustomer) {
        	new NewCustomerView();
        }
        if(e.getSource()== btnCancel) {
    	dispose();
        }
        if(e.getSource()== btnUpdate) {
            customerList = Customer.getCustomersFromDB();
            tblCustomers = new JTable(new CustomerTableModel(customerList));
            tblCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            js = new JScrollPane(tblCustomers);
          	add(js).setBounds(20,100,900,500);
    	
        }
        
    }
    
}
