package com.RestAssured.goodpractise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {

	public static void main(String[] args) {
		// base url
		RestAssured.baseURI="http://216.10.245.166";
	    given().
	    param("location", "-38.383494,-38.383494").
	    param("accuracy", "50").
	    param("name", "Frontline house").
	    param("phone_number", "(+91)983 893 3937").
	    param("address", "29, side layout, cohen 09").
	    param("website", "http://gooogle.com").
	    param("language", "French-IN").
	    param("key", "qaclick123").
	    when().
	    get("/maps/api/place/add/json").
	    then().assertThat().
        statusCode(200).and().contentType(ContentType.JSON).and().
        body("location.lat", equalTo("-38.383494"));
		

	}

}
