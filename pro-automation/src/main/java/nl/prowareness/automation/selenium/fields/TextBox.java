package nl.prowareness.automation.selenium.fields;

import nl.prowareness.automation.selenium.exceptions.AutomationElementNotFoundException;
import nl.prowareness.automation.selenium.utilities.FindBy;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

/**
 * contains  methods related to TextBox Actions
 *
 */
public class TextBox extends BaseElement{
    public TextBox(final DriverContext drvContext, final FindBy findBy, final String findByValue){
        super(drvContext, findBy, findByValue);
    }
    public void typeText(final String text) throws AutomationElementNotFoundException{
        drvContext.typeText(findBy, findByValue.get(), text);
    }

    public void clear() throws AutomationElementNotFoundException{
        drvContext.clearText(findBy, findByValue.get());
    }

    public void click() throws AutomationElementNotFoundException{
        drvContext.click(findBy, findByValue.get());
    }


    @Override
    public TextBox replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;

    }

}