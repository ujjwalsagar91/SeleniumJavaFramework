package com.qa.company.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.company.driver.Driver;

public class BaseTest {

	protected BaseTest(){
	}
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setup(Object data[]) throws Exception{
		Map<String, String> map = (Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"));
	}

	@AfterMethod
	protected void teardown(){
		Driver.quitDriver();
	}
}
