import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class Rest_Get_Reference {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in/";
		
		String resBody = given()
				.header("Accept","*/*")
				.body("").log().all()
				.when()
				.get("api/users?page=2")
				.then().log().all()
				.extract()
				.response()
				.asString();
		System.out.println(resBody);
	}

}
