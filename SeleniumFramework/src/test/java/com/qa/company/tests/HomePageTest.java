package com.qa.company.tests;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.company.driver.DriverManager;

public final class HomePageTest extends BaseTest{

	private HomePageTest(){
	}

	@Test
	public void test2(){
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing mini bytes - youtube", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();

		assertThat(title)
		.as("Title is null").isNotNull()
		.as("").containsIgnoringCase("google search")
		.hasSizeBetween(15, 100);

		/*Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.toLowerCase().contains("google search"));
		Assert.assertTrue(title.length()>15);*/

		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));

		assertThat(elements)
		.hasSize(11)
		.extracting(WebElement :: getText)
		.contains("Testing Mini Bytes");

		/*Assert.assertEquals(elements.size(), 11);

		boolean isElementPresent = false;

		for(WebElement e: elements){
			if(e.getText().equalsIgnoreCase("Testing Mini Bytes")){
				isElementPresent = true;
				break;
			}
		}
		Assert.assertTrue(isElementPresent, "Testing Mini Bytes not found");*/
	}



	/*@Test
	public void test3(){
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("API", Keys.ENTER);
	}*/
}
