package com.github.chenchiahung.page.search;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.result.Result;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search extends PageObject {

	private static final Logger Log = LogManager.getLogger(Search.class);

	By searchTextBox = By.id("com.thecarousell.Carousell:id/input_search_bar");

	public Search(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter keyword
	 *
	 * @param keyword
	 * @return {@link Search}
	 */
	public Search enterKeyword(String keyword) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox));
		WebElement element = driver.findElement(searchTextBox);
		element.sendKeys(keyword);
		return this;
	}

	/**
	 * Submit keyword
	 *
	 * @return {@link Result}
	 */
	public Result submitKeyword() {
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		return new Result(driver);
	}

	/**
	 * Show result by search a keyword
	 *
	 * @param keyword
	 * @return {@link Result}
	 */
	public Result searchKeyword(String keyword) {
		Log.info("Step 10 - Search 'BMW' and press Enter");
		this.enterKeyword(keyword);
		return this.submitKeyword();
	}
}
