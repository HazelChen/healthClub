package edu.nju.healthClub.actions;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.healthClub.model.ActivityReserveShow;
import edu.nju.healthClub.model.PaymentRecords;
import edu.nju.healthClub.model.User;

public class UserPageAction extends BaseAction{
	private static final long serialVersionUID = 5917450856728620395L;
	
	private User user;
	private ArrayList<ActivityReserveShow> activityReserveShows;
	private ArrayList<PaymentRecords> paymentRecords;
	
	public User getUser() {
		return user;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public ArrayList<PaymentRecords> getPaymentRecords() {
		return paymentRecords;
	}


	public void setPaymentRecords(ArrayList<PaymentRecords> paymentRecords) {
		this.paymentRecords = paymentRecords;
	}


	public ArrayList<ActivityReserveShow> getActivityReserveShows() {
		return activityReserveShows;
	}


	public void setActivityReserveShows(
			ArrayList<ActivityReserveShow> activityReserveShows) {
		this.activityReserveShows = activityReserveShows;
	}


	@Override
	public String execute() {
		String id = (String)session.get("id");		
		user = new User(id, "images/mm.jpg", "海维", "123@123.com", "person", 0, 3);
		
		activityReserveShows = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 11, 20);
		ActivityReserveShow activityReserveShow1 = new ActivityReserveShow("1","冷宫的房檐下，李未央数着长发上的第六只虱子", calendar.getTime(), calendar.getTime());
		ActivityReserveShow activityReserveShow2 = new ActivityReserveShow("2","常年没有澡洗，身上像长了层厚厚的盔甲", calendar.getTime(), calendar.getTime());
		ActivityReserveShow activityReserveShow3 = new ActivityReserveShow("3","捉虱子便成了她打发时间的唯一方法", calendar.getTime(), calendar.getTime());
		ActivityReserveShow activityReserveShow4 = new ActivityReserveShow("4","十二年了，被关进冷宫整整十二年了", calendar.getTime(), calendar.getTime());
		ActivityReserveShow activityReserveShow5 = new ActivityReserveShow("5","未央抬起头看着天空，每到这样下雨的天气", calendar.getTime(), calendar.getTime());
		activityReserveShows.add(activityReserveShow1);
		activityReserveShows.add(activityReserveShow2);
		activityReserveShows.add(activityReserveShow3);
		activityReserveShows.add(activityReserveShow4);
		activityReserveShows.add(activityReserveShow5);
		
		paymentRecords = new ArrayList<>();
		PaymentRecords paymentRecords1 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords2 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords3 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords4 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords5 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords6 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords7 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords8 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		paymentRecords.add(paymentRecords1);
		paymentRecords.add(paymentRecords2);
		paymentRecords.add(paymentRecords3);
		paymentRecords.add(paymentRecords4);
		paymentRecords.add(paymentRecords5);
		paymentRecords.add(paymentRecords6);
		paymentRecords.add(paymentRecords7);
		paymentRecords.add(paymentRecords8);
		return SUCCESS;
		
	}
	
	public String getUserInfo() {
		String id = request.getParameter("id");		
		user = new User(id, "images/mm.jpg", "海维", "123@123.com", "person", 0, 3);
		
		activityReserveShows = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 11, 20);
		ActivityReserveShow activityReserveShow1 = new ActivityReserveShow("1","冷宫的房檐下，李未央数着长发上的第六只虱子", calendar.getTime(), calendar.getTime());
		ActivityReserveShow activityReserveShow2 = new ActivityReserveShow("2","常年没有澡洗，身上像长了层厚厚的盔甲", calendar.getTime(), calendar.getTime());
		ActivityReserveShow activityReserveShow3 = new ActivityReserveShow("3","捉虱子便成了她打发时间的唯一方法", calendar.getTime(), calendar.getTime());
		ActivityReserveShow activityReserveShow4 = new ActivityReserveShow("4","十二年了，被关进冷宫整整十二年了", calendar.getTime(), calendar.getTime());
		ActivityReserveShow activityReserveShow5 = new ActivityReserveShow("5","未央抬起头看着天空，每到这样下雨的天气", calendar.getTime(), calendar.getTime());
		activityReserveShows.add(activityReserveShow1);
		activityReserveShows.add(activityReserveShow2);
		activityReserveShows.add(activityReserveShow3);
		activityReserveShows.add(activityReserveShow4);
		activityReserveShows.add(activityReserveShow5);
		
		paymentRecords = new ArrayList<>();
		PaymentRecords paymentRecords1 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords2 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords3 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords4 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords5 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords6 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords7 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		PaymentRecords paymentRecords8 = new PaymentRecords("会员月费用", 20, calendar.getTime());
		paymentRecords.add(paymentRecords1);
		paymentRecords.add(paymentRecords2);
		paymentRecords.add(paymentRecords3);
		paymentRecords.add(paymentRecords4);
		paymentRecords.add(paymentRecords5);
		paymentRecords.add(paymentRecords6);
		paymentRecords.add(paymentRecords7);
		paymentRecords.add(paymentRecords8);
		return SUCCESS;
	}
}
