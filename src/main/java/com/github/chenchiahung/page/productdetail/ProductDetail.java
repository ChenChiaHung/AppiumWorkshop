package com.github.chenchiahung.page.productdetail;

import com.github.chenchiahung.page.PageObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetail extends PageObject {

	@AndroidFindBy(id = "com.thecarousell.Carousell:id/feature_button")
	private WebElement okGotItLink;

	@AndroidFindBy(id = "com.thecarousell.Carousell:id/tvInfo")
	private WebElement title;

	public ProductDetail(WebDriver driver) {
		super(driver);
	}

	/**
	 * Check if product title contains keyword
	 *
	 * @return {@link String}
	 */
	public String getTitle() {
		return action.getValueFromAttribute(title, "text");
	}

	/**
	 * Tap 'Ok, got it' link
	 *
	 * @return {@link ProductDetail}
	 */
	public ProductDetail tapOKGotItLink() {
		System.out.println("Step 12,13 - Click 'OK, Got it!' button on tip"); // deprecated
		action.tap(okGotItLink);
		return new ProductDetail(driver);
	}

	/**
	 * Check if title contains keyword
	 *
	 * @param keyword
	 * @return
	 */
	public boolean isTitleContain(String keyword) {
		System.out.println("Step 14 - Check if title contain 'BMW'"); // deprecated
		return this.getTitle().toLowerCase().contains(keyword);
	}

}
