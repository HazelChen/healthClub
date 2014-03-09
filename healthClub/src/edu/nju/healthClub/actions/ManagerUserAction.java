package edu.nju.healthClub.actions;

import edu.nju.healthClub.model.MemberAgeStatistics;
import edu.nju.healthClub.model.MemberPlaceStatistics;
import edu.nju.healthClub.model.MemberSexStatistics;
import edu.nju.healthClub.model.MembershipStatistics;
import edu.nju.healthClub.services.impl.UserService;

public class ManagerUserAction extends BaseAction{
	private static final long serialVersionUID = -7290297593628014043L;
	
	private MembershipStatistics membershipStatistics;
	private MemberPlaceStatistics memberPlaceStatistics;
	private MemberAgeStatistics memberAgeStatistics;
	private MemberSexStatistics memberSexStatistics;
	
	private UserService userService;
	
	@Override
	public String execute () {
		String dateString = request.getParameter("month");
		membershipStatistics = userService.getMembershipStatistics(dateString);
		memberPlaceStatistics = userService.getMemberPlaceStatistics(dateString);
		memberAgeStatistics = userService.getMemberAgeStatistics(dateString);
		memberSexStatistics = userService.getMemberSexStatistics(dateString);
		return SUCCESS;
	}

	public MembershipStatistics getMembershipStatistics() {
		return membershipStatistics;
	}

	public MemberPlaceStatistics getMemberPlaceStatistics() {
		return memberPlaceStatistics;
	}

	public MemberAgeStatistics getMemberAgeStatistics() {
		return memberAgeStatistics;
	}

	public MemberSexStatistics getMemberSexStatistics() {
		return memberSexStatistics;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
