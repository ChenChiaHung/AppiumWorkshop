package com.github.chenchiahung.page.home;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.result.Result;
import io.appium.java_client.MobileBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends PageObject {

	private static final Logger Log = LogManager.getLogger(Home.class);

	By categoryView = By.id("com.thecarousell.Carousell:id/recyclerView");

	public Home(WebDriver driver) {
		super(driver);
	}

	/**
	 * Tap target category to show result
	 *
	 * @param categoryName
	 * @return {@link Result}
	 */
	public Result browseCategory(String categoryName) {
		Log.info(
						"Step 06 - Define the swipe action on the view bar of explore carousell");
		Log.info(
						"Step 07 - Try to find Cars category on the view bar of explore carousell");
		By locator = MobileBy.AndroidUIAutomator(
						".className(\"android.widget.TextView\").text(\"" + categoryName + "\")");
		action.slideTillFind(categoryView, locator);
		action.tap(locator);
		return new Result(driver);
	}
}
