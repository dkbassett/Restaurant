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

public class AddStaffView extends JFrame implements ActionListener{
    
	JLabel Title,StaffID,Staffname,Startedfrom, Phone,Password; //Declaring JLabels
	JTextField txtStaffId,txtStaffname,txtStartedfrom, txtPhone, txtPassword; //Declaring JTextfields
	JButton btnConfirm,btnCancel;
     
   public AddStaffView(){//Creating constructor
       setLayout(null);
       
	    Title = new JLabel("Add Staff Member");
	    add(Title).setBounds(20,20,120,20);
        
       StaffID = new JLabel("Staff ID");
        add(StaffID).setBounds(20,65,120,20);
       
        Staffname = new JLabel("Staff Name");
        add(Staffname).setBounds(20,90,120,20);
        
        Startedfrom = new JLabel("Startedfrom:");
        add(Startedfrom).setBounds(20,115,120,20);
        
        Phone = new JLabel("Phone:");
        add(Phone).setBounds(20,140,120,20);
        
        Password = new JLabel("Password:");
        add(Password).setBounds(20,165,120,20);
        
        txtStaffId = new JTextField();
       add(txtStaffId).setBounds(120,65,100,20);
        
       txtStaffname = new JTextField();
       add(txtStaffname).setBounds(120,90,100,20);
       
       txtStartedfrom = new JTextField();
       add(txtStartedfrom).setBounds(120,115,100,20);
       
       txtPhone= new JTextField();
       add(txtPhone).setBounds(120,140,100,20);
       
       txtPassword= new JTextField();
       add(txtPassword).setBounds(120,165,100,20);
       
	   btnConfirm = new JButton("Confirm");
	   add(btnConfirm).setBounds(20,200,80,20);
	   btnConfirm.addActionListener(this);
       
	   btnCancel = new JButton("Cancel");
	   add(btnCancel).setBounds(120,200,80,20);
	   btnCancel.addActionListener(this);	 
  
       setTitle(" Add Staff");
       setSize(300,275);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      
    }

   @Override
   public void actionPerformed(ActionEvent e) {
   		if(e.getSource().equals(btnCancel)){
   			//System.exit(0);
   			dispose();
   		}
   		else if(e.getSource().equals(btnConfirm)){
   			String id = txtStaffId.getText();
   			String name = txtStaffname.getText();
   			String startDate = txtStartedfrom.getText();
   			String phone = txtPhone.getText();
   			String password = txtPassword.getText();
   			
   			System.out.println("Ui Level: " + id);
   			System.out.println("Ui Level: " + name);
   			System.out.println("Ui Level: " + startDate);
   			System.out.println("Ui Level: " + phone);  		
   			System.out.println("Ui Level: " + password);  	
   			
   			new StaffMember(id,name,password);
   			
   			dispose();
   			
   		}
   		
   	}
   	
}

