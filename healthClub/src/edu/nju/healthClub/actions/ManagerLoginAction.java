package edu.nju.healthClub.actions;

import edu.nju.healthClub.services.ManagerVerificationInterface;

public class ManagerLoginAction extends BaseAction{
	private static final long serialVersionUID = 5725554387307121434L;

	private ManagerVerificationInterface service;
	
	@Override
	public String execute () {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		boolean ok = service.verificate(id, password);
		if (ok) {
			session.put("managerid", id);
			return SUCCESS;
		} else {
			session.put("fail", "用户名或密码错误！");
			return INPUT;
		}
	}

	public void setService(ManagerVerificationInterface service) {
		this.service = service;
	}
	
}
