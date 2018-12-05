package com.github.chenchiahung.page.misc;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailDialog extends PageObject {

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
		System.out.println("Step 02 - Click Cancel"); // deprecated
		action.tap(cancelLink);
		return new Login(driver);
	}
}
