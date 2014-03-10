package edu.nju.healthClub.actions;

import java.util.ArrayList;

import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubMemberStatistics;
import edu.nju.healthClub.model.ClubPlaceColumn;
import edu.nju.healthClub.services.ActivityServiceInterface;
import edu.nju.healthClub.services.ReserveServiceInterface;

public class ManagerClubAction extends BaseAction{
	private static final long serialVersionUID = 1146621566194268753L;
	
	private ClubMemberStatistics clubMemberStatistics;
	private ArrayList<ClubPlaceColumn> placeColumns;
	private ArrayList<ClubCoachColumn> coachColumns;
	
	private ReserveServiceInterface reserveService;
	private ActivityServiceInterface activityService;
	
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

	public void setReserveService(ReserveServiceInterface reserveService) {
		this.reserveService = reserveService;
	}

	public void setActivityService(ActivityServiceInterface activityService) {
		this.activityService = activityService;
	}
}
