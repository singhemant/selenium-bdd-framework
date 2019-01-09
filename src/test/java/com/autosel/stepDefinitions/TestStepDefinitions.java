package com.autosel.stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.autosel.pages.LoginPage;
import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepDefinitions {

	public WebDriver driver;
	Properties props = new Properties();
	String propertyFilePath = "src/test/resources/config/";

	@Before
	public void setup() throws IOException {
		String env = System.getProperty("env");
		try {
			if (!env.isEmpty()) {
				propertyFilePath = propertyFilePath + env + ".properties";
			}

		} catch (Exception e) {
			System.out.println("Please provide either dev/qa/local.properties only!");
		}

		props.load(new FileInputStream(propertyFilePath));

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	}

	@Given("^I am on the bank login page \"([^\"]*)\"$")
	public void i_am_on_the_bank_login_page(String url) throws Throwable {
		driver.get(props.getProperty("baseUrl"));
		//Actions action = new Actions(driver);
//		WebElement searchBtn = driver.findElement(By.id("search-button-hp-package"));
//		searchBtn.click();
//
//		List<WebElement> radioBtns = driver.findElements(By.xpath("//*[@type='radio']"));
//
//		WebDriverWait wait = new WebDriverWait(driver, 3);
//		searchBtn = wait.until(ExpectedConditions.visibilityOf(searchBtn));
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		System.out.println("Scrolling...");
//		js.executeScript("window.scrollBy(0,100000);");
//		Thread.sleep(3000);
//
//		driver.switchTo().frame("");
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		alert.dismiss();
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 200, 0).build().perform();
		Thread.sleep(3000);
		
		Set<String> handles = driver.getWindowHandles();	
		for (String handle : handles) {
			System.out.println(handle);
			
		}
		
		
	}

	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_the_and(String userName, String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		LoginPage login = new LoginPage(driver);
		login.login(userName, password);
		Reporter.addStepLog("Login Successful!");

	}

	@Then("^I verify the \"([^\"]*)\" in step$")
	public void i_verify_the_in_step(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// driver.quit();
	}

	@After
	public void wrapUp(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			// scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File("target/screenshots/" + screenshotname + ".png");
			Files.copy(source, destination);
			Reporter.addScreenCaptureFromPath(destination.getAbsolutePath());

		}
		driver.quit();
	}

}
