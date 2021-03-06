package edu.nju.healthClub.actions;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.UserServiceInterface;

public class UserBarAction extends BaseAction{
	private static final long serialVersionUID = 5144563963912658234L;
	
	private String id;
	private User user;
	
	private UserServiceInterface userService;

	/** (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * 判断用户是否登录，如果登录，就给界面用户的信息
	 */
	@Override
	public String execute () throws ServletException, IOException {
		String id = (String) session.get("userid");
		if (id == null) {
			return "notLogon";
		} else {
			this.id = id;
			this.user = userService.find(id);
			return "logon";
		}
		
	}
	
	public String getId () {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUserService(UserServiceInterface userService) {
		this.userService = userService;
	}
}
