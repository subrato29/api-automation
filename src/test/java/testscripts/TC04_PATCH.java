package testscripts;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC04_PATCH {
	String url = "http://localhost:3030/products/";
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_01() {
		JSONObject request = new JSONObject();
		
		request.put("price", 5000);
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.patch(url + "9999680")
		.then()
			.statusCode(200)
			.log().all();
		//created id: 9999679, 9999680
	}
}
