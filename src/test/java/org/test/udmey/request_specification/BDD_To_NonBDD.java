package org.test.udmey.request_specification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BDD_To_NonBDD {

RequestSpecification requestspecification;
	
	@BeforeClass
	public void beforclass() {		
		requestspecification = given().baseUri("https://api.postman.com/").header("x-api-key",
				"PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").log().all();
	}	

	@org.testng.annotations.Test
	public void Request_Specification_Method() {		
		Response response = requestspecification.get("/workspaces").then().log().all().extract().response();
		assertThat(response.statusCode(), is(equalTo(200)));
	}
	
	public void Response_Specification_Method() {		
		Response response = requestspecification.get("/workspaces").then().log().all().extract().response();
		assertThat(response.statusCode(), is(equalTo(200)));
		assertThat(response.path("workspace[0].name").toString(), equalTo("Team Workspace"));
	}
	
}
