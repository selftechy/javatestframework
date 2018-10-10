package nl.prowareness.automation.selenium.fields;

import nl.prowareness.automation.selenium.exceptions.AutomationElementNotFoundException;
import nl.prowareness.automation.selenium.utilities.FindBy;
import nl.prowareness.automation.selenium.webdriver.DriverContext;



/**
 * Initializes instances of driver, findBy and findByValue
 *
 */
public abstract class BaseElement {
    protected DriverContext drvContext;
    protected FindBy findBy;
    protected ThreadLocal<String> findByValue = new ThreadLocal<String>();
    protected String findByValueStatic;

    protected BaseElement(final DriverContext webDriver, final FindBy findBy, final String findByValue) {
        this.drvContext = webDriver;
        this.findBy = findBy;
        this.findByValue.set(findByValue);
        findByValueStatic = findByValue;
    }

    public DriverContext getWebDriver() {
        return drvContext;
    }

    public void setWebDriver(DriverContext webDriver) {
        this.drvContext = webDriver;
    }



    public FindBy getFindBy() {
        return findBy;
    }
    public void setFindBy(FindBy findBy) {
        this.findBy = findBy;
    }
    public String getFindByValue() {
        return findByValue.get();
    }
    public void setFindByValue(String fieldName) {
        this.findByValue.set(fieldName);
    }

    public String getAttribute(final String attributeName) throws AutomationElementNotFoundException {
        return drvContext.getAttribute(findBy, findByValue.get(), attributeName);
    }

    public abstract BaseElement replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith);

    protected void replaceSubString(String subStrToMatch, String subStrToReplaceWith){
        findByValue.set(findByValueStatic.replace(subStrToMatch, subStrToReplaceWith));
    }


    public boolean isPresent(){
        return drvContext.isElementPresent(findBy, findByValue.get());
    }

    public boolean isVisible(){
        return drvContext.isElementVisible(findBy, findByValue.get());
    }

    public boolean isEnabled(){
        return drvContext.isElementEnabled(findBy, findByValue.get());
    }

    public void mouseHover() throws AutomationElementNotFoundException {
        drvContext.mouseHover(findBy, findByValue.get());
    }

    public String getText() throws AutomationElementNotFoundException{
        return drvContext.getElementText(findBy, findByValue.get());
    }
    
    public String getCSSValue(String propertyName) throws AutomationElementNotFoundException{
    	return drvContext.getCSSValue(findBy, findByValue.get(), propertyName);
    }

    public void clickByJavaScript() throws AutomationElementNotFoundException{
        drvContext.clickByJavaScript(findBy, findByValue.get());
    }

    public void clearCache(){
    	drvContext.clearBrowserCache();
    }

    public void javaScriptScrollUntilVisible() throws AutomationElementNotFoundException{
    	drvContext.javaScriptScrollToElement(findBy, findByValue.get());
    }

}
