package com.github.chenchiahung.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Type {

	Action type(By by, String text);

	Action type(WebElement element, String text);

	Action submit();

}
