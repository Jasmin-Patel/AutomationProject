package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author Hitendra: ExtentManager class is used for Extent Report
 * 
 */
public class ExtentManager {

	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static ExtentReports getReporter() {
		// htmlReporter= new
		// ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		String reportPath = (System.getProperty("user.dir") + "/ExtentReport/" + "MyReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		// htmlReporter.loadXMLConfig(System.getProperty("user.dir") +
		// "/extent-config.xml");
		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setReportName("Test Automation Report");
		spark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		// extent.attachReporter(spark);

		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "MyStoreProject");
		extent.setSystemInfo("Tester", "ABC");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");

		return extent;
	}

	public static ExtentTest startTest(String testName) {
		ExtentTest extentTest = getReporter().createTest(testName);
		test.set(extentTest);
		return extentTest;
	}

	public static void endTest() {
		getReporter().flush();
	}

	public static ExtentTest getTest() {
		return test.get();
	}
}
