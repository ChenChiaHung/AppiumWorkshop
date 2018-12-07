package com.github.chenchiahung.action;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Action implements Wait, Tap, Type, Slide, Misc {

	protected static final int DEFAULT_WAIT_SECONDS = 20;
	protected static final int DEFAULT_RETRY_TIME = 10;
	protected WebDriver driver;

	public Action(WebDriver driver) {
		this.setDriver(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Wait target element in default seconds
	 * @param by
	 * @return
	 */
	@Override
	public Action waitFor(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return this;
	}

	/**
	 * Wait target element in specific seconds
	 * @param by
	 * @param sec
	 * @return
	 */
	@Override
	public Action waitFor(By by, int sec) {
		WebDriverWait wait = new WebDriverWait(getDriver(), sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return this;
	}

	/**
	 * Wait target element in default seconds
	 * @param element
	 * @return
	 */
	@Override
	public Action waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
		return this;
	}

	/**
	 * Wait target element in specific seconds
	 * @param element
	 * @param sec
	 * @return
	 */
	@Override
	public Action waitFor(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(getDriver(), sec);
		wait.until(ExpectedConditions.visibilityOf(element));
		return this;
	}

	/**
	 * Tap target element
	 * @param by
	 * @return
	 */
	@Override
	public Action tap(By by) {
		this.waitFor(by);
		this.getDriver().findElement(by).click();
		return this;
	}

	/**
	 * Tap target element
	 * @param element
	 * @return
	 */
	@Override
	public Action tap(WebElement element) {
		this.waitFor(element);
		element.click();
		return this;
	}

	/**
	 * Tap elements by index
	 * @param by
	 * @param index
	 * @return
	 */
	@Override
	public Action tapElementsByIndex(By by, int index) {
		List<WebElement> elements = getDriver().findElements(by);
		this.tapElementsByIndex(elements, index);
		return this;
	}

	/**
	 * Tap elements by index
	 * @param elements
	 * @param index
	 * @return
	 */
	@Override
	public Action tapElementsByIndex(List<WebElement> elements, int index) {
		this.tap(elements.get(index));
		return this;
	}

	/**
	 * Type text into by locator
	 * @param by
	 * @param text
	 * @return
	 */
	@Override
	public Action type(By by, String text) {
		this.waitFor(by);
		this.getDriver().findElement(by).sendKeys(text);
		return this;
	}

	/**
	 * Type text into element
	 * @param element
	 * @param text
	 * @return
	 */
	@Override
	public Action type(WebElement element, String text) {
		this.waitFor(element);
		element.sendKeys(text);
		return this;
	}

	/**
	 * Slide source element one times
	 * @param source
	 * @return
	 */
	@Override
	public Action slide(By source) {
		this.waitFor(source);

		WebElement element = getDriver().findElement(source);
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

	/**
	 * Slide source element one times
	 * @param source
	 * @return
	 */
	@Override
	public Action slide(WebElement source) {
		this.waitFor(source);

		int eleLocationX = source.getLocation().getX();
		int eleLocationY = source.getLocation().getY();
		System.out.println("element location x : " + eleLocationX + ", element location y : " + eleLocationY); // deprecated

		int destinationX = eleLocationX + (int) (source.getSize().getWidth() * 0.1F);
		int destinationY = eleLocationY + (int) (source.getSize().getHeight() * 0.5F);
		int originX = eleLocationX + (int) (source.getSize().getWidth() * 0.9F);
		int originY = eleLocationY + (int) (source.getSize().getHeight() * 0.5F);
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

	/**
	 * Slide source by locator to find target element
	 * @param source
	 * @param target
	 * @return
	 */
	@Override
	public Action slideTillFind(By source, By target) {
		this.waitFor(source);
		for (int count = 0; count < DEFAULT_RETRY_TIME; count++) {
			if (this.exists(target)) {
				break;
			} else {
				this.slide(source);
			}
		}
		return this;
	}

	/**
	 * Slide source element to find target element
	 * @param source
	 * @param target
	 * @return
	 */
	@Override
	public Action slideTillFind(WebElement source, WebElement target) {
		this.waitFor(source);
		for (int count = 0; count < DEFAULT_RETRY_TIME; count++) {
			if (this.exists(target)) {
				break;
			} else {
				this.slide(source);
			}
		}
		return this;
	}

	/**
	 * Slide source element to find target element
	 * @param source
	 * @param target
	 * @return
	 */
	@Override
	public Action slideTillFind(WebElement source, By target) {
		this.waitFor(source);
		for (int count = 0; count < DEFAULT_RETRY_TIME; count++) {
			if (this.exists(target)) {
				break;
			} else {
				this.slide(source);
			}
		}
		return this;
	}

	/**
	 * Submit form
	 * @return
	 */
	@Override
	public Action submit() {
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		return this;
	}

	/**
	 * Get target attribute from target by locator
	 * @param by
	 * @param attributeName
	 * @return
	 */
	@Override
	public String getValueFromAttribute(By by, String attributeName) {
		this.waitFor(by);
		WebElement element = getDriver().findElement(by);
		return element.getAttribute(attributeName);
	}

	/**
	 * Get target attribute from target element
	 * @param element
	 * @param attributeName
	 * @return
	 */
	@Override
	public String getValueFromAttribute(WebElement element, String attributeName) {
		this.waitFor(element);
		return element.getAttribute(attributeName);
	}

	/**
	 * Check if by locator exists
	 * @param by
	 * @return
	 */
	@Override
	public Boolean exists(By by) {
		try {
			waitFor(by, 1);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	/**
	 * Check if element exists
	 * @param element
	 * @return
	 */
	@Override
	public Boolean exists(WebElement element) {
		try {
			waitFor(element, 1);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}
