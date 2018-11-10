package com.github.chenchiahung.testcases;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

  private static final Logger Log = LogManager.getLogger(MyFirstAppiumTest.class);

  WebDriver driver;

  @Before
  public void setUp() throws MalformedURLException {
    Log.info("setUp - Start");

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
        MobileCapabilityType.APP, "/Users/chiahungchen/Documents/AppPackage/2.92.217.196-1384.apk");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
    capabilities.setCapability(
        AndroidMobileCapabilityType.APP_ACTIVITY,
        "com.thecarousell.Carousell.activities.EntryActivity");
    capabilities.setCapability(
        AndroidMobileCapabilityType.APP_PACKAGE, "com.thecarousell.Carousell");
    driver = new AndroidDriver(url, capabilities);

    Log.info("setUp - End");
  }

  @Test
  public void testSearchCarListingInCarCategory() {
    Log.info("Test -Start");

    Log.info("Step 01 - Click Login Button");
    By loginButton_1 = By.id("com.thecarousell.Carousell:id/welcome_page_login_button");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton_1));
    WebElement element = driver.findElement(loginButton_1);
    element.click();

    Log.info("Step 02 - Click Cancel"); // deprecated
    By cancelLink =
        By.xpath(
            "//android.widget.LinearLayout[@content-desc=\"Choose an Account\"]/android.widget.LinearLayout/android.widget.Button");
    wait.until(ExpectedConditions.visibilityOfElementLocated(cancelLink));
    element = driver.findElement(cancelLink);
    element.click();

    Log.info("Step 03 - Input Account"); // deprecated
    By editTextbox = MobileBy.AndroidUIAutomator(".className(\"android.widget.EditText\")");
    wait.until(ExpectedConditions.visibilityOfElementLocated(editTextbox));
    element = driver.findElements(editTextbox).get(0);
    element.sendKeys("chiahung003");

    Log.info("Step 04 - Input Password"); // deprecated
    element = driver.findElements(editTextbox).get(1);
    element.sendKeys("1111111w");

    Log.info("Step 05 - Click Log in Button"); // deprecated
    By loginButton_2 = By.id("com.thecarousell.Carousell:id/login_page_login_button");
    wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton_2));
    element = driver.findElement(loginButton_2);
    element.click();

    Log.info(
        "Step 06 - Define the swipe action on the view bar of explore carousell"); // deprecated
    By CategoryList = By.id("com.thecarousell.Carousell:id/recyclerView");
    wait.until(ExpectedConditions.visibilityOfElementLocated(CategoryList));
    element = driver.findElement(CategoryList);

    int windowWidth = driver.manage().window().getSize().getWidth();
    int windowHeight = driver.manage().window().getSize().getHeight();
    Log.debug("window width : {} , window height {}", windowWidth, windowHeight);

    int eleLocationX = element.getLocation().getX();
    int eleLocationY = element.getLocation().getY();
    Log.debug("element location x : {} , element location y : {}", eleLocationX, eleLocationY);

    int destinationX = eleLocationX + (int) (element.getSize().getWidth() * 0.1F);
    int destinationY = eleLocationY + (int) (element.getSize().getHeight() * 0.5F);
    int originX = eleLocationX + (int) (element.getSize().getWidth() * 0.9F);
    int originY = eleLocationY + (int) (element.getSize().getHeight() * 0.5F);
    Log.debug("Origin X : {} , Origin Y : {}", originX, originY);
    Log.debug("Destination X : {}, Destination Y : {}", destinationX, destinationY);

    Log.info("Step 07 - Try to find Cars category on the view bar of explore carousell");
    By CarsCategory =
        MobileBy.AndroidUIAutomator(".className(\"android.widget.TextView\").text(\"Cars\")");
    int count = 1;
    while (count <= 8) {
      try {
        WebElement ele = driver.findElement(CarsCategory);
        if (ele != null) {
          Log.debug("Count : {}, find element !", count);
          ele.click();
          break;
        }
      } catch (Exception e) {
        Log.warn("Count : {} , Can not find element !", count);
        TouchAction action = new TouchAction((AndroidDriver) driver);
        action.press(PointOption.point(originX, originY));
        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2L)));
        action.moveTo(PointOption.point(destinationX, destinationY));
        action.release();
        action.perform();
        count = count + 1;
      }
    }

    Log.info("Step 08 - Click 'Ok, got it!' button on tip");
    By okGotItlink1 = By.id("com.thecarousell.Carousell:id/feature_button");
    wait.until(ExpectedConditions.visibilityOfElementLocated(okGotItlink1));
    element = driver.findElement(okGotItlink1);
    element.click();

    Log.info("Step 09 - Click 'Search' Textbox bar");
    By searchTextbox = By.id("com.thecarousell.Carousell:id/header_page_search_text_field");
    wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextbox));
    element = driver.findElement(searchTextbox);
    element.click();

    Log.info("Step 10 - Search 'BMW' and press Enter");
    By inputSearchTextbox = By.id("com.thecarousell.Carousell:id/input_search_bar");
    wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchTextbox));
    element = driver.findElement(inputSearchTextbox);
    element.sendKeys("BMW");
    KeyEvent keyEvent = new KeyEvent(AndroidKey.ENTER);
    ((AndroidDriver) driver).pressKey(keyEvent);

    Log.info("Step 11 - Click first listing on search result");
    By productCard = By.id("com.thecarousell.Carousell:id/card_product");
    wait.until(ExpectedConditions.visibilityOfElementLocated(productCard));
    element = driver.findElements(productCard).get(0);
    element.click();

    Log.info("Step 12 - Click 'OK, Got it!' button on tip");
    By okgotitLink2 = By.id("com.thecarousell.Carousell:id/feature_button");
    wait.until(ExpectedConditions.visibilityOfElementLocated(okgotitLink2));
    element = driver.findElement(okgotitLink2);
    element.click();

    Log.info("Step 13 - Click 'OK, Got it!' button on tip");
    wait.until(ExpectedConditions.visibilityOfElementLocated(okgotitLink2));
    element = driver.findElement(okgotitLink2);
    element.click();

    Log.info("Step 14 - Check if title contain 'BMW'");
    By productDetailTitle = By.id("com.thecarousell.Carousell:id/tvInfo");
    wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailTitle));
    element = driver.findElement(productDetailTitle);
    String title = element.getAttribute("text").toLowerCase();
    Assert.assertTrue(title.contains("bmw"));

    Log.info("Test - End");
  }

  @After
  public void tearDown() {
    Log.info("tearDown - Start");

    driver.quit();

    Log.info("tearDown - End");
  }
}
