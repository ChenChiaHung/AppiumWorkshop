package com.github.chenchiahung.page.login;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.home.Home;
import io.appium.java_client.MobileBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends PageObject {

	private static final Logger Log = LogManager.getLogger(Login.class);

	By accountTextbox = MobileBy.AndroidUIAutomator(".className(\"android.widget.EditText\").instance(0)");
	By passwordTextbox = MobileBy.AndroidUIAutomator(".className(\"android.widget.EditText\").instance(1)");
	By loginButton = By.id("com.thecarousell.Carousell:id/login_page_login_button");

	public Login(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter account on account textbox
	 *
	 * @param account
	 */
	private Login enterAccount(String account) {
		action.type(accountTextbox, account);
		return this;
	}

	/**
	 * Enter password on password textbox
	 *
	 * @param password
	 * @return
	 */
	private Login enterPassword(String password) {
		action.type(passwordTextbox, password);
		return this;
	}

	/**
	 * Tap login button and login success
	 *
	 * @return
	 */
	public Home tapLoginButtonExpectingSuccess() {
		action.tap(loginButton);
		return new Home(driver);
	}

	/**
	 * Tap login button but login failure
	 *
	 * @return
	 */
	public Login tapLoginButtonExpectingFailure() {
		action.tap(loginButton);
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
		Log.info("Step 03 - Input Account");
		this.enterAccount(account);
		Log.info("Step 04 - Input Password");
		this.enterPassword(password);
		Log.info("Step 05 - Click Log in Button");
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
