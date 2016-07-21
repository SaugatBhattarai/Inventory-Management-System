import java.awt.BorderLayout;
import java.awt.Color;
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


public class AddSupplier extends JFrame {

	private JFrame frame;
	private JTextField textAddSupplierAddress;
	private JTextField textAddSupplierSupplierName;
	private JTextField textAddSupplierPhoneNumber;
	private JTextField textAddSupplierEmail;
	public AddSupplier() {
		setTitle("Add Supplier");
		setMinimumSize(new Dimension(450, 300));
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		Label supplierName = new Label("Supplier Name");
		supplierName.setBounds(10, 10, 85, 22);
		getContentPane().add(supplierName);
		
		textAddSupplierAddress = new JTextField();
		textAddSupplierAddress.setColumns(10);
		textAddSupplierAddress.setBounds(105, 45, 300, 22);
		getContentPane().add(textAddSupplierAddress);
		
		Label address = new Label("Address");
		address.setBounds(10, 45, 82, 22);
		getContentPane().add(address);
		
		textAddSupplierSupplierName = new JTextField();
		textAddSupplierSupplierName.setColumns(10);
		textAddSupplierSupplierName.setBounds(105, 10, 150, 22);
		getContentPane().add(textAddSupplierSupplierName);
		
		Label phoneNumber = new Label("Phone Number");
		phoneNumber.setBounds(10, 80, 82, 22);
		getContentPane().add(phoneNumber);
		
		textAddSupplierPhoneNumber = new JTextField();
		textAddSupplierPhoneNumber.setColumns(10);
		textAddSupplierPhoneNumber.setBounds(105, 80, 150, 22);
		getContentPane().add(textAddSupplierPhoneNumber);
		 //BigInteger supplierPhone = new BigInteger(textAddSupplierPhoneNumber.getText().toString());
		
		Label email = new Label("E-mail");
		email.setBounds(10, 115, 82, 22);
		getContentPane().add(email);
		
		textAddSupplierEmail = new JTextField();
		textAddSupplierEmail.setColumns(10);
		textAddSupplierEmail.setBounds(105, 115, 150, 22);
		getContentPane().add(textAddSupplierEmail);
		
		JButton btnAddSupplierSave = new JButton("Save");
		btnAddSupplierSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main query = new Main();
				String stringQuery = "INSERT INTO `supplier` (`supplierName`,`address`,`phoneNumber`,`email`) VALUES ('"+textAddSupplierSupplierName.getText().toString()+"','"+textAddSupplierAddress.getText().toString()+"','"+new BigInteger(textAddSupplierPhoneNumber.getText().toString())+"','"+textAddSupplierEmail.getText().toString()+"')";
				query.connectData(stringQuery,1);
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
//					preparedstatement = connection.prepareStatement("INSERT INTO `supplier` (`supplierName`,`address`,`phoneNumber`,`email`) VALUES ('"+textAddSupplierSupplierName.getText().toString()+"','"+textAddSupplierAddress.getText().toString()+"','"+new BigInteger(textAddSupplierPhoneNumber.getText().toString())+"','"+textAddSupplierEmail.getText().toString()+"')");
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
				
			}
		});
		btnAddSupplierSave.setBounds(345, 237, 89, 23);
		getContentPane().add(btnAddSupplierSave);
				
		initialize();
	}


private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setLocationRelativeTo(null);
	}
}