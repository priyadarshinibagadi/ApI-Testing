package com.RestAssured.goodpractise;

public class Resources {
	public String addJsonResources(){
		String rs = "/maps/api/place/add/json";
		return rs;
	}
	public String deleteJsonResource(){
		String drs = "/maps/api/place/delete/json";
		return drs;
		
	}
	public String addXmlResource(){
		String addxml= "/maps/api/place/add/xml";		
		return addxml;
		
	}
	public String getJsonResource(){
	String getrs=	"/maps/api/place/nearbysearch/json";
		return getrs;
		
	}

}
