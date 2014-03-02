package edu.nju.healthClub.actions;

import edu.nju.healthClub.services.AdminPrePageChangeService;
import edu.nju.healthClub.services.ReserveService;
import edu.nju.healthClub.services.UserPrePageChangeService;

public class ReserveAction extends BaseAction{
	private static final long serialVersionUID = 6822203867640557812L;
	
	private String prePage;
	
	private UserPrePageChangeService userPrePageChangeService;
	private AdminPrePageChangeService adminPrePageChangeService;
	private ReserveService reserveService;
	
	@Override
	public String execute() {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePage = userPrePageChangeService.change(url, queryUrl);
		if (session.containsKey("userid")) {
			String userId = (String) session.get("userid");
			String activityId = request.getParameter("activityId");
			reserveService.reserve(userId, activityId);
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	public String adminReserve () {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePage = adminPrePageChangeService.change(url, queryUrl);
		String userId = request.getParameter("userid");
		String activityId = request.getParameter("activityId");
		System.out.println(userId + " " + activityId);
		return SUCCESS;
	}
	
	public String userCancel () {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePage = userPrePageChangeService.change(url, queryUrl);
		return cancel();
	}
	
	public String adminCancel () {
		String url = (String) session.get("prePage");
		url = url.replace(".jsp", "");
		String queryUrl = (String) session.get("queryUrl");
		prePage = adminPrePageChangeService.change(url, queryUrl);
		return cancel();
	}
	
	public String getPrePage() {
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	
	public void setUserPrePageChangeService(
			UserPrePageChangeService userPrePageChangeService) {
		this.userPrePageChangeService = userPrePageChangeService;
	}

	public void setAdminPrePageChangeService(
			AdminPrePageChangeService adminPrePageChangeService) {
		this.adminPrePageChangeService = adminPrePageChangeService;
	}
	
	public void setReserveService(ReserveService reserveService) {
		this.reserveService = reserveService;
	}

	private String cancel() {
		String userId = request.getParameter("userId");
		String activityId = request.getParameter("activityId");
		reserveService.cancel (userId, activityId);
		return SUCCESS;
	}
}
