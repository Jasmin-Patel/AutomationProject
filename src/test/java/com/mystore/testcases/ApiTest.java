package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.utility.ApiUtility;

import io.restassured.response.Response;

public class ApiTest {

	@Test()
	public void verifyGetUserAPI() {
		// Step 1
		String endPoint = "https://jsonplaceholder.typicode.com/users";
		System.out.println("API endpoint: " + endPoint);

		// Step 2
		System.out.println("Sending GET Request");
		Response response = ApiUtility.sendGetRequest(endPoint);

		// Step 3
		System.out.println("Validating API Response");
		boolean isStatusCodeValid = ApiUtility.validateStatusCode(response, 200);

		Assert.assertTrue(isStatusCodeValid, "Status Code is not as Expected");

		if (isStatusCodeValid) {
			System.out.println("Status Code Validation Passed!");
		}

		// Step 4
		String userName = ApiUtility.getJsonvalue(response, "username");
		System.out.println("User Name: " + userName);
		boolean isUserNameValid = userName.contains("Bret");
		Assert.assertTrue(isUserNameValid, "User Name is not Valid");

		if (isUserNameValid) {
			System.out.println("User Name is Valid!");
		}
	}

}
