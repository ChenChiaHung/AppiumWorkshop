package com.github.chenchiahung.page.welcome;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.misc.EmailDialog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Welcome extends PageObject {

	private static final Logger Log = LogManager.getLogger(Welcome.class);

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
		Log.info("Step 01 - Click Login Button");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		WebElement element = driver.findElement(loginButton);
		element.click();
		return new EmailDialog(driver);
	}
}
