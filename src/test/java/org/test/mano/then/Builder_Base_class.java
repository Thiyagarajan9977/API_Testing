package org.test.mano.then;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Builder_Base_class {
	
	public static RequestSpecification getreqspec() {
	// Request
		
		RequestSpecBuilder req = new RequestSpecBuilder();
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("thiyagarajanrajasudhakar@gmail.com");
		auth.setPassword("PRBBsO72iCerO3Ej34WF3611");
		RequestSpecification reqspec = req.setContentType(ContentType.JSON).setAuth(auth).build();
		return reqspec;
	}
	
	
	public static ResponseSpecification getresspec(int code) {

		// Response
		
		ResponseSpecBuilder res = new ResponseSpecBuilder();
		ResponseSpecification resspec = res.expectContentType(ContentType.JSON).expectStatusCode(code).build();
		return resspec;
		
		
	}

}
