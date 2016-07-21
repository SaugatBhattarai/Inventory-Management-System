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

public class RoomAllocation extends JFrame 
{

	private JFrame frame;
	private JTextField textRoomAllocationItemId;
	private JTextField textRoomAllocationRoomName;
	private JTextField textRoomAllocationQuantity;
	public RoomAllocation()
	{
		setTitle("Room Allocation");
		setResizable(false);
		setMinimumSize(new Dimension(450, 300));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		Label roomAllocationItemId = new Label("Item Id");
		roomAllocationItemId.setBounds(20, 20, 85, 22);
		getContentPane().add(roomAllocationItemId);
		
		Label roomAllocationRoomName = new Label("Room Name");
		roomAllocationRoomName.setBounds(20, 60, 85, 22);
		getContentPane().add(roomAllocationRoomName);
		
		Label roomAllocationQuantity = new Label("Quantity");
		roomAllocationQuantity.setBounds(20, 100, 85, 22);
		getContentPane().add(roomAllocationQuantity);
		
		textRoomAllocationItemId = new JTextField();
		textRoomAllocationItemId.setColumns(10);
		textRoomAllocationItemId.setBounds(105, 20, 150, 22);
		getContentPane().add(textRoomAllocationItemId);
		
		textRoomAllocationRoomName = new JTextField();
		textRoomAllocationRoomName.setColumns(10);
		textRoomAllocationRoomName.setBounds(105, 60, 150, 22);
		getContentPane().add(textRoomAllocationRoomName);
		
		textRoomAllocationQuantity = new JTextField();
		textRoomAllocationQuantity.setColumns(10);
		textRoomAllocationQuantity.setBounds(105, 100, 150, 22);
		getContentPane().add(textRoomAllocationQuantity);
		
		JButton btnRoomAllocationSave = new JButton("Save");
		btnRoomAllocationSave.setBounds(345, 237, 89, 23);
		getContentPane().add(btnRoomAllocationSave);
		
		JButton btnRoomAllocationView = new JButton("View");
		btnRoomAllocationView.setBounds(345, 193, 89, 23);
		getContentPane().add(btnRoomAllocationView);
		
		initialize();
	}

private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
}