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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class Requisition extends JFrame 
{

	private JFrame frame;
	private JTextField textRequisitionOrderedBy;
	private JTextField textRequisitionReceivedBy;
	private JTextField textRequisitionStoreInCharge;
	String comboBoxRequsitionSchoolSelect, comboBoxRequisitionDepartmentSelect;
	public Requisition()
	{
		setResizable(false);
		setMinimumSize(new Dimension(420, 300));
		setTitle("Requisition");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		
		Label requisitionSchool = new Label("School");
		requisitionSchool.setBounds(20, 20, 85, 22);
		getContentPane().add(requisitionSchool);
		
		Label requisitionOrderedBy = new Label("Ordered By");
		requisitionOrderedBy.setBounds(20, 100, 85, 22);
		getContentPane().add(requisitionOrderedBy);
		
		Label requisitionStoreInCharge = new Label("Store In Charge");
		requisitionStoreInCharge.setBounds(20, 180, 85, 22);
		getContentPane().add(requisitionStoreInCharge);
		
		Label requisitionReceivedBy = new Label("Received By");
		requisitionReceivedBy.setBounds(20, 140, 85, 22);
		getContentPane().add(requisitionReceivedBy);
		
		Label requisitionDepartment = new Label("Department");
		requisitionDepartment.setBounds(20, 60, 85, 22);
		getContentPane().add(requisitionDepartment);
		
		textRequisitionOrderedBy = new JTextField();
		textRequisitionOrderedBy.setColumns(10);
		textRequisitionOrderedBy.setBounds(105, 100, 150, 22);
		getContentPane().add(textRequisitionOrderedBy);
		
		textRequisitionReceivedBy = new JTextField();
		textRequisitionReceivedBy.setColumns(10);
		textRequisitionReceivedBy.setBounds(105, 140, 150, 22);
		getContentPane().add(textRequisitionReceivedBy);
		
		textRequisitionStoreInCharge = new JTextField();
		textRequisitionStoreInCharge.setColumns(10);
		textRequisitionStoreInCharge.setBounds(105, 180, 150, 22);
		getContentPane().add(textRequisitionStoreInCharge);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Main query = new Main();
				String stringQuery = "INSERT INTO `requisition` (`school`,`department`,`orderedBy`,`receivedBy`,`storeInCharge`) VALUES ('"+comboBoxRequsitionSchoolSelect+"','"+comboBoxRequisitionDepartmentSelect+"','"+textRequisitionOrderedBy.getText().toString()+"','"+textRequisitionReceivedBy.getText().toString()+"','"+textRequisitionStoreInCharge.getText().toString()+"')";
				query.connectData(stringQuery,1);
				JOptionPane.showMessageDialog(null, "requisition is successfull");
	//			comboBoxRequsitionSchool.setText(" ");
	//			comboBoxRequisitionDepartment.setText(" ");
				textRequisitionOrderedBy.setText(" ");
				textRequisitionReceivedBy.setText(" ");
				textRequisitionStoreInCharge.setText(" ");
				
				int numID = 0;
				
				final String DATABASE_URL = "jdbc:mysql://localhost/inventory";
				Connection connection = null;
				Statement statement = null;
				ResultSet result;
				
				try {
					connection = DriverManager.getConnection( DATABASE_URL,"root","");
					//java.sql.BLOB myBlob = java.sql.BLOB.createTemporary(connection, false, oracle.sql.BLOB.DURATION_SESSION);
//					String data = textAddProductProductName.toString();
//					byte[] buff = data.getBytes();
					//System.out.printf("%s",textEditProductProductName.toString());
					statement = connection.createStatement();
					result = statement.executeQuery("SELECT RequisitionID FROM requisition ORDER   BY RequisitionID DESC LIMIT 1");
//					preparedstatement.setString(1, comboBoxCategory );
//					preparedstatement.setString(2, textAddProductProductName.getText().toString() );
//					preparedstatement.setInt(3,Integer.parseInt(textAddProductQuantity.getText()));
//					preparedstatement.setString(4,textAddProductDescription.toString());
					//result = preparedstatement.executeUpdate();
					
					while(result.next()){
						
						//String Category = (String) result.getObject(1);
						numID = (int) result.getObject(1);
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
	
				RequiredItem frame = new RequiredItem(numID);
				frame.setVisible(true);
			}
		});
		button.setBounds(289, 212, 89, 23);
		getContentPane().add(button);
		
		JComboBox comboBoxRequsitionSchool = new JComboBox();
		comboBoxRequsitionSchool.setBounds(105, 20, 150, 22);
		getContentPane().add(comboBoxRequsitionSchool);
		comboBoxRequsitionSchool.addItem(" ");
		comboBoxRequsitionSchool.addItem("Science");
		comboBoxRequsitionSchool.addItem("Engineering");
		comboBoxRequsitionSchool.addItem("Humanities");
		comboBoxRequsitionSchool.addItem("Medicine");
		comboBoxRequsitionSchool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxRequsitionSchoolSelect = (String) comboBoxRequsitionSchool.getSelectedItem();
				//textItemSelect.setText(item);
				
				//textItemSelect.get(comboBox.getSelectedItem());
			}
		});
		
		JComboBox comboBoxRequisitionDepartment = new JComboBox();
		comboBoxRequisitionDepartment.setBounds(105, 60, 150, 22);
		getContentPane().add(comboBoxRequisitionDepartment);
		comboBoxRequisitionDepartment.addItem(" ");
		comboBoxRequisitionDepartment.addItem("CE");
		comboBoxRequisitionDepartment.addItem("Civil");
		comboBoxRequisitionDepartment.addItem("BT");
		comboBoxRequisitionDepartment.addItem("ENE");
		comboBoxRequisitionDepartment.addItem("ME");
		comboBoxRequisitionDepartment.addItem("EE");
		comboBoxRequisitionDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxRequisitionDepartmentSelect = (String) comboBoxRequisitionDepartment.getSelectedItem();
				//textItemSelect.setText(item);
				
				//textItemSelect.get(comboBox.getSelectedItem());
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