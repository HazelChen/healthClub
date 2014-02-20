package edu.nju.healthClub.actions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import edu.nju.healthClub.model.MemberAgeStatistics;
import edu.nju.healthClub.model.MemberPlaceColumn;
import edu.nju.healthClub.model.MemberPlaceStatistics;
import edu.nju.healthClub.model.MembershipStatistics;
import edu.nju.healthClub.model.MonthSelection;

public class ManagerUserAction extends BaseAction{
	private static final long serialVersionUID = -7290297593628014043L;
	
	private ArrayList<MonthSelection> monthSelections;
	private MembershipStatistics membershipStatistics;
	private MemberPlaceStatistics memberPlaceStatistics;
	private MemberAgeStatistics memberAgeStatistics;
	
	@Override
	public String execute () {
		String selectMonth = request.getParameter("month");
		if (selectMonth == null) {
			selectMonth = "2014.1";
		}
		
		monthSelections = new ArrayList<>();
		monthSelections.add(new MonthSelection("2013.12", false));
		monthSelections.add(new MonthSelection(selectMonth, true));
		monthSelections.add(new MonthSelection("2013.11", false));
		monthSelections.add(new MonthSelection("2013.10", false));
		monthSelections.add(new MonthSelection("2013.9", false));
		
		membershipStatistics = new MembershipStatistics(20, 5, 3);
		
		memberPlaceStatistics = new MemberPlaceStatistics("福建");
		MemberPlaceColumn column1 = new MemberPlaceColumn("福建", 50, 50);
		MemberPlaceColumn column3 = new MemberPlaceColumn("江苏", 30, 30);
		MemberPlaceColumn column4 = new MemberPlaceColumn("浙江", 15, 15);
		MemberPlaceColumn column2 = new MemberPlaceColumn("广东", 15, 15);
		memberPlaceStatistics.add(column1);
		memberPlaceStatistics.add(column2);
		memberPlaceStatistics.add(column3);
		memberPlaceStatistics.add(column4);
		
		memberAgeStatistics = new MemberAgeStatistics(percents, bestAge)
		
		return SUCCESS;
	}

	public ArrayList<MonthSelection> getMonthSelections() {
		return monthSelections;
	}

	public void setMonthSelections(ArrayList<MonthSelection> monthSelections) {
		this.monthSelections = monthSelections;
	}

	public MembershipStatistics getMembershipStatistics() {
		return membershipStatistics;
	}

	public void setMembershipStatistics(MembershipStatistics membershipStatistics) {
		this.membershipStatistics = membershipStatistics;
	}

	public MemberPlaceStatistics getMemberPlaceStatistics() {
		return memberPlaceStatistics;
	}

	public void setMemberPlaceStatistics(MemberPlaceStatistics memberPlaceStatistics) {
		this.memberPlaceStatistics = memberPlaceStatistics;
	}
	
	

}
