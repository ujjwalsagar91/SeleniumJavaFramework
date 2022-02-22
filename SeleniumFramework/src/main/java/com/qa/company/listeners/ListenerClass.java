package com.qa.company.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.company.reports.ExtentLogger;
import com.qa.company.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onFinish(ISuite arg0) {
		try {
			ExtentReport.flushReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(ISuite arg0) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ITestContext arg0) {

	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");

	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
	}

}
