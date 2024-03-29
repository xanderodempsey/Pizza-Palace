package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** An abstract class to represent a customer at the Pizza Palace restaurant.
 *  The Customer class is used as a base class of PickUpCustomer, 
 *  DriverDeliveryCustomer and DroneDeliverCustomer. Each of these subclasses overwrites
 *  the abstract method getDeliveryDistance. A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.  
 * 
 * @author Alexander O'Dempsey
*/
public abstract class Customer {
	
	private String name, mobileNumber, type;
	private int locationX, locationY;

	/**
	 *  This class represents a customer of the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.2. 
	 *  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment Specification
	 *  are violated. 
	 *  
  	 * <P> PRE: True
  	 * <P> POST: All field values are set
  	 * 
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY - The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param type - A human understandable description of this Customer type
	 * @throws CustomerException if supplied parameters are invalid 
	 * 
	 */
	public Customer(String name, String mobileNumber, int locationX, int locationY, String type) throws CustomerException{
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.type = type;
		this.locationX = locationX;
		this.locationY = locationY;	
		int firstMobNum = Integer.parseInt(mobileNumber.substring(0, 1));
		
		if(name == "" || name == null) {
			throw new CustomerException("The customer's name is an empty string or is null.");
		}
		if(name.length() < 1 || name.length() > 20) {
			throw new CustomerException("The customer's name requires between 1 to 20 characters.");
		}
		if(name.matches(" ")) {
			throw new CustomerException("The customer's name cannot be filled with only white spaces.");
		}
		if(mobileNumber == "" || mobileNumber == null) {
			throw new CustomerException("The mobile number is an empty string or is null.");
		}
		if(mobileNumber.length() != 10) {
			throw new CustomerException("The mobile number must be 10 digits long.");
		}
		if(firstMobNum != 0){
			throw new CustomerException("The mobile number must start with a 0.");
		}
		if(type == "" || type == null) {
			throw new CustomerException("customerType is an empty string or is null.");
		}
		
		if(this.getCustomerType().equals("Pick Up")) {
			if(locationX != 0 || locationY != 0) {
				throw new CustomerException("Customers pickup location is not the location of the restaurant");
			}
		} else {
			if(locationX == 0 && locationY == 0) {
				throw new CustomerException("Cannot deliver to the customer when they are at the restaurant");
			}
			if(locationX > 10 ) {
				throw new CustomerException("Cannot deliver to customer more than 10 blocks East");
			}
			if(locationX < -10 ) {
				throw new CustomerException("Cannot deliver to customer more than 10 blocks West");
			}
			if(locationY > 10) {
				throw new CustomerException("Cannot deliver to customer more than 10 blocks North");
			}
			if(locationY < -10) {
				throw new CustomerException("Cannot deliver to customer more than 10 blocks South");
			}
		}
	}
	
	/**
	 * Returns the Customer's name.
	 * @return The Customer's name.
	 * @throws CustomerException if name is empty string
	 * @throws CustomerException if name is not between 1-20 characters
	 * @throws CustomerException if name is filled with only white space
	 */
	public final String getName(){
		return name;
	}
	
	/**
	 * Returns the Customer's mobile number.
	 * @return The Customer's mobile number.
	 * @throws CustomerException if mobileNumber is empty string
	 * @throws CustomerException if mobileNumber is less than 10 digits
	 * @throws CustomerException if mobileNumber doesn't start with a 0
	 */
	public final String getMobileNumber(){
		return mobileNumber;
	}

	/**
	 * Returns a human understandable description of the Customer's type. 
	 * The valid alternatives are listed in Section 5.2 of the Assignment Specification. 
	 * @return A human understandable description of the Customer's type.
	 * @throws CustomerException if customerType is empty string
	 */
	public final String getCustomerType(){
		return type;
	}
	
	/**
	 * Returns the Customer's X location which is the number of blocks East or West 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's X location
	 * @throws CustomerException if locationX is not 0 and they have elected pickup
	 * @throws CustomerException if locationX is greater than 10, or less than -10 and have elected delivery
	 */
	public final int getLocationX(){
		return locationX;
	}

	/**
	 * Returns the Customer's Y location which is the number of blocks North or South 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's Y location
	 * @throws CustomerException if locationY is not 0 and they have elected pickup
	 * @throws CustomerException if locationY is greater than 10, or less than -10 and have elected delivery
	 */
	public final int getLocationY(){
			return locationY;
	}

	/**
	 * An abstract method that returns the distance between the Customer and 
	 * the restaurant depending on the mode of delivery. 
	 * @return The distance between the restaurant and the Customer depending on the mode of delivery.
	 */
	public abstract double getDeliveryDistance();

	
	
	/**
	 * Compares *this* Customer object with an instance of an *other* Customer object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 *  You do not need to test this method.
	 * 
	 * @return true if *this* Customer object and the *other* Customer object have the same values returned for 	
	 * getName(),getMobileNumber(),getLocationX(),getLocationY(),getCustomerType().
	 */
	@Override
	public boolean equals(Object other){
		Customer otherCustomer = (Customer) other;

		return ( (this.getName().equals(otherCustomer.getName()))  &&
			(this.getMobileNumber().equals(otherCustomer.getMobileNumber())) && 
			(this.getLocationX() == otherCustomer.getLocationX()) && 
			(this.getLocationY() == otherCustomer.getLocationY()) && 
			(this.getCustomerType().equals(otherCustomer.getCustomerType())) );			
	}

}
