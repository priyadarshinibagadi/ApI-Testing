package com.RestAssured.StaticJson;

import org.testng.annotations.Test;

import com.RestAssured.goodpractise.CommonFunctions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StaticJson {
	@Test
	public void staticJsonPayload() throws IOException{
		CommonFunctions cf = new CommonFunctions();
		String postdata=generateStringFromResource("C:\\Users\\New User\\Desktop\\staticpayload.json");

		RestAssured.baseURI = "http://216.10.245.166";
		Response res = given()
		.body(postdata)
		.when()
		.post("/Library/Addbook.php")
		.then()
		.assertThat().statusCode(200).and().extract().response();
		JsonPath jp =cf.commonMethodsForJson(res);
		String id  = jp.get("ID");
		System.out.println(id);
		
	}
	public String generateStringFromResource(String path) throws IOException{
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}
	private static String String(byte[] readAllBytes) {
		// TODO Auto-generated method stub
		return null;
	}

}
