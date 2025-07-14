package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "(//input[@name='email'])[1]")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement loginBotton;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void clickOnSignIn() throws Throwable {
		action.click(getDriver(), signInBtn);
		// return new LoginPage();
	}

	public void login(String uname, String pswd) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), loginBotton);
	}

}
