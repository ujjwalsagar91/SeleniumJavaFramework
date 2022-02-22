package com.qa.company.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qa.company.enums.ConfigProperties;
import com.qa.company.utils.PropertyUtils;

public class RetryFailed implements IRetryAnalyzer{

	private int count=0;
	private int retry=1;

	@Override
	public boolean retry(ITestResult result) {
		try {
			if(PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")){
				if(count<retry) {
					count++;
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
