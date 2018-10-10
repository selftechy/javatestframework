package nl.prowareness.automation.selenium.fields;

import nl.prowareness.automation.selenium.exceptions.AutomationElementNotFoundException;
import nl.prowareness.automation.selenium.utilities.FindBy;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

/**
 * contains  methods related to Button Actions
 *
 */
public class Button extends BaseElement{

    public Button(DriverContext drvContext, FindBy findBy, String findByValue) {
        super(drvContext, findBy, findByValue);
    }

    public void click() throws AutomationElementNotFoundException{
        drvContext.click(findBy, findByValue.get());
    }

    @Override
    public Button replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;

    }
}
