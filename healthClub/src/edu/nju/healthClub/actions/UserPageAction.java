package edu.nju.healthClub.actions;

import java.util.ArrayList;
import java.util.Set;

import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.PaymentRecords;
import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.ReserveServiceInterface;
import edu.nju.healthClub.services.UserServiceInterface;

public class UserPageAction extends BaseAction{
	private static final long serialVersionUID = 5917450856728620395L;
	
	private User user;
	private ArrayList<ActivityReserve> activityReserves;
	private Set<PaymentRecords> paymentRecords;
	
	private UserServiceInterface userService;
	private ReserveServiceInterface reserveService;
	
	@Override
	public String execute() {
		String id = (String)session.get("userid");
		return getUserInfo(id);
	}
	
	public String getUserInfoForAdmin () {
		String id = request.getParameter("userId");
		return getUserInfo(id);
	}
	
	public User getUser() {
		return user;
	}
	
	public Set<PaymentRecords> getPaymentRecords() {
		return paymentRecords;
	}

	public ArrayList<ActivityReserve> getActivityReserves() {
		return activityReserves;
	}

	public void setUserService(UserServiceInterface userService) {
		this.userService = userService;
	}

	public void setReserveService(ReserveServiceInterface reserveService) {
		this.reserveService = reserveService;
	}
	
	private String getUserInfo(String id) {
		user = userService.find(id);
		
		activityReserves = reserveService.findByUser(user);
		
		paymentRecords = user.getPaymentRecords();
		return SUCCESS;
	}
}
