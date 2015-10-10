

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;


public class CurrentOrderView extends JFrame implements ActionListener{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel dtm = new DefaultTableModel();
    JTable tbl = new JTable(dtm);
    JTextField find;
    JLabel Item;
    JButton btnview,btncreate;
    
    
   

    public CurrentOrderView(){
        setLayout(null);
        
        
        
        setVisible(true);
        setTitle("Current Order");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,1000);
        getTableData();
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnview){
            
            
            
           new OrderView();
           
        }
       if(e.getSource()==btncreate){
           new NewCustomerView().show();
           
       
       
       }
       
       if(e.getSource()==btnview){
           new OrderView().show();
           
       
       
       }
        
    }
    

    private void getTableData() {
        dtm.addColumn("Menu Item");
        dtm.addColumn("Quantity");
        dtm.addColumn("Conformation Status");
        
        
        
        
       
       JScrollPane js = new JScrollPane(tbl);
       add(js).setBounds(20,100,900,500);
       
        
        
        
        
        
    }
   
}
