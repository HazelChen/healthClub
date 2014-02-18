package edu.nju.healthClub.actions;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.healthClub.model.Activity;

public class ActivityAction extends BaseAction{
	private static final long serialVersionUID = -8934726765255655806L;
	
	private ArrayList<Activity> activities;
	
	public ArrayList<Activity> getActivities () {
		return activities;
	}
	
	
	public String getActivityFromDate () {
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month")) - 1;
		int date = Integer.parseInt(request.getParameter("date"));
		
		this.activities = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, date);
		Activity a1 = new Activity("123",
				calendar.getTime(), 
				"images/spa.jpg", 
				"网易娱乐2月2日报道 虽然原著结束已经6年，但全球最卖座系列小说《哈利波特》作者J.K罗琳还是承认，最后将哈利波特的好友罗恩与赫敏拉起红线其实是个错误，哈利波特其实更适合聪慧的赫敏。罗琳在接受《泰晤士报》专访时表示，将罗恩与赫敏配成一对，是她最初的构思，纯粹是个人决定，与文学没有太大关系，她坦言两人并非赏心悦目的一对，甚至相信当故事结束后，这一对早晚要走上“婚姻辅导”的路子。罗琳接受访问时坦承犯下了这个“错误”。有趣的是，采访者，正是在电影扮演赫敏的女星艾玛·沃特森(Emma Watson)，她也同意，哈利其实更适合赫敏。",
				"赫敏应该和哈利波特在一起",
				"英国",
				"罗琳",
				false);
		activities.add(a1);
		
		Activity a2 = new Activity("123",
				calendar.getTime(), 
				"images/团购.jpg", 
				"网易娱乐2月2日报道 据香港媒体报道，凭内地节目《爸爸去哪儿》人气急升的林志颖，不时在微博上传与儿子Kimi温馨合照晒幸福。今日(2月2日)，小志同爱子又大晒父子装，齐齐戴着棒球帽、穿着羽绒背心，分别推着“大人Size”及“孩童Size”的推车。单看照片，亦看得出这对父子甚有默契。林志颖留言写道：“全家逛超市补货去。”看来小志应该是趁新春大家都忙着去拜年，超市没人的时候进行补货。",
				"林志颖晒与Kimi温馨合照",
				"台湾",
				"林志颖",
				true);
		activities.add(a2);
		return SUCCESS;
	}
	
	public String getActivityFromDateWithUser () {
		ArrayList<String> userIds = new ArrayList<>();
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		
		this.activities = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2012, 6, 21);
		Activity a1 = new Activity("123",
				calendar.getTime(), 
				"images/spa.jpg", 
				"赫敏应该和哈利波特在一起",
				"英国",
				"罗琳",
				userIds);
		activities.add(a1);
		
		Activity a2 = new Activity("456",
				calendar.getTime(), 
				"images/spa.jpg", 
				"赫敏应该和哈利波特在一起",
				"英国",
				"罗琳",
				userIds);
		activities.add(a2);
		return SUCCESS;
	}
	public String getActivityFromIdWithUser () {
		ArrayList<String> userIds = new ArrayList<>();
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		
		this.activities = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2012, 6, 21);
		Activity a1 = new Activity("123",
				calendar.getTime(), 
				"images/spa.jpg", 
				"赫敏应该和哈利波特在一起",
				"英国",
				"罗琳",
				userIds);
		activities.add(a1);
		
		Activity a2 = new Activity("456",
				calendar.getTime(), 
				"images/spa.jpg", 
				"赫敏应该和哈利波特在一起",
				"英国",
				"罗琳",
				userIds);
		activities.add(a2);
		return SUCCESS;
	}
	public String getActivity () {
		ArrayList<String> userIds = new ArrayList<>();
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		userIds.add("海维");
		
		this.activities = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2012, 6, 21);
		Activity a1 = new Activity("123",
				calendar.getTime(), 
				"images/spa.jpg", 
				"赫敏应该和哈利波特在一起",
				"英国",
				"罗琳",
				userIds);
		activities.add(a1);
		
		Activity a2 = new Activity("456",
				calendar.getTime(), 
				"images/spa.jpg", 
				"赫敏应该和哈利波特在一起",
				"英国",
				"罗琳",
				userIds);
		activities.add(a2);
		return SUCCESS;
	}
	
	public String getActivityFromId () {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		this.activities = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 01, 01);
		Activity a1 = new Activity("123",calendar.getTime(), 
				"images/spa.jpg", 
				"网易娱乐2月2日报道 虽然原著结束已经6年，但全球最卖座系列小说《哈利波特》作者J.K罗琳还是承认，最后将哈利波特的好友罗恩与赫敏拉起红线其实是个错误，哈利波特其实更适合聪慧的赫敏。罗琳在接受《泰晤士报》专访时表示，将罗恩与赫敏配成一对，是她最初的构思，纯粹是个人决定，与文学没有太大关系，她坦言两人并非赏心悦目的一对，甚至相信当故事结束后，这一对早晚要走上“婚姻辅导”的路子。罗琳接受访问时坦承犯下了这个“错误”。有趣的是，采访者，正是在电影扮演赫敏的女星艾玛·沃特森(Emma Watson)，她也同意，哈利其实更适合赫敏。",
				"赫敏应该和哈利波特在一起",
				"英国",
				"罗琳",
				false);
		activities.add(a1);
		
		Activity a2 = new Activity("123",calendar.getTime(), 
				"images/团购.jpg", 
				"网易娱乐2月2日报道 据香港媒体报道，凭内地节目《爸爸去哪儿》人气急升的林志颖，不时在微博上传与儿子Kimi温馨合照晒幸福。今日(2月2日)，小志同爱子又大晒父子装，齐齐戴着棒球帽、穿着羽绒背心，分别推着“大人Size”及“孩童Size”的推车。单看照片，亦看得出这对父子甚有默契。林志颖留言写道：“全家逛超市补货去。”看来小志应该是趁新春大家都忙着去拜年，超市没人的时候进行补货。",
				"林志颖晒与Kimi温馨合照",
				"台湾",
				"林志颖",
				true);
		activities.add(a2);
		return SUCCESS;
	}
}
