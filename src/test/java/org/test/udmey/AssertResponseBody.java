package org.test.udmey;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class AssertResponseBody {

	@org.testng.annotations.Test
	public void StatusCode() {

		given().baseUri("https://api.postman.com/").

				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-18e52b2287d79e7dffbdf8acf511131811").

				when().get("/workspaces").then().log().all().assertThat().statusCode(200);

	}
	
//This two method to validate the key and value pair
	
	//hasitems
	//equalto
	@org.testng.annotations.Test
	public void Responsebody() {
		
		
		given().baseUri("https://api.postman.com/").

		header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-18e52b2287d79e7dffbdf8acf511131811").

		when().get("/workspaces").then().log().all().assertThat().statusCode(200)
		.body("workspaces.name", hasItems("Team Workspace","My Workspace"),"workspaces.type",hasItems("team","personal"),
				"workspaces[0].name", is(equalTo("Team Workspace")));

	}

}
