package com.RestAssured.goodpractise;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest {
	@Test
	public void validation(){
		RestAssured.baseURI = "http://216.10.245.166";
		given().
		queryParam("key","qaclick123").
	    body("{"+
	"\"location\":{"+
		"\"lat\" : -38.383494,"+
		"\"lng\" : -38.383494"+
	"},"+
	"\"accuracy\" : 50,"+
	"\"name\" : \"Frontline house\","+
	"\"phone_number\" : \"(+91)983 893 3937\","+
	"\"address\" : \"29, side layout, cohen 09\","+
	"\"types\" : [\"shoe park\", \"shop\"],"+
	"\"website\" : \"http:google.com\","+
	"\"language\" : \"French_IN\""
	+ "}").
	 when().
	 post("/maps/api/place/add/json")
	 .then().assertThat()
	 .statusCode(200).and().contentType(ContentType.JSON).and().
	 body("status", equalTo("OK"));
	}

}
