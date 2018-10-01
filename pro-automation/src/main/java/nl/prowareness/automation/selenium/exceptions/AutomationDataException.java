package nl.prowareness.automation.selenium.exceptions;

public class AutomationDataException extends Throwable {
	
    private static final long serialVersionUID = 0x1L;
    
    public AutomationDataException(final String message, final Throwable cause){
        super(message, cause);
    }

	public AutomationDataException(String message) {
        super(message);
	}
	

}
