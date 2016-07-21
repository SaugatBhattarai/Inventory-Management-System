import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JEditorPane;

public class EditProduct extends JFrame 
{

	private JFrame frame;
	private JTextField textSearchProductById;
	private JTextField textEditProductDescription;
	private JTextField textEditProductProductName;
	private JTextField textEditProductQuantity;
	private String comboBoxCategory1;
	public EditProduct()
	{
		setResizable(false);
		setMinimumSize(new Dimension(450, 400));
		setAlwaysOnTop(true);
		setTitle("Search product by Id");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
	
/////////////////////////////
		Label searchProductById = new Label("Search Product by Id");
		searchProductById.setBounds(10, 10, 114, 22);
		getContentPane().add(searchProductById);
		
		
		
		textSearchProductById = new JTextField();
		textSearchProductById.setColumns(10);
		textSearchProductById.setBounds(134, 10, 124, 22);
		getContentPane().add(textSearchProductById);
		
		JButton btnSearchProductSearch = new JButton("Search");
		btnSearchProductSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String DATABASE_URL = "jdbc:mysql://localhost/inventory";
				Connection connection = null;
				Statement statement = null;
				ResultSet result;
				//Main connectionData = new Main();
//				String insertQuery = "INSERT INTO product(category,productName,quantity,remarks) VALUES(?,?,?,?)";
//				System.out.printf("%s",textAddProductProductName.getText());
				
				//connectionData.connectData(insertQuery,1);
				try {
					connection = DriverManager.getConnection( DATABASE_URL,"root","");
					//java.sql.BLOB myBlob = java.sql.BLOB.createTemporary(connection, false, oracle.sql.BLOB.DURATION_SESSION);
//					String data = textAddProductProductName.toString();
//					byte[] buff = data.getBytes();
					System.out.printf("%s",textEditProductProductName.toString());
					statement = connection.createStatement();
					result = statement.executeQuery("SELECT category, productName, quantity, remarks FROM product WHERE productID = '"+Integer.parseInt(textSearchProductById.getText())+"' LIMIT 1 ");
//					preparedstatement.setString(1, comboBoxCategory );
//					preparedstatement.setString(2, textAddProductProductName.getText().toString() );
//					preparedstatement.setInt(3,Integer.parseInt(textAddProductQuantity.getText()));
//					preparedstatement.setString(4,textAddProductDescription.toString());
					//result = preparedstatement.executeUpdate();
					
					while(result.next()){
						
						String Category = (String) result.getObject(1);
						textEditProductProductName.setText(result.getObject(2).toString());
						textEditProductQuantity.setText(String.valueOf(result.getObject(3)));
						textEditProductDescription.setText((String) result.getObject(4));
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					try{
						/*resultSet.close();
						statement.close();
						connection.close(); */
					}
					
					catch( Exception exception){
						exception.printStackTrace();
					}
				}
			}
		});
		btnSearchProductSearch.setBounds(292, 10, 82, 23);
		getContentPane().add(btnSearchProductSearch);
	
		
//////////
		Label editProductCategory = new Label("Category");
		editProductCategory.setBounds(10, 54, 92, 22);
		getContentPane().add(editProductCategory);
		
		Label editProductDescription = new Label("Description");
		editProductDescription.setBounds(10, 158, 82, 22);
		getContentPane().add(editProductDescription);
		
		textEditProductDescription = new JTextField();
		textEditProductDescription.setBounds(118, 158, 300, 99);
		getContentPane().add(textEditProductDescription);
		textEditProductDescription.setColumns(10);
		
		JButton btnEditProductSave = new JButton("Save");
		btnEditProductSave.addActionListener(new ActionListener() {
			private String comboBoxCategory;

			public void actionPerformed(ActionEvent arg0) {
			System.out.printf("%s",comboBoxCategory);
				Main Query = new Main();
				String queryText = "UPDATE `product` SET `category` = 'Consumable',`productName` ='"+textEditProductProductName.getText().toString()+"',`quantity` = '"+Integer.parseInt(textEditProductQuantity.getText())+"',`remarks` ='"+textEditProductDescription.getText().toString()+"' WHERE `productID`='"+Integer.parseInt(textSearchProductById.getText())+"' ";
				Query.connectData(queryText, 1);
				JOptionPane.showMessageDialog(frame, "Product Edited");
				
			}
		});
		btnEditProductSave.setBounds(329, 285, 89, 23);
		getContentPane().add(btnEditProductSave);
		
		Label editProductProductName = new Label("Product Name");
		editProductProductName.setBounds(10, 92, 92, 22);
		getContentPane().add(editProductProductName);
		
		textEditProductProductName = new JTextField();
		textEditProductProductName.setColumns(10);
		textEditProductProductName.setBounds(118, 92, 140, 22);
		getContentPane().add(textEditProductProductName);
		
		Label editProductQuantity = new Label("Quantity");
		editProductQuantity.setBounds(10, 120, 92, 22);
		getContentPane().add(editProductQuantity);
		
		textEditProductQuantity = new JTextField();
		textEditProductQuantity.setColumns(10);
		textEditProductQuantity.setBounds(118, 125, 140, 22);
		getContentPane().add(textEditProductQuantity);
		
		JComboBox comboBoxEditProductCategory = new JComboBox();
		comboBoxEditProductCategory.setBounds(118, 54, 140, 22);
		getContentPane().add(comboBoxEditProductCategory);
		comboBoxEditProductCategory.addItem(" ");
		comboBoxEditProductCategory.addItem("Consumable");
		comboBoxEditProductCategory.addItem("NonConsumable");
		comboBoxEditProductCategory.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				
				comboBoxCategory1 = (String) comboBoxEditProductCategory.getSelectedItem();
				//textItemSelect.setText(item);
				
				//textItemSelect.get(comboBox.getSelectedItem());
			}
		});
		
		JButton btnEditProductView = new JButton("View");
		btnEditProductView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayQueryResults viewProduct = new DisplayQueryResults("SELECT * FROM product");
			}
		});
		btnEditProductView.setBounds(329, 321, 89, 23);
		getContentPane().add(btnEditProductView);
		

			initialize();
	}

	
private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
}