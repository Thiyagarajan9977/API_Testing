package org.test.udmey.request_specification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Request_Spec_Builder {
	
	RequestSpecification requestspecification;
	
	
	// RequestSpecification to avoid the repeated writting
	// should use the logdetail
	// We can add the dummy Header data as well
	// both given().spec(ABC) or given(ABC) both are accepting
	// Method chaining also accept this concept
	
	// Below Example Method chaining concept also working fine 
	
		/*	RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
			.setBaseUri().addHeader().Log()  
		*/	
	
	
	@BeforeClass
	public void beforclass() {
		
		//requestspecification = given().baseUri("https://api.postman.com/").header("x-api-key",
			//	"PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").log().all();
		
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://api.postman.com/");
		requestSpecBuilder.addHeader("x-api-key",
				"PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec");
		requestSpecBuilder.log(LogDetail.ALL);
	
		requestspecification = requestSpecBuilder.build();		
	}
		
	@org.testng.annotations.Test
	public void Request_Specification_Method() {
		
			
		Response response = given().spec(requestspecification).header("dummy1","dummy2").get("/workspaces").then().log().all().extract().response();
		assertThat(response.statusCode(), is(equalTo(200)));
	}
	
	public void Response_Specification_Method() {		
		Response response = given().spec(requestspecification).get("/workspaces").then().log().all().extract().response();
		assertThat(response.statusCode(), is(equalTo(200)));
		assertThat(response.path("workspace[0].name").toString(), equalTo("Team Workspace"));
	}
}
