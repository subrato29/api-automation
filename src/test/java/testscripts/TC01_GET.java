package testscripts;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TC01_GET {
	String url = "http://localhost:3030/";
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
			.statusCode(200);
	}
	
}
