package org.test.udmey.automate_headers;

import org.junit.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

public class Automate_Headers {
	
	@org.testng.annotations.Test
	public void Response_multipleheader() {
		
		Header header = new Header("header", "value2");
		Header matchheader = new Header("x-mock-match-request-headers", "header");
		
		System.out.println("************multipleheader*******************");
		
		given().baseUri("https://9f987fe6-2037-4571-8c18-7d549da8dbf6.mock.pstmn.io").
		header(header).
		header(matchheader).
		
		when().get("/get").
		then().log().all().assertThat().statusCode(200);
	}
	
	@org.testng.annotations.Test
	public void Response_multiple_Headers() {
		
		Header header = new Header("header", "value2");
		Header matchheader = new Header("x-mock-match-request-headers", "header");
		
		// This is the new method in Headers to run the script 
		
		Headers head = new Headers(header, matchheader);
		
		System.out.println("************multiple_Headers*******************");
		
		given().baseUri("https://9f987fe6-2037-4571-8c18-7d549da8dbf6.mock.pstmn.io").
			   headers(head).	
		
		when().get("/get").
		
		then().log().all().assertThat().statusCode(200);
	}
	
	
	@org.testng.annotations.Test
	public void Response_multiple_Headers_usingHashmap() {
		
		HashMap<String, String> head = new HashMap<String, String>();
		head.put("header", "value2");
		head.put("x-mock-match-request-headers", "header");
		
		// This is the new method in Headers to run the script		
		
		System.out.println("************multiple_Headers_usingHashmap*******************");
		
		given().baseUri("https://9f987fe6-2037-4571-8c18-7d549da8dbf6.mock.pstmn.io").
			   headers(head).	
		
		when().get("/get").
		
		then().log().all().assertThat().statusCode(200);
	}
	
	
	//***************************Response Header Assert Validation************************
	
	@org.testng.annotations.Test
	public void Response_Headers_Assert_validation_1() {
		
		HashMap<String, String> head = new HashMap<String, String>();
		head.put("header", "value2");
		head.put("x-mock-match-request-headers", "header");
		
		// This is the new method in Headers to run the script		
		
		System.out.println("************Headers_Assert_validation_1*******************");
		
		given().baseUri("https://9f987fe6-2037-4571-8c18-7d549da8dbf6.mock.pstmn.io").
			   headers(head).	
		
		when().get("/get").
		
		then().log().all().assertThat().statusCode(200).
		
		// The Key and value taken from postman header response  
		
				header("headervalue1", "resvalue1").
				header("responseheader", "resvalue1");							
	}
	
	@org.testng.annotations.Test
	public void Response_Headers_Assert_validation_2() {
		
		HashMap<String, String> head = new HashMap<String, String>();
		head.put("header", "value2");
		head.put("x-mock-match-request-headers", "header");
		
		// This is the new method in Headers to run the script		
		
		System.out.println("************Response_Headers_Assert_validation_2*******************");
		
		given().baseUri("https://9f987fe6-2037-4571-8c18-7d549da8dbf6.mock.pstmn.io").
			   headers(head).	
		
		when().get("/get").
		
		then().log().all().assertThat().statusCode(200).
		
//		The Key and value taken from postman header response 
		
				headers("headervalue1", "resvalue1","responseheader", "resvalue2");				
	}
	
	
	@org.testng.annotations.Test
	public void Response_Header_Extract() {
		
		HashMap<String, String> head = new HashMap<String, String>();
		head.put("header", "value2");
		head.put("x-mock-match-request-headers", "header");
		
		// To Extract the Response Header Validation
		
		System.out.println("************Response_Header_Extract*******************");
		
		Headers extractheaders = given().baseUri("https://9f987fe6-2037-4571-8c18-7d549da8dbf6.mock.pstmn.io").
			   headers(head).	
		
		when().get("/get").
		
		then().assertThat().statusCode(200)	
			  .extract().headers();
		
		System.out.println("Respone Header name is...:" +extractheaders.get("responseheader").getName());
		System.out.println("Respone Header value is...:" +extractheaders.get("responseheader").getValue());
		System.out.println("Respone Header value......:"+ extractheaders.getValue("responseheader"));				
	}
	
	
	
	@org.testng.annotations.Test
	public void Response_Header_Extract_usingforloop() {
		
		HashMap<String, String> head = new HashMap<String, String>();
		head.put("header", "value2");
		head.put("x-mock-match-request-headers", "header");
		
		// To Extract the Response Header Validation
		
		System.out.println("************Response_Header_Extract_usingforloop*******************");
		
		Headers headers = given().baseUri("https://9f987fe6-2037-4571-8c18-7d549da8dbf6.mock.pstmn.io").
			   headers(head).	
		
		when().get("/get").
		
		then().log().all()
			  .assertThat().statusCode(200)
			  .extract().headers();
		
		// DataType Objectname : ObjectReference
		
		for (Header header : headers) {
			
			System.out.print("Header Name... : " + header.getName());
			System.out.println("Header Value...:" +header.getValue());
		}						
	}
	
	@org.testng.annotations.Test
	public void Multiple_Response_Header_Extract() {
		
		HashMap<String, String> head = new HashMap<String, String>();
		head.put("header", "value1");
		head.put("x-mock-match-request-headers", "header");
		
		// To Extract the Response Header Validation
		
		System.out.println("************Multiple_Response_Header_Extract*******************");
		
		Headers extractheaders = given().baseUri("https://9f987fe6-2037-4571-8c18-7d549da8dbf6.mock.pstmn.io").
			   headers(head).	
		
		when().get("/get").
		
		then().log().all().assertThat().statusCode(200)	
			  .extract().headers();
		
		List<String> values = extractheaders.getValues("multiplevalueheader");		
		
		for (String value : values) {
			
			System.out.println("Response is..........: "+value);
		}
		
					
	}
	
	
	
	
	
	
	
	
	
	
		
}
