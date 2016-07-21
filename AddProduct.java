import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JTextField;

import java.awt.Label;
import java.awt.Button;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;


public class AddProduct extends JFrame {

	private JFrame frame2;
	private JTextField textAddProductDescription;
	private JTextField textAddProductProductName;
	private JTextField textAddProductQuantity;
	String comboBoxCategory;
	public AddProduct() {
		getContentPane().setMinimumSize(new Dimension(450, 350));
		getContentPane().setBackground(new Color(173, 216, 230));
		setTitle("Add Product");
		setAlwaysOnTop(true);
		setMinimumSize(new Dimension(450, 320));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		Label addProductCategory = new Label("Category");
		addProductCategory.setBounds(10, 10, 92, 22);
		getContentPane().add(addProductCategory);
		
		Label addProductDescription = new Label("Description");
		addProductDescription.setBounds(10, 115, 82, 22);
		getContentPane().add(addProductDescription);
		
		textAddProductDescription = new JTextField();
		textAddProductDescription.setBounds(118, 115, 300, 99);
		getContentPane().add(textAddProductDescription);
		textAddProductDescription.setColumns(10);
		
		JButton btnAddProductSave = new JButton("Save");
		btnAddProductSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main Query = new Main();
				String queryText = "INSERT INTO `product` (`category`,`productName`,`quantity`,`remarks`) VALUES ('"+comboBoxCategory+"', '"+textAddProductProductName.getText().toString()+"','"+Integer.parseInt(textAddProductQuantity.getText())+"','"+textAddProductDescription.getText().toString()+"')";
				Query.connectData(queryText, 1);
				JOptionPane.showMessageDialog(frame2, "Product Added");
//				final String DATABASE_URL = "jdbc:mysql://localhost/inventory";
//				Connection connection = null;
//				//Main connectionData = new Main();
////				String insertQuery = "INSERT INTO product(category,productName,quantity,remarks) VALUES(?,?,?,?)";
////				System.out.printf("%s",textAddProductProductName.getText());
//				
//				//connectionData.connectData(insertQuery,1);
//				try {
//					connection = DriverManager.getConnection( DATABASE_URL,"root","");
//					//java.sql.BLOB myBlob = java.sql.BLOB.createTemporary(connection, false, oracle.sql.BLOB.DURATION_SESSION);
////					String data = textAddProductProductName.toString();
////					byte[] buff = data.getBytes();
//					
//					PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO `product` (`category`,`productName`,`quantity`,`remarks`) VALUES ('"+comboBoxCategory+"', '"+textAddProductProductName.getText().toString()+"','"+Integer.parseInt(textAddProductQuantity.getText())+"','"+textAddProductDescription.getText().toString()+"')");
////					preparedstatement.setString(1, comboBoxCategory );
////					preparedstatement.setString(2, textAddProductProductName.getText().toString() );
////					preparedstatement.setInt(3,Integer.parseInt(textAddProductQuantity.getText()));
////					preparedstatement.setString(4,textAddProductDescription.toString());
//					int result = preparedstatement.executeUpdate();
//					
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				finally
//				{
//					try{
//						/*resultSet.close();
//						statement.close();
//						connection.close(); */
//					}
//					
//					catch( Exception exception){
//						exception.printStackTrace();
//					}
				}
				
				
			
		});
		btnAddProductSave.setBounds(329, 243, 89, 23);
		getContentPane().add(btnAddProductSave);
		
		Label addProductProductName = new Label("Product Name");
		addProductProductName.setBounds(10, 45, 92, 22);
		getContentPane().add(addProductProductName);
		
		textAddProductProductName = new JTextField();
		textAddProductProductName.setColumns(10);
		textAddProductProductName.setBounds(118, 45, 140, 22);
		getContentPane().add(textAddProductProductName);
		
		Label addProductQuantity = new Label("Quantity");
		addProductQuantity.setBounds(10, 80, 92, 22);
		getContentPane().add(addProductQuantity);
		
		textAddProductQuantity = new JTextField();
		textAddProductQuantity.setColumns(10);
		textAddProductQuantity.setBounds(118, 80, 140, 22);
		getContentPane().add(textAddProductQuantity);
		
		JComboBox comboBoxAddProductCategory = new JComboBox();
		comboBoxAddProductCategory.setBounds(118, 10, 140, 22);
		getContentPane().add(comboBoxAddProductCategory);
		comboBoxAddProductCategory.addItem(" ");
		comboBoxAddProductCategory.addItem("Consumable");
		comboBoxAddProductCategory.addItem("NonConsumable");
		comboBoxAddProductCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxCategory = (String) comboBoxAddProductCategory.getSelectedItem();
				//textItemSelect.setText(item);
				
				//textItemSelect.get(comboBox.getSelectedItem());
			}
		});
		
		JButton btnAddProductView = new JButton("View");
		btnAddProductView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayQueryResults viewProduct = new DisplayQueryResults("SELECT * FROM product");
			}
		});
		btnAddProductView.setBounds(118, 243, 89, 23);
		getContentPane().add(btnAddProductView);
		
		//DisplayQueryResults viewProduct = new DisplayQueryResults();
		
		initialize();
	}


private void initialize() {
	frame2 = new JFrame();
	frame2.setBounds(100, 100, 450, 300);
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.getContentPane().setLayout(null);;
	}
}