package com.github.chenchiahung.page.search;

import com.github.chenchiahung.page.PageObject;
import com.github.chenchiahung.page.result.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search extends PageObject {

	By searchTextBox = By.id("com.thecarousell.Carousell:id/input_search_bar");

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
