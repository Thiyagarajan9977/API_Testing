package org.test.udmey.gettingstarted;

import static io.restassured.RestAssured.*;

public class Automatic_AssertStatusCode_54 {
	
	@org.testng.annotations.Test
	public void validatestatuscode() {
		given().baseUri("https://api.postman.com").headers("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-18e52b2287d79e7dffbdf8acf511131811")
		.when().get("workspaces").
		then().log().all().assertThat().statusCode(201);
	}
}
