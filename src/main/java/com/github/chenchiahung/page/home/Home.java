package com.github.chenchiahung.page.home;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.result.Result;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home extends PageObject {

	private static final Logger Log = LogManager.getLogger(Home.class);

	@AndroidFindBy(id = "com.thecarousell.Carousell:id/recyclerView")
	private WebElement categoryView;

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
		Log.info("Step 06 - Define the swipe action on the view bar of explore carousell");
		Log.info("Step 07 - Try to find Cars category on the view bar of explore carousell");
		By locator = MobileBy.AndroidUIAutomator(
						".className(\"android.widget.TextView\").text(\"" + categoryName + "\")");
		action.slideTillFind(categoryView, locator);
		action.tap(locator);
		return new Result(driver);
	}
}
