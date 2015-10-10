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


public class CreditCardView extends JFrame implements ActionListener{
	
	JLabel Title, Number, Expiry, CardHolder,CardProvider;
	JTextField txtNumber,txtMonthExpiry,txtYearExpiry,txtCardHolder,txtCardProvider;
	JButton btnConfirm,btnCancel;
	
	public CreditCardView(){
		setLayout(null);
		
	    Title = new JLabel("New Credit Card");
	     add(Title).setBounds(20,20,120,20);
	     
	     Number = new JLabel("Number:");  
	     add(Number).setBounds(20,65,120,20);
	     
	     Expiry = new JLabel("Expiry(mm/yy):");
	     add(Expiry).setBounds(20,90,120,20);
	     
	     CardHolder = new JLabel("Card Holder:");
	     add(CardHolder).setBounds(20,115,120,20);	     

	     CardProvider= new JLabel("Card Provider:");
	     add(CardProvider).setBounds(20,140,120,20);	
	     
	     txtNumber = new JTextField();
	     add(txtNumber).setBounds(110,65,200,20);	     
	     
	     txtMonthExpiry = new JTextField();
	     add(txtMonthExpiry).setBounds(110,90,20,20);	
	     
	     txtYearExpiry = new JTextField();
	     add(txtYearExpiry).setBounds(130,90,20,20);		     

	     txtCardHolder = new JTextField();
	     add(txtCardHolder).setBounds(110,115,200,20);
	     
	     txtCardProvider = new JTextField();
	     add(txtCardProvider).setBounds(110,140,200,20);		    
	     
	     btnConfirm = new JButton("Confirm");
	     add(btnConfirm).setBounds(20,200,80,20);
	     btnConfirm.addActionListener(this);
	     
	     btnCancel = new JButton("Cancel");
	     add(btnCancel).setBounds(120,200,80,20);
	     btnCancel.addActionListener(this);	     
	     
	     setTitle("New Credit Card");
	     setSize(400,300);
	     setVisible(true);
	     setDefaultCloseOperation(DISPOSE_ON_CLOSE);	      
	     
	}
	

	
@Override
public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnCancel)){
			//System.exit(0);
			dispose();
		}
		else if(e.getSource().equals(btnConfirm)){
			String number = txtNumber.getText();
			String expiryMon = txtMonthExpiry.getText();
			String expiryYear = txtYearExpiry.getText();
			String cardHold = txtCardHolder.getText();
			String cardProv = txtCardProvider.getText();
			
			System.out.println("Ui Level: " + cardHold);
			System.out.println("Ui Level: " + cardProv);
			System.out.println("Ui Level: " + expiryYear);
			System.out.println("Ui Level: " + expiryMon);
			System.out.println("Ui Level: " + number);
			
			
			//DateFormat Nexpiry= new DateFormat();
			//new CreditCard(cardHold,cardProv,number,expiry);
			dispose();
			
			//Customer_details.Close();
			//new Customer(Cust,)
		}
		
	}
	
}
