package testscripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TC02_POST {
	String url = "http://localhost:3030/products";
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_01() {
		JSONObject request = new JSONObject();
		
		request.put("name", "new_product");
		request.put("type", "goods_type");
		request.put("price", 800);
		request.put("shipping", 90);
		request.put("upc", "upcxysx");
		request.put("description", "best_quality_product");
		request.put("model", "model1234");
			
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.post(url)
		.then()
			.statusCode(201)
			.log().all();
		//created id: 9999679, 9999680
	}
}
