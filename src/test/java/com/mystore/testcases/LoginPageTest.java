package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	private LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

	@Test()
	public void verifyLogin() throws Throwable {
		// logger.info("verifyLogin");
		loginPage = new LoginPage();
		Thread.sleep(1000);
		loginPage.clickOnSignIn();
		Thread.sleep(1000);
		loginPage.login("test-j0s1pyd16@srv1.mail-tester.com", "test1234");
	}

}
