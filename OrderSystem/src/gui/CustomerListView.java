

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


public class CustomerListView extends JFrame implements ActionListener{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel dtm = new DefaultTableModel();
    JTable tbl = new JTable(dtm);
    JTextField find;
    JLabel Name;
    JButton  btncreate, btnview;
   

    public CustomerListView(){
        setLayout(null);
        
        Name = new JLabel("Name:");
        add(Name).setBounds(20,20,100,20);
        
        find = new JTextField();
        add(find).setBounds(140,20,100,20);
        
        
        btnview = new JButton("View");
        add(btnview).setBounds(600, 45, 150, 20);
        btnview.addActionListener(this);

        btncreate = new JButton("Create new");
        add(btncreate).setBounds(100, 45, 150, 20);
        btncreate.addActionListener(this);
        
        setVisible(true);
        setTitle("Customer list");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,1000);
        getTableData();
        System.out.println("CustomerListView");
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnview){
            String a = tbl.getValueAt(tbl.getSelectedRow(),0).toString();
            String b = tbl.getValueAt(tbl.getSelectedRow(),1).toString();
            String c = tbl.getValueAt(tbl.getSelectedRow(),2).toString();
            String d = tbl.getValueAt(tbl.getSelectedRow(),3).toString();
            String ee = tbl.getValueAt(tbl.getSelectedRow(),4).toString();
            String f = tbl.getValueAt(tbl.getSelectedRow(),5).toString();
            
            
            NewCustomerView cd = new NewCustomerView();
            cd.transferData(a,b,c,d,ee,f);
            cd.show();
        }
       if(e.getSource()==btncreate){
           new NewCustomerView().show();
           
       
       
       }
        
    }
    

    private void getTableData() {
        dtm.addColumn("First Nme");
        dtm.addColumn("Last Name");
        dtm.addColumn("Address");
        dtm.addColumn("Phone");
        dtm.addColumn("Credit Card");
        dtm.addColumn("CVV");
        dtm.addColumn("Expiry Date");
        dtm.addColumn("Home Delivery/Take away");
        

       JScrollPane js = new JScrollPane(tbl);
       add(js).setBounds(20,100,900,500);
       
 
    }
    
}
