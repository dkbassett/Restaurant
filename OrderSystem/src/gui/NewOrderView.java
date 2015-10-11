package gui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import system.CustomerHandler;
import system.MenuItem;
import system.Order;
import system.OrderHandler;
import system.OrderItem;


public class NewOrderView extends JFrame implements ActionListener{
    private JPanel pnlCustomerDetails, pnlDelivery, pnlMenu, pnlOrder, pnlConfirmation;
    private DefaultTableModel dtm = new DefaultTableModel();
    private JTable tblMenu;
    private JTable tblOrder = new JTable(dtm);
    private JTextField txtItemNumber;
    private JLabel lblItemNumber;
    private JButton btnAddToOrder, btnview, btnConfirm, btnCancel;
    private JRadioButton rdoTakeAway, rdoHomeDelivery;
    private ButtonGroup deliveryOptions;
    private JScrollPane js, jsOrder;
    
    private FlowLayout experimentLayout = new FlowLayout();
    private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
    private float total = 0.00F;    	
    private Order currentOrder = new Order(CustomerHandler.getCurrentCustomer().getId(), orderItems, "Take away", total);

	public boolean RIGHT_TO_LEFT = false;
	
    public NewOrderView(){
    	
    	OrderHandler.setCurrentOrder(currentOrder);
    	
    	createAndShowGUI();
        System.out.println("NewOrderView");
    }
    
    public void addComponents(Container contentPane) {
        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        }
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        
        List<MenuItem> menuItemList = MenuItem.getMenuItemsFromDB();
        
        String[] orderColumnNames = {"Name", "Price", "Quantity"};
        Object[][] orderData = {
        		{"test","",""}
        };

        /** 
    	 * Delivery Panel and components
    	 */
        pnlDelivery = new JPanel();
        pnlDelivery.setLayout(new FlowLayout());
        pnlDelivery.setBorder(BorderFactory.createTitledBorder("Delivery Type"));
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
	     * Menu Panel and components
	     */
        pnlMenu = new JPanel();
        pnlMenu.setLayout(null);
        pnlMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
      	pnlMenu.setPreferredSize(new Dimension(800, 340));
           
      	// Item number label and text field
      	lblItemNumber = new JLabel("Item Number:");
      	pnlMenu.add(lblItemNumber).setBounds(20,20,100,20);      
      	txtItemNumber = new JTextField();
      	pnlMenu.add(txtItemNumber).setBounds(110,20,100,20);
            
      	// Menu item table
      	tblMenu = new JTable(new MenuTableModel(menuItemList));
      	tblMenu.setFillsViewportHeight(true);
      	js = new JScrollPane(tblMenu);
      	pnlMenu.add(js).setBounds(20,60,600,200);
      
      	// Add to order button
      	btnAddToOrder = new JButton("Add to order");
      	pnlMenu.add(btnAddToOrder).setBounds(20,280,120,20);
      	btnAddToOrder.addActionListener(this);
      
      	contentPane.add(pnlMenu);
            
	    /**
	     * Order Panel and components
	     */
	  	pnlOrder = new JPanel();
	  	pnlOrder.setLayout(new FlowLayout());
	  	pnlOrder.setBorder(BorderFactory.createTitledBorder("Order"));
	  	pnlOrder.setPreferredSize(new Dimension(800, 350));
	  	
	  	// Order item table
	  	tblOrder = new JTable(orderData, orderColumnNames);
	  	tblOrder.setFillsViewportHeight(true);
	  	jsOrder = new JScrollPane(tblOrder);
	  	pnlMenu.add(jsOrder).setBounds(20,400,600,200);
	  	
	  	contentPane.add(pnlOrder);
   	  	
	   /**
	    * Confirmation Panel and components
	    */
	  	pnlConfirmation = new JPanel();
	  	pnlConfirmation.setPreferredSize(new Dimension(300, 70));
	  	
	  	// Confirm button
	  	btnConfirm = new JButton("Confirm");
	  	btnConfirm.setPreferredSize(new Dimension(80, 20));
	  	pnlConfirmation.add(btnConfirm);
	  	btnConfirm.addActionListener(this);
	  	
	  	// Cancel button
	  	btnCancel = new JButton("Cancel");
	  	btnCancel.setPreferredSize(new Dimension(80, 20));
	  	pnlConfirmation.add(btnCancel);
	  	btnCancel.addActionListener(this);
	   
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==btnview){
           new CurrentOrderView();
       } else if (e.getSource()==btnConfirm) {
          new PaymentMethodView();
       } else if (e.getSource().equals(btnCancel)) {
    	   dispose();
       }
        
    }
   
}
