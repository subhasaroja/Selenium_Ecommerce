package com.mystore.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	public static void setExtent() {
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/test-output/ExtentReport/"+"MyReport.html");
		try {
			String xmlPath=System.getProperty("user.dir")+"/extent-config.xml";
			System.out.println(xmlPath);
			reporter.loadXMLConfig(xmlPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "MyStoreProject");
		extent.setSystemInfo("Tester", "Subha");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
	public static void endReport() {
		extent.flush();
	}
}
