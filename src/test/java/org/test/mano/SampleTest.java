package org.test.mano;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class SampleTest {
	
	public static void main(String[] args) {
		
		// Maintain the BaseURI of the application
		
		RestAssured.baseURI="https://reqres.in/"; 
				
		System.out.println("**********************GET*****************");
		
	/*	// Old way	
		RequestSpecification given = RestAssured.given();
		given.header("Content-Type","application/json");
		given.queryParam("page", "2");
		Response reget = given.when().get("api/users");
		
		// ResponseBody
		ResponseBody body = reget.getBody();
		System.out.println(body);
		
		//ResponseCode or Statuscode
		int statusCode = reget.statusCode();
		System.out.println(statusCode);
	*/		
		// *******New Way to Write******

		// get
		
		Response reget = RestAssured.given().header("Content-Type","application/json").queryParam("page", "2").when().get("api/users");		
		
		// ResponseBody
		ResponseBody body = reget.getBody();
		System.out.println(body.asString());
		
		//ResponseCode or Statuscode 
		
		int statusCode = reget.statusCode();
		System.out.println(statusCode);
		
		System.out.println("***************post******************");
		
		//POST
		
		Response repost = RestAssured.given().header("Content-Type","application/json")
		.body("{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"pistol\"\r\n" + 
				"}").when().post("api/register");
		
		// ResponseBody
		String poststring = repost.getBody().asString();
		System.out.println(poststring);
		
		//RespondeCode
		int poststatus = repost.getStatusCode();
		System.out.println(poststatus);
		
		
		System.out.println("***************put******************");
		//Put
		
		Response reput = RestAssured.given().header("Content-Type","application/json")
		.body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}").when().put("api/users/2");
		
		//ResponseBody
		
		String putString = reput.getBody().asString();
		System.out.println(putString);
		
		//getStatusCode
		
		int putstatusCode = reput.getStatusCode();
		System.out.println(putstatusCode);
		
		System.out.println("***************delete******************");
		
		// Delete
		
		Response redelete = RestAssured.given().header("Content-Type","application/json").when().delete("api/users/2");
		
		String deleteString = redelete.getBody().asString();
		System.out.println(deleteString);
		
		int deletestatusCode = redelete.getStatusCode();
		System.out.println(deletestatusCode);
		
		
	} 
}
