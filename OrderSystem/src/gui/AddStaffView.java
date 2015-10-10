

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


public class AddStaffView extends JFrame{
    
	JLabel StaffID,Staffname,Startedfrom, Phone; //Declearing JLabels
	JTextField txtStaffId,txtStaffname,txtStartedfrom, txtPhone; //Declearing JTextfields
	JButton btnSave,btnCreate,btnExit,btnDel; //Declearing JButtons
  
  
   
   public AddStaffView(){//Creating constructor
       setLayout(null);
        
       StaffID = new JLabel("Staff ID");
        add(StaffID).setBounds(20,20,120,20);
       
        Staffname = new JLabel("Staff Name");
        add(Staffname).setBounds(20,45,120,20);
        
        Startedfrom = new JLabel("Startedfrom:");
        add(Startedfrom).setBounds(20,70,120,20);
        
        Phone = new JLabel("Phone:");
        add(Phone).setBounds(20,95,120,20);
        
        
        
        txtStaffId = new JTextField();
       add(txtStaffId).setBounds(160,20,100,20);
        
       
       txtStaffname = new JTextField();
       add(txtStaffname).setBounds(160,45,100,20);
       
       txtStartedfrom = new JTextField();
       add(txtStartedfrom).setBounds(160,70,100,20);
       
       txtPhone= new JTextField();
       add(txtPhone).setBounds(160,95,100,20);
       
       
      
        
       
       
       
       btnSave = new JButton("Save");
       add(btnSave).setBounds(20,170,100,20);
       //btnSave.addActionListener(this);
       
       
       
       btnExit = new JButton("Exit");
       add(btnExit).setBounds(260,170,100,20);
       //btnExit.addActionListener(this);
       
       btnDel = new JButton("Delete");
       add(btnDel).setBounds(140,170,100,20);
       //btnDel.addActionListener(this);
       
      
       
       
       setTitle(" Add Staff");
       setSize(400,500);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
       
      
    }

public void transferData(String a, String b, String c, String d, String ee,
		String f) {
	
	
	
}


    }
    

