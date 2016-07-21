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

public class Delete extends JFrame 
{

	private JFrame frame;
	private JTextField textDeleteByItemId;
	public Delete()
	{
		setResizable(false);
		setMinimumSize(new Dimension(390, 130));
		setTitle("Delete");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		Label label = new Label("Enter Item Id");
		label.setBounds(30, 40, 82, 22);
		getContentPane().add(label);
		
		textDeleteByItemId = new JTextField();
		textDeleteByItemId.setColumns(10);
		textDeleteByItemId.setBounds(115, 40, 124, 22);
		getContentPane().add(textDeleteByItemId);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(260, 40, 82, 23);
		getContentPane().add(btnDelete);
		
		initialize();
	}

private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
}