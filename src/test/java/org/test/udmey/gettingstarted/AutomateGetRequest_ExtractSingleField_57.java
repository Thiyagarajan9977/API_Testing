package org.test.udmey.gettingstarted;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AutomateGetRequest_ExtractSingleField_57 {
	
		@org.testng.annotations.Test
		public void validatestatuscode() {
			Response response = given().baseUri("https://api.postman.com").headers("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-18e52b2287d79e7dffbdf8acf511131811")
			.when().get("/workspaces").
			then().log().all().assertThat().statusCode(200).extract().response();
			
			JsonPath jsonpath = new JsonPath(response.asString());
			
			System.out.println("Respsone : " + jsonpath.getString("workspaces[0].name"));			
			System.out.println("Respsone : " + response.path("workspaces[0].name"));
		}

}
