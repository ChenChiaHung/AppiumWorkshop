package com.github.chenchiahung.page.home;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.result.Result;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home extends PageObject {

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
		System.out.println(
						"Step 06 - Define the swipe action on the view bar of explore carousell"); // deprecated
		System.out.println(
						"Step 07 - Try to find Cars category on the view bar of explore carousell"); // deprecated
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
					System.out.println("find element !");
					ele.click();
					break;
				}
			} catch (Exception e) {
				System.out.println("Count : " + count + " , Can not find element ! " + e);
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
		System.out.println("window width : " + windowWidth + ", window height : " + windowHeight); // deprecated

		int eleLocationX = element.getLocation().getX();
		int eleLocationY = element.getLocation().getY();
		System.out.println("element location x : " + eleLocationX + ", element location y : " + eleLocationY); // deprecated

		int destinationX = eleLocationX + (int) (element.getSize().getWidth() * 0.1F);
		int destinationY = eleLocationY + (int) (element.getSize().getHeight() * 0.5F);
		int originX = eleLocationX + (int) (element.getSize().getWidth() * 0.9F);
		int originY = eleLocationY + (int) (element.getSize().getHeight() * 0.5F);
		System.out.println("Origin X : " + originX + " , Origin Y : " + originY); // deprecated
		System.out.println("Destination X : " + destinationX + " , Destination Y : " + destinationY); // deprecated

		TouchAction action = new TouchAction((AndroidDriver) driver);
		action.press(PointOption.point(originX, originY));
		action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2L)));
		action.moveTo(PointOption.point(destinationX, destinationY));
		action.release();
		action.perform();
		return this;
	}
}
