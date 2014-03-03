package edu.nju.healthClub.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.ActivityReserveShow;
import edu.nju.healthClub.model.PaymentRecords;
import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.ReserveService;
import edu.nju.healthClub.services.UserService;

public class UserPageAction extends BaseAction{
	private static final long serialVersionUID = 5917450856728620395L;
	
	private User user;
	private ArrayList<ActivityReserve> activityReserves;
	private Set<PaymentRecords> paymentRecords;
	
	private UserService userService;
	private ReserveService reserveService;
	
	@Override
	public String execute() {
		String id = (String)session.get("userid");
		user = userService.find(id);
		
		activityReserves = reserveService.findByUser(user);
		
		paymentRecords = user.getPaymentRecords();
		return SUCCESS;
	}
	
	public String getUserInfo() {
		String id = request.getParameter("id");		
user = userService.find(id);
		
		activityReserves = reserveService.findByUser(user);
		
		paymentRecords = user.getPaymentRecords();
		return SUCCESS;
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

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setReserveService(ReserveService reserveService) {
		this.reserveService = reserveService;
	}
}
