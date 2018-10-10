package nl.prowareness.automation.selenium.testsetup;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.prowareness.automation.selenium.exceptions.AutomationDriverException;
import nl.prowareness.automation.selenium.exceptions.AutomationElementNotFoundException;
import nl.prowareness.automation.selenium.fields.Button;
import nl.prowareness.automation.selenium.pageinitializers.BasePage;
import nl.prowareness.automation.selenium.utilities.FindElement;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

@Component
public class TestPageClass extends BasePage{
    private Logger log = Logger.getLogger(TestPageClass.class);
    @Autowired
    public TestPageClass(DriverContext driver) throws AutomationDriverException {
        super(driver);

    }
    @FindElement(field="loginIcon", page="logon")
    private Button test;
    
    public void test() throws AutomationElementNotFoundException, AutomationDriverException{
        log.info("Testing");
        driverContext.typeText(test.getFindBy(), test.getFindByValue(), "Text");
        driverContext.waitUntilJQueryAndAngularReady(15);
        driverContext.waitUntilElementIsVisible(test, 10);
        test.click();
    }
}
