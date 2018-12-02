package com.github.chenchiahung.page.login;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.home.Home;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends PageObject {

	By editTextbox = MobileBy.AndroidUIAutomator(".className(\"android.widget.EditText\")");
	By loginButton = By.id("com.thecarousell.Carousell:id/login_page_login_button");

	public Login(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter account on account textbox
	 *
	 * @param account
	 */
	public Login enterAccount(String account) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(editTextbox));
		WebElement element = driver.findElements(editTextbox).get(0);
		element.sendKeys(account);
		return this;
	}

	/**
	 * Enter password on password textbox
	 *
	 * @param password
	 * @return
	 */
	public Login enterPassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(editTextbox));
		WebElement element = driver.findElements(editTextbox).get(1);
		element.sendKeys(password);
		return this;
	}

	/**
	 * Tap login button and login success
	 *
	 * @return
	 */
	public Home tapLoginButtonExpectingSuccess() {
		System.out.println("Step 05 - Click Log in Button"); // deprecated
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		WebElement element = driver.findElement(loginButton);
		element.click();
		return new Home(driver);
	}

	/**
	 * Tap login button but login failure
	 *
	 * @return
	 */
	public Login tapLoginButtonExpectingFailure() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		WebElement element = driver.findElement(loginButton);
		element.click();
		return new Login(driver);
	}

	/**
	 * Login success by correct account and password
	 *
	 * @param account
	 * @param password
	 * @return
	 */
	public Home loginAsExpectingSuccess(String account, String password) {
		System.out.println("Step 03 - Input Account"); // deprecated
		this.enterAccount(account);
		System.out.println("Step 04 - Input Password"); // deprecated
		this.enterPassword(password);
		return this.tapLoginButtonExpectingSuccess();
	}

	/**
	 * Login failure by incorrect account and password
	 *
	 * @param account
	 * @param password
	 * @return
	 */
	public Login loginAsExpectingFailure(String account, String password) {
		this.enterAccount(account);
		this.enterPassword(password);
		return this.tapLoginButtonExpectingFailure();
	}
}