

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

import system.*;

public class NewCustomerView extends JFrame implements ActionListener{
    
	JLabel Title,Name/*,Last_Name*/,Address, Phone, Credit_Card, CVV; //Declaring JLabels
	JTextField  txt_Name /*,  txtLast_Name*/,txtAddress,txtPhone, txtCreditcard, txtCVV; //Declaring JTextfields
	JButton btnConfirm,btnCancel,btnExit,btnDel; //Declaring JButtons
  
   //Connection con; // Declaring Connection
   //PreparedStatement ps;// Declaring PreparedStatement
   //ResultSet rs;// Declaring Resultset
   
   
   public NewCustomerView(){//Creating constructor
       setLayout(null);
        
       
       Title = new JLabel("New Customer");
       add(Title).setBounds(20,20,120,20);
       
        Name = new JLabel("Name:");  // Changed from first name, to whole name
        add(Name).setBounds(20,65,120,20);
       
   //     Last_Name = new JLabel("Last Name:");
   //     add(Last_Name).setBounds(20,45,120,20);
        
        Address = new JLabel("Address:");
        add(Address).setBounds(20,90,120,20);
        
        Phone = new JLabel("Phone:");
        add(Phone).setBounds(20,140,120,20);
        
       // Credit_Card = new JLabel("Credit card:");
       // add(Credit_Card).setBounds(20,120,120,20);
        

      //  CVV = new JLabel("CVV:");
     //   add(CVV).setBounds(20,145,120,20);
        
       txt_Name = new JTextField();
       add(txt_Name).setBounds(90,65,200,20);
        
   //    txtLast_Name = new JTextField();
   //    add(txtLast_Name).setBounds(160,45,100,20);
        
       txtAddress = new JTextField();
       add(txtAddress).setBounds(90,90,200,40);
        
       txtPhone = new JTextField();
       add(txtPhone).setBounds(90,140,200,20);
       
    //   txtCreditcard = new JTextField();
    //   add(txtCreditcard).setBounds(160,120,100,20);
       
     //  txtCVV = new JTextField();
     //  add(txtCVV).setBounds(160,145,100,20);

       btnConfirm = new JButton("Confirm");
       add(btnConfirm).setBounds(20,400,80,20);
       btnConfirm.addActionListener(this);
       
       btnCancel = new JButton("Cancel");
       add(btnCancel).setBounds(120,400,80,20);
       btnCancel.addActionListener(this);
       
   /*    btnExit = new JButton("Exit");
       add(btnExit).setBounds(260,170,100,20);
       btnExit.addActionListener(this);
       
       btnDel = new JButton("Delete");
       add(btnDel).setBounds(140,170,100,20);
     */ //btnDel.addActionListener(this);
       

       setTitle("New Customer");
       setSize(400,500);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
       
       System.out.println("NewCustomerView");
    }

   public void transferData(String a, String b, String c, String d, String ee,
		String f) {

   }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnCancel)){
			//System.exit(0);
			dispose();
		}
		else if(e.getSource().equals(btnConfirm)){
			String name = txt_Name.getText();
			System.out.println("Ui Level: " + name);
			String address = txtAddress.getText();
			System.out.println("Ui Level: " + address);
			String pNumber = txtPhone.getText();
			System.out.println("Ui Level: " + pNumber);
			//new Customer();
			new Customer(name,address,pNumber);
			
			CustomerHandler.addNewCustomer(name, address, pNumber);
			
			dispose();
			//Customer_details.Close();
			//new Customer(Cust,)
		}
		
	}

}
    

