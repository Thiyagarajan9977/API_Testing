package org.test.mano;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Chaining extends BaseClass {

	public static void main(String[] args) throws ParseException {

		RestAssured.baseURI = "https://reqres.in";

		System.out.println("***************post******************");

		// POST
		Response repost = RestAssured.given().header("Content-Type", "application/json").body(payload.createuser())
				.when().post("api/users");

		// ResponseBody

		String getresponsebody = getresponsebody(repost);
		System.out.println(getresponsebody);

		System.out.println(getstatuscode(repost));

		String name = getvalue(getresponsebody, "name");
		System.out.println(name);

		System.out.println("***************put******************");
		// Put

		Response reput = RestAssured.given().header("Content-Type", "application/json").body(payload.updateuser(name))
				.when().put("api/users/2");

		// ResponseBody
		System.out.println(getresponsebody(reput));

		// getStatusCode
		System.out.println(getstatuscode(reput));

	}

}
