package Practise;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class practice_karahu {

	public static void main(String[] args) {
		//Declare the Base URL
		RestAssured.baseURI ="https://reqres.in/";
		// Declare the Request Body String Variable
		String requestBody = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		//Declare Given When Then Methods
		String responseBody = given(). header("content-type","application/json").
		                        body(requestBody). when(). post("api/users").
		                        then().extract().response().
		                        asString();
	
		 
//		  String responseBody = given().
//				  header("Content-Type","application/json").
//				  body(requestBody).log().all().
//				  when().
//				  post("api/users"). then().log().all().
//				  extract().
//				  response().
//				  asString();
//		  System.out.println(responseBody);
		JsonPath JspResponse = new JsonPath(responseBody);
		
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		
		System.out.println(Res_name);
		System.out.println(Res_job);

		  
	}
}
