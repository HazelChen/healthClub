package edu.nju.healthClub.services.impl;

import edu.nju.healthClub.services.PrePageService;

public class AdminPrePageChangeService implements PrePageService{
	private static PrePageService pageService;
	
	private AdminPrePageChangeService(){}

	public String change(String url, String queryUrl) {
		int index = url.indexOf("admin") + 6;
		String rootUrl = url.substring(index);
		String afterUrl = queryUrl == null ? "" : "?" + queryUrl;
		String prePage = rootUrl + afterUrl;
		return prePage;
	}
	
	public static PrePageService instance() {
		if (pageService == null) {
			pageService = new AdminPrePageChangeService();
		}
		return pageService;
	}
	
	
}
