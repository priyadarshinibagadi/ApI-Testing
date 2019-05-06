package com.RestAssured.goodpractise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequestDelete {
	Properties prop = new Properties();
	Resources rss = new Resources();
	PayLoad pl = new PayLoad();
	@BeforeTest
	public void getData() throws IOException{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\New User\\Desktop\\selenium\\eclipse\\Rest Assured Project\\Rest Assured\\src\\com\\RestAssured\\Properties\\environment.properties");
	    prop.load(fis);
	}
	@Test
	public void addedAndDelete(){
		
		RestAssured.baseURI = prop.getProperty("Host");
	// grab the response
		Response rs =given().
		queryParam("key",prop.getProperty("Key")).
	    body(pl.getPostData()).
	 when().
	 post(rss.placeResources())
	 .then().assertThat()
	 .statusCode(200).and().contentType(ContentType.JSON).and().
	 body("status", equalTo("OK"))
	 .and().extract().response();
		String response = rs.asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
	// grab place_id from response
		String placeid=js.get("place_id");
		System.out.println(placeid);
		
		//place this place_id in the delete request
		
		given().
		queryParam("key",prop.getProperty("Key")).
		body("{"+
				"\"place_id\":\""+placeid+"\""+
				
			"}")
		.when()
		.post(rss.deleteTypeResource()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status", equalTo("OK"));
		
	}
	

}
