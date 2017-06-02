package asgn2Tests;

import org.junit.*;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;
/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Daniel Larmar
 */
public class RestaurantCustomerTests 
{
	
	private PizzaRestaurant TestRestaurant;
	
	//Setting up the new restaurant before testing other methods
	@Before
	public void Setup() throws CustomerException, PizzaException, LogHandlerException
	{
		
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170101.txt");
		TestRestaurant.processLog(file);
		
	}
	
	//Error less process log test
	@Test
	public void ProcessLogTest() throws CustomerException, PizzaException, LogHandlerException
	{
		
		String file = (System.getProperty("user.dir") + "\\logs\\20170101.txt");
		assert(TestRestaurant.processLog(file) == true);

	}
	
	//Inner Exception test
	//Process log invalid log exception
	@Test(expected = LogHandlerException.class)
	public void ProcessLogInvalidLogError() throws CustomerException, PizzaException, LogHandlerException
	{
		
		TestRestaurant.processLog("InvalidFile.txt");
		
	}
	
	//Process Log bad X location
	@Test(expected = LogHandlerException.class)
	public void ProcessLogBadXLocationError() throws CustomerException, PizzaException, LogHandlerException
	{
		
		String file = (System.getProperty("user.dir") + "\\logs\\20170104.txt");
		TestRestaurant.processLog(file);
		
	}
	
	//Too long of a file Exception
	@Test(expected = LogHandlerException.class)
	public void ProcessLogTooLongError() throws CustomerException, PizzaException, LogHandlerException
	{
		
		String file = (System.getProperty("user.dir") + "\\logs\\20170105.txt");
		TestRestaurant.processLog(file);
		
	}
	
	//invalid Name Test
	@Test(expected = CustomerException.class)
	public void ProcessLogInvalidCustomerError() throws CustomerException,PizzaException,LogHandlerException
	{
		
		String file = (System.getProperty("user.dir") + "\\logs\\20170106.txt");
		TestRestaurant.processLog(file);
	
	}
	
	//GetCustomerByIndex Test
	@Test
	public void GetCustomerByIndexTest() throws CustomerException
	{
	
		TestRestaurant.getCustomerByIndex(2);
		
	}
	
	//GetCustomerByIndex Outside of Bounds
	@Test(expected = CustomerException.class)
	public void GetCustomerByIndexError() throws CustomerException
	{
		
		TestRestaurant.getCustomerByIndex(4);
		
	}
	
	//Get Total Distance Covered
	@Test
	public void GetTotalDeliveryDistanceTest()
	{
		
		//Total distance in 20170101.txt document is 15
		int Distance = 15;
		
		assert(TestRestaurant.getTotalDeliveryDistance() == Distance);
		
	}
	
}
