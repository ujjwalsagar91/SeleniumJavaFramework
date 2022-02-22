package com.qa.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.company.enums.WaitStrategy;
import com.qa.company.factories.ExplicitWaitFactory;
import com.qa.company.reports.ExtentLogger;

public class BasePage {

	protected BasePage(){

	}

	protected void click(By by, WaitStrategy waitStrategy, String elementName){
		WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
		element.click();
		try {
			ExtentLogger.pass(elementName + " is clicked", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void sendKeys(By by, WaitStrategy waitStrategy, String value, String elementName){
		WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value + " entered in " + elementName, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}