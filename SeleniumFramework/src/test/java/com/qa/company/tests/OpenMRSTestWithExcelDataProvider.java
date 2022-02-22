package com.qa.company.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.qa.company.pages.OpenMRSLoginPage;
import com.qa.company.utils.DataProviderUtilWithExcel;

public final class OpenMRSTestWithExcelDataProvider extends BaseTest{
	
	private OpenMRSTestWithExcelDataProvider(){
	}
	
	@Test(dataProvider="FetchDataFromExcel", dataProviderClass=DataProviderUtilWithExcel.class)
	public void loginLogoutTest(Map<String, String> map) throws Exception{
		String title  = new OpenMRSLoginPage()
				.enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin()
				.clickAccount().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
		.as("Title is not mathing").isEqualTo("Login");
		
	}
}
