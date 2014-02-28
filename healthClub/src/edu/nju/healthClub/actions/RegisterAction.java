package edu.nju.healthClub.actions;

import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.BankService;
import edu.nju.healthClub.services.UserPrePageChangeService;
import edu.nju.healthClub.services.UserService;


public class RegisterAction extends BaseAction{
	private static final long serialVersionUID = 8034555455451599580L;
	
	private UserPrePageChangeService userPrePageChangeService;
	private UserService userService;
	private BankService bankService;
	
	private String prePage;
	private String id;
	
	@Override
	public String execute() {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String type = request.getParameter("type");
		user.setType(type);
		if (type.equals("family")) {
			id = "F" + System.currentTimeMillis();
			int childCount = Integer.parseInt(request.getParameter("childCount"));
			user.setChildCount(childCount);
		} else {
			id = "P" + System.currentTimeMillis();
		}
		user.setId(id);
		Bank bank = new Bank();
		bank.setId("004");
		bank.setBalance(500);
		user.setBank(bank);
		userService.save(user);
		
		session.put("userid", id);
		
		return SUCCESS;
	}
	
	public String submitCardId () {
		String id = (String) session.get("userid");
		User user = userService.find(id);
		String cardId = request.getParameter("cardId");
		Bank bank = bankService.find(cardId);
		user.setBank(bank);
		userService.update(user);
		return SUCCESS;
	}
	
	public String change() {
		return SUCCESS;
	}
	
	public String cancel() {
		return SUCCESS;
	}
	
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


	public void setUserPrePageChangeService(
			UserPrePageChangeService userPrePageChangeService) {
		this.userPrePageChangeService = userPrePageChangeService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}
	
	
	
	
}
