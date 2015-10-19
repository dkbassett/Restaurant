package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class LoginView extends JFrame implements ActionListener {
   JLabel Title,lblUserName, lblPassword;
   JTextField txtUserName;
   JPasswordField Password;
   JButton btnLogin, btnCancel;
   
   public LoginView(){
       setLayout(null);
       setSize(300,200);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       fieldinitializer();
       
   }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btnLogin){
          if(txtUserName.getText().toString().equals("Daniel")&& Password.getText().toString().equals("Daniel")|| txtUserName.getText().toString().equals("Uttam")&& Password.getText().toString().equals("Uttam")|| txtUserName.getText().toString().equals("David")&& Password.getText().toString().equals("David")) {
             new MainwindowView();
             dispose();
          }else{
          JOptionPane.showMessageDialog(null,"Input correct userName and password");
          }
      }else if(e.getSource().equals(btnCancel)){
    	  dispose();
      }
    }

    private void fieldinitializer() {
    	
	   Title = new JLabel("Staff Login");
	   add(Title).setBounds(20,20,120,20);
	     
       lblUserName = new JLabel("UserName:");
       add(lblUserName).setBounds(20,65,100,20);
       txtUserName = new JTextField();
       add(txtUserName).setBounds(100,65,100,20);
       
       lblPassword = new JLabel("Password:");
       add(lblPassword).setBounds(20,90,100,30);
       Password = new JPasswordField();
       add(Password).setBounds(100,90,100,20);
       
       btnLogin = new JButton("Login");
       add(btnLogin).setBounds(20,130,80,20);
       btnLogin.addActionListener(this);
       
	   btnCancel = new JButton("Cancel");
	   add(btnCancel).setBounds(120,130,80,20);
	   btnCancel.addActionListener(this);	     
        
    }

}
