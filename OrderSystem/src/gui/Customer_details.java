

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
import javax.swing.JTextField;


public class Customer_details extends JFrame implements ActionListener{
    
	JLabel First_Name,Last_Name,Address, Phone, Credit_Card, CVV; //Declearing JLabels
	JTextField txtFirst_Name,  txtLast_Name,txtAddress,txtPhone, txtCreditcard, txtCVV; //Declearing JTextfields
	JButton btnSave,btnCreate,btnExit,btnDel; //Declearing JButtons
  
   //Connection con; // Declearing Connection
   //PreparedStatement ps;// Declearing PreparedStatement
   //ResultSet rs;// Declearing Resultset
   
   
   public Customer_details(){//Creating constructor
       setLayout(null);
        
        First_Name = new JLabel("First Name:");
        add(First_Name).setBounds(20,20,120,20);
       
        Last_Name = new JLabel("Last Name:");
        add(Last_Name).setBounds(20,45,120,20);
        
        Address = new JLabel("Address:");
        add(Address).setBounds(20,70,120,20);
        
        Phone = new JLabel("Phone:");
        add(Phone).setBounds(20,95,120,20);
        
        Credit_Card = new JLabel("Credit card:");
        add(Credit_Card).setBounds(20,120,120,20);
        

        CVV = new JLabel("CVV:");
        add(CVV).setBounds(20,145,120,20);
        
        
        
       
        
        
       txtFirst_Name = new JTextField();
       add(txtFirst_Name).setBounds(160,20,100,20);
        
       txtLast_Name = new JTextField();
       add(txtLast_Name).setBounds(160,45,100,20);
        
       txtAddress = new JTextField();
       add(txtAddress).setBounds(160,70,100,20);
        
       txtPhone = new JTextField();
       add(txtPhone).setBounds(160,95,100,20);
       
       txtCreditcard = new JTextField();
       add(txtCreditcard).setBounds(160,120,100,20);
       
       txtCVV = new JTextField();
       add(txtCVV).setBounds(160,145,100,20);
       
       
       
       btnSave = new JButton("Save");
       add(btnSave).setBounds(20,170,100,20);
       //btnSave.addActionListener(this);
       
       btnCreate = new JButton("Create");
       add(btnCreate).setBounds(140,170,100,20);
       //btnCreate.addActionListener(this);
       
       btnExit = new JButton("Exit");
       add(btnExit).setBounds(260,170,100,20);
       btnExit.addActionListener(this);
       
       btnDel = new JButton("Delete");
       add(btnDel).setBounds(140,170,100,20);
       //btnDel.addActionListener(this);
       
      
       
       
       setTitle("Customer Details");
       setSize(400,500);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
       
      
    }

public void transferData(String a, String b, String c, String d, String ee,
		String f) {
	
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource().equals(btnExit)){
		System.exit(0);
	}
	
}

    }
    

