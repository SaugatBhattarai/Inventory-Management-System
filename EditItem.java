import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditItem extends JFrame 
{

	private JFrame frame;
	private JTextField texteditItemProductId;
	private JTextField texteditItemSupplierId;
	private JTextField texteditItemModel;
	private JTextField texteditItemPrice;
	private JTextPane txtPaneEditItemRemarks;
	private JTextField textField;
	public EditItem()
	{
		
		Border outerBorder = BorderFactory.createEtchedBorder();
		
		setResizable(false);
		setTitle("Search Item By Id");
		setMinimumSize(new Dimension(450, 400));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		texteditItemProductId = new JTextField();
		texteditItemProductId.setColumns(10);
		texteditItemProductId.setBounds(118, 45, 124, 22);
		getContentPane().add(texteditItemProductId);
		
		JLabel editItemProductId = new JLabel("Product Id");
		editItemProductId.setBounds(10, 45, 82, 22);
		getContentPane().add(editItemProductId);
		editItemProductId.setBorder(outerBorder);
		
		JLabel editItemSupplierId = new JLabel("Supplier Id");
		editItemSupplierId.setBounds(10, 80, 82, 22);
		getContentPane().add(editItemSupplierId);
		editItemSupplierId.setBorder(outerBorder);
		
		texteditItemSupplierId = new JTextField();
		texteditItemSupplierId.setColumns(10);
		texteditItemSupplierId.setBounds(118, 80, 124, 22);
		getContentPane().add(texteditItemSupplierId);
		
		texteditItemModel = new JTextField();
		texteditItemModel.setColumns(10);
		texteditItemModel.setBounds(118, 115, 124, 22);
		getContentPane().add(texteditItemModel);
		
		JLabel editItemModel = new JLabel("Model");
		editItemModel.setBounds(10, 115, 82, 22);
		getContentPane().add(editItemModel);
		editItemModel.setBorder(outerBorder);
		
		JLabel editItemPrice = new JLabel("Price");
		editItemPrice.setBounds(10, 150, 82, 22);
		getContentPane().add(editItemPrice);
		editItemPrice.setBorder(outerBorder);
		
		texteditItemPrice = new JTextField();
		texteditItemPrice.setColumns(10);
		texteditItemPrice.setBounds(118, 150, 124, 22);
		getContentPane().add(texteditItemPrice);
		
		JLabel editItemRemarks = new JLabel("Remarks");
		editItemRemarks.setBounds(10, 182, 82, 22);
		getContentPane().add(editItemRemarks);
		editItemRemarks.setBorder(outerBorder);
		
		txtPaneEditItemRemarks = new JTextPane();
		txtPaneEditItemRemarks.setBounds(118, 190, 300, 101);
		getContentPane().add(txtPaneEditItemRemarks);
		
		JLabel label = new JLabel("Product Id");
		label.setBounds(10, 10, 80, 22);
		getContentPane().add(label);
		label.setBorder(outerBorder);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(118, 10, 124, 22);
		getContentPane().add(textField);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		button.setBounds(267, 10, 89, 23);
		getContentPane().add(button);
		
		JButton btnEditItemSave = new JButton("Save");
		btnEditItemSave.setBounds(329, 302, 89, 23);
		getContentPane().add(btnEditItemSave);
		
		JButton btnEditItemView = new JButton("View");
		btnEditItemView.setBounds(329, 336, 89, 23);
		getContentPane().add(btnEditItemView);
		

		
		initialize();
	}

private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	}
}
