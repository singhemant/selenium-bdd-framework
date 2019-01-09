package com.autosel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	@FindBy(id = "userId")
	public static WebElement userId;

	@FindBy(id = "passwordInputFiel")
	public static WebElement password;

	@FindBy(id = "olb-btn")
	public static WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String user, String pwd) {
		userId.sendKeys(user);
		LoginPage.password.sendKeys(pwd);
		loginButton.click();
	}
}
