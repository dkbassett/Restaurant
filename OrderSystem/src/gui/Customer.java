




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


public class Customer extends JFrame implements ActionListener{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel dtm = new DefaultTableModel();
    JTable tbl = new JTable(dtm);
    JTextField find;
    JLabel Item;
    JButton   btnview;
   

    public Customer(){
        setLayout(null);
        
        Item = new JLabel("Item:");
        add(Item).setBounds(20,20,100,20);
        
        find = new JTextField();
        add(find).setBounds(140,20,100,20);
        
        
        

       
        
        setVisible(true);
        setTitle("StaffList");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,1000);
        getTableData();
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnview){
           
        }
       
           
       
       
       
        
    }
    

    private void getTableData() {
        dtm.addColumn(" ID");
        dtm.addColumn("Order");
        dtm.addColumn("Sale Date");
        dtm.addColumn("Payment method");
        
        
        
        
       
       JScrollPane js = new JScrollPane(tbl);
       add(js).setBounds(20,100,900,500);
       
        
        
        
        
        
    }
   
}



