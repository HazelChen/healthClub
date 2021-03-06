package edu.nju.healthClub.actions;

import edu.nju.healthClub.services.AdminVerificationServiceInterface;

public class AdminLoginAction extends BaseAction{
	private static final long serialVersionUID = 1545426746338603362L;
	
	private AdminVerificationServiceInterface service;
	
	@Override
	public String execute () {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		boolean ok = service.verificate(id, password);
		if (ok) {
			session.put("adminid", id);
			return SUCCESS;
		} else {
			session.put("fail", "用户名或密码错误！");
			return INPUT;
		}
	}

	public void setService(AdminVerificationServiceInterface service) {
		this.service = service;
	}
	
}
