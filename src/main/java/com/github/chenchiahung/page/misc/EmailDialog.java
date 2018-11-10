package com.github.chenchiahung.page.misc;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.login.Login;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		action.tap(cancelLink);
		return new Login(driver);
	}
}
