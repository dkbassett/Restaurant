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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;
import javax.swing.table.DefaultTableModel;

import system.CustomerHandler;
import system.MenuItem;
import system.Order;
import system.OrderHandler;
import system.OrderItem;


public class NewOrderView extends JFrame implements ActionListener, TableModelListener {
	private JFrame frame;
	private JPanel pnlCustomerDetails, pnlDelivery, pnlMenu, pnlOrder, pnlConfirmation;
    private DefaultTableModel dtm = new DefaultTableModel();
    private JTable tblMenu, tblOrder;
    private JTextField txtItemNumber;
    private JLabel lblItemNumber, lblTotalTitle, lblTotalValue;
    private JButton btnAddToOrder, btnview, btnConfirm, btnCancel;
    private JRadioButton rdoTakeAway, rdoHomeDelivery;
    private ButtonGroup deliveryOptions;
    private JScrollPane js, jsOrder;
    private ListSelectionModel listSelectionModel;
    private OrderItemTableModel orderItemTableModel;
    
    private FlowLayout experimentLayout = new FlowLayout();
    private ArrayList<MenuItem> menuItemList;
    private ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
    private float total = 0.00f;    	
    private Order currentOrder = new Order(CustomerHandler.getCurrentCustomer().getId(), orderItemList, "take-away", total);
    private JOptionPane confirmation = new JOptionPane();
    private int confirm;

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
        
        menuItemList = MenuItem.getMenuItemsFromDB();

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
      	txtItemNumber.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				textFieldChange();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				textFieldChange();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				textFieldChange();
			}
      		
      	});
      	pnlMenu.add(txtItemNumber).setBounds(110,20,100,20);
            
      	// Menu item table
      	tblMenu = new JTable(new MenuTableModel(menuItemList));
      	tblMenu.setFillsViewportHeight(true);
      	listSelectionModel = tblMenu.getSelectionModel();
      	
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
	  	pnlOrder.setLayout(null);
	  	pnlOrder.setBorder(BorderFactory.createTitledBorder("Order"));
	  	pnlOrder.setPreferredSize(new Dimension(800, 350));
	  	
	  	// Order item table
	  	orderItemTableModel = new OrderItemTableModel(orderItemList);
	  	tblOrder = new JTable(orderItemTableModel);
	  	tblOrder.getModel().addTableModelListener(this);
	  	tblOrder.setFillsViewportHeight(true);
	  	jsOrder = new JScrollPane(tblOrder);
	  	pnlOrder.add(jsOrder).setBounds(20,40,600,200);
	  	
	  	lblTotalTitle = new JLabel("Total:");
	  	pnlOrder.add(lblTotalTitle).setBounds(550, 280, 80, 30);
	  	lblTotalValue = new JLabel(String.valueOf(total));
	  	pnlOrder.add(lblTotalValue).setBounds(590, 280, 80, 30);
	  	
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
        frame = new JFrame("New Order") {
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
    	  OrderHandler.updateCurrentOrderItemList((ArrayList<OrderItem>) orderItemTableModel.getOrderItems());
          new PaymentMethodView();
       } else if (e.getSource().equals(btnCancel)) {
    	   frame.dispose();
    	   System.out.println("Cancel button fired");
       } else if (e.getSource().equals(btnAddToOrder)) {
    	   confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to add this item?","Confirmation",JOptionPane.YES_NO_OPTION);
    	   if (confirm==0){
    		   int[] selectedRowIndices = tblMenu.getSelectedRows();  
    		   for (int i = 0; i < selectedRowIndices.length; i++) {
    			   System.out.println("Selected Row Index: " + selectedRowIndices[i]);
    			   OrderItem orderItem = new OrderItem(menuItemList.get(selectedRowIndices[i]), 1, false);
    			   orderItemTableModel.addOrderItem(orderItem);

    			   System.out.println("Order item in current order orderItem list: " + currentOrder.getItemList().get(i));
    		   }
    	   
    	   total = currentOrder.calculateTotal();
    	   String totalValue = String.format("$%.2f", total);
    	   lblTotalValue.setText(totalValue);
    	   System.out.println("First Order Item: " + orderItemList.get(0).getMenuItem().getName());
    	   }
       }
        
    }

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
        int column = e.getColumn();
        String columnName = orderItemTableModel.getColumnName(column);
        
        if (columnName == "Quantity") {     	
        	Object data = orderItemTableModel.getValueAt(row, column);
            int count = (Integer) data;
     		currentOrder.getItemList().get(row).setQuantity(count);
     		total = currentOrder.calculateTotal();
     		String totalValue = String.format("$%.2f", total);
     		lblTotalValue.setText(totalValue);
        }
       
	}
	
	public void textFieldChange() {	
		if (!txtItemNumber.getText().equals(null) && !txtItemNumber.getText().equals("")) {
			try {
				int itemNumber = Integer.parseInt(txtItemNumber.getText());
				listSelectionModel.setSelectionInterval(itemNumber - 1, itemNumber - 1);
			} catch (NumberFormatException e) {
				System.out.println("number not in correct format");
			}
		}
	}
    
   
}
