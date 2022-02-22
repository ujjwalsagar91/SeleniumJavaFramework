package com.qa.company.pages;

import org.openqa.selenium.By;

import com.qa.company.enums.WaitStrategy;
import com.qa.company.utils.DynamicXpathUtils;

public class AmazonHamburgerMenuPage extends BasePage {

	private String linkOptions = "//div[text()='%s']/parent::a";
	private String linkLaptops = "//a[text()='%s']";
	
	public AmazonHamburgerMenuPage clickHamburgerOption(String option) {
		click(By.xpath(DynamicXpathUtils.getXpath(linkOptions, option)), WaitStrategy.CLICKABLE, option);
		return new AmazonHamburgerMenuPage();
	}
	
	public AmazonLaptopPage clickHamburgerSubOption(String subOption) {
		click(By.xpath(DynamicXpathUtils.getXpath(linkLaptops, subOption)), WaitStrategy.CLICKABLE, subOption);
		return new AmazonLaptopPage();
	}
}
