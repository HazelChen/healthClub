package edu.nju.healthClub.actions;

import edu.nju.healthClub.model.MemberAgeStatistics;
import edu.nju.healthClub.model.MemberPlaceColumn;
import edu.nju.healthClub.model.MemberPlaceStatistics;
import edu.nju.healthClub.model.MemberSexStatistics;
import edu.nju.healthClub.model.MembershipStatistics;

public class ManagerUserAction extends BaseAction{
	private static final long serialVersionUID = -7290297593628014043L;
	
	private MembershipStatistics membershipStatistics;
	private MemberPlaceStatistics memberPlaceStatistics;
	private MemberAgeStatistics memberAgeStatistics;
	private MemberSexStatistics memberSexStatistics;
	
	@Override
	public String execute () {
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
		
		double[] percents = new double[]{30,50,15,3,2};
		memberAgeStatistics = new MemberAgeStatistics(percents, "20~40");
		
		memberSexStatistics = new MemberSexStatistics(60, 40, "男");
		return SUCCESS;
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

	public MemberAgeStatistics getMemberAgeStatistics() {
		return memberAgeStatistics;
	}

	public void setMemberAgeStatistics(MemberAgeStatistics memberAgeStatistics) {
		this.memberAgeStatistics = memberAgeStatistics;
	}

	public MemberSexStatistics getMemberSexStatistics() {
		return memberSexStatistics;
	}

	public void setMemberSexStatistics(MemberSexStatistics memberSexStatistics) {
		this.memberSexStatistics = memberSexStatistics;
	}

}
