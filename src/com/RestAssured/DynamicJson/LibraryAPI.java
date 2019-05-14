package com.RestAssured.DynamicJson;

import org.testng.annotations.Test;

import com.RestAssured.goodpractise.CommonFunctions;
import com.RestAssured.goodpractise.PayLoad;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LibraryAPI {
	@Test
	public void addBook(){
		//Dynamically build JSON payload with excternal data inputs
		
		CommonFunctions cf = new CommonFunctions();
		RestAssured.baseURI="http://216.10.245.166";
		Response res =given()
		.body(PayLoad.addBookToPayload("abcdefgh", "2323"))
		.when()
		.post("/Library/Addbook.php")
		.then()
		.assertThat().statusCode(200).and().extract().response();
		JsonPath jp =cf.commonMethodsForJson(res);
		String id =jp.get("ID");
		System.out.println(id);
		//delete book
		
	}
	
	
	

}
