package org.test.udmey.gettingstarted;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;


public class HamcrestAssertion_Extracted_Response_58 {
	
	@org.testng.annotations.Test
	public void validatestatuscode() {
String response = given().
					baseUri("https://api.postman.com").
					headers("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-18e52b2287d79e7dffbdf8acf511131811").
					when().
					get("/workspaces").
					then().
					assertThat().
					statusCode(200).
					extract().
					response().path("workspaces[0].name");				
		
		assertThat(response, equalTo("Team Workspace"));		
		Assert.assertEquals(response, "Team Workspace");		
		
//		JsonPath jsonpath = new JsonPath(response.toString());
//						
//		System.out.println("Respsone : " + ("workspaces[0].name"));		
		
	}
}
