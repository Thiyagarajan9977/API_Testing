package org.test.udmey.Response_Specification;

import static io.restassured.RestAssured.get;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class Default_Response_Specification {
	
	@BeforeClass
	public void beforclass() {
		
		/*requestSpecification = given().
				baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
				log().all();*/
				
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://api.postman.com/");
		requestSpecBuilder.addHeader("x-api-key",
				"PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec");
		requestSpecBuilder.log(LogDetail.ALL);
	
		RestAssured.requestSpecification = requestSpecBuilder.build();	
		
	/*	responseSpecification = RestAssured.expect().
								statusCode(200).
								contentType(ContentType.JSON).
								log().all();*/
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType(ContentType.JSON).
				log(LogDetail.ALL);				
				
		RestAssured.responseSpecification = responseSpecBuilder.build();
	}
	
	@Test
	public void validate_status_code() {
		get("/workspaces");

	}
	
	
	public void Validate_Response_Body() {
		Response response = get("/workspaces").then().extract().response();
		assertThat(response.path("workspaces[0].name").toString(), equalTo("Team Workspace"));		
		
	}
	

}
