package com.practice.restfulbooker;

import io.restassured.RestAssured;

public class GetBooking {

	public static void main(String[] args) {
		
		//Build Request
		//RequestSpecification requestSpecification = 
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/{id}")
				.pathParam("id", 1)
		
			//Hit the request and get the response
			.when()
				.get()
			//Validate the response
			.then()
				.log()
				.all()
				.statusCode(200);
		
	}

}
