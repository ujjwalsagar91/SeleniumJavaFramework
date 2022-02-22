package com.qa.company.pages;

import org.openqa.selenium.By;

import com.qa.company.enums.WaitStrategy;

public class OpenMRSHomePage extends BasePage {

	private final By linkaccount = By.xpath("//*[contains(text(),'admin')]");
	
	private final By linklogout = By.xpath("//i[contains(@class,'signout')]");
	
	public OpenMRSHomePage clickAccount() throws Exception{
		click(linkaccount, WaitStrategy.CLICKABLE, "Account");
		return this;
	}
	
	public OpenMRSLoginPage clickLogout() {
		//new WebDriverWait(DriverManager.getDriver(), 10).until(d->d.findElement(linklogout).isEnabled()); Java 8
		//new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(linklogout)); //old
		click(linklogout, WaitStrategy.CLICKABLE, "Logout button");
		return new OpenMRSLoginPage();
	}
	
}
