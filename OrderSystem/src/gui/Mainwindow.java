
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Mainwindow extends JFrame implements ActionListener  {

    JMenuBar menu; // Declearing Jmenubar
    JMenu Staffmember,Customerhandler,Rmenu, AddCustomer;  // Declearing Jmenu for Jmenubar
    JMenuItem Menuitem,Orderitem,Customer,Customer_Details, Customerlist, Ordertransaction,Stafflist ; //Declearing Jmenuitem for Jmenu
    JButton btnorder;
    JLabel label; // Declearing Jlabel
     
    
    public Mainwindow(){
        setLayout(null);
        menu = new JMenuBar();
        add(menu);
        Staffmember = new JMenu("Staff Member");
        menu.add(Staffmember).setBounds(20,20,40,40);
       
        Stafflist = new JMenuItem("Staff Lists");
        Staffmember.add(Stafflist).setBounds(20,30,40,40);
        Stafflist.addActionListener(this);
        
        
        
        
        Customerhandler = new JMenu("CustomerHandler");
        menu.add(Customerhandler).setBounds(70,20,40,40);
        Customer = new JMenuItem(" Add Staff");
        Customerhandler.add(Customer).setBounds(20,20,40,40);
        
        Customer_Details = new JMenuItem("Add customer");
        Customerhandler.add(Customer_Details).setBounds(20,30,40,40);
        
        Customerlist = new JMenuItem("Customer list");
        Customerhandler.add(Customerlist).setBounds(20,40,40,40);
        
        Customer.addActionListener(this);
        Customer_Details.addActionListener(this);
        Customerlist.addActionListener(this);
        
        Rmenu = new JMenu("Menu");
        menu.add(Rmenu).setBounds(80,20,40,40);
        
        
        Menuitem = new JMenuItem("Menuitem");
        Rmenu.add(Menuitem).setBounds(70,30,40,40);
        Menuitem.addActionListener(this);
       
        
        Orderitem = new  JMenuItem("Order Item");
        Rmenu.add(Orderitem).setBounds(70,30,40,40);
        Orderitem.addActionListener(this);
        
        Ordertransaction = new  JMenuItem("Order Transacation");
        Rmenu.add(Ordertransaction).setBounds(70,40,40,40);
        Ordertransaction.addActionListener(this);
        
        btnorder = new JButton("Click to make Order");
        add(btnorder).setBounds(500,300,300,100);
        btnorder.addActionListener(this);
        
        
       
        
        
try{
          setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Images\\LOGO.jpg"))))); //setting background screen
       }
       catch(IOException e){
            System.out.println("Image not found " );
        
       }
       
       
        
        setSize(600,400);
        setVisible(true);
        setJMenuBar(menu);
        
        
    
    
    }
    public static void main(String args[]){
    new Mainwindow();
    }

  
       

        @Override
        public void actionPerformed(ActionEvent e) {
           if(e.getSource()==Customerlist){
             new Customer_list();
           }
           if (e.getSource()==Customer_Details){
             new Customer_details();
           }
           if(e.getSource()==Customer){
              new Staff_Details();
           
           }
           if(e.getSource()== Orderitem){
               new Order();
              
            
            }
           if(e.getSource()==Menuitem){
        	   new MenuItem();
           }
           if(e.getSource()==Ordertransaction){
        	   new Orderhistory();
           }
           if(e.getSource()==Stafflist){
        	   new Login();
           }
           if(e.getSource()==btnorder){
        	   new OrderItem();
           }
              
    }
      
     
        
    
    
    
}
