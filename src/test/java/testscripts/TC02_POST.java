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
				
		request.put("name", "brand_new_product");
		request.put("type", "goods_type_xx");
		request.put("price", 2000);
		request.put("shipping", 200);
		request.put("upc", "upcxysx");
		request.put("description", "best_quality_product_xx");
		request.put("model", "model456");
			
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
