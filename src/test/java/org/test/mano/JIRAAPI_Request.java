package org.test.mano;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JIRAAPI_Request {

	public static void main(String[] args) {

		// GET

		System.out.println("*************GET***************");

		RestAssured.baseURI = "https://thiyagarajanrajasudhakar.atlassian.net/";

		Response reget = RestAssured.given().header("Content-Type", "application/json").auth().preemptive()
				.basic("thiyagarajanrajasudhakar@gmail.com", "PRBBsO72iCerO3Ej34WF3611").when()
				.get("rest/api/2/search");

		String getasString = reget.getBody().asString();
		System.out.println("Get Body Response Code is ..... : " + getasString);

		int getstatusCode = reget.getStatusCode();
		System.out.println("Get Status Code is ..... :" + getstatusCode);

		// POST

		System.out.println("*************POST***************");

		Response repost = RestAssured.given().header("Content-Type", "application/json")
				.auth().preemptive().basic("thiyagarajanrajasudhakar@gmail.com", "PRBBsO72iCerO3Ej34WF3611")
				.body("{\r\n" + 
						"    \"fields\": {\r\n" + 
						"       \"project\":\r\n" + 
						"       {\r\n" + 
						"          \"key\": \"FLIP\"\r\n" + 
						"       },\r\n" + 
						"       \"summary\": \"REST ye merry gentlemen.\",\r\n" + 
						"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
						"       \"issuetype\": {\r\n" + 
						"          \"name\": \"Bug\"\r\n" + 
						"       }\r\n" + 
						"   }\r\n" + 
						"}")
				
				
				.when().post("rest/api/2/issue/");

		String postasString = repost.getBody().asString();
		System.out.println("Post Body Response Code is ..... :"+postasString);
		
		int poststatusCode = repost.getStatusCode();
		System.out.println("Post Status Code is ..... :"+poststatusCode);
		
		
		
		
		System.out.println("*************PUT***************");

		Response reput = RestAssured.given().header("Content-Type", "application/json")
				.auth().preemptive().basic("thiyagarajanrajasudhakar@gmail.com", "PRBBsO72iCerO3Ej34WF3611")
				.body("{\r\n" + 
						"    \"fields\": {\r\n" + 
						"       \"summary\": \" Automated 11-11- 2011 Updated Summary Report\",\r\n" + 
						"       \"description\": \" Date - 11-11- 2011  This is the Updated description\"\r\n" + 
						"       }\r\n" + 
						"}")				
					.when().put("rest/api/2/issue/FLIP-53");

		String putasString = reput.getBody().asString();
		System.out.println("Put Body Response Code is ..... :"+putasString);
		
		int putstatusCode = reput.getStatusCode();
		System.out.println("Put Status Code is ..... :"+putstatusCode);
		
		
		
		System.out.println("*************DELETE***************");
		Response redelete = RestAssured.given().header("Content-Type", "application/json")
				.auth().preemptive().basic("thiyagarajanrajasudhakar@gmail.com", "PRBBsO72iCerO3Ej34WF3611")			
					.when().put("rest/api/2/issue/FLIP-51");

		String deleteasString = redelete.getBody().asString();
		System.out.println("Put Body Response Code is ..... :"+deleteasString);
		
		int deletestatusCode = redelete.getStatusCode();
		System.out.println("Put Status Code is ..... :"+deletestatusCode);
		
		System.out.println("Done");
		
		


	}

}
