package testscripts;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC03_PUT {
	String url = "http://localhost:3030/products/";
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_01() {
		JSONObject request = new JSONObject();
		
		request.put("name", "subratos_product");
		request.put("type", "goods_type");
		request.put("price", 4000);
		request.put("shipping", 500);
		request.put("upc", "upcxysx");
		request.put("description", "best_quality_product");
		request.put("model", "model1234");
		
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.put(url + "9999680")
		.then()
			.statusCode(200)
			.log().all();
		//created id: 9999679, 9999680
	}
}
