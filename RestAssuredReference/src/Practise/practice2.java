package Practise;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import org.testng.Assert;
import io.restassured.path.json.JsonPath;
public class practice2 {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in/";
		String reqBody ="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
//		Declare  the Expected Result
		JsonPath jspReq = new JsonPath(reqBody);
		String req_name = jspReq.getString("name");
		String req_job = jspReq.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0,11);
		
   
		String resBody = given()
				.header("content-type","application/json")
				.body(reqBody)
				.when()
				.post("api/users")
				.then()
				.extract()
				.response()
				.asString();
//		System.out.println(resBody);
		JsonPath jspRes = new JsonPath(resBody);
		
		String res_name = jspRes.getString("name");
		String res_job = jspRes.getString("job");
		String res_createdAt =jspRes.getString("createdAt");
		res_createdAt = res_createdAt.substring(0,11);
//		System.out.println(res_name);
//		System.out.println(res_job);
		
//		Validate Response Body Parameter
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertEquals(res_createdAt, expecteddate);
		

	}

}
