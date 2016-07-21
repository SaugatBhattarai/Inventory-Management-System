import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Desktop.Action;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;


public class Main {
	static final String DATABASE_URL = "jdbc:mysql://localhost/inventory";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	private JFrame frmI;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		
		initialize();
	}
	public void close(){
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void connectData(String Query, int update){
	
	
	try {
		connection = DriverManager.getConnection( DATABASE_URL,"root","");
		statement = connection.createStatement();
		if( update == 0){
			resultSet = statement.executeQuery(Query);
			ResultSetMetaData metaData = null;
			int numberOfColumns = 0;
			try {
				metaData = resultSet.getMetaData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				numberOfColumns = metaData.getColumnCount();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for ( int i = 1; i <= numberOfColumns; i++)
				System.out.printf("%-8s\t",metaData.getColumnName(i));
				System.out.println();
		}else{
			statement.executeUpdate(Query);
	
		}
		
		
		
		
		
		
		
		
			
	}
	
	catch( SQLException sqlEXception ){
		sqlEXception.printStackTrace();
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
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmI = new JFrame();
		frmI.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		frmI.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		frmI.setTitle("Inventory Management System");
		frmI.setMinimumSize(new Dimension(450, 300));
		frmI.setResizable(false);
		frmI.setBounds(100, 100, 450, 300);
		frmI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmI.getContentPane().setLayout(null);
		frmI.getContentPane().setBackground(new Color(173, 216, 230));
		frmI.setLocationRelativeTo(null);
		
		 	
		Label label = new Label("LOG IN");
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(196, 80, 98, 22);
		frmI.getContentPane().add(label);
		
		Label label_1 = new Label("Username");
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_1.setBounds(111, 108, 62, 22);
		frmI.getContentPane().add(label_1);
		
		Label label_2 = new Label("Password");
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_2.setBounds(111, 136, 62, 22);
		frmI.getContentPane().add(label_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setToolTipText("Enter your username");
		formattedTextField.setBounds(174, 108, 120, 20);
		frmI.getContentPane().add(formattedTextField);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(174, 136, 120, 20);
		frmI.getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnLogIn.setBounds(190, 180, 89, 23);
		frmI.getContentPane().add(btnLogIn);
		
		btnLogIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				connectData("SELECT * FROM admin",0);
				ResultSetMetaData metaData = null;
				int numberOfColumns = 0;
				try {
					metaData = resultSet.getMetaData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					numberOfColumns = metaData.getColumnCount();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				int chickenChowmin = 0;
				String username = (String) formattedTextField.getText();
				char[] password = passwordField.getPassword();
				System.out.printf("%s",username);
				try {
					while (resultSet.next()){
						System.out.printf("%s", resultSet.getString("username"));
						String datad = resultSet.getString("password");
						char[] passArr = datad.toCharArray();
						int flag = resultSet.getString("username").compareTo(username);
						int flag2 = 1;
						if(Arrays.equals(password, passArr)){
							flag2 = 0;
						}
						System.out.printf("flag %d flag2  %d j",flag,flag2);
							if (flag == 0 && flag2 == 0){
								chickenChowmin = 1;
								break;
							}
								
						
							
					}
					
					//Clearing username and password field after login
					formattedTextField.setText("");
					passwordField.setText("");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.printf("%s", chickenChowmin);
					if(chickenChowmin == 1){
						PostAdminLogIn frame0 = new PostAdminLogIn();
						frame0.setVisible(true);
						//frmI.setVisible(false);
					}
								
				
			}
		});
	}
}