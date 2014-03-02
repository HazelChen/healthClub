package edu.nju.healthClub.actions;

import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.UserPrePageChangeService;
import edu.nju.healthClub.services.UserService;

public class LoginAction extends BaseAction{
	private static final long serialVersionUID = 897954802106607865L;
	
	private UserPrePageChangeService userPrePageChangeService;
	private UserService userService;
	
	private String prePage = "homepage.jsp";
	
	public String login() {
		putPrePage();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		User user = userService.find(id);
		if (user == null || !password.equals(user.getPassword())) {
			session.put("fail", "用户名或密码错误");
			return INPUT;
		} else {
			session.put("userid", id);
			return SUCCESS;
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
		session.remove("userid");
		session.remove("fail");
		return SUCCESS;
	}
	
	public void putPrePage() {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePage = userPrePageChangeService.change(url, queryUrl);
	}

	public void setUserPrePageChangeService(
			UserPrePageChangeService userPrePageChangeService) {
		this.userPrePageChangeService = userPrePageChangeService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
}
