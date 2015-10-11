package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.TableColumn;
import javax.swing.text.Document;


public class NewOrderView extends JFrame implements ActionListener{
    JPanel pnlCustomerDetails, pnlDelivery, pnlMenu, pnlOrder, pnlConfirmation;
    DefaultTableModel dtm = new DefaultTableModel();
    JTable tblMenu;
    JTable tblOrder = new JTable(dtm);
    JTextField txtItemNumber;
    JLabel lblItemNumber;
    JButton btnAddToOrder, btnview, btnConfirm, btnCancel;
    JRadioButton rdoTakeAway, rdoHomeDelivery;
    ButtonGroup deliveryOptions;
    JScrollPane js, jsOrder;
    
    FlowLayout experimentLayout = new FlowLayout();

    public NewOrderView(){
    	createAndShowGUI();
        System.out.println("NewOrderView");
    }
    
    public boolean RIGHT_TO_LEFT = false;

    public void addComponents(Container contentPane) {
        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        }
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        
        String[] menuColumnNames = {"ID", "Name", "Price"};
        Object[][] menuData = {
        		{"1", "Pizza", "$10.50"},
        		{"2", "Hamburger", "$8.50"},
        		{"3", "Shephard Pie", "$9.50"}
        };
        
        String[] orderColumnNames = {"Name", "Price", "Quantity"};
        Object[][] orderData = {
        		{"test","",""}
        };
        
        /** 
    	 * Delivery Panel
    	 */
        pnlDelivery = new JPanel();
        pnlDelivery.setLayout(new FlowLayout());
        pnlDelivery.setBorder(BorderFactory.createTitledBorder("Delivery Type"));
//        add(pnlDelivery).setBounds(20, 50, 300, 70);
        pnlDelivery.setPreferredSize(new Dimension(300, 70));
        
        // Radio button group within panel
        deliveryOptions = new ButtonGroup(); 
        rdoTakeAway = new JRadioButton("Take Away");
        rdoHomeDelivery = new JRadioButton("Home Delivery");
        rdoTakeAway.setSelected(true);
        deliveryOptions.add(rdoTakeAway);
        deliveryOptions.add(rdoHomeDelivery);
        
        // Add radio buttons to panel
        pnlDelivery.add(rdoTakeAway); 
        pnlDelivery.add(rdoHomeDelivery);
        contentPane.add(pnlDelivery);
        
        /** 
         * Menu Panel
         */
        pnlMenu = new JPanel();
        pnlMenu.setLayout(null);
//        pnlMenu.setAlignmentX(FlowLayout.TRAILING);
        pnlMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
      	pnlMenu.setPreferredSize(new Dimension(800, 340));
      	
//      add(pnlMenu).setBounds(20, 100, 800, 500);
      
      
       // Item number label and text field
       lblItemNumber = new JLabel("Item Number:");
//       lblItemNumber.setPreferredSize(new Dimension(100, 20));
//     	 pnlMenu.add(lblItemNumber);
       pnlMenu.add(lblItemNumber).setBounds(20,20,100,20);

       
       txtItemNumber = new JTextField();
//       txtItemNumber.setPreferredSize(new Dimension(100, 20));
//       pnlMenu.add(txtItemNumber);
       pnlMenu.add(txtItemNumber).setBounds(110,20,100,20);
       
       
      // Menu item table
       tblMenu = new JTable(menuData, menuColumnNames);
       tblMenu.setFillsViewportHeight(true);
       js = new JScrollPane(tblMenu);
//      js.setPreferredSize(new Dimension(600, 200));
//      pnlMenu.add(js, BorderLayout.LINE_START);
       pnlMenu.add(js).setBounds(20,60,600,200);
      
      // Add to order button
      btnAddToOrder = new JButton("Add to order");
//      btnAddToOrder.setPreferredSize(new Dimension(120, 20));
//      pnlMenu.add(btnAddToOrder);
      pnlMenu.add(btnAddToOrder).setBounds(20,280,120,20);
//      btnAddToOrder.addActionListener(this);
      
      contentPane.add(pnlMenu);
      
      
	    /**
	    * Order Panel
	    */
	   pnlOrder = new JPanel();
	   pnlOrder.setLayout(new FlowLayout());
	   pnlOrder.setBorder(BorderFactory.createTitledBorder("Order"));
	//   add(pnlOrder).setBounds(20, 300, 800, 500);
	   pnlOrder.setPreferredSize(new Dimension(800, 350));
	   contentPane.add(pnlOrder);
	   
	// Order item table
       tblOrder = new JTable(orderData, orderColumnNames);
       tblOrder.setFillsViewportHeight(true);
       jsOrder = new JScrollPane(tblOrder);
//      js.setPreferredSize(new Dimension(600, 200));
//      pnlMenu.add(js, BorderLayout.LINE_START);
       pnlMenu.add(jsOrder).setBounds(20,400,600,200);
   
	   /**
	    * Confirmation Panel
	    */
	   pnlConfirmation = new JPanel();
	   pnlConfirmation.setPreferredSize(new Dimension(300, 70));
	   btnConfirm = new JButton("Confirm");
//	   add(btnConfirm).setBounds(20,800,80,20);
	   btnConfirm.setPreferredSize(new Dimension(80, 20));
	   pnlConfirmation.add(btnConfirm);
//	   btnConfirm.addActionListener(this);

	   btnCancel = new JButton("Cancel");
//	   add(btnCancel).setBounds(120,800,80,20);
	   btnCancel.setPreferredSize(new Dimension(80, 20));
	   pnlConfirmation.add(btnCancel);
//	   btnCancel.addActionListener(this);
	   
	   contentPane.add(pnlConfirmation);
	   
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("New Order") {
            public Dimension getMinimumSize() {
                Dimension prefSize = getPreferredSize();
                return new Dimension(100, prefSize.height);
            }
        };
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Set up the content pane and components in FlowLayout
        addComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
//    public static void createNewOrderView() {
//    	NewOrderView frame = new NewOrderView();
//    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    	frame.addComponentsToPane(frame.getContentPane());
//    	frame.pack();
//    	frame.setVisible(true);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==btnview){
           new CurrentOrderView();

       }
        
    }
    

    private void getTableData() {
        dtm.addColumn("ID");
        dtm.addColumn("Customer ID");
        dtm.addColumn("Item list");
        dtm.addColumn("Confirmation Status");
        dtm.addColumn("Delivery");
        dtm.addColumn("Grand Total");
    }
   
}
