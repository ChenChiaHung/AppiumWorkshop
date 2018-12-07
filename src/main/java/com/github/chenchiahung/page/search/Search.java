package com.github.chenchiahung.page.search;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.result.Result;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search extends PageObject {

  @AndroidFindBy(id = "com.thecarousell.Carousell:id/input_search_bar")
	private WebElement searchTextBox;

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
		action.type(searchTextBox, keyword);
		return this;
	}

	/**
	 * Submit keyword
	 *
	 * @return {@link Result}
	 */
	public Result submitKeyword() {
		action.submit();
		return new Result(driver);
	}

	/**
	 * Show result by search a keyword
	 *
	 * @param keyword
	 * @return {@link Result}
	 */
	public Result searchKeyword(String keyword) {
		System.out.println("Step 10 - Search 'BMW' and press Enter"); // deprecated
		this.enterKeyword(keyword);
		return this.submitKeyword();
	}
}
