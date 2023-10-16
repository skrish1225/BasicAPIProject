package org.relayrApiTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TryAgain {
	
	@Test
	 public  void tc01_validateJSONFormat(){
		getDetails(); 
		//boardAPI(); 
	 }
	
	 public static void boardAPI() {
		 RestAssured.baseURI ="https://www.boredapi.com/api";
		 Response r = RestAssured.given().when().get().then().extract().response();
		 System.out.println(r.asString());
	 }
	 
	 
	 public static void getDetails() {
		 //RestAssured.baseURI = URL;
		 String Payloadbody = "{\r\n"
		 		+ "  \"from\": \"Task\",\r\n"
		 		+ "  \"select\": [\r\n"
		 		+ "    \"Name\",\r\n"
		 		+ "    \"Number\",\r\n"
		 		+ "    \"Super.Number\",\r\n"
		 		+ "    \"Parent.Number\",\r\n"
		 		+ "     \"CreateDate\",\r\n"
		 		+ "     \"CreatedBy.Name\",\r\n"
		 		+ "     \"ChangedBy.Name\",\r\n"
		 		+ "     \"ParentMeAndUp.Name\",\r\n"
		 		+ "    \"Status.Name\",\r\n"
		 		+ "    \"Team.Name\",\r\n"
		 		+ "    \"Scope.Name\"\r\n"
		 		+ "  ],\r\n"
		 		+ "  \"where\": {\r\n"
		 		+ "    \"Scope.Name\": \"APAC-OpSol-Gemini CY23-3\",\r\n"
		 		+ "    \"Team.Name\": \"FXE - OpSol - Megatron\"\r\n"
		 		+ "  }\r\n"
		 		+ "}";
		 
		
	     Response r = RestAssured.given()
	    		 .auth().oauth2("1.TRXj5lyraPsVpCZHgGsf1mkeTkA=")
	    		 .relaxedHTTPSValidation()
	    		// .header("Connection","keep-alive")
	    		// .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36")
	    		 .and()
	    		 .body(Payloadbody)
	             	.when()
	             .post("https://www19.v1host.com/FedEx/query.v1")
	             	.then()
	             .extract().response();
	     System.out.println(r.asString());
	    
	 }

}
