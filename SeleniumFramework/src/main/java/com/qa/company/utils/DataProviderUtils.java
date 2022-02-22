package com.qa.company.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.qa.company.constants.FrameworkConstants;

public final class DataProviderUtils {

	@DataProvider()
	public static Object[] getData(Method m) throws IOException {
		String testname = m.getName();

		List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());

		List<Map<String, String>> iterationList = new ArrayList<>();

		for(int i=0; i<list.size(); i++){
			if(list.get(i).get("testName").equalsIgnoreCase(testname) && 
					list.get(i).get("execute").equalsIgnoreCase("yes")) {
				iterationList.add(list.get(i));
			}
		}
		return iterationList.toArray();
	}

}
