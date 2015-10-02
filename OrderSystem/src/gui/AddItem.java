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


public class AddItem extends JFrame{
    
	JLabel Itemid,Price,ItemName; //Declearing JLabels
	JTextField txtItemid,txtPrice,txtItemName; //Declearing JTextfields
	JButton btnSave,btnCreate,btnExit,btnDel; //Declearing JButtons
  
  
   
   public AddItem(){//Creating constructor
       setLayout(null);
        
       Itemid = new JLabel("Item ID:");
        add(Itemid).setBounds(20,20,120,20);
       
        Price = new JLabel("Item Name:");
        add(Price).setBounds(20,45,120,20);
        
        ItemName = new JLabel("Item Price:");
        add(ItemName).setBounds(20,70,120,20);
        
        
        txtItemid = new JTextField();
       add(txtItemid).setBounds(160,20,100,20);
        
       
       txtItemName = new JTextField();
       add(txtItemName).setBounds(160,45,100,20);
       
       txtPrice = new JTextField();
       add(txtPrice).setBounds(160,70,100,20);
      

       btnSave = new JButton("Save");
       add(btnSave).setBounds(20,170,100,20);
       //btnSave.addActionListener(this);
       
       btnCreate = new JButton("Create");
       add(btnCreate).setBounds(140,170,100,20);
       //btnCreate.addActionListener(this);
       
       btnExit = new JButton("Exit");
       add(btnExit).setBounds(260,170,100,20);
       //btnExit.addActionListener(this);
       
       btnDel = new JButton("Delete");
       add(btnDel).setBounds(140,170,100,20);
       //btnDel.addActionListener(this);
            
       setTitle("Item Add");
       setSize(400,500);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
    
    }

public void transferData(String a, String b, String c, String d, String ee,
		String f) {
	
	
	
}


    }
    

