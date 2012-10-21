package DataLayer;

// Original basis for basic GUI and connection code courtesy of Professor Qi Yu
// and his Class 05 in-class example.

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JavaConnection extends JFrame
{
	public static MySQLDatabase mdb = new MySQLDatabase();

	public static void main(String [] args)
	{
		new JavaConnection();
	}
	
	public JavaConnection()
	{
		// Create our Database Connection Objects
		//final OracleDatabase odb = new OracleDatabase();
		
		// Basis for GUI here
		JFrame frame = new JFrame("Server Connection Tester 1.01");
		frame.setSize(800, 600);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		// MySQL Test Button
		JButton sqlButton = new JButton("Connect to MySQL Database");
		sqlButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      frame.add(sqlButton);
		
		/* Oracle Test Button
		JButton oracleButton = new JButton("Connect to Oracle Database");
		oracleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      frame.add(oracleButton);*/

		// SQL button event handling
		sqlButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(mdb.connect()){
					JOptionPane.showMessageDialog(null,"MySQL Connection Successful");
					
					//Repeat the PE3 task: instantiate the equipment data object, set its equipmentId, call the data 
					//object’s fetch method, and then display the values to the user.
					
					//Write a “main” class that instantiates the equipment data object
					Equipment equipment = new Equipment();
					
					//sets	its	equipmentId,
					equipment.setEquipID("568");
					
					//calls the data object’s fetch method
					equipment.fetch();
					
					//then	displays	the	values	to	the	user.
					JOptionPane.showMessageDialog(null,"Equipment Data:\nEquipment ID: " + 
															equipment.getEquipID() + "\nEquipment Name: " +
															equipment.getEquipmentName() + "\nEquipment Description: " +
															equipment.getEquipmentDescription() + "\nEquipment Capacity: " +
															equipment.getEquipmentCapacity());
					
					//Then call the swap method of the object and pass in an equipmentId.
					if(equipment.swap(894))
					{
						//Finally, call the object’s fetch method again and display the values.
						equipment.fetch();
						JOptionPane.showMessageDialog(null,"Swapped Equipment Data:\nEquipment ID: " + 
																equipment.getEquipID() + "\nEquipment Name: " +
																equipment.getEquipmentName() + "\nEquipment Description: " +
																equipment.getEquipmentDescription() + "\nEquipment Capacity: " +
																equipment.getEquipmentCapacity());
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Data Swap Failure");
					}
					
					//You didn't ask us to test some other methods, but when has that stopped anyone?
					equipment.setEquipID("569");
					equipment.put();
					equipment.setEquipmentName("Baconator");
					equipment.post();
					JOptionPane.showMessageDialog(null,"Equipment Data:\nEquipment ID: " + 
															equipment.getEquipID() + "\nEquipment Name: " +
															equipment.getEquipmentName() + "\nEquipment Description: " +
															equipment.getEquipmentDescription() + "\nEquipment Capacity: " +
															equipment.getEquipmentCapacity());
					equipment.delete();
					
					if(mdb.close()){
						JOptionPane.showMessageDialog(null,"MySQL Closure Successful");
					}
					else{
						JOptionPane.showMessageDialog(null,"MySQL Closure Failure");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"MySQL Connection Failure");
				}
			}
		}
		);
		
		/* Oracle button event handling
		oracleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(odb.connect()){
					JOptionPane.showMessageDialog(null,"Oracle Connection Successful");
					if(mdb.close()){
						JOptionPane.showMessageDialog(null,"Oracle Closure Successful");
					}
					else{
						JOptionPane.showMessageDialog(null,"Oracle Closure Failure");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Oracle Connection Failure");
				}
			}
		}
		);*/

		frame.setVisible(true);
	}
}