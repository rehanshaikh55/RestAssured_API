package day3;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;


public class validateResponsedata {
       
	
	@Test
	 void testJsonResponse() {
		 given()
		 .contentType("ContentType.JSON")
		 .when()
		 .get("https://reqres.in/api/users")
		 .then()
		  .body("data[5].email", equalTo("tracey.ramos@reqres.in"))
		 
		 ;
	}
}
