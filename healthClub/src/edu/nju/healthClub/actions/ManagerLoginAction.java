package edu.nju.healthClub.actions;

public class ManagerLoginAction extends BaseAction{
	private static final long serialVersionUID = 5725554387307121434L;

	@Override
	public String execute () {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if (id.equals("123") && password.equals("123")) {
			session.put("adminId", id);
			return SUCCESS;
		} else {
			session.put("fail", "用户名或密码错误");
			return INPUT;
		}
	}
}
