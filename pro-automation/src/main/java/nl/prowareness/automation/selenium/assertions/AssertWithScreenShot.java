package nl.prowareness.automation.selenium.assertions;

import org.junit.Assert;

import nl.prowareness.automation.selenium.webdriver.DriverContext;


public class AssertWithScreenShot {

	protected AssertWithScreenShot() {
	}

	static public void assertTrue(String message, boolean condition,
			DriverContext driver) {
		try {
			Assert.assertTrue(message, condition);
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

	static public void assertTrue(boolean condition, DriverContext driver) {
		try {
			Assert.assertTrue(condition);
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

	static public void assertFalse(String message, boolean condition,
			DriverContext driver) {
		try {
			Assert.assertFalse(message, condition);
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

	static public void assertFalse(boolean condition, DriverContext driver) {
		try {
			Assert.assertFalse(condition);
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

	static public void fail(String message, DriverContext driver) {
		try {
			Assert.fail(message);
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

	static public void fail(DriverContext driver) {
		try {
			Assert.fail();
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

	static public void assertEquals(String message, Object expected,
			Object actual, DriverContext driver) {
		try {
			Assert.assertEquals(message, expected, actual);
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

	static public void assertEquals(Object expected, Object actual,
			DriverContext driver) {
		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

	static public void assertNotEquals(String message, Object first,
			Object second, DriverContext driver) {
		try {
			Assert.assertNotEquals(message, first, second);
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

	static public void assertNotEquals(Object first, Object second,
			DriverContext driver) {
		try {
			Assert.assertNotEquals(first, second);
		} catch (AssertionError e) {
			driver.captureScreenshot();
			throw e;
		}
	}

}
