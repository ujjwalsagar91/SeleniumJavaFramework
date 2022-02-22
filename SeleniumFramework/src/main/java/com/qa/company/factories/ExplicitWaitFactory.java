package com.qa.company.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.company.constants.FrameworkConstants;
import com.qa.company.driver.DriverManager;
import com.qa.company.enums.WaitStrategy;

public class ExplicitWaitFactory {
	
	public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy){
		
		WebElement element=null;
		
		if(waitStrategy==WaitStrategy.CLICKABLE){
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
			.until(ExpectedConditions.elementToBeClickable(by));
			//new WebDriverWait(DriverManager.getDriver(), 10).until(d->d.findElement(by).isEnabled());
		}
		else if(waitStrategy==WaitStrategy.PRESENCE){
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
			.until(ExpectedConditions.presenceOfElementLocated(by));
			//new WebDriverWait(DriverManager.getDriver(), 10).until(d->d.findElement(by).isEnabled());
		}
		else if(waitStrategy==WaitStrategy.VISIBLE){
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
			.until(ExpectedConditions.visibilityOfElementLocated(by));
			//new WebDriverWait(DriverManager.getDriver(), 10).until(d->d.findElement(by).isEnabled());
		}
		else if(waitStrategy==WaitStrategy.NONE){
			System.out.println("not doing anything");
		}
		return element;
	}
	                                        

}
