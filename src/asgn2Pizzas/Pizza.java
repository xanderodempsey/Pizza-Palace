package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Daniel Larmar
 *
 */
public abstract class Pizza  {
	
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if quantity is not between 1 and 10
	 * @throws PizzaException if the orderTime is not within store hours: 7pm - 11pm
	 * @throws PizzaException if the pizza type isn't a valid pizzatype: Meat Lovers, Vegetarian, Margherita
	 * 
	 */
	
	// Globals to be used by other methods
	
	private double Cost;
	private double Price;
	private String Type;
	private int Quantity;
	
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException
	{
		
		// Test for exceptions
		if(quantity < 1) // if quantity order is less than 1
		{
			
			throw new PizzaException("At least one pizza must be ordered."); //throw exception
			
		}
		else if(orderTime.isBefore(LocalTime.of(19, 00))) // if the orderTime is before opening hours
		{
			
			throw new PizzaException("Please Order After 7:00pm Local Time"); //throw exception
			
		}
		else if(orderTime.isAfter(LocalTime.of(23, 00))) // If the orderTime is after opening hours
		{
			
			throw new PizzaException("Please Order Before 11:00pm Local Time"); // throw exception
			
		}
		else if(!type.equals("Meat Lovers") && !type.equals("Vegetarian") && !type.equals("Margherita")) // If the pizza not a valid pizza type
		{
			
			throw new PizzaException(type + " is not a valid pizza name. Please enter a valid pizza type: PZL, PZM or PZV."); // Throw the exception						
			
		}
		else if(quantity > 10) // if the quantity is more than 10
		{
			
			throw new PizzaException("Maximum number of pizzas is 10."); // throw the exception
			
		}
		else // values are valid
		{
		
			// Store globals
			Quantity = quantity;
			Type = type;
			Price = price;
					
			//calculates the cost per pizza
			this.calculateCostPerPizza();		
		
		}
	}

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza()
	{
			
		// Get all the toppings from the enum
		PizzaTopping Toppings[] = PizzaTopping.class.getEnumConstants();
		// Loop through all the toppings
		for(PizzaTopping topping: Toppings)
		{
			
			// Check if the pizza contains the topping
			if(this.containsTopping(topping))
			{
				
				// Add the cost of the topping to the total cost
				Cost += topping.getCost();
				
			}
			
		}
		
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza()
	{
		
		//Returns the cost of the pizza
		return Cost;
		
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza()
	{
		
		//Return the price of the pizza
		return this.Price;
		
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost()
	{
		
		//Return the cost of the order: Cost of 1 pizza * quantity ordered
		return getCostPerPizza() * this.Quantity;
		
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice()
	{
		
		//Return the order price (pizza * quantity ordered)
		return getPricePerPizza() * this.Quantity;
		
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit()
	{
		
		// Returns the profit: Price of the order - cost of the order
		return getOrderPrice() - getOrderCost();
		
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping)
	{
		
		// Check if the pizza is a meat lover
		if(this.getPizzaType().equals("PZL"))
		{
			
			// Check if the topping is a topping on the meat lover
			if(MeatLoversPizza.Toppings.contains(topping))
			{
				
				return true;
				
			}
			else
			{
				
				return false;
				
			}
			
		}
		// Check if the pizza is a margherita
		else if (this.getPizzaType().equals("PZM"))
		{
			
			//Check if the topping is a topping on the margherita
			if(MargheritaPizza.Toppings.contains(topping))
			{
				
				return true;
				
			}
			else
			{
				
				return false;
				
			}
			
		}
		// The pizza has to be a vegetarian as exception would've already been risen
		else
		{
			
			// Check if the topping is a topping on the vegetarian
			if(VegetarianPizza.Toppings.contains(topping))
			{
				
				return true;
				
			}
			else
			{
			
				return false;
				
			}			
			
		}
		
	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity()
	{
		
		//Return Quantity
		return Quantity;
		
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType()
	{
		
		//Returns Pizza type
		return Type;
		
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other)
	{
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
