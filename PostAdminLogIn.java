import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import java.awt.GridLayout;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.util.Locale;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PostAdminLogIn extends JFrame {

	/**
	 * 
	 */
	private JFrame frame;
	public PostAdminLogIn() {
		setVisible(true);
//		setMinimumSize(new Dimension(1366, 768));
		
	     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	     setBounds(0,0,screenSize.width, screenSize.height);
		
		
//		setResizable(false);
		getContentPane().setBackground(new Color(173, 216, 230));
		setTitle("Inventory Management System");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 42);
		getContentPane().add(menuBar);
		
		JMenu mnAddToInventory = new JMenu("Add Inventory");
		menuBar.add(mnAddToInventory);
		
		JMenuItem mntmAddProduct = new JMenuItem("Add Product");
		mnAddToInventory.add(mntmAddProduct);
		
		mntmAddProduct.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				AddProduct frame = new AddProduct();
				frame.setVisible(true);
				
			}
		});
		
		JMenuItem mntmAddItem = new JMenuItem("Add Item");
		mnAddToInventory.add(mntmAddItem);
		
		mntmAddItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				AddItem frame3 = new AddItem();
				frame3.setVisible(true);
			}
		});
		
		JMenu mnViewInventory = new JMenu("View Inventory");
		menuBar.add(mnViewInventory);
		
		JMenuItem mntmViewByCategory = new JMenuItem("View by Category");
		mnViewInventory.add(mntmViewByCategory);
		
		JMenuItem mntmViewByLocation = new JMenuItem("View by Location");
		mnViewInventory.add(mntmViewByLocation);
		
		JMenuItem mntmViewByUser = new JMenuItem("View by User");
		mnViewInventory.add(mntmViewByUser);
		
		JMenuItem mntmViewProduct = new JMenuItem("View Product");
		mnViewInventory.add(mntmViewProduct);
		mntmViewProduct.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				DisplayQueryResults viewProduct = new DisplayQueryResults("SELECT * FROM product");
				
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("View Items");
		mnViewInventory.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				DisplayQueryResults viewItems = new DisplayQueryResults("SELECT * FROM item");
				
			}
		});
		
		
		
		JMenu mnEditInventory = new JMenu("Edit Inventory");
		menuBar.add(mnEditInventory);
		
		JMenuItem mntmEditProduct = new JMenuItem("Edit Product");
		mnEditInventory.add(mntmEditProduct);
		
		mntmEditProduct.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				EditProduct frame = new EditProduct(); 
				frame.setVisible(true);
				}
		});
		
		JMenuItem mntmEditItem = new JMenuItem("Edit Item");
		mnEditInventory.add(mntmEditItem);
		
		mntmEditItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				EditItem frame = new EditItem(); 
				frame.setVisible(true);
				}
		});
	
		
		JMenu mnSupplier = new JMenu("Supplier");
		menuBar.add(mnSupplier);
		
		JMenuItem mntmSupplierAdd = new JMenuItem("Add Supplier");
		mnSupplier.add(mntmSupplierAdd);
		
		mntmSupplierAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				AddSupplier frame = new AddSupplier();
				frame.setVisible(true);
				
			}
		});
		
		JMenuItem mntmSupplierEdit = new JMenuItem("Edit Supplier");
		mnSupplier.add(mntmSupplierEdit);
		
		JMenu mnNewMenu = new JMenu("Allocation");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmUserAllocation = new JMenuItem("User Allocation");
		mnNewMenu.add(mntmUserAllocation);
		
		mntmUserAllocation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				UserAllocation frame = new UserAllocation();
				frame.setVisible(true);
				
			}
		});
		
		JMenuItem mntmRoomAllocation = new JMenuItem("Room Allocation");
		mnNewMenu.add(mntmRoomAllocation);
		
		mntmRoomAllocation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				RoomAllocation frame = new RoomAllocation();
				frame.setVisible(true);
				
			}
		});
		
		JMenu mnUser = new JMenu("User");
		menuBar.add(mnUser);
		
		JMenuItem mntmAddUser = new JMenuItem("Add User");
		mnUser.add(mntmAddUser);
		
		mntmAddUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				AddUser frame = new AddUser();
				frame.setVisible(true);
				
			}
		});
		
		JMenuItem mntmViewUser = new JMenuItem("View User");
		mnUser.add(mntmViewUser);
		mntmViewUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				DisplayQueryResults viewUser = new DisplayQueryResults("SELECT * FROM user");
				
				
			}
		});
		
		
		JMenu mnRoom = new JMenu("Room");
		menuBar.add(mnRoom);
		
		JMenuItem mntmAddRoom = new JMenuItem("Add Room");
		mnRoom.add(mntmAddRoom);
		
		mntmAddRoom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				AddRoom frame = new AddRoom();
				frame.setVisible(true);
				
			}
		});
		
		JMenuItem mntmViewRoom = new JMenuItem("View Room");
		mnRoom.add(mntmViewRoom);
		
		mntmViewRoom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				DisplayQueryResults viewRoom = new DisplayQueryResults("SELECT * FROM room");
				
			}
		});
		
		JMenu mnRequisitionForm = new JMenu("Requisition Form");
		menuBar.add(mnRequisitionForm);
		
		JMenuItem mntmRequisition = new JMenuItem("Requisition");
		mnRequisitionForm.add(mntmRequisition);
		
		JMenu mnDelete = new JMenu("Delete");
		menuBar.add(mnDelete);
		
		JMenuItem mntmById = new JMenuItem("By ID");
		mnDelete.add(mntmById);
		
		mntmById.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				Delete frame = new Delete();
				frame.setVisible(true);
				
			}
		});
		
		mntmRequisition.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				Requisition frame = new Requisition();
				frame.setVisible(true);
				
			}
		});
		
		initialize();
	}


private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
}

/*import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUser extends JFrame 
{

	private JFrame frame;
	public AddUser()
	{
		
		initialize();
	}

private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
}
*/