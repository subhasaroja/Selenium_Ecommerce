package com.mystore.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.mystore.actioninterface.ActionInterface;

public class Action implements ActionInterface{

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement ele) {
      boolean flag=false;
      //flag=findElement(driver,ele);
     
    	  flag=ele.isDisplayed();
    	  if(flag) {
    		  System.out.println("Element is Displayed");
    	  }else {
    		  System.out.println("Element is not Displayed ");
    	  }
    

		return flag;
	}

	@Override
	public String getTitle(WebDriver driver) {
		String text=driver.getTitle();
		return text;
	}

	@Override
	public void click(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		
	}

	@Override
	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		Wait<WebDriver> wait=null;
		try {
			wait=new FluentWait<WebDriver>(driver).
					withTimeout(Duration.ofSeconds(20)).
					pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public boolean type(WebElement ele, String text) {
		boolean flag=false;
		try {
			flag=ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag=true;
		}catch(Exception e) {
			System.out.println("Location not found");
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Successfully entered value");
			}else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}

	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView", ele);
		
	}
	@Override
	public String getCurrentURL(WebDriver driver)  {
		String text = driver.getCurrentUrl();
		System.out.println("Current URL is: \""+text+"\"");
		return text;
	}

	@Override
	public boolean JSClick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}

	@Override
	public boolean selectByValue(WebElement element, String value) {
		boolean flag=false;
		try {
			Select select=new Select(element);
			select.selectByValue(value);
			flag=true;
		}catch(Exception e) {
			return false;
		}finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
		return flag;
	}


	@Override
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}

	@Override
	public String screenShot(WebDriver driver, String filename) {
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir") + "\\target\\test-output\\ScreenShots\\"+
				filename+"_"+dateName+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return destination;
	}
}
