package com.github.chenchiahung.page.result;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.productdetail.ProductDetail;
import com.github.chenchiahung.page.search.Search;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		action.tap(searchTextBox);
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
		action.tapElementsByIndex(productList, 0);
		return new ProductDetail(driver);
	}

	/**
	 * Tap 'OK, got it!' link on tip
	 *
	 * @return {@link Result}
	 */
	public Result tapOKGotItLink() {
		Log.info("Step 08 - Click 'Ok, got it!' button on tip");
		action.tap(okGotItLink);
		return this;
	}
}
