package com.github.chenchiahung.page.result;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.productdetail.ProductDetail;
import com.github.chenchiahung.page.search.Search;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Result extends PageObject {

	private static final Logger Log = LogManager.getLogger(Result.class);

	By searchTextBox = By.id("com.thecarousell.Carousell:id/header_page_search_text_field");
	By productList = By.id("com.thecarousell.Carousell:id/card_product");
	By okGotItLink = By.id("com.thecarousell.Carousell:id/feature_button");

	public Result(WebDriver driver) {
		super(driver);
	}

	/**
	 * Tap 'Search' textbox to open search page
	 *
	 * @return {@link Search}
	 */
	public Search tapSearchTextBox() {
		Log.info("Step 09 - Click 'Search' Textbox bar");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox));
		WebElement element = driver.findElement(searchTextBox);
		element.click();
		return new Search(driver);
	}

	/**
	 * Browse product listing by index on search result
	 *
	 * @param index
	 * @return {@link ProductDetail}
	 */
	public ProductDetail browseProductList(int index) {
		Log.info("Step 11 - Click first listing on search result");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
		WebElement element = driver.findElements(productList).get(index);
		element.click();
		return new ProductDetail(driver);
	}

	/**
	 * Tap 'OK, got it!' link on tip
	 *
	 * @return {@link Result}
	 */
	public Result tapOKGotItLink() {
		Log.info("Step 08 - Click 'Ok, got it!' button on tip");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(okGotItLink));
		WebElement element = driver.findElement(okGotItLink);
		element.click();
		return this;
	}
}