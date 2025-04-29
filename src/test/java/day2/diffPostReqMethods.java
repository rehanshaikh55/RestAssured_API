package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.*;
import org.testng.annotations.Test;


import io.restassured.response.ValidatableResponse;
import netscape.javascript.JSObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

public class diffPostReqMethods {
     
	private String id;
	//1) post request body using hashmap
	//@Test(priority = 0)
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
	
	//2) post request body using Json
	//@Test(priority = 0)
	void usingorg_json() {
		
		JSONObject data = new JSONObject();
		
		
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
	
	//3) post request body using POJO class
		//@Test(priority = 0)
		void usingPojoClass() {
			POJOClass data = new POJOClass();
			data.setEmpId("0001");
			data.setJobTitle("QA");
			data.setFullName("Priya");
			data.setAddress("delhi");
			
			id =given()
			     .contentType("application/json")
			     .body(data)
			.when()
			    .post("http://localhost:3000/Employees")
			    .jsonPath().get("id");
			
		}
		//4) post request body using External Json file
				@Test(priority = 0)
				void usingExternaljsonfile() throws FileNotFoundException {
					File file= new File("C:\\Users\\shaik\\eclipse-workspace\\RestAssured_api\\test.json");
					FileReader fr= new FileReader(file);
					JSONTokener jt = new JSONTokener(fr);
					JSONObject data = new JSONObject(jt);
					
					id =given()
					     .contentType("application/json")
					     .body(data.toString())
					.when()
					    .post("http://localhost:3000/Employees")
					    .jsonPath().get("id");
					
				}
			
	@Test(priority = 1)
	void deleteEmp() {
		given()
		
		.when()
		 .delete("http://localhost:3000/Employees/"+id)
		    
		.then()
		.statusCode(200);
	}
	
}
