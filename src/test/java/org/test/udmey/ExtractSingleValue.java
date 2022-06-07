package org.test.udmey;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractSingleValue {

	@org.testng.annotations.Test
	public void firstwaygettingValue() {

		Response response = given().baseUri("https://api.postman.com/").

				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").

				when().get("/workspaces").

				then().assertThat().statusCode(200).extract().response();

		// by getting Jsonpath class to get the response string

		JsonPath jsonpath = new JsonPath(response.asString());

		System.out.println("First way of getting value from as String.........." + response.path("workspaces.type"));
	}

	@org.testng.annotations.Test
	public void secondwaygettingValue() {

		Response response = given().baseUri("https://api.postman.com/").

				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").

				when().get("/workspaces").

				then().assertThat().statusCode(200).extract().response();

		// by getting Jsonpath class to get the response string

		JsonPath jsonpath = new JsonPath(response.asString());

		System.out.println("Second way of getting Response....." + jsonpath.getString("workspaces.id"));

	}

	@org.testng.annotations.Test
	public void Thirdwaygettingvalue() {

		// by declaring a object as String

		String three = given().baseUri("https://api.postman.com/").

				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").

				when().get("/workspaces").

				then().assertThat().statusCode(200).extract().response().path("workspaces[0].id");

		System.out.println("third way of getting value by giving path.....:" +three);

	}

	@org.testng.annotations.Test
	public void fourthwaygettingvalue() {

		// by declaring a object as String

		String response = given().baseUri("https://api.postman.com/").

				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").

				when().get("/workspaces").

				then().assertThat().statusCode(200).extract().response().asString();

		System.out.println(
				"fourth way of getting value from JSON File........: " + JsonPath.from(response).getString("workspaces[0].name"));

	}

}
