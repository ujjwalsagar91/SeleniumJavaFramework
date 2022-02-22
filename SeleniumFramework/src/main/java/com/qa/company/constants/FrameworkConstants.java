package com.qa.company.constants;

import com.qa.company.enums.ConfigProperties;
import com.qa.company.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants(){

	}

	private static final int EXPLICITWAIT = 10;
	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources/";
	private static final String CHROMEDRIVEPATH = RESOURCESPATH + "executables/chromedriver.exe";
	private static final String GECKODRIVEPATH = RESOURCESPATH + "executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "config/config.properties";
	private static final String EXCELPATH = RESOURCESPATH + "config/testdata.xlsx";
	private static final String SIMPLEDATAJSONPATH = RESOURCESPATH + "config/simpledatajson.json";
	private static final String ARRAYDATAJSONPATH = RESOURCESPATH + "config/arrayOfJson.json";
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-test-output";
	private static String GETREPORTFILEPATH = "";
	private static final String RUNMANAGERDATASHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}


	public static String getRunmanagerDataSheet() {
		return RUNMANAGERDATASHEET;
	}


	public static String getExtentReportFilePath() throws Exception {
		if(GETREPORTFILEPATH.isEmpty()) {
			GETREPORTFILEPATH = createReportpath();
		}
		return GETREPORTFILEPATH;
	}


	public static String createReportpath() throws Exception {
		if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORT).equalsIgnoreCase("no")){
			return EXTENTREPORTPATH + "/" + System.currentTimeMillis() + "/index.html";
		}
		else {
			return EXTENTREPORTPATH + "/index.html";
		}
	}

	public static String getSimpledatajsonpath() {
		return SIMPLEDATAJSONPATH;
	}

	public static String getArraydatajsonpath() {
		return ARRAYDATAJSONPATH;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVEPATH;
	}

	public static String getGeckoDriverPath() {
		return GECKODRIVEPATH;
	}

}
