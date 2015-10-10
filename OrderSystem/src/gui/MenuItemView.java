




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


public class MenuItemView extends JFrame implements ActionListener{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel dtm = new DefaultTableModel();
    JTable tbl = new JTable(dtm);
    JTextField find;
    JLabel Item;
    JButton  btncreate, btnadd, btnview;
   

    public MenuItemView(){
        setLayout(null);
        
        Item = new JLabel("Item:");
        add(Item).setBounds(20,20,100,20);
        
        find = new JTextField();
        add(find).setBounds(140,20,100,20);
        
        
        btnadd = new JButton("View");
        add(btnadd).setBounds(600, 45, 150, 20);
        btnadd.addActionListener(this);

        btncreate = new JButton("Create new");
        add(btncreate).setBounds(100, 45, 150, 20);
        btncreate.addActionListener(this);
        
        setVisible(true);
        setTitle("MenuItem");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,1000);
        getTableData();
    
    
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
           new AddItemView().show();
           
       
       
       }
       
        
    }
    

    private void getTableData() {
        dtm.addColumn("Item ID");
        dtm.addColumn("Item Name");
        dtm.addColumn("Item Price");
        
        
        
        
       
       JScrollPane js = new JScrollPane(tbl);
       add(js).setBounds(20,100,900,500);
       
        
        
        
        
        
    }
   
}



