package org.test.mano.serial;

import org.test.mano.BaseClass;
import org.test.mano.payload;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Serial_Class extends BaseClass {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://thiyagarajanrajasudhakar.atlassian.net/";
		
		Project project = new Project();
		 project.setKey("FLIP");
		 
		 IssueType issuetype = new IssueType();
		 issuetype.setName("Bug");
		 
		 Fields field = new Fields();
		 field.setProject(project);
		 field.setSummary("Login is not working");
		 field.setDescription("User not able to login");
		 field.setIssuetype(issuetype);
		 
		 
		 Createissue createissue = new Createissue();
		 createissue.setFields(field);
		 
		 
			Response repost = RestAssured.given().header("Content-Type", "application/json")
					.auth().preemptive().basic("thiyagarajanrajasudhakar@gmail.com", "PRBBsO72iCerO3Ej34WF3611")
					.body(createissue)				
					.when().post("rest/api/2/issue/");
			
			 System.out.println("StatusCode..................:"+getstatuscode(repost));
			 System.out.println("getBody.....................:"+getresponsebody(repost));
			 
			 CreateDeserial cd = repost.as(CreateDeserial.class);
			 
			 System.out.println("ID..........:" +cd.getId());
			 System.out.println("Key..........:"+cd.getKey());
			 System.out.println("self..........:"+cd.getSelf());
		 
	}

}
