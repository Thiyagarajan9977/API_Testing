package org.test.udmey;

//import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AutomationGet {

	@org.testng.annotations.Test
	public void validatestatuscode() {
		given().baseUri("https://api.getpostman.com").header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("workspaces/").
		then().assertThat().statusCode(200).log().all();
	}
	
	@org.testng.annotations.Test
	public void validateresponsebody() {
		given().baseUri("https://api.getpostman.com").header("x-api-key", "PMAK-618ba56a772ecf003cdbcc1b-017d807c9f744b45d666188054a19a93ec").
		when().get("workspaces/").
		then().assertThat().statusCode(200).body("workspaces.name", hasItems("Team Workspace", "My Workspace"),"workspaces.type",hasItems("team","personal")) 
		.log().all();
		}
	}