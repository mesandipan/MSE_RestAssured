package com.practice.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PathParameterExample {

	public static void main(String[] args) {

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.log().all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("{basePath}/{bookingId}");
		requestSpecification.pathParam("basePath", "booking");
		requestSpecification.pathParam("bookingId", 2);

		Response response = requestSpecification.get();
		
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
		System.out.println("Status Code is: " + response.getStatusCode());
	}

}
