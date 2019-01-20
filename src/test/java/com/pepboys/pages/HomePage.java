package com.pepboys.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	JavascriptExecutor js;

	@FindBy(css = "a[class='dropdown-toggle j-store-dropdown-toggle']")
	public static WebElement findAStore;

	@FindBy(css = "button[class='btn btn-primary j-find-store']")
	// @FindBy(xpath = "//*[@id='testrow']//button")
	public static WebElement findButton;

	@FindBy(id = "findByZip")
	public static WebElement zipcodeInputField;

	// @FindBy(xpath = "//*[@id='storesnearyou']//a[text()='Pep Boys Chicago']")
	@FindBy(xpath = "//*[@id='storesnearyou']//a[text()='BRICKYARD MALL']")
	public static WebElement chicagoTestStore;

	// @FindBy(id = "passwordInputFiel")
	// public static WebElement password;
	//
	// @FindBy(id = "olb-btn")
	// public static WebElement loginButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);

	}

	public void findAStore() throws InterruptedException {
		js.executeScript("document.body.style.zoom='75%';");
		js.executeScript("arguments[0].click();", findAStore);
		// findAStore.click();
		System.out.println("clicked!!!");
		Thread.sleep(3000);
	}

	public void selectAStore() throws InterruptedException {
		js.executeScript("arguments[0].value='60707';", zipcodeInputField);
		// zipcodeInputField.sendKeys("60707");
		js.executeScript("arguments[0].click();", findButton);
		// findButton.click();
		js.executeScript("arguments[0].click();", chicagoTestStore);
		// chicagoTestStore.click();
		Thread.sleep(5000);
	}
}
