package org.test.udmey;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.response.Response;

public class ExtractResponse {
	
	
	//This code is generate the response and we can take from consel
	
	// .extract().response();
	
	
	
	@org.testng.annotations.Test
	public void StatusCode() {

		Response response = given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().
				get("/workspaces").
		
		then().assertThat()
			  .statusCode(200).extract().response();
		
		System.out.println("response.........." +response.asString());

	}
	

}
