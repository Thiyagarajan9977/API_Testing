package org.test.mano.deserial;

import java.util.List;

import org.test.mano.BaseClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Deserial_Class extends BaseClass {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://reqres.in/";

		Response reget = RestAssured.given().header("Content-Type", "application/json").queryParam("page", "2").when()
				.get("api/users");

		System.out.println("Status Code is...........: " + getstatuscode(reget));

		String getresponsebody = getresponsebody(reget);
		System.out.println("Status Body is.......... : " + getresponsebody);

		UserDetails as = reget.as(UserDetails.class);

		System.out.println("**************Page Details*******************");
		System.out.println("Page................." + as.getPage());
		System.out.println("Per_Page................." + as.getPer_page());
		System.out.println("Total................." + as.getTotal());
		System.out.println("Total_Pages................." + as.getTotal_pages());

		
		System.out.println("**************Data*******************");
		
		List<Data> data = as.getData();

		System.out.println(as.getData().get(0).getFirst_name());

		for (Data data2 : data) {

			System.out.println("ID........" + data2.getId());
			System.out.println("Email........" + data2.getEmail());
			System.out.println("First_name........" + data2.getFirst_name());
			System.out.println("Last_name........" + data2.getLast_name());
			System.out.println("Avatar........" + data2.getAvatar());

		}
		
		System.out.println("**************Support*******************");

		System.out.println("URL........." + as.getSupport().getUrl());
		System.out.println("Text........." + as.getSupport().getText());

	}

}
