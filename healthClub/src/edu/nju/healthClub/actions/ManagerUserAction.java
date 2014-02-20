package edu.nju.healthClub.actions;

import java.util.ArrayList;

public class ManagerUserAction extends BaseAction{
	private ArrayList<String> months;
	
	@Override
	public String execute () {
		months = new ArrayList<>();
		months.add("2014年1月");
		months.add("2013年12月");
		months.add("2013年11月");
		months.add("2013年10月");
		months.add("2013年9月");
		return SUCCESS;
	}
	//sd
	
	

}
