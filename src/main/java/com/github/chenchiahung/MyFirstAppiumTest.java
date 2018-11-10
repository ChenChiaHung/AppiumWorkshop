package com.github.chenchiahung;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MyFirstAppiumTest {

  WebDriver driver;

  @Before
  public void setUp() throws MalformedURLException {
    System.out.println("setUp - Start"); // deprecated
    URL url = new URL("http://127.0.0.1:9999/wd/hub");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
    capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
    capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
    capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
    capabilities.setCapability(
        MobileCapabilityType.APP, "/Users/chiahungchen/Documents/AppPackage/2.89.197.179-1308.apk");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
    capabilities.setCapability(
        AndroidMobileCapabilityType.APP_ACTIVITY,
        "com.thecarousell.Carousell.activities.EntryActivity");
    capabilities.setCapability(
        AndroidMobileCapabilityType.APP_PACKAGE, "com.thecarousell.Carousell");
    driver = new AndroidDriver(url, capabilities);
    System.out.println("setUp - End"); // deprecated
  }

  @Test
  public void SearchCarsInCarCategory() {
    System.out.println("Hello Appium"); // deprecated

    By locator;
    MobileElement element;

    System.out.println("Step 01 - Click Login Button"); // deprecated
    locator = By.id("com.thecarousell.Carousell:id/welcome_page_login_button");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);
    element.click();

    System.out.println("Step 02 - Click Cancel"); // deprecated
    locator = By.id("com.google.android.gms:id/cancel");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);
    element.click();

    System.out.println("Step 03 - Input Account"); // deprecated
    locator = MobileBy.AndroidUIAutomator(".className(\"android.widget.EditText\")");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = (MobileElement) driver.findElements(locator).get(0);
    element.sendKeys("chiahung003");

    System.out.println("Step 04 - Input Password"); // deprecated
    element = (MobileElement) driver.findElements(locator).get(1);
    element.sendKeys("1111111w");

    System.out.println("Step 05 - Click Log in Button"); // deprecated
    locator = By.id("com.thecarousell.Carousell:id/login_page_login_button");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);
    element.click();

    System.out.println(
        "Step 06 - Define the swipe action on the view bar of explore carousell"); // deprecated
    locator = By.id("com.thecarousell.Carousell:id/recyclerView");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);

    int windowWidth = driver.manage().window().getSize().getWidth();
    int windowHeight = driver.manage().window().getSize().getHeight();
    System.out.println("window width : " + windowWidth + ", window height : " + windowHeight);

    int eleLocationX = element.getLocation().getX();
    int eleLocationY = element.getLocation().getY();
    System.out.println(
        "element location x : " + eleLocationX + ", element location y : " + eleLocationY);

    int destinationX = eleLocationX + (int) (element.getSize().getWidth() * 0.1F);
    int destinationY = eleLocationY + (int) (element.getSize().getHeight() * 0.5F);
    int originX = eleLocationX + (int) (element.getSize().getWidth() * 0.9F);
    int originY = eleLocationY + (int) (element.getSize().getHeight() * 0.5F);
    System.out.println("Start - Origin X : " + originX + " , Origin Y : " + originY); // deprecated
    System.out.println(
        "End - Destination X : "
            + destinationX
            + " , Destination Y : "
            + destinationY); // deprecated

    System.out.println(
        "Step 07 - Try to find Cars category on the view bar of explore carousell"); // deprecated
    locator = MobileBy.AndroidUIAutomator(".className(\"android.widget.TextView\").text(\"Cars\")");
    int count = 1;
    while (count <= 8) {
      try {
        WebElement ele = driver.findElement(locator);
        System.out.println("element : " + ele);
        if (ele != null) {
          System.out.println("find element !");
          ele.click();
          break;
        }
      } catch (Exception e) {
        System.out.println("Count : " + count + " , Can not find element ! " + e);
        TouchAction action = new TouchAction((AndroidDriver) driver);
        action.press(PointOption.point(originX, originY));
        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2L)));
        action.moveTo(PointOption.point(destinationX, destinationY));
        action.release();
        action.perform();
        count = count + 1;
      }
    }

    System.out.println("Step 08 - Click 'Ok, got it!' button on tip"); // deprecated
    locator = By.id("com.thecarousell.Carousell:id/feature_button");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);
    element.click();

    System.out.println("Step 09 - Click 'Search' Textbox bar"); // deprecated
    locator = By.id("com.thecarousell.Carousell:id/header_page_search_text_field");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);
    element.click();

    System.out.println("Step 10 - Search 'BMW' and press Enter"); // deprecated
    locator = By.id("com.thecarousell.Carousell:id/input_search_bar");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);
    element.sendKeys("BMW");
    KeyEvent keyEvent = new KeyEvent(AndroidKey.ENTER);
    ((AndroidDriver) driver).pressKey(keyEvent);

    System.out.println("Step 11 - Click first listing on search result"); // deprecated
    locator = By.id("com.thecarousell.Carousell:id/card_product");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = (MobileElement) driver.findElements(locator).get(0);
    element.click();

    System.out.println("Step 12 - Click 'OK, Got it!' button on tip"); // deprecated
    locator = By.id("com.thecarousell.Carousell:id/feature_button");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);
    element.click();

    System.out.println("Step 13 - Click 'OK, Got it!' button on tip"); // deprecated
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);
    element.click();

    System.out.println("Step 14 - Check if title contain 'BMW'"); // deprecated
    locator = By.id("com.thecarousell.Carousell:id/tvInfo");
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element = driver.findElement(locator);
    String title = element.getAttribute("text").toLowerCase();
    Assert.assertTrue(title.contains("bmw"));
  }

  @After
  public void tearDown() {
    System.out.println("tearDown - Start"); // deprecated
    driver.quit();
    System.out.println("tearDown - End"); // deprecated
  }
}
