package com.qa.company.listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.qa.company.constants.FrameworkConstants;
import com.qa.company.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<Map<String, String>> testList = null;
		List<IMethodInstance> results = null;

		try {
			testList = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagerDataSheet());
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		results = new ArrayList<>();

		for(int i=0; i<methods.size();i++) {
			for(int j=0; j<testList.size(); j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(testList.get(j).get("testName")) &&
					testList.get(j).get("execute").equalsIgnoreCase("yes")) {
						methods.get(i).getMethod().setDescription((testList.get(j).get("testDescription")));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(testList.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(testList.get(j).get("priority")));
						results.add(methods.get(i));
				}

			}
		}
		return results;
	}
}
