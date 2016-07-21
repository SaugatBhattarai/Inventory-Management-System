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

import javax.swing.JTextPane;

public class RequiredItem extends JFrame 
{

	private JFrame frame;
	private JTextField textRequiredItemRequisitionId;
	private JTextField textRequiredItemUnit;
	private JTextField textRequiredItemQuantity;
	private JTextField textRequiredItemRate;
	private JTextField textRequiredItemTotal;
	public RequiredItem(final int rID)
	{
		
		setTitle("Required Item");
		setResizable(false);
		setMinimumSize(new Dimension(400, 400));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		Label requiredItemRequisitionId = new Label("Requisition Id");
		requiredItemRequisitionId.setBounds(20, 20, 77, 22);
		getContentPane().add(requiredItemRequisitionId);
		
		textRequiredItemRequisitionId = new JTextField();
		textRequiredItemRequisitionId.setName("");
		textRequiredItemRequisitionId.setColumns(10);
		textRequiredItemRequisitionId.setBounds(105, 20, 150, 22);
		getContentPane().add(textRequiredItemRequisitionId);
		
		
		Label requiredItemDescription = new Label("Description");
		requiredItemDescription.setBounds(20, 60, 77, 22);
		getContentPane().add(requiredItemDescription);
		
		JTextPane textPaneRequiredItemDescription1 = new JTextPane();
		textPaneRequiredItemDescription1.setBounds(104, 60, 150, 50);
		getContentPane().add(textPaneRequiredItemDescription1);
		
		Label requiredItemUnit = new Label("Unit");
		requiredItemUnit.setBounds(20, 140, 77, 22);
		getContentPane().add(requiredItemUnit);
		
		textRequiredItemUnit = new JTextField();
		textRequiredItemUnit.setColumns(10);
		textRequiredItemUnit.setBounds(105, 140, 150, 22);
		getContentPane().add(textRequiredItemUnit);
		
		Label requiredItemQuatity = new Label("Quantity");
		requiredItemQuatity.setBounds(20, 180, 77, 22);
		getContentPane().add(requiredItemQuatity);
		
		textRequiredItemQuantity = new JTextField();
		textRequiredItemQuantity.setColumns(10);
		textRequiredItemQuantity.setBounds(105, 180, 150, 22);
		getContentPane().add(textRequiredItemQuantity);
		
		Label requiredItemRate = new Label("Rate");
		requiredItemRate.setBounds(20, 220, 77, 22);
		getContentPane().add(requiredItemRate);
		
		textRequiredItemRate = new JTextField();
		textRequiredItemRate.setColumns(10);
		textRequiredItemRate.setBounds(105, 220, 150, 22);
		getContentPane().add(textRequiredItemRate);
		
		Label requiredItemTotal = new Label("Total");
		requiredItemTotal.setBounds(20, 260, 77, 22);
		getContentPane().add(requiredItemTotal);
		
		Label requiredItemRemarks = new Label("Remarks");
		requiredItemRemarks.setBounds(20, 300, 77, 22);
		getContentPane().add(requiredItemRemarks);
		
		textRequiredItemTotal = new JTextField();
		textRequiredItemTotal.setColumns(10);
		textRequiredItemTotal.setBounds(105, 260, 150, 22);
		getContentPane().add(textRequiredItemTotal);
		JTextPane textPaneRequiredItemRemarks = new JTextPane();
		textPaneRequiredItemRemarks.setBounds(105, 300, 150, 50);
		getContentPane().add(textPaneRequiredItemRemarks);
		String reID = Integer.toString(rID);
		textRequiredItemRequisitionId.setText(reID);
		JButton butRequiredItemSave = new JButton("Save");
		butRequiredItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main query = new Main();
				String stringQuery = "INSERT INTO `requireditem` (`RequisitionID`,`description`,`unit`,`quantity`,`rate`,`total`,`remarks`) VALUES ('"+textRequiredItemRequisitionId.getText().toString()+"','"+textPaneRequiredItemDescription1.getText().toString()+"','"+textRequiredItemUnit.getText().toString()+"','"+Integer.parseInt(textRequiredItemQuantity.getText())+"','"+Integer.parseInt(textRequiredItemRate.getText())+"','"+Integer.parseInt(textRequiredItemTotal.getText())+"','"+textPaneRequiredItemRemarks.getText().toString()+"')";
				query.connectData(stringQuery,1);
				JOptionPane.showMessageDialog(null, "requisition is successfull");
				textRequiredItemRequisitionId.setText(" ");
				textPaneRequiredItemDescription1.setText(" ");
				textRequiredItemUnit.setText(" ");
				textRequiredItemQuantity.setText(" ");
				textRequiredItemRate.setText(" ");
				textRequiredItemTotal.setText(" ");
				textPaneRequiredItemRemarks.setText(" ");
				
			}
		});
		butRequiredItemSave.setBounds(326, 327, 89, 23);
		getContentPane().add(butRequiredItemSave);
		
		initialize();
	}

private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	}
}