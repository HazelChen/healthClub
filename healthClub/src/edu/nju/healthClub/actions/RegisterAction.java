package edu.nju.healthClub.actions;

import edu.nju.healthClub.services.UserPrePageChangeService;


public class RegisterAction extends BaseAction{
	private static final long serialVersionUID = 8034555455451599580L;
	
	private UserPrePageChangeService userPrePageChangeService;
	
	private String prePage;

	private String id;
	
	public String getId() {
		return id;
	}
	public String getPrePage() {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePage = userPrePageChangeService.change(url, queryUrl);
		return prePage;
	}
	
	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	
	@Override
	public String execute() {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		String childCount = null;
		if (type.equals("family")) {
			childCount = request.getParameter("childCount");
		}
		System.out.println(email);
		System.out.println(password);
		System.out.println(type);
		System.out.println(childCount);
		
		id="123456789";
		
		session.put("id", id);
		
		return SUCCESS;
	}
	
	public String submitCardId () {
		String cardId = request.getParameter("cardId");
		System.out.println(cardId);
		return SUCCESS;
	}
	
	public String change() {
		return SUCCESS;
	}
	
	public String cancel() {
		return SUCCESS;
	}
}
