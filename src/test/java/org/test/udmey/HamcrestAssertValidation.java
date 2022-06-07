package org.test.udmey;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import junit.framework.Assert;

public class HamcrestAssertValidation {
	
	@org.testng.annotations.Test
	public void Thirdwaygettingvalue() {

		// by declaring a object as String

		String three = given().baseUri("https://api.postman.com/").

				header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").

				when().get("/workspaces").

				then().assertThat().statusCode(200).extract().response().path("workspaces[0].name");

		System.out.println("third way of getting value by giving path.....:" +three);
		
		
		// Hamcrest Assest Validation
		
		Assert.assertEquals(three, "Team Workspace");
	}

}
