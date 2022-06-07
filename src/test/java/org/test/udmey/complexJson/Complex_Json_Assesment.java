package org.test.udmey.complexJson;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class Complex_Json_Assesment {
	
	ResponseSpecification customresponseSpecification;
	
	@BeforeClass
	public void beforclass() {
	
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
		setBaseUri("https://194a0c80-647b-4d9e-b579-6412a7ac2918.mock.pstmn.io").
		addHeader("x-mock-match-request-body", "true").setContentType("application/json;charset=utf-8").
		log(LogDetail.ALL);
	
		RestAssured.requestSpecification = requestSpecBuilder.build();	
	
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType(ContentType.JSON).
				log(LogDetail.ALL);				
				
		customresponseSpecification = responseSpecBuilder.build();
	}
	
	@Test
	public void Complex_Json_Assesment_Udmeny() {
		
		List<Integer> blackrgbaArrayList = new ArrayList<Integer>();
		blackrgbaArrayList.add(255);
		blackrgbaArrayList.add(255);
		blackrgbaArrayList.add(255);
		blackrgbaArrayList.add(1);
		
		LinkedHashMap<String, Object> codevalue = new LinkedHashMap<String, Object>();
		codevalue.put("rgba", blackrgbaArrayList);
		codevalue.put("hex", "#000");		
		
		LinkedHashMap<String, Object> blackcolor = new LinkedHashMap<String, Object>();
		blackcolor.put("color", "black");
		blackcolor.put("category","hue");
		blackcolor.put("type", "primary");
		blackcolor.put("code", codevalue );
	
		List<Integer> WhitergbaArrayList = new ArrayList<Integer>();
		WhitergbaArrayList.add(0);
		WhitergbaArrayList.add(0);
		WhitergbaArrayList.add(0);
		WhitergbaArrayList.add(1);
		
		LinkedHashMap<String, Object> codevalue2 = new LinkedHashMap<String, Object>();
		codevalue2.put("rgba", WhitergbaArrayList);
		codevalue2.put("hex", "#FFF");	
		
		LinkedHashMap<String, Object> whitecolor = new LinkedHashMap<String, Object>();
		whitecolor.put("color", "white");
		whitecolor.put("category", "value");
		whitecolor.put("code", codevalue2);
						
		List<Object> FinalColor = new ArrayList<Object>();
		FinalColor.add(blackcolor);
		FinalColor.add(whitecolor);
		
		HashMap<String, Object> Colors = new HashMap<String, Object>();
		Colors.put("colors", FinalColor);
		
		
		given().body(Colors).when().post("/postcomplexjson").then().spec(customresponseSpecification)
		.assertThat().body("msg", equalTo("sucessfull"));
		
	}

}
