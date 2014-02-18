package edu.nju.healthClub.actions;

import edu.nju.healthClub.factorys.ServiceFactory;
import edu.nju.healthClub.services.PrePageChangeServiceInterface;

public class ReserveAction extends BaseAction{
	private static final long serialVersionUID = 6822203867640557812L;
	
	private PrePageChangeServiceInterface prePageChangeService;
	private String prePage;
	
	public String getPrePage() {
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	
	@Override
	public String execute() {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePageChangeService = ServiceFactory.getUserPrePageChangeService();
		prePage = prePageChangeService.change(url, queryUrl);
		if (session.containsKey("id")) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	public String adminReserve () {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePageChangeService = ServiceFactory.getAdminPrePageChangeService();
		prePage = prePageChangeService.change(url, queryUrl);
		String userId = request.getParameter("userId");
		String activityId = request.getParameter("activityId");
		System.out.println(userId + " " + activityId);
		return SUCCESS;
	}
	
	public String userCancel () {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePageChangeService = ServiceFactory.getUserPrePageChangeService();
		prePage = prePageChangeService.change(url, queryUrl);
		return cancel();
	}
	
	public String adminCancel () {
		String url = (String) session.get("prePage");
		url = url.replace(".jsp", "");
		String queryUrl = (String) session.get("queryUrl");
		prePageChangeService = ServiceFactory.getAdminPrePageChangeService();
		prePage = prePageChangeService.change(url, queryUrl);
		return cancel();
	}
	
	private String cancel() {
		String userId = request.getParameter("userId");
		String activityId = request.getParameter("activityId");
		System.out.println(userId + " " + activityId);
		return SUCCESS;
	}
}
