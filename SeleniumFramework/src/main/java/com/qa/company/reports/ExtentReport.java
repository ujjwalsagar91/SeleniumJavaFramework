package com.qa.company.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.company.constants.FrameworkConstants;

public final class ExtentReport {

	private ExtentReport(){

	}

	private static ExtentReports extent;
	public static ExtentTest test;

	@Test
	public static void initReports() throws Exception{
		if(Objects.isNull(extent)){
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());

			extent.attachReporter(spark);

			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("My Extent Report");
			spark.config().setReportName("Testing Extent Report");
		}
	}

	public static void flushReports() throws Exception{
		if(Objects.nonNull(extent)){
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());

	}

	public static void createTest(String testcaseName){
		ExtentManager.setExtTest(extent.createTest(testcaseName));
	}
}
