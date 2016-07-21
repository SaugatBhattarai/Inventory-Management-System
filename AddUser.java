import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Label;

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
import java.sql.SQLException;

public class AddUser extends JFrame 
{

	private JFrame frame;
	private JTextField textaddUserUsername;
	private JTextField textaddUserDesignation;
	private JTextField textaddUserPhoneNumber;
	private JTextField textaddUserEmail;
	public AddUser()
	{
		setTitle("Add User");
		setMinimumSize(new Dimension(450, 300));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		Label addUserUsername = new Label("Username");
		addUserUsername.setBounds(10, 10, 85, 22);
		getContentPane().add(addUserUsername);
		
		textaddUserUsername = new JTextField();
		textaddUserUsername.setColumns(10);
		textaddUserUsername.setBounds(105, 10, 150, 22);
		getContentPane().add(textaddUserUsername);
		
		Label addUserDesignatin = new Label("Designation");
		addUserDesignatin.setBounds(10, 45, 85, 22);
		getContentPane().add(addUserDesignatin);
		
		textaddUserDesignation = new JTextField();
		textaddUserDesignation.setColumns(10);
		textaddUserDesignation.setBounds(105, 43, 150, 22);
		getContentPane().add(textaddUserDesignation);
		
		Label addUserPhoneNumber = new Label("Phone Number");
		addUserPhoneNumber.setBounds(10, 80, 85, 22);
		getContentPane().add(addUserPhoneNumber);
		
		textaddUserPhoneNumber = new JTextField();
		textaddUserPhoneNumber.setColumns(10);
		textaddUserPhoneNumber.setBounds(105, 80, 150, 22);
		getContentPane().add(textaddUserPhoneNumber);
		
		Label addUserEmail = new Label("E-mail");
		addUserEmail.setBounds(10, 115, 85, 22);
		getContentPane().add(addUserEmail);
		
		textaddUserEmail = new JTextField();
		textaddUserEmail.setColumns(10);
		textaddUserEmail.setBounds(105, 115, 150, 22);
		getContentPane().add(textaddUserEmail);
		
		JButton btnAddUserSave = new JButton("Save");
		btnAddUserSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main query = new Main();
				String stringQuery = "INSERT INTO `user` (`userName`,`designation`,`phoneNumber`,`email`) VALUES ('"+textaddUserUsername.getText().toString()+"','"+textaddUserDesignation.getText().toString()+"','"+new BigInteger(textaddUserPhoneNumber.getText().toString())+"','"+textaddUserEmail.getText().toString()+"')";
				query.connectData(stringQuery,1);
				JOptionPane.showMessageDialog(null, "user added successfully");	
				textaddUserUsername.setText(" ");
				textaddUserDesignation.setText(" ");
				textaddUserPhoneNumber.setText(" ");
				textaddUserEmail.setText(" ");
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
//					preparedstatement = connection.prepareStatement("INSERT INTO `user` (`supplierName`,`address`,`phoneNumber`,`email`) VALUES ('"+textAddSupplierSupplierName.getText().toString()+"','"+textAddSupplierAddress.getText().toString()+"','"+new BigInteger(textAddSupplierPhoneNumber.getText().toString())+"','"+textAddSupplierEmail.getText().toString()+"')");
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
		btnAddUserSave.setBounds(335, 227, 89, 23);
		getContentPane().add(btnAddUserSave);
		
		
		
		
		initialize();
	}

private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
}
