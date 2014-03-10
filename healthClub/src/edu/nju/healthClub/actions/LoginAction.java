package edu.nju.healthClub.actions;

import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.PrePageService;
import edu.nju.healthClub.services.UserServiceInterface;
import edu.nju.healthClub.services.impl.UserPrePageChangeService;

public class LoginAction extends BaseAction{
	private static final long serialVersionUID = 897954802106607865L;
	
	private PrePageService prePageChangeService;
	private UserServiceInterface userService;
	
	/**
	 * 如果用户在查看用户界面注销，必须返回主页，不论prepage是什么
	 */
	private boolean isMustHomepage;
	
	/**
	 * 默认返回主页
	 */
	private String prePage = "homepage.jsp";
	
	public String login() {
		prePageChangeService = UserPrePageChangeService.instance();
		
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

	public String logout() {
		prePageChangeService = UserPrePageChangeService.instance();
		if (prePage.contains("userPage")) {
			isMustHomepage = true;
		}
		session.remove("userid");
		session.remove("fail");
		return SUCCESS;
	}
	
	public void setUserService(UserServiceInterface userService) {
		this.userService = userService;
	}
	
	public String getPrePage() {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePage = prePageChangeService.change(url, queryUrl);
		if (isMustHomepage) {
			prePage = "homepage.jsp";
		}
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	
	
}
