package org.test.udmey.request_specification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;

public class Default_Specification {
	
	@BeforeClass
	public void beforclass() {
		
		//requestspecification = given().baseUri("https://api.postman.com/").header("x-api-key",
			//	"PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").log().all();
		
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://api.postman.com/");
		requestSpecBuilder.addHeader("x-api-key",
				"PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec");
		requestSpecBuilder.log(LogDetail.ALL);
	
		RestAssured.requestSpecification = requestSpecBuilder.build();		
	}
		
	@org.testng.annotations.Test
	public void Request_Specification_Method() {
		
			
		Response response = get("/workspaces").then().log().all().extract().response();
		assertThat(response.statusCode(), is(equalTo(200)));
	}
	
	public void Response_Specification_Method() {		
		Response response = get("/workspaces").then().log().all().extract().response();
		assertThat(response.statusCode(), is(equalTo(200)));
		assertThat(response.path("workspace[0].name").toString(), equalTo("Team Workspace"));
	}

}
