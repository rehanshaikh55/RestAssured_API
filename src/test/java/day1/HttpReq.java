package day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

import java.util.HashMap;



public class HttpReq {

	private int id;
	@Test(priority = 1)
	void getUser() {
		baseURI="https://reqres.in/api/users?page=2";
		
		given()
		.when()
		.get()
		.then()
		  .statusCode(200)
		  
		  .log().all();
		//Response res= RestAssured.get("https://reqres.in/api/users?page=2");
		//Assert.assertEquals(200,res.getStatusCode());
		
	}
	
	@Test(priority = 2)
	void createUser() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "rehans");
		data.put("job", "QA");
		
		id = given()
		   .contentType("application/json")
		   .body(data)
		.when()
		    .post("https://reqres.in/api/users")
		    .jsonPath().getInt("id");
		    
		//.then()
		 //   .statusCode(201)
		 //   .log().body();	
	}
	@Test(priority = 3,dependsOnMethods = "createUser")
	void updateUser() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "rehan");
		data.put("job", "QA Automation");
		
		 given()
		   .contentType("application/json")
		   .body(data)
		.when()
		    .post("https://reqres.in/api/users/"+id)
		    
		.then()
                .log().all();
	}
	
	@Test(priority = 4)
	void deleteUser() {
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)                                                                                                                                                                                                                                                                                                                                                            
		.log().all();
	}
	
	
}
