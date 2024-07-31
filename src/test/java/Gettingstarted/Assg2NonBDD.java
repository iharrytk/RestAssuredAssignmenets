package Gettingstarted;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Assg2NonBDD {
	
	@Test
	public void getUsers() {
		RestAssured.baseURI="https://gorest.co.in";
		
		Response resp=RestAssured
		.given()
		.header("Accept","application/json")
		.header("Content-Type", "application/json")
		.header("Authorization","Bearer f353a2e05089756583c09ebb7cd8832df56b9c9aa14c89f019466549589cdbb4")
		.get("/public/v2/users");
		
		System.out.println("Validating the status code");
		Assert.assertEquals(200, resp.statusCode());
		System.out.println("Validating the Content type");
		Assert.assertEquals("application/json; charset=utf-8", resp.contentType());
		
		System.out.println("Validating the Response field values");
		JsonPath js= resp.jsonPath();
		List<Integer> idvalue=js.getList("id");
		List<String> namevalue=js.getList("name");
		List<String> emailvalue=js.getList("email");
		Assert.assertFalse(idvalue.isEmpty());
		Assert.assertFalse(namevalue.isEmpty());
		Assert.assertFalse(emailvalue.isEmpty());
		
		System.out.println("Printing the response body for debugging purpose:"+resp.asPrettyString());
		
	
		
		
	}
	
	
	

}
