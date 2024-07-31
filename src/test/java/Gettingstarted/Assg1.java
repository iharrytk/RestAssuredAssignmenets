package Gettingstarted;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import org.testng.annotations.Test;
import io.restassured.response.ValidatableResponse;

public class Assg1 {

	@Test

	public void getUsers() {
		
		ValidatableResponse resp=given()
		.baseUri("https://gorest.co.in")
		.headers("Authorization", "Bearer f353a2e05089756583c09ebb7cd8832df56b9c9aa14c89f019466549589cdbb4")
		.headers("Accept", "application/json")
		.headers("Content-Type", "application/json")
		.log()
		.all()
		.when()
		.get("/public/v2/users")
		.then()
		.statusCode(200)
		.contentType("application/json")
		.body("id",not(empty()))
		.body("name",not(empty()))
		.body("email",not(empty()));
		
		System.out.println("The Reponse body of the get API call is printed below");
		System.out.println(resp.extract().asPrettyString());
		
		
		
		

	}

}
