package com.github.chenchiahung.page.welcome;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.misc.EmailDialog;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Welcome extends PageObject {

	private static final Logger Log = LogManager.getLogger(Welcome.class);

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
		Log.info("Step 01 - Click Login Button");
		action.tap(loginButton);
		return new EmailDialog(driver);
	}
}
