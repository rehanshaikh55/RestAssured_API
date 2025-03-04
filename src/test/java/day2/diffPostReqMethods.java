package day2;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

public class diffPostReqMethods {
     
	private String id;

	@Test(priority = 0)
	void usingHashMap() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("empId", "EMP04");
		data.put("jobTitle", "QA");
		data.put("fullName", "Rehan shaikh");
		data.put("address", "ahmedabad");
		
		id =given()
		     .contentType("application/json")
		     .body(data)
		.when()
		    .post("http://localhost:3000/Employees")
		    .jsonPath().get("id");
		
	}
	@Test(priority = 1)
	void deleteEmp() {
		given()
		
		.when()
		 .delete("http://localhost:3000/Employees/"+id)
		    
		.then();
	}
	
}
