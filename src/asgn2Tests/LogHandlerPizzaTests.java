package asgn2Tests;

import org.junit.*;

import asgn2Exceptions.PizzaException;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;



/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Alexander O'Dempsey
* 
*/
public class LogHandlerPizzaTests {
	@Test
	public void populatePizzaDatasetLogOne() throws PizzaException, LogHandlerException {
		String file = (System.getProperty("user.dir") + "\\logs\\20170101.txt");
		LogHandler.populatePizzaDataset(file);
	}
	
	@Test
	public void populatePizzaDatasetLogTwo() throws PizzaException, LogHandlerException {
		String file = (System.getProperty("user.dir") + "\\logs\\20170102.txt");
		LogHandler.populatePizzaDataset(file);
	}
	
	@Test
	public void populatePizzaDatasetLogThree() throws PizzaException, LogHandlerException {
		String file = (System.getProperty("user.dir") + "\\logs\\20170103.txt");
		LogHandler.populatePizzaDataset(file);
	}
	
	@Test(expected = LogHandlerException.class)
	public void populatePizzaDatasetWrongFile() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset("Error.txt");
	}
	
	@Test(expected = LogHandlerException.class)
	public void createPizza() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("PZM,1,19:00:00,19:20:00");
	}
	
	@Test(expected = LogHandlerException.class)
	public void createPizzaError() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("PZM,1,2,19:00:00,19:20:00");
	}
	
	@Test(expected = LogHandlerException.class)
	public void createPizzaBadCode() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("PZA,1,19:00:00,19:20:00");
	}
	
	@Test(expected = LogHandlerException.class)
	public void createPizzaAmountError() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("PZM,100000,19:00:00,19:20:00");
	}
	
	@Test(expected = LogHandlerException.class)
	public void createPizzaTimeError() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("PZM,1,19:00,19:00");
	}
	
	@Test(expected = LogHandlerException.class)
	public void createPizzaAllWrong() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("PZE,100000222,19:001,19:20");
	}
}
