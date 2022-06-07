package org.test.mano;

public class payload {

	public static String createuser() {
		return "{\r\n" + "    \"name\" : \"morpheus\",\r\n" + "    \"job\" : \"leader\"\r\n" + "}";

	}

	public static String updateuser(String name) {
		return "{\r\n" + "    \"name\" : \" " + name + "\",\r\n" + "    \"job\" : \"zion resident\"\r\n" + "}";
	}

	public static String createissue() {
		return "{\r\n" + "    \"fields\": {\r\n" + "       \"project\":\r\n" + "       {\r\n"
				+ "          \"key\": \"FLIP\"\r\n" + "       },\r\n"
				+ "       \"summary\": \"REST ye merry gentlemen.\",\r\n"
				+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "       \"issuetype\": {\r\n" + "          \"name\": \"Bug\"\r\n" + "       }\r\n" + "   }\r\n" + "}";
	}

	public static String updateissue() {

		return "{\r\n" + "    \"fields\": {\r\n"
				+ "       \"summary\": \" Automated 11-11- 2011 Updated Summary Report\",\r\n"
				+ "       \"description\": \"Date - 11-11- 2011  This is the Updated description\"\r\n"
				+ "       }\r\n" + "}";
	}

}
