package com.RestAssured.goodpractise;

public class PayLoad {
	public String getPostData(){
		String b ="{"+
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
			+ "}";
		return b;
		
	}

}
