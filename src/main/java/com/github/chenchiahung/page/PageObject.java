package com.github.chenchiahung.page;

import com.github.chenchiahung.action.Action;
import org.openqa.selenium.WebDriver;

public class PageObject {

	protected WebDriver driver;
	protected Action action;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		action = new Action(this.driver);
	}

}
