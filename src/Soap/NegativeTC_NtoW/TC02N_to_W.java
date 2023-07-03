package Soap.NegativeTC_NtoW;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.path.xml.*;
public class TC02N_to_W {

	public static void main(String[] args) {
//		Declare the BaseURL
		RestAssured.baseURI="https://www.dataaccess.com/";

//		Declare RequestBody
		String RequestBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>1000000000000000000000000000000000</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		
//		Extract Response Body
		String ResponseBody = given().header("Content-Type","text/xml; charset=utf-8") .body(RequestBody).
				when().post("/webservicesserver/NumberConversion.wso").then().extract().response().asString();
		System.out.println(ResponseBody);;
		
//		Parse the ResponseBody
		XmlPath XmlResponse = new XmlPath(ResponseBody);
		String res_parameter = XmlResponse.getString("NumberToWordsResult");
		System.out.println(res_parameter);
		
//		Validation Of ResponseBody for single Digit
		Assert.assertEquals(res_parameter, "number too large");
				
	}

}
