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

import javax.swing.JTable;

import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class AddRoom extends JFrame 
{

	private JFrame frame;
	private JTextField textAddRoomRoomName;
	private JTable table;
	public AddRoom()
	{
		setTitle("Add Room");
		setMinimumSize(new Dimension(380, 145));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		Label addRoomAoomName = new Label("Room Name");
		addRoomAoomName.setBounds(20, 20, 71, 22);
		getContentPane().add(addRoomAoomName);
		
		textAddRoomRoomName = new JTextField();
		textAddRoomRoomName.setColumns(10);
		textAddRoomRoomName.setBounds(100, 20, 188, 22);
		getContentPane().add(textAddRoomRoomName);
		
		JButton btnAddRoomAdd = new JButton("Add");
		btnAddRoomAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main Query = new Main();
				String queryText = "INSERT INTO `room` (`roomName`) VALUES ('"+textAddRoomRoomName.getText().toString()+"')";
				Query.connectData(queryText, 1);
			}
			
		});
		btnAddRoomAdd.setBounds(217, 72, 89, 23);
		getContentPane().add(btnAddRoomAdd);
		
		table = new JTable();
		table.setBounds(205, 160, 1, 1);
		getContentPane().add(table);
		
		JButton btnAddRoomRoomInfo = new JButton("Room Info.");
		btnAddRoomRoomInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DisplayQueryResults viewRoom = new DisplayQueryResults("SELECT * FROM room");
			}
		});
		btnAddRoomRoomInfo.setBounds(100, 72, 107, 23);
		getContentPane().add(btnAddRoomRoomInfo);
		
		//DisplayQueryResults viewProduct = new DisplayQueryResults();
		
		initialize();
	}

private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}