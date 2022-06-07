package org.test.udmey.gettingstarted;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class Automatic_GetRequest_ExtractResponse_56 {
	
	@org.testng.annotations.Test
	public void validatestatuscode() {
		Response response = given().baseUri("https://api.postman.com").headers("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-18e52b2287d79e7dffbdf8acf511131811")
		.when().get("workspaces").
		then().log().all().assertThat().statusCode(200).extract().response();
		
		System.out.println("response = " +response.asString());
	}
}
