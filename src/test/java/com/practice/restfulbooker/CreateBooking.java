package com.practice.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBooking {

	public static void main(String[] args) {

		// Build Request
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification = requestSpecification.log().all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking ");

		requestSpecification.body("{\r\n" + "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}");

		requestSpecification.contentType("application/json");

		// Hit the request and get response
		Response response = requestSpecification.post();

		// Validate response
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		/*
		RestAssured
			.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking")
			.body("{\\r\\n\" + \"    \\\"firstname\\\" : \\\"Jim\\\",\\r\\n\" + \"    \\\"lastname\\\" : \\\"Brown\\\",\\r\\n\"\r\n"
					+ "				+ \"    \\\"totalprice\\\" : 111,\\r\\n\" + \"    \\\"depositpaid\\\" : true,\\r\\n\" + \"    \\\"bookingdates\\\" : {\\r\\n\"\r\n"
					+ "				+ \"        \\\"checkin\\\" : \\\"2018-01-01\\\",\\r\\n\" + \"        \\\"checkout\\\" : \\\"2019-01-01\\\"\\r\\n\"\r\n"
					+ "				+ \"    },\\r\\n\" + \"    \\\"additionalneeds\\\" : \\\"Breakfast\\\"\\r\\n\" + \"}")
			.contentType(ContentType.JSON)
			.post()
			.then()
			.log()
			.all()
			.statusCode(200); */
	}

}
