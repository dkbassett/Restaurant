package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login extends JFrame implements ActionListener {
   JLabel lblUserName, lblPassword;
   JTextField txtUserName;
   JPasswordField Password;
   JButton btnLogin, btnExit;
   
   public Login(){
       setLayout(null);
       setSize(400,200);
       setVisible(true);
       fieldinitializer();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btnLogin){
          if(txtUserName.getText().toString().equals("Daniel")&& Password.getText().toString().equals("Daniel")|| txtUserName.getText().toString().equals("Uttam")&& Password.getText().toString().equals("Uttam")) {
             new Staff_Details().show();
          }
          else{
          JOptionPane.showMessageDialog(null,"Input correct userName and password");
          }
      }
    }

    private void fieldinitializer() {
       lblUserName = new JLabel("UserName:");
       add(lblUserName).setBounds(10,20,100,20);
       txtUserName = new JTextField();
       add(txtUserName).setBounds(130,20,100,20);
       
       lblPassword = new JLabel("Password:");
       add(lblPassword).setBounds(10,50,100,30);
       Password = new JPasswordField();
       add(Password).setBounds(130,50,100,20);
       
       btnLogin = new JButton("Login");
       add(btnLogin).setBounds(20,80,100,20);
       btnLogin.addActionListener(this);
       
       
    }

   
   
    
}
