package com.qa.company.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.qa.company.pages.OpenMRSLoginPage;
import com.qa.company.utils.DataProviderUtilWithJson;

public final class OpenMRSTestWithJSONDataProvider extends BaseTest{
	
	private OpenMRSTestWithJSONDataProvider(){
	}
	
	/*@Test(dataProvider="FetchDataFromJsonArray", dataProviderClass=DataProviderUtilWithJson.class)
	public void loginLogoutTest(Map<String, String> map){
		map.forEach((k,v)->{
		String title  = new OrangeHRMLoginPage()
				.enterUsername(k).enterPassword(v).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
		.as("Title is not mathing").isEqualTo("Login - PHPTRAVELS");
	});
	}*/
	
	@Test(dataProvider="FetchDataFromJsonArray", dataProviderClass=DataProviderUtilWithJson.class)
	public void loginLogoutTest(Map<String, String> map) throws Exception{
		String title  = new OpenMRSLoginPage()
				.enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin()
				.clickAccount().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
		.as("Title is not mathing").isEqualTo("Login");
	}
}
