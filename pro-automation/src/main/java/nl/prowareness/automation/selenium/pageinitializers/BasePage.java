package nl.prowareness.automation.selenium.pageinitializers;

import org.apache.log4j.Logger;

import nl.prowareness.automation.selenium.exceptions.AutomationDriverException;
import nl.prowareness.automation.selenium.webdriver.SeleniumWebDriver;

/**
 *
 * All Page class should extend this base page class for initialization
 *
 */
public class BasePage {
    protected SeleniumWebDriver driver;
	private static final Logger LOGGER = Logger.getLogger(BasePage.class);

    public BasePage(SeleniumWebDriver driver) throws AutomationDriverException  {
        PageInitializer.initialize(this, driver);
        this.driver=driver;
    }



    public SeleniumWebDriver getDriver() {
        return driver;
    }

    public void setDriver(SeleniumWebDriver driver) {
        this.driver = driver;
    }
    
   
}
