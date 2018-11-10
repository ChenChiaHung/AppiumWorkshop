package com.github.chenchiahung.page.misc;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.login.Login;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailDialog extends PageObject {

	private static final Logger Log = LogManager.getLogger(EmailDialog.class);

	By cancelLink = By.id("com.google.android.gms:id/cancel");

	public EmailDialog(WebDriver driver) {
		super(driver);
	}

	/**
	 * Tap cancel link on email dialog
	 *
	 * @return {@link Login}
	 */
	public Login tapCancelLink() {
		Log.info("Step 02 - Click Cancel");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cancelLink));
		WebElement element = driver.findElement(cancelLink);
		element.click();
		return new Login(driver);
	}
}
