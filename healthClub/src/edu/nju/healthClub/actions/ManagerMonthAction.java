package edu.nju.healthClub.actions;

import java.util.ArrayList;

import edu.nju.healthClub.model.MonthSelection;

public class ManagerMonthAction extends BaseAction{

	private static final long serialVersionUID = 2605451054715313856L;
	private ArrayList<MonthSelection> monthSelections;
	
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
		return SUCCESS;
	}
	
	public ArrayList<MonthSelection> getMonthSelections() {
		return monthSelections;
	}

	public void setMonthSelections(ArrayList<MonthSelection> monthSelections) {
		this.monthSelections = monthSelections;
	}
}
