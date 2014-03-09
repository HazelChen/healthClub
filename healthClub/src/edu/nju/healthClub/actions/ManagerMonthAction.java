package edu.nju.healthClub.actions;

import java.util.ArrayList;

import edu.nju.healthClub.model.MonthSelection;
import edu.nju.healthClub.services.impl.UserService;

public class ManagerMonthAction extends BaseAction{
	private static final long serialVersionUID = 2605451054715313856L;
	
	private ArrayList<MonthSelection> monthSelections;
	
	private UserService userService;
	
	@Override
	public String execute () {
		String selectMonth = request.getParameter("month");
		monthSelections = userService.getDuration(selectMonth);
		return SUCCESS;
	}
	
	public ArrayList<MonthSelection> getMonthSelections() {
		return monthSelections;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
