package org.test.mano;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JIRA_API_Chaining extends BaseClass {
	
	public static void main(String[] args) throws ParseException {
		
		RestAssured.baseURI = "https://thiyagarajanrajasudhakar.atlassian.net/";
		
		// POST
		System.out.println("*************POST***************");

		Response repost = RestAssured.given().header("Content-Type", "application/json")
				.auth().preemptive().basic("thiyagarajanrajasudhakar@gmail.com", "PRBBsO72iCerO3Ej34WF3611")
				.body(payload.createissue())				
				.when().post("rest/api/2/issue/");
		
		String getresponsebody = getresponsebody(repost);
		
		System.out.println("Post Body Response Code is ..... :" +getresponsebody);		
		System.out.println("Post Status Code is ..... :"+getstatuscode(repost));
		
		String key = getvalue(getresponsebody, "key");

	//!@#$%^&*()!@#$%^&*()@#$%^&*()...PUT...!@#$%^&*()!@#$%^&*()@#$%^&*()	
		
		System.out.println("*************PUT***************");

		Response reput = RestAssured.given().header("Content-Type", "application/json")
				.auth().preemptive().basic("thiyagarajanrajasudhakar@gmail.com", "PRBBsO72iCerO3Ej34WF3611")
				.body(payload.updateissue())				
					.when().put("rest/api/2/issue/"+key);

		String putasString = reput.getBody().asString();
		System.out.println("Put Body Response Code is ..... :"+putasString);
		
		int putstatusCode = reput.getStatusCode();
		System.out.println("Put Status Code is ..... :"+putstatusCode);		
		
	//!@#$%^&*()!@#$%^&*()@#$%^&*()...DELETE...!@#$%^&*()!@#$%^&*()@#$%^&*()
		
		
		System.out.println("*************DELETE***************");
		Response redelete = RestAssured.given().header("Content-Type", "application/json")
				.auth().preemptive().basic("thiyagarajanrajasudhakar@gmail.com", "PRBBsO72iCerO3Ej34WF3611")
				.when().delete("rest/api/2/issue/"+key);

		String deleteasString = redelete.getBody().asString();
		System.out.println("Delete Body Response Code is ..... :"+deleteasString);
		
		int deletestatusCode = redelete.getStatusCode();
		System.out.println("Delete Status Code is ..... :"+deletestatusCode);	
			
		System.out.println("Done");
	}				
}