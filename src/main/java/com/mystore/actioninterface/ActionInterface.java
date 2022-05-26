package com.mystore.actioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	public boolean isDisplayed(WebDriver ldriver, WebElement ele);
	public String getTitle(WebDriver driver);
	public void click(WebDriver driver, WebElement ele);
	public void fluentWait(WebDriver driver,WebElement element, int timeOut);
	public boolean type(WebElement ele, String text);
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
	public String getCurrentURL(WebDriver driver);
	public boolean JSClick(WebDriver driver, WebElement ele);
	public boolean selectByValue(WebElement element,String value);
	public boolean selectByVisibleText(String visibletext, WebElement ele);
	public String screenShot(WebDriver driver, String filename);

}
