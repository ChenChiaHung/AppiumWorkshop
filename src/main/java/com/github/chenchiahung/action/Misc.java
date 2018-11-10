package com.github.chenchiahung.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Misc {

	Boolean exists(By by);

	Boolean exists(WebElement element);

	String getValueFromAttribute(By by, String attributeName);

	String getValueFromAttribute(WebElement element, String attributeName);
}
