package asgn2Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;


/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Alexander O'Dempsey
 *
 */
public class RestaurantPizzaTests {
	private PizzaRestaurant TestRestaurant;
	
	//Error less process log test
	@Test
	public void processLogOneTest() throws CustomerException, PizzaException, LogHandlerException{
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170101.txt");
		assert(TestRestaurant.processLog(file) == true);
	}
	
	@Test
	public void processLogTwoTest() throws CustomerException, PizzaException, LogHandlerException{
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170102.txt");
		assert(TestRestaurant.processLog(file) == true);
	}
	
	@Test
	public void processLogThreeTest() throws CustomerException, PizzaException, LogHandlerException{
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170103.txt");
		assert(TestRestaurant.processLog(file) == true);
	}
	
	@Test
	public void pizzaOrderTotalLogOne() throws CustomerException, PizzaException, LogHandlerException{
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170101.txt");
		TestRestaurant.processLog(file);
		Assert.assertTrue(TestRestaurant.getNumPizzaOrders() == 3);
	}
	
	@Test
	public void pizzaOrderTotalLogTwo() throws CustomerException, PizzaException, LogHandlerException{
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170102.txt");
		TestRestaurant.processLog(file);
		Assert.assertTrue(TestRestaurant.getNumPizzaOrders() == 10);
	}

	@Test
	public void pizzaOrderTotalLogThree() throws CustomerException, PizzaException, LogHandlerException{
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170103.txt");
		TestRestaurant.processLog(file);
		Assert.assertTrue(TestRestaurant.getNumPizzaOrders() == 100);
	}
	
	@Test
	public void pizzaProfitTotalLogOne() throws CustomerException, PizzaException, LogHandlerException{
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170101.txt");
		TestRestaurant.processLog(file);
		Assert.assertTrue(TestRestaurant.getTotalProfit() == 36.5);
	}
	
	@Test
	public void pizzaProfitTotalLogTwo() throws CustomerException, PizzaException, LogHandlerException{
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170102.txt");
		TestRestaurant.processLog(file);
		Assert.assertTrue(TestRestaurant.getTotalProfit() == 316.5);
	}
	
	@Test
	public void pizzaProfitTotalLogThree() throws CustomerException, PizzaException, LogHandlerException{
		TestRestaurant = new PizzaRestaurant();
		String file = (System.getProperty("user.dir") + "\\logs\\20170103.txt");
		TestRestaurant.processLog(file);
		Assert.assertTrue(TestRestaurant.getTotalProfit() == 2849.0);
	}
}
