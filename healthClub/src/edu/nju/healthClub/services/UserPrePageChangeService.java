package edu.nju.healthClub.services;

public class UserPrePageChangeService{
	
	public String change(String url, String queryUrl) {
		int index = url.indexOf("user") + 5;
		String rootUrl = url.substring(index);
		String afterUrl = queryUrl == null ? "" : "?" + queryUrl;
		String prePage = rootUrl + afterUrl;
		return prePage;
	}
	
}
