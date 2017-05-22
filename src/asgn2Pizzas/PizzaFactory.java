package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;

/**
 * A class that instantiates the subclasses of asgn2Pizzas.Pizza using the Factory Method pattern. 
 * The classes are instantiated from one of the three valid pizza codes outlined in
 * Section 5.3 of the Assignment Specification. Any other code will throw a PizzaException.      
 *  
 * @author Daniel Larmar
 *
 */

public class PizzaFactory {


	/**
	 * A method that uses the Factory Method pattern to produce an instance of one of the asgn2Pizzas.Pizza subclasses. 
	 * Subclasses are created using the pizzaCode. All valid pizza codes are listed in Section 5.3 of the Assignment Specification.
	 * A PizzaException should be thrown if an invalid pizza code is used as a parameter. 
	 * 
	 * @param pizzaCode - A code indicating the subclass of asgn2Pizzas.Pizza to instantiate. The valid codes are listed in Section 5.3 of the Assignment Specification. 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if the pizzaCode is not one of the three valid codes listed in Section 5.3 of the Assignment Specification. 
	 * @return A valid Pizza object using the specified parameters 
	 * */
	
	public static Pizza getPizza(String pizzaCode, int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException
	{
		
		// If the pizza code isn't one of the existing pizzas
		if(!pizzaCode.equals("PZL") && !pizzaCode.equals("PZV") && !pizzaCode.equals("PZM"))
		{
			
			// Throw the exception:
			throw new PizzaException(pizzaCode + " is not a valid pizza name. Please enter a valid pizza type: PZL, PZM or PZV.");
			
		}
		else // The pizza is a valid code
		{
			
			if(pizzaCode.equals("PZL")) // If the pizza is a meat lovers:
			{
				
				return new MeatLoversPizza(quantity, orderTime, deliveryTime);
				
			}
			else if(pizzaCode.equals("PZV")) // If the pizza is a vegetarian:
			{
				
				return new VegetarianPizza(quantity, orderTime, deliveryTime);
				
			}
			else // The pizza has to be a margherita otherwise would've throw exception:
			{
				
				return new MargheritaPizza(quantity, orderTime, deliveryTime);
			
			}
			
		}
		
	}

}
