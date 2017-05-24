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
 * @author Person A
 */
public class RestaurantCustomerTests 
{
	
	private PizzaRestaurant TestRestaurant;
	
	@Before
	public void Setup()
	{
		
		TestRestaurant = new PizzaRestaurant();
		
	}
	
	
	@Test
	public void SetupOrders() throws CustomerException, PizzaException, LogHandlerException
	{
		
		try
		{
			
			System.out.println(TestRestaurant.processLog("C:\\Users\\daniel.larmar\\Desktop\\20170101.txt"));
			
			
		}catch(Exception e)
		{
			
			
			
		}

	}
	
}
