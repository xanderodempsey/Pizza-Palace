package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.*;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Alexander O'Dempsey
 *
 */
public class PizzaTests {
	MeatLoversPizza meatLovers;
	MargheritaPizza marg;
	VegetarianPizza veg;
	
	//Testing of Meat Lovers
	
		//Testing order time of 7pm and deliveryTime time of 7:20pm with 1 Meat Lover
		@Test
		public void meatLoversFirstOrderTime() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			meatLovers = new MeatLoversPizza(1, orderTime, deliveryTime);
		}
			
		//Testing order time of 10pm and deliveryTime time of 10:20pm with 5 meat lovers
		@Test
		public void meatLoversTimeTestTwo() throws PizzaException {
			LocalTime orderTime = LocalTime.of(22, 0);
			LocalTime deliveryTime = LocalTime.of(22, 20);
			meatLovers = new MeatLoversPizza(5, orderTime, deliveryTime);
		}
			
		//Testing order time of 10:59pm and deliveryTime time of 11:20pm with 1 meat lover
		@Test
		public void meatLoversLastPossibleOrder() throws PizzaException {
			LocalTime orderTime = LocalTime.of(22, 59);
			LocalTime deliveryTime = LocalTime.of(23, 20);
			meatLovers = new MeatLoversPizza(1, orderTime, deliveryTime);
		}
			
		//Testing an order of 10 meatlovers
		@Test
		public void tenMeatLovers() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			meatLovers = new MeatLoversPizza(10, orderTime, deliveryTime);
		}
		
		//Testing an order greater than 10 meat lovers
		@Test(expected = PizzaException.class)
		public void tooManyMeatLovers() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			meatLovers = new MeatLoversPizza(11, orderTime, deliveryTime);
		}
			
		//Testing an order far greater than 10 meat lovers
		@Test(expected = PizzaException.class)
		public void wayTooManyPizzasTestMeatLovers() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			meatLovers = new MeatLoversPizza(1007, orderTime, deliveryTime);
		}
			
		//Testing an invalid order time of me
		@Test(expected = PizzaException.class)
		public void lateOrderTimeMeatLovers() throws PizzaException {
			LocalTime orderTime = LocalTime.of(23, 01);
			LocalTime deliveryTime = LocalTime.of(23, 20);
			meatLovers = new MeatLoversPizza(1, orderTime, deliveryTime);
		}
			
		//Testing an invalid orderTime time of 6:59pm
		@Test(expected = PizzaException.class)
		public void earlyOrderTimeMeatLovers() throws PizzaException {
			LocalTime orderTime = LocalTime.of(18, 59);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			meatLovers = new MeatLoversPizza(1, orderTime, deliveryTime);
		}
			
		//Testing an extreme order time of 4am
		@Test(expected = PizzaException.class)
		public void veryLateOrderTimeMeatLovers() throws PizzaException {
			LocalTime orderTime = LocalTime.of(4, 0);
			LocalTime deliveryTime = LocalTime.of(4, 20);
			meatLovers = new MeatLoversPizza(1, orderTime, deliveryTime);
		}
		
	//Margherita testing
		
		//Test first possible order of margherita
		@Test
		public void margheritaOrderTime() throws PizzaException{
			LocalTime orderTimeTime = LocalTime.of(19,00);
			LocalTime deliveryTimeTime = LocalTime.of(19,30);
			marg = new MargheritaPizza(1, orderTimeTime, deliveryTimeTime);
		}
	
		//Testing order time of 10pm and deliveryTime time of 10:20pm with 5 margs
		@Test
		public void margheritaOrderTimeTwo() throws PizzaException {
			LocalTime orderTime = LocalTime.of(22, 0);
			LocalTime deliveryTime = LocalTime.of(22, 20);
			marg = new MargheritaPizza(5, orderTime, deliveryTime);
		}
	
		//Testing order time of 10:59pm and delivery time of 11:20pm with 1 marg
		@Test
		public void margheritaOrderTimeBeforeClose() throws PizzaException {
			LocalTime orderTime = LocalTime.of(22, 59);
			LocalTime deliveryTime = LocalTime.of(23, 20);
			marg = new MargheritaPizza(1, orderTime, deliveryTime);
		}
	
		//Testing an order of 10 margs
		@Test
		public void tenMargheritas() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			marg = new MargheritaPizza(10, orderTime, deliveryTime);
		}
	
		//Testing an orderTime greater than 10 margs
		@Test(expected = PizzaException.class)
		public void tooManyMargheritas() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			marg = new MargheritaPizza(11, orderTime, deliveryTime);
		}
	
		//Testing an orderTime far greater than 10 margs
		@Test(expected = PizzaException.class)
		public void wayTooManyMargheritas() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			marg = new MargheritaPizza(1022, orderTime, deliveryTime);
		}
	
		//Testing an invalid marg order time - after service end
		@Test(expected = PizzaException.class)
		public void invalidOrderTimeMargherita() throws PizzaException {
			LocalTime orderTime = LocalTime.of(23, 01);
			LocalTime deliveryTime = LocalTime.of(23, 20);
			marg = new MargheritaPizza(1, orderTime, deliveryTime);
		}
	
		//Testing an invalid marg order time - before service start
		@Test(expected = PizzaException.class)
		public void secondInvalidOrderTimeMargherita() throws PizzaException {
			LocalTime orderTime = LocalTime.of(18, 59);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			marg = new MargheritaPizza(1, orderTime, deliveryTime);
		}
	
		//Testing an extremely late marg order time
		@Test(expected = PizzaException.class)
		public void thirdInvalidOrderTimeMargherita() throws PizzaException {
			LocalTime orderTime = LocalTime.of(3, 0);
			LocalTime deliveryTime = LocalTime.of(3, 20);
			marg = new MargheritaPizza(1, orderTime, deliveryTime);
		}
	
	
	//Testing of Vegetarian Pizza
	
		//Testing orderTime time of 7pm and deliveryTime time of 7:20pm with 1 veg
		@Test
		public void vegTimeTest() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			veg = new VegetarianPizza(1, orderTime, deliveryTime);
		}	
			
		//Testing order time of 10pm and delivery time of 10:20pm with 5 veg
		@Test
		public void secondVegTimeTest() throws PizzaException {
			LocalTime orderTime = LocalTime.of(22, 0);
			LocalTime deliveryTime = LocalTime.of(22, 20);
			veg = new VegetarianPizza(5, orderTime, deliveryTime);
		}
		
		//Testing order time of 10:59pm and delivery time of 11:20pm with 1 veg
		@Test
		public void justInTimeVegOrder() throws PizzaException {
			LocalTime orderTime = LocalTime.of(22, 59);
			LocalTime deliveryTime = LocalTime.of(23, 20);
			veg = new VegetarianPizza(1, orderTime, deliveryTime);
		}
		
		//Testing an order of 10 veg
		@Test
		public void tenVeg() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			veg = new VegetarianPizza(10, orderTime, deliveryTime);
		}
	
		//Testing a veg order greater than 10
		@Test(expected = PizzaException.class)
		public void tooManyVeg() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			veg = new VegetarianPizza(11, orderTime, deliveryTime);
		}
		
		//Testing a veg order far greater than 10
		@Test(expected = PizzaException.class)
		public void farTooManyVeg() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 0);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			veg = new VegetarianPizza(100023, orderTime, deliveryTime);
		}
		
		//Testing an invalid order time for veg - after service
		@Test(expected = PizzaException.class)
		public void lateOrderTimeVeg() throws PizzaException {
			LocalTime orderTime = LocalTime.of(23, 01);
			LocalTime deliveryTime = LocalTime.of(23, 20);
			veg = new VegetarianPizza(1, orderTime, deliveryTime);
		}
	
		//Testing an invalid order time for veg - before service
		@Test(expected = PizzaException.class)
		public void earlyOrderTimeVeg() throws PizzaException {
			LocalTime orderTime = LocalTime.of(18, 59);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			veg = new VegetarianPizza(1, orderTime, deliveryTime);
		}
		
		//Testing an extreme order time for veg
		@Test(expected = PizzaException.class)
		public void veryLateOrderTimeVeg() throws PizzaException {
			LocalTime orderTime = LocalTime.of(7, 0);
			LocalTime deliveryTime = LocalTime.of(7, 20);
			veg = new VegetarianPizza(1, orderTime, deliveryTime);
		}
}
