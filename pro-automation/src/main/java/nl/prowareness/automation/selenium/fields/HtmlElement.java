package nl.prowareness.automation.selenium.fields;


import nl.prowareness.automation.selenium.utilities.FindBy;
import nl.prowareness.automation.selenium.webdriver.DriverContext;

public class HtmlElement extends BaseElement{

    public HtmlElement(DriverContext drvContext, FindBy findBy, String findByValue) {
        super(drvContext, findBy, findByValue);
    }


    @Override
    public HtmlElement replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;

    }
}