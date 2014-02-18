package edu.nju.healthClub.actions;

import java.util.Calendar;

import edu.nju.healthClub.model.Activity;

public class CreateActivityAction extends BaseAction{
	
	private static final long serialVersionUID = -7748387898106500093L;
	
	private Activity activity;
	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String create() {
		return SUCCESS;
	}
	
	public String change() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1992, 01, 01);
		activity = new Activity(calendar.getTime(), 
				"【微软通过Android获16亿美元年收入】最新报告显示，Android系统每年给微软带来了巨额授权收入。由于谷歌和微软之间的授权协议，微软通过每台Android设备获得约5美元的授权收入，而微软的授权协议已覆盖70%市场。而Windows Phone相同财年给微软带来的利润是3.47亿美元。", 
				"微软and安卓", 
				"微博", 
				"机器人");
		return SUCCESS;
	}
	
}
