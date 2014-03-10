package edu.nju.healthClub.actions;

import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.services.PrePageService;
import edu.nju.healthClub.services.impl.AdminPrePageChangeService;
import edu.nju.healthClub.services.impl.ReserveService;
import edu.nju.healthClub.services.impl.UserPrePageChangeService;

public class ReserveAction extends BaseAction{
	private static final long serialVersionUID = 6822203867640557812L;
	
	private String prePage;
	/**
	 * prePage传来的是个action
	 */
	private boolean isAction;
	
	private PrePageService prePageChangeService;
	private ReserveService reserveService;
	
	/** (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * @return SUCCESS：预订成功；INPUT：需要登录
	 */
	@Override
	public String execute() {
		prePageChangeService = UserPrePageChangeService.instance();
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
		prePageChangeService = AdminPrePageChangeService.instance();
		String userId = request.getParameter("userId");
		String activityId = request.getParameter("activityId");
		reserveService.reserve(userId, activityId);
		return SUCCESS;
	}
	
	public String userCancel () {
		prePageChangeService = UserPrePageChangeService.instance();
		return cancel();
	}
	
	public String adminCancel () {
		isAction = true;
		prePageChangeService = AdminPrePageChangeService.instance();
		return cancel();
	}
	
	public String getPrePage() {
		String url = (String) session.get("prePage");
		if (isAction) {
			url = url.replace(".jsp", "");
		}
		String queryUrl = (String) session.get("queryUrl");
		prePage = prePageChangeService.change(url, queryUrl);
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	
	public void setReserveService(ReserveService reserveService) {
		this.reserveService = reserveService;
	}

	private String cancel() {
		String userId = request.getParameter("userId");
		String activityId = request.getParameter("activityId");
		ActivityReserve activityReserve = reserveService.find(userId, activityId);
		reserveService.cancel (activityReserve);
		return SUCCESS;
	}
}
