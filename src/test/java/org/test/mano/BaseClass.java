package org.test.mano;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.response.Response;

public class BaseClass {
	
	public static int getstatuscode(Response res) {
		return res.getStatusCode();		
	}
	
	public static String getresponsebody(Response res) {
		return res.getBody().asString();
	}
	
	public static String getvalue(String body, Object obj ) throws ParseException {
		
		JSONParser p =new JSONParser();
		Object parse = p.parse(body);	
		
		
		JSONObject j = (JSONObject)parse;
		String name = j.get(obj).toString();
		return name;
	}
	
	

}
