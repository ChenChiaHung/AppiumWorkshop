package com.github.chenchiahung.page.misc;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.login.Login;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailDialog extends PageObject {

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
		System.out.println("Step 02 - Click Cancel"); // deprecated
		action.tap(cancelLink);
		return new Login(driver);
	}
}
