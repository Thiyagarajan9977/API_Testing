package org.test.udmey.ResponseTypes;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class Post_BDD_Style {
	
	String payload = "{\r\n" + 
			"	\"workspace\" : {\r\n" + 
			"	\"name\" : \"mythirdWorkspace\",\r\n" + 
			"	\"type\" : \"personalTraining\",\r\n" + 
			"	\"description\" : \"RestAssured Created\"\r\n" + 
			"	}\r\n" + 
			"}";
	
	@BeforeClass
	public void beforclass() {
						
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
		setBaseUri("https://api.postman.com/").
		addHeader("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		setContentType(ContentType.JSON).
		log(LogDetail.ALL);
	
		RestAssured.requestSpecification = requestSpecBuilder.build();	
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType(ContentType.JSON).
				log(LogDetail.ALL);		
				
		RestAssured.responseSpecification = responseSpecBuilder.build();
	}
	
	
	@Test
	public void validate_post_request_bdd_style() {
		given().body(payload).		
		when().
		post("/workspaces").
		then().
		assertThat().
		body("workspace.name", equalTo("mythirdWorkspace"),"workspace.id", matchesPattern("^[a-z0-9-]{36}$"));
	}
}
