package com.github.chenchiahung.testcases;

import com.github.chenchiahung.page.home.Home;
import com.github.chenchiahung.page.login.Login;
import com.github.chenchiahung.page.misc.EmailDialog;
import com.github.chenchiahung.page.productdetail.ProductDetail;
import com.github.chenchiahung.page.result.Result;
import com.github.chenchiahung.page.search.Search;
import com.github.chenchiahung.page.welcome.Welcome;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstAppiumTest {

	private static final Logger Log = LogManager.getLogger(MyFirstAppiumTest.class);

	protected WebDriver driver;

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
	public void testSearchCarListingInCarCategory1() {
		Log.info("Test1 - Start");

		Welcome welcome = new Welcome(driver);
		EmailDialog emailDialog = new EmailDialog(driver);
		Login login = new Login(driver);
		Home home = new Home(driver);
		Result result = new Result(driver);
		Search search = new Search(driver);
		ProductDetail productDetail = new ProductDetail(driver);

		welcome.tapLoginButton();
		emailDialog.tapCancelLink();
		login.loginAsExpectingSuccess("chiahung003", "1111111w");
		home.browseCategory("Cars");
		result.tapOKGotItLink();
		result.tapSearchTextBox();
		search.searchKeyword("BMW");
		result.browseProductList(0);
		productDetail.tapOKGotItLink();
		productDetail.tapOKGotItLink();
		Assert.assertTrue(productDetail.isTitleContain("bmw"));

		Log.info("Test1 - End");
	}

	@Test
	public void testSearchCarListingInCarCategory2() {
		Log.info("Test2 - Start");

		boolean isCorrectListing =
						new Welcome(driver)
										.tapLoginButton()
										.tapCancelLink()
										.loginAsExpectingSuccess("chiahung003", "1111111w")
										.browseCategory("Cars")
										.tapOKGotItLink()
										.tapSearchTextBox()
										.searchKeyword("BMW")
										.browseProductList(0)
										.tapOKGotItLink()
										.tapOKGotItLink()
										.isTitleContain("bmw");

		Assert.assertTrue(isCorrectListing);

		Log.info("Test2 - End");
	}

	@After
	public void tearDown() {
		Log.info("tearDown - Start");
		driver.quit();
		Log.info("tearDown - End");
	}
}
