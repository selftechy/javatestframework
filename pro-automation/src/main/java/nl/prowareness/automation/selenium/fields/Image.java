package nl.prowareness.automation.selenium.fields;

import nl.prowareness.automation.selenium.exceptions.AutomationElementNotFoundException;
import nl.prowareness.automation.selenium.utilities.FindBy;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

public class Image extends BaseElement{

    public Image(final DriverContext drvContext, final FindBy findBy, final String findByValue){
        super(drvContext, findBy, findByValue);
    }

    public void click() throws AutomationElementNotFoundException{
        drvContext.click(findBy, findByValue.get());
    }

    public String getSrc() throws AutomationElementNotFoundException{
        return getAttribute("src");
    }

    public String getStyle() throws AutomationElementNotFoundException{
        return getAttribute("style");
    }

    @Override
    public Image replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;

    }

}
