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


public class Staff_DetailsView extends JFrame implements ActionListener{
    
    DefaultTableModel dtm = new DefaultTableModel();
    JTable tbl = new JTable(dtm);
    JTextField find;
    JLabel Name;
    JButton  btncreate, btnview;
   

    public Staff_DetailsView(){
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
        setTitle("Staff List");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,1000);
        getTableData();
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnview){
            
        }
       if(e.getSource()==btncreate){
           new AddStaffView().show();
           
       
       
       }
        
    }
    

    private void getTableData() {
        dtm.addColumn("Staff ID");
        dtm.addColumn("Staff Name");
        
        
        
       
       JScrollPane js = new JScrollPane(tbl);
       add(js).setBounds(20,100,900,500);
       
        
        
        
        
        
    }
    
}
