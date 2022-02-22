package com.qa.company.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager(){

	}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

	static ExtentTest getExtTest() {
		return extTest.get();
	}

	static void setExtTest(ExtentTest extTestRef) {
		extTest.set(extTestRef);
	}

	static void unload(){
		extTest.remove();
	}

}
