package com.RestAssured.xmlpractices;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BasciesOfXml {
	@Test
	public void postRequestXml() throws IOException{
		String postdata=generateStringFromResource("C:\\Users\\New User\\Documents\\places.xml");
		RestAssured.baseURI = "http://216.10.245.166";
		Response res =given().
		queryParam("key", "qaclick123").
	    body(postdata).
        when().
	    post("/maps/api/place/add/xml")
	   .then()
	   .assertThat().statusCode(200)
	   .and().contentType(ContentType.XML)
	   .and().extract().response();
		
		String response =res.asString();
		System.out.println(response);
		
	}
	public String generateStringFromResource(String path) throws IOException{
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}

}
