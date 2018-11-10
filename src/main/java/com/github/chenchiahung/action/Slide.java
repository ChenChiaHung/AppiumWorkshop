package com.github.chenchiahung.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Slide {

	Action slide(By by);

	Action slide(WebElement webElement);

	Action slideTillFind(By by, By target);

	Action slideTillFind(WebElement element, WebElement target);

	Action slideTillFind(WebElement element, By target);
}
