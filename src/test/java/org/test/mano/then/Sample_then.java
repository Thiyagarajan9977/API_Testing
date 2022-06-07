package org.test.mano.then;

import static org.junit.Assert.*;
import org.junit.Test;
import org.test.mano.BaseClass;
import org.test.mano.payload;
import org.test.mano.serial.CreateDeserial;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.test.mano.then.Builder_Base_class.*;

public class Sample_then extends BaseClass {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://thiyagarajanrajasudhakar.atlassian.net/";	
		
		// POST
		System.out.println("*************POST***************");

		

		Response repost = RestAssured.given().log().all().spec(Builder_Base_class.getreqspec()).header("Content-Type", "application/json")
				.auth().preemptive().basic("thiyagarajanrajasudhakar@gmail.com", "PRBBsO72iCerO3Ej34WF3611")
				.body(payload.createissue())				
				.when().post("rest/api/2/issue/").then().spec(Builder_Base_class.getresspec(201)).log().all().extract().response();
		
		// The below line to get response until statuscode (201) ValidatableResponse
		//then only need to add exract.response so that we can combine the code in restAssured given
		
		
		//*****************************************************************
		//repost.then().assertThat().statusCode(201).extract().response();
		//*****************************************************************
		
		String getresponsebody = getresponsebody(repost);		
		System.out.println("Post Body Response Code is ..... :" +getresponsebody);		
		System.out.println("Post Status Code is ..... :"+getstatuscode(repost));
		
		
		 CreateDeserial cd = repost.as(CreateDeserial.class);
		 
		 System.out.println("ID..........:" +cd.getId());
		 System.out.println("Key..........:"+cd.getKey());
		 System.out.println("self..........:"+cd.getSelf());
		
		assertEquals("Status code should be : ", 201, getstatuscode(repost));
		assertTrue("Self contatin should be: ", cd.getSelf().contains("thiya"));	
		
	}

}
