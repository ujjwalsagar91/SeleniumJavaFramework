package com.qa.company.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.company.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {
	}

	public static List<Map<String, String>> getTestDetails(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath());
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;

		for(int i=1; i<=rowCount; i++) {
			map = new HashMap<>();
			for(int j=0; j<colCount; j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
			}
			list.add(map);
		}
		return list;
	}

}
