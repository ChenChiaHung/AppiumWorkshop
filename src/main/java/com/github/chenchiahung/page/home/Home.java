package com.github.chenchiahung.page.home;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.result.Result;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home extends PageObject {

	private static final Logger Log = LogManager.getLogger(Home.class);

	By categoryView = By.id("com.thecarousell.Carousell:id/recyclerView");
	private int maxTries = 10;

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
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(categoryView));
		WebElement categories = driver.findElement(categoryView);

		By locator = MobileBy.AndroidUIAutomator(
						".className(\"android.widget.TextView\").text(\"" + categoryName + "\")");
		int count = 1;
		while (count < maxTries) {
			try {
				WebElement ele = driver.findElement(locator);
				if (ele != null) {
					Log.debug("find element !");
					ele.click();
					break;
				}
			} catch (Exception e) {
				Log.debug("Count : {} , Can not find element ! ", count);
				count++;
				doSwipeOnCategory(categories);
			}
		}
		return new Result(driver);
	}

	/**
	 * Slide Category view
	 *
	 * @param element
	 * @return {@link Home}
	 */
	private Home doSwipeOnCategory(WebElement element) {
		int windowWidth = driver.manage().window().getSize().getWidth();
		int windowHeight = driver.manage().window().getSize().getHeight();
		Log.debug("window width : {} , window height : {}", windowWidth, windowHeight);

		int eleLocationX = element.getLocation().getX();
		int eleLocationY = element.getLocation().getY();
		Log.debug("element location X : {} , element location Y : {}", eleLocationX, eleLocationY);

		int destinationX = eleLocationX + (int) (element.getSize().getWidth() * 0.1F);
		int destinationY = eleLocationY + (int) (element.getSize().getHeight() * 0.5F);
		int originX = eleLocationX + (int) (element.getSize().getWidth() * 0.9F);
		int originY = eleLocationY + (int) (element.getSize().getHeight() * 0.5F);
		Log.debug("Origin X : {} , Origin Y : {}", originX, originY);
		Log.debug("Destination X : {} , Destination Y : {}", destinationX, destinationY);

		TouchAction action = new TouchAction((AndroidDriver) driver);
		action.press(PointOption.point(originX, originY));
		action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2L)));
		action.moveTo(PointOption.point(destinationX, destinationY));
		action.release();
		action.perform();
		return this;
	}
}
