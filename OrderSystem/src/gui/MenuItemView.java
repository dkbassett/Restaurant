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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import system.CustomerHandler;
import system.MenuItem;
import system.Order;
import system.OrderHandler;
import system.OrderItem;


public class MenuItemView extends JFrame implements ActionListener, TableModelListener {
	private JFrame frame;
	private JPanel pnlCustomerDetails, pnlDelivery, pnlMenu, pnlOrder, pnlConfirmation;
    private DefaultTableModel dtm = new DefaultTableModel();
    private JTable tblMenu, tblOrder;
    private JTextField txtItemNumber;
    private JLabel lblItemNumber, lblTotalTitle, lblTotalValue;
    private JButton btnAddToOrder, btnview, btnSave, btnCancel,btnUpdate;
    private JScrollPane js, jsOrder;
    private ListSelectionModel listSelectionModel;
    
    private ArrayList<MenuItem> menuItemList;
    private MenuTableModel menuTableModel;
	public boolean RIGHT_TO_LEFT = false;
	
    public MenuItemView(){
    	
    //	OrderHandler.setCurrentOrder(currentOrder);
    	
    	createAndShowGUI();
        System.out.println("MenuItemView");
    }
    
    public void addComponents(Container contentPane) {
        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        }
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        
        menuItemList = MenuItem.getMenuItemsFromDB();
        
        String[] orderColumnNames = {"Name", "Price", "Quantity"};
        Object[][] orderData = {
        		{"test","",""}
        };
        
	    /** 
	     * Menu Panel and components
	     */
        pnlMenu = new JPanel();
        pnlMenu.setLayout(null);
        pnlMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
      	pnlMenu.setPreferredSize(new Dimension(800, 340));
            
      	// Menu item table
      	menuTableModel = new MenuTableModel(menuItemList);
      	menuTableModel.setEditableColumn(1, true);
      	menuTableModel.setEditableColumn(2, true);
      	tblMenu = new JTable(menuTableModel);
      	tblMenu.getModel().addTableModelListener(this);
      	tblMenu.setFillsViewportHeight(true);
      	listSelectionModel = tblMenu.getSelectionModel();
      	
      	js = new JScrollPane(tblMenu);
      	pnlMenu.add(js).setBounds(20,60,600,200);
      
      	// Add to order button
      	btnAddToOrder = new JButton("Add to Menu");
      	pnlMenu.add(btnAddToOrder).setBounds(20,280,120,20);
      	btnAddToOrder.addActionListener(this);
      
      	btnUpdate = new JButton("Update");
      	pnlMenu.add(btnUpdate).setBounds(160,280,80,20);
      	btnUpdate.addActionListener(this);
      	
      	contentPane.add(pnlMenu);
            
   	  	
	   /**
	    * Confirmation Panel and components
	    */
	  	pnlConfirmation = new JPanel();
	  	pnlConfirmation.setPreferredSize(new Dimension(300, 70));
	  	
	  	// Confirm button
	  	btnSave = new JButton("Save");
	  	btnSave.setPreferredSize(new Dimension(80, 20));
	  	pnlConfirmation.add(btnSave);
	  	btnSave.addActionListener(this);
	  	
	  	// Cancel button
	  	btnCancel = new JButton("Cancel");
	  	btnCancel.setPreferredSize(new Dimension(80, 20));
	  	pnlConfirmation.add(btnCancel);
	  	btnCancel.addActionListener(this);
	   
	  	contentPane.add(pnlConfirmation);	   
    }
    
    public void createAndShowGUI() {
        frame = new JFrame("Menu Items") {
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
       } else if (e.getSource()==btnSave) {
    	   frame.dispose();  	   
       } else if (e.getSource().equals(btnCancel)) {
    	   frame.dispose();
    	   System.out.println("Cancel button fired");
       } else if (e.getSource().equals(btnAddToOrder)) { // acts as add to Menu button
    	 new AddItemView();
       } else if (e.getSource()==btnUpdate) {

    	// frame.setVisible(false);
    	  // frame.getContentPane().remove(pnlMenu);
    	   JPanel contentPane = (JPanel) frame.getContentPane();
    	   frame.getContentPane().removeAll();
    	   
    	  menuItemList = MenuItem.getMenuItemsFromDB();
    	   
           String[] orderColumnNames = {"Name", "Price", "Quantity"};
           Object[][] orderData = {
          		{"test","",""}
           };
           	pnlMenu = new JPanel();
           	pnlMenu.setLayout(null);
          	pnlMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
         	pnlMenu.setPreferredSize(new Dimension(800, 340));
         	
         	// menu item table
         	tblMenu = new JTable(new MenuTableModel(menuItemList));
          	tblMenu.setFillsViewportHeight(true);
          	
          	js = new JScrollPane(tblMenu);
         	pnlMenu.add(js).setBounds(20,60,600,200);
         	
          	btnAddToOrder = new JButton("Add to Menu");
          	pnlMenu.add(btnAddToOrder).setBounds(20,280,120,20);
          	btnAddToOrder.addActionListener(this);
          
          	btnUpdate = new JButton("Update");
          	pnlMenu.add(btnUpdate).setBounds(160,280,80,20);
          	btnUpdate.addActionListener(this);
          	
          	frame.getContentPane().add(pnlMenu);
          	frame.getContentPane().add(pnlConfirmation);
          	
          	// createAndShowGUI();
         	frame.getContentPane().repaint();
         	frame.getContentPane().revalidate();
         	frame.getContentPane().repaint();
       }
    }
    
    
    @Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
        int column = e.getColumn();
        String columnName = menuTableModel.getColumnName(column);
        
        if (columnName.equals("Name")) {     	
        	Object data = menuTableModel.getValueAt(row, column);
            String name = (String) data;
            menuItemList.get(row).setName(name);
        }
        if (columnName.equals("Price")) {     	
        	Object data = menuTableModel.getValueAt(row, column);
            float price = (Float) data;
            menuItemList.get(row).setPrice(price);
        }
       
	}
    
        
}


    
   




