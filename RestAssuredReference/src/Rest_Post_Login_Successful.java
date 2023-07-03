import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class Rest_Post_Login_Successful {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		String reqBody ="{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"cityslicka\"\r\n"
				+ "}"; 
		
		String resBody =given().header("content-type","application/json")
				.body(reqBody).when().post("/api/login").then().extract()
				.response().asString();
		System.out.println(resBody);
		
		JsonPath jspres = new JsonPath (resBody);
		String 	res_token = jspres.getString("token");
//		System.out.println(res_token);
		Assert.assertEquals(res_token, "QpwL5tke4Pnpja7X4");
	}

}
