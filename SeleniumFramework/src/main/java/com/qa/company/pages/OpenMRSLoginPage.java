package com.qa.company.pages;

import org.openqa.selenium.By;

import com.qa.company.driver.DriverManager;
import com.qa.company.enums.WaitStrategy;

public final class OpenMRSLoginPage extends BasePage{

	private final By textboxusername = By.id("username");
	private final By textboxpassword = By.id("password");
	private final By buttonlogin = By.id("loginButton");
	private final By buttonRegistration = By.xpath("//ul[@id='sessionLocation']/li[.='Registration Desk']");
	
	
	public OpenMRSLoginPage enterUsername(String username) {
		sendKeys(textboxusername, WaitStrategy.PRESENCE, username, "Username");
		return this;
	}
	
	public OpenMRSLoginPage enterPassword(String password) {
		sendKeys(textboxpassword, WaitStrategy.PRESENCE, password, "Password");
		return this;
	}
	
	public OpenMRSLoginPage selectRegistration() {
		click(buttonRegistration, WaitStrategy.CLICKABLE, "Registration button");
		return this;
	}
	
	public OpenMRSHomePage clickLogin() {
		click(buttonlogin, WaitStrategy.CLICKABLE, "Login");
		return new OpenMRSHomePage();
	}
	
	public String getTitle(){
		return DriverManager.getDriver().getTitle();
	}
	
}
