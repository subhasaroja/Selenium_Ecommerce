package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static Properties prop;
public static ThreadLocal<WebDriver> driver= new ThreadLocal<>();;

public static WebDriver getDriver() {
	return driver.get();
}
@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
public void loadConfig() {
	System.out.println("Entering Before Suite");
	ExtentManager.setExtent();
	try {
		prop=new Properties();
		FileInputStream fis=new FileInputStream
				(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		prop.load(fis);
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public void launchApp(String browserName) {
	if(browserName.equalsIgnoreCase("Chrome")){
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
	}else if(browserName.equalsIgnoreCase("FireFox")) {
		WebDriverManager.chromedriver().setup();
		driver.set(new FirefoxDriver());
	}else if(browserName.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver.set(new EdgeDriver());
	}
	getDriver().manage().window().maximize();
	getDriver().manage().deleteAllCookies();
	getDriver().manage().timeouts().implicitlyWait
	(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
	getDriver().manage().timeouts().pageLoadTimeout
	(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeOut"))));
	getDriver().get(prop.getProperty("url"));
}
@AfterSuite(groups = { "Smoke", "Sanity", "Regression" })
public void afterSuite() {
	ExtentManager.endReport();
}
}