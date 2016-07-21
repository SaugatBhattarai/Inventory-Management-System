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

public class UserAllocation extends JFrame 
{

	private JFrame frame;
	private JTextField textUserAllocationUserID;
	private JTextField textUserAllocationItemId;
	public UserAllocation()
	{
		setTitle("User Allocation");
		setResizable(false);
		setMinimumSize(new Dimension(450, 300));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		Label userAllocationUserId = new Label("User Id");
		userAllocationUserId.setBounds(10, 10, 85, 22);
		getContentPane().add(userAllocationUserId);
		
		textUserAllocationUserID = new JTextField();
		textUserAllocationUserID.setColumns(10);
		textUserAllocationUserID.setBounds(105, 10, 150, 22);
		getContentPane().add(textUserAllocationUserID);
		
		Label userAllocationItemId = new Label("Item Id");
		userAllocationItemId.setBounds(10, 45, 85, 22);
		getContentPane().add(userAllocationItemId);
		
		textUserAllocationItemId = new JTextField();
		textUserAllocationItemId.setColumns(10);
		textUserAllocationItemId.setBounds(105, 45, 150, 22);
		getContentPane().add(textUserAllocationItemId);
		
		JButton btnUserAllocationSave = new JButton("Save");
		btnUserAllocationSave.setBounds(345, 237, 89, 23);
		getContentPane().add(btnUserAllocationSave);
		btnUserAllocationSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main Query = new Main();
				String queryText = "INSERT INTO `userallocation` (`userID`,`itemID`) VALUES ('"+Integer.parseInt(textUserAllocationUserID.getText())+"', '"+Integer.parseInt(textUserAllocationItemId.getText())+"')";
				Query.connectData(queryText, 1);
				JOptionPane.showMessageDialog(frame, "Item Allocated");
			}
		});
		
		initialize();
	}

private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
}