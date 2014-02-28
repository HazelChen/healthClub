package edu.nju.healthClub.services;

public class AdminPrePageChangeService{

	public String change(String url, String queryUrl) {
		int index = url.indexOf("admin") + 6;
		String rootUrl = url.substring(index);
		String afterUrl = queryUrl == null ? "" : "?" + queryUrl;
		String prePage = rootUrl + afterUrl;
		return prePage;
	}
	
}
