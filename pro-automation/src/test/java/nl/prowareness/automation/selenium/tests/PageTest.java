package nl.prowareness.automation.selenium.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import nl.prowareness.automation.selenium.exceptions.AutomationDataException;
import nl.prowareness.automation.selenium.exceptions.AutomationDriverException;
import nl.prowareness.automation.selenium.exceptions.AutomationElementNotFoundException;
import nl.prowareness.automation.selenium.testsetup.TestConfig;
import nl.prowareness.automation.selenium.testsetup.TestPageClass;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class PageTest {
	@Autowired
	DriverContext driverContext;
	@Autowired
	TestPageClass tp;

	
	@Before
	public void initialize(){
		//System.setProperty("webdriver.gecko.driver", "C:\\TestAutomation\\SeleniumWrapper\\src\\main\\resources\\drivers\\geckodriver.exe");
		if(driverContext.getWebDriver()==null){
			driverContext.setUpBrowser();
		}
	}
	
	@Test
	public void test() throws AutomationElementNotFoundException, AutomationDriverException, IOException, AutomationDataException{
		driverContext.connect("http://google.com");
		tp.test();
		

		
	}
	
	@After
	public void ss(){
		for(WebDriver driver : driverContext.getActiveDrivers()){
			driver.quit();
		}
	}
	

}
