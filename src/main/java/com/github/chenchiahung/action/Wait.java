package com.github.chenchiahung.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Wait {

	Action waitFor(By by);

	Action waitFor(By by, int sec);

	Action waitFor(WebElement element);

	Action waitFor(WebElement element, int sec);
}
