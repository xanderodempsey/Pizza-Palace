package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Daniel Larmar and Alexander O'Dempsey
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	
	private PizzaRestaurant restaurant;
	
	private JFrame window;
	private JFileChooser TheFile;
	private JTextArea OutputArea;
	private JButton Open, Exit, Profit, Order, Reset, Distance;
	private JScrollPane Scroller;
	private JPanel MainPanel;
	private Boolean Loaded = false;
	private String FormTitle;
	
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) 
	{
		
		this.FormTitle = title;		
		//Create the Restaurant
		restaurant = new PizzaRestaurant();
		
	}
	
	public void run()
	{
		
		//Create the Frame
		window = new JFrame(FormTitle);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create the panel
		JPanel MainPane = MainPanel();
				
		//Window Settings
		window.add(MainPane);
		window.pack();
		window.setVisible(true);
		
	}
	
	public JPanel MainPanel()
	{
		
		//Load Button
		Open = new JButton("Select File");
		Open.addActionListener(this);
		Open.setActionCommand("Load");
		
		//Exit Button
		Exit = new JButton("Exit");
		Exit.addActionListener(this);
		Exit.setActionCommand("Exit");
		
		//Profit button
		Profit = new JButton("Profit");
		Profit.addActionListener(this);
		Profit.setActionCommand("Profit");
		
		//Distance Button
		Distance = new JButton("Distance");
		Distance.addActionListener(this);
		Distance.setActionCommand("Distance");
		
		//Order Number
		Order = new JButton("Orders");
		Order.addActionListener(this);
		Order.setActionCommand("Order");
		
		//Reset Button
		Reset = new JButton("Reset");
		Reset.addActionListener(this);
		Reset.setActionCommand("Reset");
		
		//OutPutArea
		OutputArea = new JTextArea(30,40);
		OutputArea.setEditable(false);
		
		//ScrollPane
		Scroller = new JScrollPane(OutputArea);
		Scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		Scroller.setPreferredSize(new Dimension(300,800));
		
		//MainPanel
		MainPanel = new JPanel();
		
		//Frame Layout
		GroupLayout layout = new GroupLayout(MainPanel);
		MainPanel.setLayout(layout);
		
		//Setup for the horizontal groups
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
						//Group 1
						.addComponent(Scroller))
						.addGroup(layout.createSequentialGroup()
								//Group 2
								.addComponent(Open)
								.addComponent(Exit)
								.addComponent(Profit)
								.addComponent(Distance)
								.addComponent(Order)
								.addComponent(Reset))
				);
		//Setup for the veritical groups
		layout.setVerticalGroup(
				layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						//Top group
				.addComponent(Open)
				.addComponent(Exit)
				.addComponent(Profit)
				.addComponent(Distance)
				.addComponent(Order)
				.addComponent(Reset))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								//bottom group
								.addComponent(Scroller)
						));
		
		return MainPanel;

	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		switch(e.getActionCommand())
		{
		
			case "Exit": //Exit button
				window.dispose();	
				break;
				
			case "Load": //Load Button
				TheFile = new JFileChooser();
				int returnValue = TheFile.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
					//if the file is a txt file
					if(TheFile.getSelectedFile().getPath().toString().contains(".txt"))
					{
						
						File selectedFile = TheFile.getSelectedFile();
						try 
						{
							//Process the log file
							if(restaurant.processLog(selectedFile.getPath().toString()) == true)
								{
																		
									OutputArea.setText("Successfully Loaded File");
									Loaded = true;
									
								}
							
						} catch(Exception ex)
						{
							//If error in log file
							OutputArea.setText(ex.getMessage());
							
						}						
						
					}else
					{
						
						OutputArea.setText("Invalid File: Please Select a .txt File.");
						
					}
					
				}
				
				break;
				
			case "Profit"://Profit button
				
				if(Loaded == true)
				{
					
					DecimalFormat df = new DecimalFormat("#.00");
					OutputArea.setText("The total profit from the log is: $" + df.format(restaurant.getTotalProfit()));	
					
				}else
				{
					
					OutputArea.setText("Cannot Perform Action: No file Loaded.");
					
				}
				
				break;
				
			case "Reset": //Reset button
				
				if(Loaded == true)
				{
					
					restaurant.resetDetails();
					Loaded = false;
					OutputArea.setText("Reset Complete");
					
				}else
				{
					
					OutputArea.setText("Cannot Perform Action: No file Loaded.");
					
				}
				
				break;
				
			case "Order": //Order Button
				
				if(Loaded == true)
				{
					
					try
					{
					
						String OutPut = "";
						
						for(int i = 0; i < restaurant.getNumCustomerOrders(); i++)
						{
						
							//For each order create the strong
							//TODO FORMAT THESE VARIABLES AS ACCORDING TO SECTION 13.5 IN SPEC DOCUMENT
							DecimalFormat df = new DecimalFormat("#.00");
							String CustomerName = restaurant.getCustomerByIndex(i).getName();
							String CustomerMob = restaurant.getCustomerByIndex(i).getMobileNumber();
							String CustomerType = restaurant.getCustomerByIndex(i).getCustomerType();
							Integer XLocation = restaurant.getCustomerByIndex(i).getLocationX();
							Integer YLocation = restaurant.getCustomerByIndex(i).getLocationY();
							Double Distance = restaurant.getCustomerByIndex(i).getDeliveryDistance();
							
							
							String PizzaType = restaurant.getPizzaByIndex(i).getPizzaType();
							Integer Quantity = restaurant.getPizzaByIndex(i).getQuantity();
							Double OrderPrice = restaurant.getPizzaByIndex(i).getOrderPrice();
							Double OrderCost = restaurant.getPizzaByIndex(i).getOrderCost();
							Double OrderProfit = restaurant.getPizzaByIndex(i).getOrderPrice();
							
							//Build
							OutPut += "Customer " + (i+1) + ": \n Customer Name: " + CustomerName + "\n Mobile Number: " + CustomerMob 
									+ "\n CustomerType: " + CustomerType + "\n X and Y Location: " + XLocation + ":" + YLocation
									+ "\n Delivery Distnace from Restaurant: " + df.format(Distance)+ "km" + "\n"
									+ "\n Order " + (i+1) + ": \n Pizza Type: " + PizzaType + "\n Quantity: " + Quantity + "\n Order Price: $" 
									+ df.format(OrderPrice) + "\n Order Cost: $" + df.format(OrderCost) + "\n Order Profit: $" + df.format(OrderProfit)
									+ "\n \n";
							
						}
						
						OutputArea.setText(OutPut);					
					
					}catch(Exception ex)
					{
						
						OutputArea.setText(ex.getMessage());
						
					}
					
				}else
				{
					
					OutputArea.setText("Cannot Perform Action: No file Loaded.");
					
				}
				
				break;
				
			case "Distance": //output total distance
				
				if(Loaded == true)
				{
					//TODO FORMAT SO IT LOOKS LIKE 10KM or whatever the spec wants you to format it like.
					DecimalFormat df = new DecimalFormat("#.00");
					OutputArea.setText("Total Distance Travelled: " + df.format(restaurant.getTotalDeliveryDistance()) + "km");
					
				}else
				{
					
					OutputArea.setText("Cannot Perform Action: No file Loaded.");
					
				}
				
				break;
				
		} //End of Switch
		
	}
	
}
