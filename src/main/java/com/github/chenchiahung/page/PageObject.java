package com.github.chenchiahung.page;

import com.github.chenchiahung.action.Action;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

	protected WebDriver driver;
	protected Action action;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		action = new Action(this.driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

}
