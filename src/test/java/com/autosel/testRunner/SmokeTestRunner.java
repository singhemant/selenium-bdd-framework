package com.autosel.testRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		monochrome = true, 
		features = { "classpath:features" }, 
		glue = {"com.autosel.stepDefinitions" }, 
		tags = { "@smoke" }, 
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent/report.html" }

)

public class SmokeTestRunner {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig("src/test/resources/config/extent-config.xml");
	}

}
