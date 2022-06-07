package org.test.udmey.Response_Specification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class Response_Specification {
	
	ResponseSpecification responseSpecification;	
	
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
		
		responseSpecification = RestAssured.expect().
								statusCode(200).
								contentType(ContentType.JSON).
								log().all();
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType(ContentType.JSON).
				log(LogDetail.ALL);				
				
		responseSpecification = responseSpecBuilder.build();
	}
	
	@Test
	public void validate_status_code() {
		get("/workspaces").then().spec(responseSpecification);

	}		
}
