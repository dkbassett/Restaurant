package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;


public class NewOrderView extends JFrame implements ActionListener{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    JPanel pnlDelivery, pnlMenu, pnlOrder;
//    DefaultTableModel dtm = new DefaultTableModel();
//    JTable tblMenu = new JTable(dtm);
    
    JTextField txtItemNumber;
    JLabel lblItemNumber;
    JButton btnAddToOrder, btnview, btnConfirm, btnCancel;
    JRadioButton rdoTakeAway, rdoHomeDelivery;
    ButtonGroup deliveryOptions;
   

    public NewOrderView(){
        
    	 setLayout(null);
    	
       
        
        pnlDelivery = new JPanel();
        pnlDelivery.setBorder(BorderFactory.createTitledBorder("Delivery Type"));
        add(pnlDelivery).setBounds(20, 100, 500, 100);
        
        deliveryOptions = new ButtonGroup(); 
        rdoTakeAway = new JRadioButton("Take Away");
        rdoHomeDelivery = new JRadioButton("Home Delivery");
        rdoTakeAway.setSelected(true);
        deliveryOptions.add(rdoTakeAway);
        deliveryOptions.add(rdoHomeDelivery);
        
        pnlDelivery.add(rdoTakeAway); 
        pnlDelivery.add(rdoHomeDelivery);
        
        pnlMenu = new JPanel();
        pnlMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
        add(pnlMenu).setBounds(20, 300, 500, 500);
        
        lblItemNumber = new JLabel("Item Number:");
        pnlMenu.add(lblItemNumber).setBounds(20,20,100,20);
        
        txtItemNumber = new JTextField();
        pnlMenu.add(txtItemNumber).setBounds(140,20,100,20);
        
        btnAddToOrder = new JButton("Add to order");
        pnlMenu.add(btnAddToOrder).setBounds(20,500,120,20);
        btnAddToOrder.addActionListener(this);
        
        
        btnConfirm = new JButton("Confirm");
        add(btnConfirm).setBounds(20,800,80,20);
        btnConfirm.addActionListener(this);
        
        btnCancel = new JButton("Cancel");
//        btnCancel.setPreferredSize(new Dimension(80,20));
        add(btnCancel).setBounds(120,800,80,20);
        add(btnCancel);
        btnCancel.addActionListener(this);
        
        setVisible(true);
        setTitle("New Order");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,1000);
//        getTableData();
    
        System.out.println("NewOrderView");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==btnview){
           new CurrentOrderView();

       }
        
    }
    

//    private void getTableData() {
//        dtm.addColumn("ID");
//        dtm.addColumn("Customer ID");
//        dtm.addColumn("Item list");
//        dtm.addColumn("Confirmation Status");
//        dtm.addColumn("Delivery");
//        dtm.addColumn("Grand Total");
//        
//
//       JScrollPane js = new JScrollPane(tblMenu);
//       add(js).setBounds(20,100,900,500);
//
//    }
   
}
