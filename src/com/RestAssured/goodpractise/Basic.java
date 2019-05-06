package com.RestAssured.goodpractise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://weather-ydn-yql.media.yahoo.com";
	given().
	param("location","sunnyvale").
	param("lat","37.372").
	param("lon", "-122.038").
	param("format", "json").
	param("woeid", "2502265").   
	when().
	get("/forecastrss").
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	
	}

}
