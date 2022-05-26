package com.mystore.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ListenerClass extends ExtentManager implements ITestListener{
	Action action= new Action();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.get().log(Status.PASS, result.getMethod().getMethodName());
			//extent.flush();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			
	extentTest.get().log(Status.FAIL, 
	MarkupHelper.createLabel(result.getMethod().getMethodName() + " - Test Case Failed", ExtentColor.RED));
	extentTest.get().log(Status.FAIL,
	MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	String imgPath = action.screenShot(BaseClass.getDriver(), result.getName());
	extentTest.get().fail("ScreenShot is Attached",MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
	//extent.flush();
	}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}
}
