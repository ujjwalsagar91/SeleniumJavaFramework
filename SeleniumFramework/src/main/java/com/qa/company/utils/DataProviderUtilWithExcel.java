package com.qa.company.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.company.constants.FrameworkConstants;

public class DataProviderUtilWithExcel {

	@Test(dataProvider="FetchDataFromExcel")
	public void test2(Map<String, String> map){
		
		map.forEach((k,v)->System.out.println(k+" : "+v));
		
		//System.out.println(map.get("username") + " | " + map.get("password") + " | " + map.get("fname") + " | " + map.get("lname"));
		}
	
	@DataProvider(name="FetchDataFromExcel")
	public Object[] getData() throws IOException{
		FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath());
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		Object[] data= new Object[rowCount];
		Map<String, String> map;
		
		for(int i=0; i<rowCount; i++){
			map = new LinkedHashMap<>();
			for(int j=0;j<colCount;j++){
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i+1).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i]=map;
			}
		}
		return data;
	}
}

