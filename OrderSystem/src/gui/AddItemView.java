

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

public class AddItemView extends JFrame implements ActionListener{
    
	JLabel Title,ItemID,Itemname,Itemprice; //Declaring JLabels
	JTextField txtId,txtName,txtPrice; //Declaring JTextfields
	JButton btnConfirm,btnCancel;
  
  
   
   public AddItemView(){//Creating constructor
       setLayout(null);
       
       Title = new JLabel("Add Menu Item");
       add(Title).setBounds(20,20,120,20);
        
       ItemID = new JLabel("Item ID");
        add(ItemID).setBounds(20,65,120,20);
       
        Itemname = new JLabel("Item Name");
        add(Itemname).setBounds(20,90,120,20);
        
        Itemprice = new JLabel("Itemprice:");
        add(Itemprice).setBounds(20,115,120,20);
        
       txtId = new JTextField();
       add(txtId).setBounds(130,65,120,20);
        
       
       txtName = new JTextField();
       add(txtName).setBounds(130,90,120,20);
       
       txtPrice = new JTextField();
       add(txtPrice).setBounds(130,115,120,20);
       
       
	   btnConfirm = new JButton("Confirm");
	   add(btnConfirm).setBounds(20,180,80,20);
	   btnConfirm.addActionListener(this);
       
       btnCancel = new JButton("Cancel");
       add(btnCancel).setBounds(120,180,80,20);
       btnCancel.addActionListener(this);	
       
       setTitle(" Add Item");
       setSize(300,250);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
       System.out.println("AddItemView");
      
    }

   @Override
   public void actionPerformed(ActionEvent e) {	
		if(e.getSource().equals(btnCancel)){
			//System.exit(0);
			dispose();
		}
		else if(e.getSource().equals(btnConfirm)){	 
			
			int id = Integer.parseInt(txtId.getText());
			String name = txtName.getText();
			float price = Float.parseFloat(txtPrice.getText());
			
			System.out.println("Ui Level: " + id);
			System.out.println("Ui Level: " + name);
			System.out.println("Ui Level: " + price);
			
			new MenuItem(id,name,price);
			
			dispose();
	
		}
	
	
   }
}


    
    

