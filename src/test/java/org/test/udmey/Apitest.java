package org.test.udmey;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
//import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Apitest {
	
	@org.testng.annotations.Test
	public void Apitest() {
		
		given().baseUri("https://api.postman.com/").
		header("x-api-key","PMAK-618ba56a772ecf003cdbcc1b-18e52b2287d79e7dffbdf8acf511131811").
		when().get("./workspaces").
		then().statusCode(200).
				body("name", is(equalTo("")),
						"email",is(equalTo("")));
			
	}

}
