package com.github.chenchiahung.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface Tap {

	Action tap(By by);

	Action tap(WebElement element);

	Action tapElementsByIndex(By by, int index);

	Action tapElementsByIndex(List<WebElement> elements, int index);
}
