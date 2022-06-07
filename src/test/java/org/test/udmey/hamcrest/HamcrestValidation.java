package org.test.udmey.hamcrest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.Collections;

import org.junit.Test;

import io.restassured.response.ValidatableResponse;

public class HamcrestValidation {
	
	
	// To validate in collection all are present or not by using contains method
	// if the order may change or missing means, assertion getting fail
	
	//***************** Contains**********************
	
	@org.testng.annotations.Test
	public void containsMethod() {
		
		System.out.println("***********************Contains****************************");

		ValidatableResponse statusCode = given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200);
		ValidatableResponse body = statusCode.body("workspaces.name", contains("Team Workspace", "My Workspace", "TestWorkspace"));
		System.out.println(body.assertThat());		
	}
	
	//***************** ContainsInanyOrder**********************
	
	// To validate in collection all are present or not by using containsanyorder method
	// if the order may it will accept, if it is missing means, assertion getting fail
	
	@org.testng.annotations.Test
	public void ContainsInanyOrder() {
		
		System.out.println("***********************ContainsInanyOrder****************************");

		ValidatableResponse statusCode = given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200);
		ValidatableResponse body = statusCode.body("workspaces.name", containsInAnyOrder("Team Workspace", "TestWorkspace","My Workspace"));		
	
		System.out.println(body);
	
	}
	
	@org.testng.annotations.Test
	public void emptyMethod() {
		
		System.out.println("***********************IsEmpty****************************");

		ValidatableResponse body = given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200)
			  .body("workspaces.name", empty());
		
		System.out.println("");
	
	}
	
	@org.testng.annotations.Test
	public void isNotemptyMethod() {
		
		System.out.println("***********************IsNotEmpty****************************");

		ValidatableResponse statusCode = given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200).body("workspaces.name", is(not(empty())));
		
		System.out.println("");
	
	}
	
	@org.testng.annotations.Test
	public void isNotemptyarrayMethod() {
		
		System.out.println("***********************IsNotEmptyarrayMethod****************************");

		ValidatableResponse statusCode = given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200).body("workspaces.name", is(not(emptyArray())));
		
		System.out.println("");
	
	}
	
	@org.testng.annotations.Test
	public void hasSizeMethod() {
		
		System.out.println("***********************hasSizeMethod****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200).body("workspaces.name", hasSize(3));
		
		System.out.println("");	
	}
	
	
	@org.testng.annotations.Test
	public void everyItemStartswithMethod() {
		
		System.out.println("***********************everyItemStartswithMethod****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200).body("workspaces.name", everyItem(startsWith("My")));
		}
	
	// To find the only key in collection
	
	@org.testng.annotations.Test
	public void haskeymethod() {
		
		System.out.println("***********************haskeymethod****************************");

		ValidatableResponse statusCode = given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200);
		ValidatableResponse body = statusCode.body("workspaces[2]", hasKey("id"));
		}
	
	@org.testng.annotations.Test
	public void hasvalueMethod() {
		
		System.out.println("***********************hasvalueMethod****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200).body("workspaces[1].name", hasValue("My Workspace"));
		}
	
	@org.testng.annotations.Test
	public void hasentryMethod() {
		
		System.out.println("***********************hasentryMethod****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200).body("workspaces[1]", hasEntry("type", "personal"));
		}
	
	
	//Expected: <{}> collection Method
	@org.testng.annotations.Test
	public void equalToCollectionsEMPTY_MAPMethod() {
		
		System.out.println("***********************equalToCollectionsEMPTY_MAPMethod****************************");

		given().baseUri("https://api.postman.com/").
				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("/workspaces").
		then().log().all()
			  .assertThat()
			  .statusCode(200).body("workspaces[0]", equalTo(Collections.EMPTY_MAP));
		}
	
	//Collection Not Empty Method
	
		@org.testng.annotations.Test
		public void equalToCollectionsNotEMPTY_MAPMethod() {
			
			System.out.println("***********************equalToCollectionsNotEMPTY_MAPMethod****************************");

			given().baseUri("https://api.postman.com/").
					header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
			when().get("/workspaces").
			then().log().all()
				  .assertThat()
				  .statusCode(200).body("workspaces[0]", not(equalTo(Collections.EMPTY_MAP)));
			}
		
		@org.testng.annotations.Test
		public void alloffMethod() {
			
			System.out.println("***********************alloffMethod****************************");

			given().baseUri("https://api.postman.com/").
					header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
			when().get("/workspaces").
			then().log().all()
				  .assertThat()
				  .statusCode(200).body("workspaces[0].id", allOf(startsWith("cccb2518"), containsString("cccb2518-5a2d-4171-893f-1b89ebbba0c2")));
			}
		
		
		@org.testng.annotations.Test
		public void anyoffMethod() {
			
			System.out.println("***********************anyoffMethod****************************");

			given().baseUri("https://api.postman.com/").
					header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
			when().get("/workspaces").
			then().log().all()
				  .assertThat()
				  .statusCode(200).body("workspaces[0].id", anyOf(startsWith("cccb258"), containsString("cccb2518-5a2d-4171-893f-1b89ebbba0c2")));
			}	
}