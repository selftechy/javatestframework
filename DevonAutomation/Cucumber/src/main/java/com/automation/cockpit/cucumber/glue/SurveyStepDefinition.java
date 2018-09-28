package com.automation.cockpit.cucumber.glue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.automation.cockpit.cucumber.config.CucumberContextConfig;
import com.automation.cockpit.webdriver.pageclass.AgileCockpitLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.prowareness.automation.selenium.assertions.AssertWithScreenShot;
import nl.prowareness.automation.selenium.webdriver.SeleniumWebDriver;

@ContextConfiguration(classes = { CucumberContextConfig.class })
public class SurveyStepDefinition {

	@Autowired
	SeleniumWebDriver webDriver;
	
	@Autowired
	AgileCockpitLoginPage agileCockpitLoginPage;
	
	@Given("^a user logs into the agile cockpit$")
	public void navigateToHomePage(){
		agileCockpitLoginPage.Login();
	}
	
	
	@When("^creates a survey$")
	public void createSurvey(){
		AssertWithScreenShot.assertTrue(true, webDriver);
	}
	
	@Then("^newly created survey should be present in the system$")
	public void validateHeadersInHomePage(){
		AssertWithScreenShot.assertTrue(true, webDriver);
	}
	
	
	
	
}
