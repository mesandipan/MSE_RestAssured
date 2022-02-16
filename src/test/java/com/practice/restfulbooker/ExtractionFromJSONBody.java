package com.practice.restfulbooker;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ExtractionFromJSONBody {

	public static void main(String[] args) {

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://jsonplaceholder.typicode.com/");
		requestSpecification.basePath("/users");

		Response response = requestSpecification.get();

		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
		System.out.println("Status code is: " + response.getStatusCode());

		JsonPath jsonPath = response.jsonPath();

		// List of ID from the response
		System.out.println("ID : \n" + jsonPath.get("id"));

		// Count the number of records in the response
		List<String> noOfRecords = jsonPath.getList("$");
		System.out.println("Total no of records: " + noOfRecords.size());

		// Print all the city name from the response
		String str = response.asString();
		JSONArray jsonArray = new JSONArray(str);
		System.out.println("Below are all the city names: ");
		for (int i = 0; i < jsonArray.length(); i++) {

			JSONObject jsonObj = (JSONObject) jsonArray.get(i);
			JSONObject jsonBodyAddress = (JSONObject) jsonObj.get("address");
			JSONObject jsonBodyGeo = (JSONObject) jsonBodyAddress.get("geo");
			System.out.println(jsonBodyAddress.get("city"));
			System.out.println("Lalitude is: " + jsonBodyGeo.get("lat"));

		}
	}

}
