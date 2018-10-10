package nl.prowareness.automation.selenium.fields;

import nl.prowareness.automation.selenium.exceptions.AutomationElementNotFoundException;
import nl.prowareness.automation.selenium.utilities.FindBy;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

/**
 * contains  methods related to DropDown Select
 *
 */
public class ListBox extends BaseElement{
    public ListBox(final DriverContext drvContext, final FindBy findBy, final String findByValue) {
        super(drvContext, findBy, findByValue);
    }

    public void selectItemByVisibleText(final String visibleText) throws AutomationElementNotFoundException{
        drvContext.selectComboBoxItemByVisibleText(findBy, findByValue.get(), visibleText);
    }

    public void selectItemByValue(final String value) throws AutomationElementNotFoundException{
        drvContext.selectComboBoxItemByValue(findBy, findByValue.get(), value);
    }
    public void selectItemByIndex(final int index) throws AutomationElementNotFoundException{
        drvContext.selectComboBoxItemByIndex(findBy, findByValue.get(), index);
    }

    public String[] getItems() throws AutomationElementNotFoundException{
        return drvContext.getComboBoxElements(findBy, findByValue.get());
    }

    public String[] getSelectedItems() throws AutomationElementNotFoundException{
        return drvContext.getSelectedComboBoxElements(findBy, findByValue.get());
    }

    @Override
    public ListBox replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;
    }

}
