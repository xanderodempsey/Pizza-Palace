package asgn2Tests;

import org.junit.*;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Daniel Larmar
 */
public class LogHandlerCustomerTests 
{
	
	//ErrorLess CustomerDataSet
	@Test
	public void PopulateCustomerDatasetErrorLess() throws CustomerException, LogHandlerException
	{
		
		String file = (System.getProperty("user.dir") + "\\logs\\20170101.txt");
		LogHandler.populateCustomerDataset(file);
		
	}
	
	//Wrong File input error
	@Test(expected = LogHandlerException.class)
	public void PopulateCustomerDatasetWrongFileError() throws CustomerException, LogHandlerException
	{

		LogHandler.populateCustomerDataset("ErrorFileName.txt");
		
	}
	
	//ErrorLess Test of a created customer
	@Test
	public void CreateCustomerErrorLess() throws CustomerException, LogHandlerException
	{
		
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
		
	}
	
	//Data line doesn't = 9 error
	@Test(expected = LogHandlerException.class)
	public void CreateCustomerLineError() throws CustomerException, LogHandlerException
	{
		
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2,10");
		
	}
	
	//Bad X location Error
	@Test(expected = LogHandlerException.class)
	public void CreateCustomerBadXError() throws CustomerException, LogHandlerException
	{
	
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,d,5,PZV,2");
		
	}
	
	//Bad Y location Error
	@Test(expected = LogHandlerException.class)
	public void CreateCustomerBadYError() throws CustomerException, LogHandlerException
	{
	
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,d,PZV,2");
		
	}
	
	//Lower Level Exception handling check: Should come back with CustomerException as phone number has 0
	@Test(expected = CustomerException.class)
	public void TestLowerLevelExceptions1() throws CustomerException, LogHandlerException
	{
		
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,1123456789,DVC,5,5,PZV,2");
		
	}
	
	//Lower Level Exception handling check: Should come back with CustomerException as pickup is not (0,0)
	@Test(expected = CustomerException.class)
	public void TestLowerLevelExceptions2() throws CustomerException, LogHandlerException
	{
		
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,PUC,0,5,PZV,2");
		
	}
	
}
