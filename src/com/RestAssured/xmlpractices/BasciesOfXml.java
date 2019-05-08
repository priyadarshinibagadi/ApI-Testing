package com.RestAssured.xmlpractices;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import com.RestAssured.goodpractise.Resources;
import com.RestAssured.goodpractise.CommonFunctions;

public class BasciesOfXml {
	Resources r = new Resources();
	CommonFunctions cf = new CommonFunctions();
	@Test
	public void postRequestXml() throws IOException{
		String postdata=generateStringFromResource("C:\\Users\\New User\\Documents\\places.xml");
		RestAssured.baseURI = "http://216.10.245.166";
		Response res =given().
		queryParam("key", "qaclick123").
	    body(postdata).
        when().
	    post(r.addXmlResource())
	   .then()
	   .assertThat().statusCode(200)
	   .and().contentType(ContentType.XML)
	   .and().extract().response();
		
		XmlPath xp = cf.commonMethodsForXml(res);
		String x=xp.get("response.place_id");
		System.out.println(x);
		
	}
	public String generateStringFromResource(String path) throws IOException{
		return new String(Files.readAllBytes(Paths.get(path)));//path of .xml file will be converted into string, in string all bytes are read
		                                                       
		
	}

}
