package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.*;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Danie Larmar
 * 
 *
 */
public class CustomerTests 
{
	
	private DriverDeliveryCustomer DriverTest;
	private DroneDeliveryCustomer DroneTest;
	private PickUpCustomer PickUpTest;
	private Customer CustomerTest;
	
	//Setup a customer Tests
	@Test
	public void NewCustomerNoError() throws CustomerException
	{
		
		// No Errors
		DriverTest = new DriverDeliveryCustomer("Casey Jones","0123456789",5,5);
		DroneTest = new DroneDeliveryCustomer("April O'Neal","0987654321",3,4);
		PickUpTest = new PickUpCustomer("Oroku Saki", "0111222333",0,0);
		
	}
	
	//White Spaces Error
	@Test(expected = CustomerException.class)
	public void NewCustomerWhiteSpaceError() throws CustomerException
	{
		
		DriverTest = new DriverDeliveryCustomer(" ","0123456789",5,5);
		
	}
	
	//MobileNumber must be 10 characters long Error
	@Test(expected = CustomerException.class)
	public void NewCustomerMobileNumberLengthError() throws CustomerException
	{
		
		DriverTest = new DriverDeliveryCustomer("Casey Jones","0456789",0,0);
		
	}
	
	//20+ characters long name Error
	@Test(expected = CustomerException.class)
	public void NewCustomerCharacterLengthError() throws CustomerException
	{
	
		DriverTest = new DriverDeliveryCustomer("qwertyuiopasdfghjklzxcvbnm","0123456789",0,0);
		
	}
	
	//10+ x location Error
	@Test(expected = CustomerException.class)
	public void NewCustomerXLocationError() throws CustomerException
	{
		
		DriverTest = new DriverDeliveryCustomer("Casey Jones","0123456789",11,5);		
		
	}
	
	//10+ y location Error
	@Test(expected = CustomerException.class)
	public void NewCustomerYLocationError() throws CustomerException
	{
		
		DriverTest = new DriverDeliveryCustomer("Casey Jones","0123456789",5,11);		
		
	}
	
	//Phone Number doesn't start with 0
	@Test(expected = CustomerException.class)
	public void NewCustomerPhoneNumberError() throws CustomerException
	{
		
		DriverTest = new DriverDeliveryCustomer("Casey Jones","1023456789",5,5);
		
	}
	
	// Functions to test
	public String GetCustName(Customer customer)
	{
		
		return customer.getName();
		
	}
	
	public String GetMobileNumber(Customer customer)
	{
		
		return customer.getMobileNumber();
		
	}
	
	public String GetCustomerType(Customer customer)
	{
		
		return customer.getCustomerType();
		
	}
	
	public double GetDeliveryDistance(Customer customer)
	{
		
		return customer.getDeliveryDistance();
		
	}
	
	// Setup for customer method test
	@Before
	public void setup() throws CustomerException
	{
		
		CustomerTest = new PickUpCustomer("Oroku Saki","0111222333",0,0);
		DroneTest = new DroneDeliveryCustomer("April O'Neal","0987654321",3,4);
		
	}
	
	// Testing customer Name
	@Test
	public void GetCustNameTest()
	{
	
		assertEquals(this.GetCustName(CustomerTest),"Oroku Saki");
		
	}
	
	//Testing Mobile Number
	@Test
	public void GetMobileNumberTest()
	{
		
		assertEquals(this.GetMobileNumber(CustomerTest), "0111222333");
		
	}
	
	//Testing Customer Type
	@Test
	public void GetCustomerTypeTest()
	{
		
		assertEquals(this.GetCustomerType(CustomerTest), "Pick Up");
		
	}
	
	//Test delivery distance for pick
	@Test
	public void GetPickUpDistanceTest()
	{
		
		assert(this.GetDeliveryDistance(CustomerTest) == 0);
		
	}
	
	//Test delivery distance for delivery
	@Test
	public void GetDeliveryDistanceTest()
	{
		
		assert(this.GetDeliveryDistance(DroneTest) == 5);
		
	}

}
