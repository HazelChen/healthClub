package edu.nju.healthClub.actions;

import java.io.IOException;
import java.util.Calendar;
import java.util.ArrayList;

import javax.servlet.ServletException;

import edu.nju.healthClub.model.Activity;

public class RecommandAction extends BaseAction{
	private static final long serialVersionUID = 1574319825950215251L;
	
	private ArrayList<Activity> recommandActivities;
	
	public ArrayList<Activity> getRecommandActivities () {
		return recommandActivities;
	}
	
	@Override
	public String execute () throws ServletException, IOException{
		this.recommandActivities = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 11, 20);
		Activity a1 = new Activity("001", calendar.getTime(), 
				"images/spa.jpg", 
				"SPA一词源于拉丁文“Solus Par Agula”（Health by water）的字首，Solus （健康），Par（在）， Agula（水中），意指用水来达到健康，健康之水。在SPA过程中使用晶体 石膏灯，AQ空气净化喷雾，可以有效增加负离子并创造出自然平衡的离子环境，让空气保持清新流通，并使人更有宁静的感觉。");
		recommandActivities.add(a1);
		calendar.set(2013, 11, 30);
		Activity a2 = new Activity("002", calendar.getTime(), 
				"images/aa.jpg", 
				"仅58元！浙江在线健康网携手杭州灸芝友道养生馆推出原价328元艾灸专业护理！90分钟内让您享受价值68元老艾泡脚一次+经络疏通+10选1艾灸——悬灸温和调理项目+养生茶+养生汤！(下附悬灸调理可选项目及功效)");
		recommandActivities.add(a2);
		calendar.set(2013, 12, 15);
		Activity a3 = new Activity("003", calendar.getTime(), 
				"images/讲座.jpg", 
				"about the party, you can ask Jim for help.");
		recommandActivities.add(a3);
		return SUCCESS;
	}

}
