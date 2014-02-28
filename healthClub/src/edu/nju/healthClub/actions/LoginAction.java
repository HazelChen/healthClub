package edu.nju.healthClub.actions;

import edu.nju.healthClub.services.UserPrePageChangeService;

public class LoginAction extends BaseAction{
	private static final long serialVersionUID = 897954802106607865L;
	
	private UserPrePageChangeService userPrePageChangeService;
	
	private String prePage;
	
	public String login() {
		putPrePage();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if (id.equals("123") && password.equals("123")) {
			session.put("id", id);
			return SUCCESS;
		} else {
			session.put("fail", "用户名或密码错误");
			return INPUT;
		}
	}
	
	public String getPrePage() {
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}

	public String logout() {
		putPrePage();
		if (prePage.contains("userPage")) {
			prePage = "homepage.jsp";
		}
		session.remove("id");
		session.remove("fail");
		return SUCCESS;
	}
	
	public void putPrePage() {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePage = userPrePageChangeService.change(url, queryUrl);
	}
}
