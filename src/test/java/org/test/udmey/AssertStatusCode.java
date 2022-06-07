package org.test.udmey;

import static io.restassured.RestAssured.*;

import org.junit.Test;

public class AssertStatusCode {
	
	//
	
	@org.testng.annotations.Test
	public void StatusCode() {
		
	given().baseUri("https://api.postman.com/").
		
		header("x-api-key","PMAK-618ba56a772ecf003cdbcc1b-18e52b2287d79e7dffbdf8acf511131811").
		
	when().get("/workspaces").
	then().log().all().assertThat()
		  .statusCode(200);
	}
}
