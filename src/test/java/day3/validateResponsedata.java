package day3;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.JSONObject;


public class validateResponsedata {
       
	
	@Test
	 void testJsonResponse() {
		 RestAssured.baseURI = "https://vegis-backend.onrender.com";  // Replace with actual API base URL

	        // Send GET request and extract response
	        Response response = given()
	                .when()
	                .get("/api/products/66ed680533ab02b48ed68f1c") // Replace with the actual endpoint
	                .then()
	                .statusCode(200)  // Validate response status
	                .body("price", not(empty())) // Ensure price field exists
	                .extract()
	                .response();

	        // Extract product prices as a List
	        List<Integer> prices = response.jsonPath().getList("price", Integer.class);

	        // Calculate total price
	        int totalPrice = prices.stream().mapToInt(Integer::intValue).sum();

	        // Print the total price
	        System.out.println("Total Price of All Products: ₹" + totalPrice);

	        // Assertion to check total price is greater than 0
	        assert totalPrice > 0 : "Total price should be greater than zero!";
		 
	}
}
