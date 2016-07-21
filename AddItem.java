import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Label;

import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextPane;


public class AddItem extends JFrame {

	private JFrame frame;
	private JTextField textaddItemProductId;
	private JTextField textaddItemSupplierId;
	private JTextField textaddItemModel;
	private JTextField textaddItemPrice;
	private JTextPane txtPaneAddItemRemarks;
	public AddItem() {
		setTitle("Add Item");
		setMinimumSize(new Dimension(450, 330));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		textaddItemProductId = new JTextField();
		textaddItemProductId.setColumns(10);
		textaddItemProductId.setBounds(118, 10, 80, 22);
		getContentPane().add(textaddItemProductId);
		
		Label addItemProductId = new Label("Product Id");
		addItemProductId.setBounds(10, 10, 82, 22);
		getContentPane().add(addItemProductId);
		
		Label addItemSupplierId = new Label("Supplier Id");
		addItemSupplierId.setBounds(229, 10, 82, 22);
		getContentPane().add(addItemSupplierId);
		
		textaddItemSupplierId = new JTextField();
		textaddItemSupplierId.setColumns(10);
		textaddItemSupplierId.setBounds(324, 10, 80, 22);
		getContentPane().add(textaddItemSupplierId);
		
		textaddItemModel = new JTextField();
		textaddItemModel.setColumns(10);
		textaddItemModel.setBounds(118, 45, 150, 22);
		getContentPane().add(textaddItemModel);
		
		Label addItemModel = new Label("Model");
		addItemModel.setBounds(10, 45, 82, 22);
		getContentPane().add(addItemModel);
		
		Label addItemPrice = new Label("Price");
		addItemPrice.setBounds(10, 80, 82, 22);
		getContentPane().add(addItemPrice);
		
		textaddItemPrice = new JTextField();
		textaddItemPrice.setColumns(10);
		textaddItemPrice.setBounds(118, 80, 80, 22);
		getContentPane().add(textaddItemPrice);
		
		Label addItemRemarks = new Label("Remarks");
		addItemRemarks.setBounds(10, 115, 82, 22);
		getContentPane().add(addItemRemarks);
		
		JButton btnAddItemSave = new JButton("Save");
		btnAddItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main Query = new Main();
				String queryText = "INSERT INTO `item` (`productID`,`supplierID`,`model`,`price`,`remarks`) VALUES ('"+Integer.parseInt(textaddItemProductId.getText())+"', '"+Integer.parseInt(textaddItemSupplierId.getText())+"','"+textaddItemModel.getText().toString()+"','"+Integer.parseInt(textaddItemPrice.getText())+"','"+txtPaneAddItemRemarks.getText().toString()+"')";
				Query.connectData(queryText, 1);
				//JOptionPane.showMessageDialog(frame, "items Added");
			}
//				final String DATABASE_URL = "jdbc:mysql://localhost/inventory";
//				Connection connection = null;
//				
//				try {
//					connection = DriverManager.getConnection( DATABASE_URL,"root","");
//				} catch (SQLException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
//				PreparedStatement preparedstatement = null;
//				try {
//					preparedstatement = connection.prepareStatement("INSERT INTO `item` (`productID`,`supplierID`,`model`,`price`,`remarks`) VALUES ('"+Integer.parseInt(textaddItemProductId.getText())+"', '"+Integer.parseInt(textaddItemSupplierId.getText())+"','"+textaddItemModel.getText().toString()+"','"+Integer.parseInt(textaddItemPrice.getText())+"','"+txtPaneAddItemRemarks.getText().toString()+"')");
//				} catch (NumberFormatException | SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				try {
//					int result = preparedstatement.executeUpdate();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
		});
		btnAddItemSave.setBounds(329, 255, 89, 23);
		getContentPane().add(btnAddItemSave);
		
		txtPaneAddItemRemarks = new JTextPane();
		txtPaneAddItemRemarks.setBounds(118, 115, 300, 120);
		getContentPane().add(txtPaneAddItemRemarks);
		
		initialize();
	}


private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
}