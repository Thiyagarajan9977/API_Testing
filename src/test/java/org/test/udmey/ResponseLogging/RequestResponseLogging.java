package org.test.udmey.ResponseLogging;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;

	

public class RequestResponseLogging {
	
//	log().all()
//	log().status()
//	log().body()
//	log().cookies()
//	log().ifValidationFails()
//	log().ifError()
//	log().headers()
	
	
	@org.testng.annotations.Test
	public void LogallMethod() {
		
		System.out.println("***********************LogallMethod****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
				log().all().
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200).log().cookies().body("workspaces.name", contains("Team Workspace", "My Workspace", "TestWorkspace"));	
	}

	@org.testng.annotations.Test
	public void Logheaders() {
		
		System.out.println("***********************Logheaders****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
				log().headers().
		when().get("/workspaces").
		then().log().status()
			  .assertThat()
			  .statusCode(200).body("workspaces.name", contains("Team Workspace", "My Workspace", "TestWorkspace"));	
	}
	
	
	// Given Invalid API Key here for ifvalidationfails condition to check 
	
	@org.testng.annotations.Test
	public void logiferrorMethod() {
		
		System.out.println("***********************logiferrorMethod****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "**ERROR**PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
				log().all().
		when().get("/workspaces").
		then().log().ifError()
			  .assertThat()
			  .statusCode(200).body("workspaces.name", contains("Team Workspace", "My Workspace", "TestWorkspace"));	
	}
	
	
	
	// Given Invalid API Key here for ifvalidationfails condition to check 
	
	@org.testng.annotations.Test
	public void ifValidationFails_Method() {
		
		System.out.println("***********************ifValidationFails_Method****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
				log().ifValidationFails().
		when().get("/workspaces").
		then().log().ifError()
			  .assertThat()
			  .statusCode(205).body("workspaces.name", contains("Team Workspace", "My Workspace", "TestWorkspace"));	
	}
	
	
	
	@org.testng.annotations.Test
	public void BlackListed_Method() {
		
		System.out.println("***********************BlackListed_Method****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
				config(RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeader("x-api-key"))).log().all().
		when().get("/workspaces").
		then().assertThat().statusCode(200).body("workspaces.name", contains("Team Workspace", "My Workspace", "TestWorkspace"));	
	}
	
	
//	Multiple Headers
	
	@org.testng.annotations.Test
	public void Multiple_Header_BlackList_Method() {
		
		Set<String> headers = new HashSet<String>();
		headers.add("x-api-key");
		headers.add("Accept");
		
		
		System.out.println("***********************Multiple_Header_BlackList_Method****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
				config(RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeaders(headers))).log().all().
		when().get("/workspaces").
		then().assertThat().statusCode(200).body("workspaces.name", contains("Team Workspace", "My Workspace", "TestWorkspace"));	
	}
	
	
}
