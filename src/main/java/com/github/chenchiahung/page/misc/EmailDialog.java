package com.github.chenchiahung.page.misc;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.login.Login;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailDialog extends PageObject {

	private static final Logger Log = LogManager.getLogger(EmailDialog.class);

	@AndroidFindBy(id = "com.google.android.gms:id/cancel")
	protected WebElement cancelLink;

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
