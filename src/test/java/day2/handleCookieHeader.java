package day2;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.*;


public class handleCookieHeader {

	
	//@Test(priority = 1)
	void testwithCookies() {
		
	     Response res=	(Response) given()
		
	
		.when()
		 .get("https://google.com");
	     
		 String cookie = res.getCookie("AEC");
		 System.out.println(cookie);
	}
	
	@Test(priority = 2)
	void headerInfo() {
		
		  Response res1=(Response) given()
		
		
		   .when()
		      .get("https://google.com");
		  
		 Headers myHeader= res1.getHeaders();
		 for(Header hd: myHeader) {
			 System.out.println(hd.getName()+"    "+hd.getValue());
		 }
	}
	
}
