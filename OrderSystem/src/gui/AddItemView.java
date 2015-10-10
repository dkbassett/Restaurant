

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


public class AddItemView extends JFrame{
    
	JLabel ItemID,Itemname,Itemprice; //Declearing JLabels
	JTextField txtId,txtname,txtprice; //Declearing JTextfields
	JButton btnCreate,btnExit; //Declearing JButtons
  
  
   
   public AddItemView(){//Creating constructor
       setLayout(null);
        
       ItemID = new JLabel("Item ID");
        add(ItemID).setBounds(20,20,120,20);
       
        Itemname = new JLabel("Staff Name");
        add(Itemname).setBounds(20,45,120,20);
        
        Itemprice = new JLabel("Itemprice:");
        add(Itemprice).setBounds(20,70,120,20);
        
       txtId = new JTextField();
       add(txtId).setBounds(160,20,100,20);
        
       
       txtname = new JTextField();
       add(txtname).setBounds(160,45,100,20);
       
       txtprice = new JTextField();
       add(txtprice).setBounds(160,65,100,20);
       
       
       btnCreate = new JButton("Save");
       add(btnCreate).setBounds(20,170,100,20);
       
       btnExit = new JButton("Exit");
       add(btnExit).setBounds(260,170,100,20);
       //btnExit.addActionListener(this);
       
       setTitle(" Add Item");
       setSize(400,500);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
       System.out.println("AddItemView");
      
    }

public void transferData(String a, String b, String c, String d, String ee,
		String f) {
	
	
	
}


    }
    

