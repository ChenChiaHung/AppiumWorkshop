package com.github.chenchiahung.page.welcome;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.misc.EmailDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Welcome extends PageObject {

	By loginButton = By.id("com.thecarousell.Carousell:id/welcome_page_login_button");

	public Welcome(WebDriver driver) {
		super(driver);
	}

	/**
	 * Tap login button to open login page
	 *
	 * @return {@link EmailDialog}
	 */
	public EmailDialog tapLoginButton() {
		System.out.println("Step 01 - Click Login Button"); // deprecated
		action.tap(loginButton);
		return new EmailDialog(driver);
	}
}
