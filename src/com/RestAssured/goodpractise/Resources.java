package com.RestAssured.goodpractise;

public class Resources {
	public String placeResources(){
		String rs = "/maps/api/place/add/json";
		return rs;
	}
	public String deleteTypeResource(){
		String drs = "/maps/api/place/delete/json";
		return drs;
		
	}

}
