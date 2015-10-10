




package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;


public class CustomerView extends JFrame implements ActionListener{

    JButton btnExistingCustomer;
    JButton btnNewCustomer; 

    public CustomerView(){
        setLayout(null);
               
        btnExistingCustomer = new JButton("Existing Customer");
        add(btnExistingCustomer).setBounds(50,60,150,30);
        btnExistingCustomer.addActionListener(this);
        
        btnNewCustomer = new JButton("New Customer");
        add(btnNewCustomer).setBounds(50,120,150,30);
        btnNewCustomer.addActionListener(this);

       
        
        setVisible(true);
        setTitle("Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(280,280);
        
        System.out.println("CustomerView");
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnExistingCustomer){
           new CustomerListView();
        }
        if(e.getSource()== btnNewCustomer){
        	new NewCustomerView();
        }
       
           
       
       
       
        
    }
   
}



