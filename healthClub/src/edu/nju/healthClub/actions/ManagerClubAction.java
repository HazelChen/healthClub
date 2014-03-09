package edu.nju.healthClub.actions;

import java.util.ArrayList;

import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubMemberStatistics;
import edu.nju.healthClub.model.ClubPlaceColumn;
import edu.nju.healthClub.services.impl.ActivityService;
import edu.nju.healthClub.services.impl.ReserveService;

public class ManagerClubAction extends BaseAction{
	private static final long serialVersionUID = 1146621566194268753L;
	
	private ClubMemberStatistics clubMemberStatistics;
	private ArrayList<ClubPlaceColumn> placeColumns;
	private ArrayList<ClubCoachColumn> coachColumns;
	
	private ReserveService reserveService;
	private ActivityService activityService;
	
	@Override
	public String execute () {
		String dateString = request.getParameter("month");
		clubMemberStatistics = reserveService.getClubMemberStatistics(dateString);
		placeColumns = activityService.getPlaceColumns(dateString);
		coachColumns = activityService.getCoachColumns(dateString);
		return SUCCESS;
	}

	public ClubMemberStatistics getClubMemberStatistics() {
		return clubMemberStatistics;
	}

	public void setClubMemberStatistics(ClubMemberStatistics clubMemberStatistics) {
		this.clubMemberStatistics = clubMemberStatistics;
	}

	public ArrayList<ClubPlaceColumn> getPlaceColumns() {
		return placeColumns;
	}

	public void setPlaceColumns(ArrayList<ClubPlaceColumn> placeColumns) {
		this.placeColumns = placeColumns;
	}

	public ArrayList<ClubCoachColumn> getCoachColumns() {
		return coachColumns;
	}

	public void setCoachColumns(ArrayList<ClubCoachColumn> coachColumns) {
		this.coachColumns = coachColumns;
	}

	public void setReserveService(ReserveService reserveService) {
		this.reserveService = reserveService;
	}

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
}
