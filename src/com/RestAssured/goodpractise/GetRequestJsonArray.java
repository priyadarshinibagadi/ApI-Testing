package com.RestAssured.goodpractise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class GetRequestJsonArray {
	Properties prop = new Properties();
	Resources rs = new Resources();
	CommonFunctions cf = new CommonFunctions();
	@BeforeTest
	public void getProperty() throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\New User\\Desktop\\selenium\\eclipse\\Rest Assured Project\\Rest Assured\\src\\com\\RestAssured\\Properties\\environment.properties");
	   prop.load(fis);
	}
  @Test
  public void jsonArray(){
	  RestAssured.baseURI = prop.getProperty("Host");
	 Response res= given()
	  .param("location", "-33.8670522,151.1957362")
	  .param("radius", "1500")
	  .param("key", "AIzaSyC3FFDGSkyU7CNz_fAhvBurz89ZtRGZT_E")
	  .when()
	  .get(rs.deleteJsonResource())
	  .then()
	  .assertThat()
	  .statusCode(200).and().contentType(ContentType.JSON).and()
	  .body("results[0].name", equalTo("Sydney"))
	  .extract().response();
	   JsonPath jp=cf.commonMethodsForJson(res);
	   int count =jp.get("results[0].size()");
	   System.out.println(count);
	  
  }
}

