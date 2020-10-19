package testscripts;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC05_DELETE {
	String url = "http://localhost:3030/products/";
	
	@Test
	public void test_01() {
		given()
	    .when()
			.delete(url + "9999681")
		.then()
			.statusCode(404)
			.log().status();
		//created id: 9999679, 9999680
	}
}
