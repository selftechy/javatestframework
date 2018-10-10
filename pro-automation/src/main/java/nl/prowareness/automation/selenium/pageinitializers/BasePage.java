package nl.prowareness.automation.selenium.pageinitializers;

import org.apache.log4j.Logger;

import nl.prowareness.automation.selenium.exceptions.AutomationDriverException;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

/**
 *
 * All Page class should extend this base page class for initialization
 *
 */
public class BasePage {
    protected DriverContext driverContext;
	private static final Logger LOGGER = Logger.getLogger(BasePage.class);

    public BasePage(DriverContext driverContext) throws AutomationDriverException  {
        PageInitializer.initialize(this, driverContext);
        this.driverContext=driverContext;
    }



    public DriverContext getDriver() {
        return driverContext;
    }

    public void setDriver(DriverContext drvContext) {
        this.driverContext = drvContext;
    }
    
   
}
