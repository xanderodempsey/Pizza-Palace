package asgn2Tests;

import org.junit.*;

import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Customers.CustomerFactory;
/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Daniel Larmar
 *
 */
public class CustomerFactoryTests 
{
	
	//Errorless tests
	@Test
	public void GetCustomerDriverDeliveryTest() throws CustomerException
	{

			CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
			
	}
	
	@Test
	public void GetCustomerDroneDeliveryTest() throws CustomerException
	{

			CustomerFactory.getCustomer("DNC", "Casey Jones", "0123456789", 5, 5);
			
	}
	
	@Test
	public void GetCustomerPickUpTest() throws CustomerException
	{

			CustomerFactory.getCustomer("PUC", "Casey Jones", "0123456789", 0, 0);
			
	}
	
	//Not one of the three pick modes
	@Test(expected = CustomerException.class)
	public void GetCustomerErrorEmptyCode() throws CustomerException
	{
		
		CustomerFactory.getCustomer("", "Casey Jones", "0123456789", 5, 5);
		
	}
	
	//Another Test
	@Test(expected = CustomerException.class)
	public void GetCustomerErrorInvalidCode() throws CustomerException
	{
		
		CustomerFactory.getCustomer("PZL", "Casey Jones", "0123456789", 5, 5);
		
	}
	
	//Test to check if catches Customer handled exceptions
	@Test(expected = CustomerException.class)
	public void GetCustomerLowerErrorTest() throws CustomerException
	{
		
		// Mobile number does not start with 0
		CustomerFactory.getCustomer("DVC", "Casey Jones", "1123456789", 5, 5);
		
	}
	
}
