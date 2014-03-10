package edu.nju.healthClub.actions;

import java.util.ArrayList;

import edu.nju.healthClub.model.MonthSelection;
import edu.nju.healthClub.services.UserServiceInterface;

/**
 * @author hazel
 * 得到应该显示的月份，并且设置上一次选择的月份
 */
public class ManagerMonthAction extends BaseAction{
	private static final long serialVersionUID = 2605451054715313856L;
	
	private ArrayList<MonthSelection> monthSelections;
	
	private UserServiceInterface userService;
	
	@Override
	public String execute () {
		String selectMonth = request.getParameter("month");
		monthSelections = userService.getDuration(selectMonth);
		return SUCCESS;
	}
	
	public ArrayList<MonthSelection> getMonthSelections() {
		return monthSelections;
	}

	public void setUserService(UserServiceInterface userService) {
		this.userService = userService;
	}
	
	
}
