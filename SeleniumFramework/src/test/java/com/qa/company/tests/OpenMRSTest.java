package com.qa.company.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.qa.company.listeners.RetryFailed;
import com.qa.company.pages.OpenMRSLoginPage;
import com.qa.company.utils.DataProviderUtils;

public final class OpenMRSTest extends BaseTest{
	
	private OpenMRSTest(){
	}
	
	@Test()
	public void loginLogoutTest(Map<String, String> map){
		
		String title  = new OpenMRSLoginPage()
				.enterUsername(map.get("username")).enterPassword(map.get("password")).selectRegistration()
				.clickLogin()
				.clickLogout()
				.getTitle();
		Assertions.assertThat(title)
		.as("Title is not mathing").isEqualTo("Login");
		
	}
	
	@Test()
	public void newTest(Map<String, String> map){
		
		String title  = new OpenMRSLoginPage()
				.enterUsername(map.get("username")).enterPassword(map.get("password")).selectRegistration()
				.clickLogin()
				.clickLogout()
				.getTitle();
		Assertions.assertThat(title)
		.as("Title is not mathing").isEqualTo("Inicio de sesión");
		
	}
	
	/*@DataProvider(parallel=true)
	public String[][] getData(){
		return new String[][]{
			{"Admin", "Admin123"},
			{"Admin123", "Admin123"}, 
			{"Admin", "admin123"}
		};
	}*/
}