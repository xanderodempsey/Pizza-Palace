package asgn2Tests;

import java.time.LocalTime;

import org.junit.*;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.PizzaFactory;


/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Alexander O'Dempsey
 * 
 */
public class PizzaFactoryTests {
	
	@Test(expected = PizzaException.class)
	public void margTest() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void vegTest() throws PizzaException {
		LocalTime orderTime = LocalTime.of(20, 0);
		LocalTime deliveryTime = LocalTime.of(20, 20);
		PizzaFactory.getPizza("PZV", 1, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void meatLoversTest() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		PizzaFactory.getPizza("PZL", 1, orderTime, deliveryTime);
	}
	
	//Testing of invalid pizza codes
	@Test(expected = PizzaException.class)
	public void badPizzaCodeOne() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		PizzaFactory.getPizza("PZP", 1, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void badPizzaCodeTwo() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		PizzaFactory.getPizza("PZE", 1, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void badPizzaCodeThree() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		PizzaFactory.getPizza("FUQ", 1, orderTime, deliveryTime);
	}
	
	//Empty pizza code
	@Test(expected = PizzaException.class)
	public void emptyPizzaCode() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		PizzaFactory.getPizza(" ", 1, orderTime, deliveryTime);
	}
}
