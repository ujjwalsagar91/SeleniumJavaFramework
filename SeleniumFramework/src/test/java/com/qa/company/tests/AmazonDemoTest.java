package com.qa.company.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.qa.company.pages.AmazonHomePage;

public class AmazonDemoTest extends BaseTest {
	
	@Test
	public void amazonDemoTest(Map<String, String> map) {
		String title = new AmazonHomePage().clickHamburger().clickHamburgerOption(map.get("menuOption")).clickHamburgerSubOption(map.get("subMenuOption")).getTitleValue();
		Assertions.assertThat(title).isEqualTo("Laptop Prices in India: Buy Laptops Online at Low Prices | Windows, Mac, DOS Laptops - Amazon.in");
	}

}
