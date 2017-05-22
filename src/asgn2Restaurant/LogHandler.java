package asgn2Restaurant;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Person A and Alexander O'Dempsey
 *
 */
public class LogHandler {
	


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		
		ArrayList<Customer> list = new ArrayList<>();
		
		//Import the file and read the data into the Customer list line by line;
		try (Stream<String> fileLines = Files.lines(Paths.get(filename))) {
			for (String line : fileLines.collect(Collectors.toList())) {
				list.add(createCustomer(line));
			}
		} catch (IOException e) {
			throw new LogHandlerException("Error when reading in the file: " + filename);
		}
		
		//return the data list
		return list;	
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		// TO DO
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		
		//Split the lines into relevant data
		String[] lines = line.split(",");
		if (lines.length != 9) { //checks data amount that was split
			throw new LogHandlerException("Not enough data on parsed line:\n" + line);
		}
		
		//reference the following lines as strings 
		String customerCode = lines[5];
		String name = lines[2];
		String mobileNumber = lines[3];
		
		//location X and Y as ints
		int locationX;
		int locationY;
		try {
			locationX = Integer.parseInt(lines[5]);
		} catch (Exception e) {	
			throw new LogHandlerException("Bad locationX data on parsed line:\n" + line + "\nData: " + lines[5]);
		}
		try {
			locationY = Integer.parseInt(lines[6]);
		} catch (Exception e) {	
			throw new LogHandlerException("Bad locationY data on parsed line:\n" + line + "\nData: " + lines[6]);
		}
		
		return CustomerFactory.getCustomer(customerCode, name, mobileNumber, locationX, locationY);	
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		// TO DO		
	}

}
