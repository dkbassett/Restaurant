

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class OrderItemView extends JFrame implements ActionListener{
    
	JLabel CustomerName,CustomerPhone,Price,ItemName, Date; //Declearing JLabels
	JTextField txtCustomerName,txtCustomerPhone,txtPrice,txtItemName,txtDate; //Declearing JTextfields
	JButton btnSave,btnCreate,btnExit,btnDel; //Declearing JButtons
	JRadioButton delivery, takeaway;
	JPanel p;
  
  
   
   public OrderItemView(){//Creating constructor
       setLayout(null);
        
       CustomerName = new JLabel("Customer Name:");
       add(CustomerName).setBounds(20,20,120,30);
       
        CustomerPhone = new JLabel("Customer Phone:");
        add(CustomerPhone).setBounds(20,45,120,20);
        
        ItemName = new JLabel("Item Name:");
        add(ItemName).setBounds(20,70,120,20);
        
        Price = new JLabel("Price:");
        add(Price).setBounds(20,95,120,20);
        
        Date = new JLabel("Date:");
        add(Date).setBounds(20,120,120,20);
        
        delivery = new JRadioButton("Home Delivery",true);
        add(delivery).setBounds(20,145,150,20);
        
        
        
        
        takeaway = new JRadioButton("Takeaway");
        add(takeaway).setBounds(20,170,120,20);
        takeaway.addActionListener(this);
        
        ButtonGroup bgrp = new ButtonGroup();
        bgrp.add(delivery);
        bgrp.add(takeaway);

        
        txtCustomerName = new JTextField();
        add(txtCustomerName).setBounds(160,20,100,20);
        
       
       txtCustomerPhone = new JTextField();
       add(txtCustomerPhone).setBounds(160,45,100,20);
       
       txtItemName = new JTextField();
       add(txtItemName).setBounds(160,70,100,20);
       
       txtPrice = new JTextField();
       add(txtPrice).setBounds(160,95,100,20);
       
       txtDate = new JTextField();
       add(txtDate).setBounds(160,120,100,20);
       

       
       btnSave = new JButton("Save");
       add(btnSave).setBounds(20,190,100,20);
       //btnSave.addActionListener(this);
       
      
       
       btnExit = new JButton("Exit");
       add(btnExit).setBounds(260,190,100,20);
       btnExit.addActionListener(this);
       

       setTitle("Order Item");
       setSize(400,500);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
       
       System.out.println("OrderItemView");
    }


	
	
	


	


@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource().equals(btnExit)){
		System.exit(0);
	}

}
public static void main(String[]args){
	new OrderItemView();
	
}


    }
    

