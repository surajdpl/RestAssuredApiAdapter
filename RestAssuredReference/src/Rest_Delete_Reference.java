
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class Rest_Delete_Reference {

	public static void main(String[] args) {
//		Declare BaseURL
		RestAssured.baseURI = "https://reqres.in/";
		
//		Declare Response Body Fetching Response BOdy
		String resBody = given()
				.header("Accept","*/*")
				.body("")
				.when()
				.put("api/users/2")
				.then()
				.extract()
				.response()
				.asString();
		
		System.out.println(resBody);

	}

}
