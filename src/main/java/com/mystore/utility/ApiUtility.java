package com.mystore.utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtility {

	public static Response sendGetRequest(String endPoint) {
		return RestAssured.get(endPoint);
	}

	public static Response sendPostRequest(String endPoint, String payLoad) {
		return RestAssured.given().header("content-type", "application/json").body(payLoad).post();
	}

	public static boolean validateStatusCode(Response response, int statuscode) {
		return response.getStatusCode() == statuscode;
	}

	public static String getJsonvalue(Response response, String value) {
		return response.jsonPath().getString(value);
	}

}
