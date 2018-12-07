package com.github.chenchiahung.page.welcome;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.misc.EmailDialog;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.SelendroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcome extends PageObject {

	@AndroidFindBy(id = "com.thecarousell.Carousell:id/welcome_page_login_button")
	private WebElement loginButton;

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
