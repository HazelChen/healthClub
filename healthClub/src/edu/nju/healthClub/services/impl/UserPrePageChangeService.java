package edu.nju.healthClub.services.impl;

import edu.nju.healthClub.services.PrePageService;

public class UserPrePageChangeService implements PrePageService{
	private static PrePageService pageService;
	
	private UserPrePageChangeService(){}
	
	public String change(String url, String queryUrl) {
		int index = url.indexOf("user") + 5;
		String rootUrl = url.substring(index);
		String afterUrl = queryUrl == null ? "" : "?" + queryUrl;
		String prePage = rootUrl + afterUrl;
		return prePage;
	}
	
	public static PrePageService instance() {
		if (pageService == null) {
			pageService = new UserPrePageChangeService();
		}
		return pageService;
	}
}
