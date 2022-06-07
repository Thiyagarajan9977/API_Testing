package org.test.udmey.gettingstarted;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Automatic_AssertResponseBody_55 {
	
	@org.testng.annotations.Test
	public void validatestatuscode() {
		
		given().baseUri("https://api.postman.com").headers("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-18e52b2287d79e7dffbdf8acf511131811").
		
		when().get("/workspaces").
		
		then().
				log().all().
				assertThat().
				statusCode(200).
				body("workspaces.name", hasItems("Team Workspace", "My Workspace", "TestWorkspace", "myFirstWorkspace", "myFirstWorkspace"),
				"workspaces.type", hasItems("team", "personal", "team", "personal", "personal"),
				"workspaces[0].name", is(equalTo("Team Workspace")),
				"workspaces.size()", equalTo(5));
	}
}
