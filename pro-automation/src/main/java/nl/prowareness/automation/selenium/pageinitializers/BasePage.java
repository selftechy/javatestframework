package nl.prowareness.automation.selenium.pageinitializers;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nl.prowareness.automation.selenium.exceptions.AutomationDriverException;
import nl.prowareness.automation.selenium.exceptions.AutomationElementTimeOutException;
import nl.prowareness.automation.selenium.fields.BaseElement;
import nl.prowareness.automation.selenium.utilities.FindBy;
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
    
    public void waitUntilElementIsVisible(BaseElement element, long timeOutInSeconds) {
		WebDriverWait waitForElement = new WebDriverWait(this.driver.getNativeWebDriver(), timeOutInSeconds);
		try{
			waitForElement.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(element.getFindBy(), element.getFindByValue())));
		}catch (TimeoutException e){
			this.driver.captureScreenshot();
			throw new AutomationElementTimeOutException("Element is not visible after waiting for "+timeOutInSeconds+" seconds", e);
		}
    }
    

    public void waitUntilElementToBeClickable(BaseElement element, long timeOutInSeconds) {
		WebDriverWait waitForElement = new WebDriverWait(this.driver.getNativeWebDriver(), timeOutInSeconds);
		try{
			waitForElement.until(ExpectedConditions.elementToBeClickable(getByLocator(element.getFindBy(), element.getFindByValue())));
		}catch (TimeoutException e){
			this.driver.captureScreenshot();
			throw new AutomationElementTimeOutException("Element is not visible after waiting for "+timeOutInSeconds+" seconds", e);
		}
    }
    
    public void waitUntilElementToBeSelected(BaseElement element, long timeOutInSeconds) {
		WebDriverWait waitForElement = new WebDriverWait(this.driver.getNativeWebDriver(), timeOutInSeconds);
		try{
			waitForElement.until(ExpectedConditions.elementToBeSelected(getByLocator(element.getFindBy(), element.getFindByValue())));
		}catch (TimeoutException e){
			this.driver.captureScreenshot();
			throw new AutomationElementTimeOutException("Element is not visible after waiting for "+timeOutInSeconds+" seconds", e);
		}
    }
    
    
    
    //Wait for JQuery Load
    private void waitForJQueryLoad(long timeOutInSeconds) {
    	JavascriptExecutor jsExec = (JavascriptExecutor) this.driver.getNativeWebDriver();
    	 WebDriverWait jsWait = new WebDriverWait(this.driver.getNativeWebDriver(), timeOutInSeconds);
    	
        //Wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver.getNativeWebDriver())
                .executeScript("return jQuery.active") == 0);
 
        //Get JQuery is Ready
        boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");
 
        //Wait JQuery until it is Ready!
        if(!jqueryReady) {
        	LOGGER.info("JQuery is NOT Ready!");
            jsWait.until(jQueryLoad);
        } else {
        	LOGGER.info("JQuery is Ready!");
        }
    }
 
 
    //Wait for Angular Load
    private void waitForAngularLoad(long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(this.driver.getNativeWebDriver(),timeOutInSeconds);
        JavascriptExecutor jsExec = (JavascriptExecutor) this.driver.getNativeWebDriver();
 
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
 
        //Wait for ANGULAR to load
        ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                .executeScript(angularReadyScript).toString());
 
        //Get Angular is Ready
        boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());
 
        //Wait ANGULAR until it is Ready!
        if(!angularReady) {
        	LOGGER.info("ANGULAR is NOT Ready!");
            //Wait for Angular to load
            wait.until(angularLoad);
        } else {
        	LOGGER.info("ANGULAR is Ready!");
        }
    }
 
    //Wait Until JS Ready
    private void waitUntilJSReady(long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(this.driver.getNativeWebDriver(),timeOutInSeconds);
        JavascriptExecutor jsExec = (JavascriptExecutor) this.driver.getNativeWebDriver();
 
        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) this.driver.getNativeWebDriver())
                .executeScript("return document.readyState").toString().equals("complete");
 
        //Get JS is Ready
        boolean jsReady =  (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");
 
        //Wait Javascript until it is Ready!
        if(!jsReady) {
        	LOGGER.info("JS in NOT Ready!");
            //Wait for Javascript to load
            wait.until(jsLoad);
        } else {
        	LOGGER.info("JS is Ready!");
        }
    }
 
    //Wait Until JQuery and JS Ready
    private void waitUntilJQueryReady(long timeOutInSeconds) {
        JavascriptExecutor jsExec = (JavascriptExecutor) this.driver.getNativeWebDriver();
 
        //First check that JQuery is defined on the page. If it is, then wait AJAX
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined == true) {
            //Pre Wait for stability (Optional)
            sleep(20);
 
            //Wait JQuery Load
            waitForJQueryLoad(timeOutInSeconds);
 
            //Wait JS Load
            waitUntilJSReady(timeOutInSeconds);
 
        }  else {
        	LOGGER.info("jQuery is not defined on this site!");
        }
    }
 
    //Wait Until Angular and JS Ready
    private void waitUntilAngularReady(long timeOutInSeconds) {
        JavascriptExecutor jsExec = (JavascriptExecutor) this.driver.getNativeWebDriver();
 
        //First check that ANGULAR is defined on the page. If it is, then wait ANGULAR
        Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
        if (!angularUnDefined) {
            Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
            if(!angularInjectorUnDefined) {
                //Pre Wait for stability (Optional)
                sleep(20);
 
                //Wait Angular Load
                waitForAngularLoad(timeOutInSeconds);
 
                //Wait JS Load
                waitUntilJSReady(timeOutInSeconds);
 
            } else {
            	LOGGER.info("Angular injector is not defined on this site!");
            }
        }  else {
        	LOGGER.info("Angular is not defined on this site!");
        }
    }
 
    //Wait Until JQuery Angular and JS is ready
    protected void waitJQueryAngular(long timeOutInSeconds) {
        waitUntilJQueryReady(timeOutInSeconds);
        waitUntilAngularReady(timeOutInSeconds);
    }
 
    private void sleep (Integer seconds) {
        long secondsLong = (long) seconds;
        try {
            Thread.sleep(secondsLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }    

	private By getByLocator(final FindBy by, final String locator) {
		By tempBy = null;
		switch(by){
		case ID :
			tempBy = By.id(locator);
			break;
		case NAME :
			tempBy = By.name(locator);
			break;
		case CLASS_NAME :
			tempBy = By.className(locator);
			break;
		case XPATH :
			tempBy = By.xpath(locator);
			break;
		case TAG_NAME :
			tempBy = By.tagName(locator);
			break;
		case CSS_SELECTOR :
			tempBy = By.cssSelector(locator);
			break;
		case LINKTEXT :
			tempBy = By.linkText(locator);
			break;
		case PARTIAL_LINKTEXT :
			tempBy = By.partialLinkText(locator);
			break;
		default:
			tempBy = By.id(locator);
			break;
		}
		return tempBy;
	}
    
    

}
