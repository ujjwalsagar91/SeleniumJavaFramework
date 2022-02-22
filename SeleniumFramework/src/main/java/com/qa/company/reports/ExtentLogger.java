package com.qa.company.reports;

import org.openqa.selenium.OutputType;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.company.driver.DriverManager;
import com.qa.company.enums.ConfigProperties;
import com.qa.company.utils.PropertyUtils;
import com.qa.company.utils.ScreenshotUtils;

import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {

	private ExtentLogger(){

	}

	public static void pass(String message){
		ExtentManager.getExtTest().pass(message);
	}

	public static void fail(String message){
		ExtentManager.getExtTest().fail(message);
	}

	public static void skip(String message){
		ExtentManager.getExtTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) throws Exception{
		if(PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
		{
			ExtentManager.getExtTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else{
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) throws Exception{
		if(PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
		{
			ExtentManager.getExtTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else{
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) throws Exception{
		if(PropertyUtils.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
		{
			ExtentManager.getExtTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else{
			skip(message);
		}
	}
}
