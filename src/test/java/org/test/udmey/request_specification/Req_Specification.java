package org.test.udmey.request_specification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;

import io.restassured.specification.RequestSpecification;

public class Req_Specification {
	
	RequestSpecification requestspecification;
	
	// Simple Request Specification
	
	@BeforeClass
	public void beforclass() {
		
		requestspecification = given().baseUri("https://api.postman.com/").header("x-api-key",
				"PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").log().all();
	}
	

	@org.testng.annotations.Test
	public void Req_Specification_Method() {
				
		System.out.println("***************RequestSpecification*******************");
		given(requestspecification).log().all().
		when().get("/workspaces").
		then().log().all().assertThat().statusCode(200);

	}
}
