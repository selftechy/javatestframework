package nl.prowareness.automation.selenium.fields;

import nl.prowareness.automation.selenium.exceptions.AutomationElementNotFoundException;
import nl.prowareness.automation.selenium.utilities.FindBy;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

/**
 * contains  methods related to Links of a web Page
 *
 */
public class Link extends BaseElement{
    public Link(final DriverContext drvContext, final FindBy findBy, final String findByValue){
        super(drvContext, findBy, findByValue);
    }

    public void click() throws AutomationElementNotFoundException{
        drvContext.click(findBy, findByValue.get());
    }  

    public String getHREF() throws AutomationElementNotFoundException{
        return getAttribute("href");
    }

    public String getName() throws AutomationElementNotFoundException{
        return getAttribute("name");
    }

    public String getOnClickScript() throws AutomationElementNotFoundException{
        return getAttribute("onclick");
    }
  

    @Override
    public Link replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;

    }

}
