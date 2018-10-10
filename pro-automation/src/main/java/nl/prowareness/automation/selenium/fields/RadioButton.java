package nl.prowareness.automation.selenium.fields;

import nl.prowareness.automation.selenium.exceptions.AutomationElementNotFoundException;
import nl.prowareness.automation.selenium.utilities.FindBy;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

/**
 * contains  methods related to Radio Button Actions
 *
 */
public class RadioButton extends BaseElement{
    public RadioButton(final DriverContext drvContext, final FindBy findBy, final String findByValue) {
        super(drvContext, findBy, findByValue);
    }

    public boolean isChecked() throws AutomationElementNotFoundException {
        return drvContext.isElementChecked(findBy, findByValue.get());
    }

    public void select() throws AutomationElementNotFoundException{
        drvContext.click(findBy, findByValue.get());

    }

    @Override
    public RadioButton replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;
    }

}
