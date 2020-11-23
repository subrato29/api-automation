package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC01_GET {
	String url = "http://localhost:3030/products";
	@Test
	public void test_01() {
		Response response = get(url);
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void test_02() {
		given()
			.get(url)
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(43900));
	}
		
	@Test
	public void test_03() {
		given()
			.param("type", "goods_type")
			.get(url)
		.then()
			.statusCode(200)
			.log().all();
	}	
	
	@Test
	public void test_04() {
		given()
			.get(url)
		.then()
			.statusCode(200)
			.body("data.name", hasItems("Duracell - AAA Batteries (4-Pack)", "Energizer - MAX Batteries AA (4-Pack)"));
	}	
	
	@Test
	public void test_05() {
		given()
			.header("Content-Type", "application/json")
			.get(url);
	}
}
