package edu.nju.healthClub.services;

import java.util.ArrayList;

import edu.nju.healthClub.dao.UserDAOInterface;
import edu.nju.healthClub.model.MemberAgeStatistics;
import edu.nju.healthClub.model.MemberPlaceStatistics;
import edu.nju.healthClub.model.MemberSexStatistics;
import edu.nju.healthClub.model.MembershipStatistics;
import edu.nju.healthClub.model.MonthSelection;
import edu.nju.healthClub.model.User;

public interface UserServiceInterface {

	public abstract void save(User user);

	public abstract void update(User user);

	public abstract User find(String id);

	public abstract void pay();

	public abstract void activate(User user, String bankId);

	public abstract ArrayList<MonthSelection> getDuration(String selectedMonth);

	public abstract MembershipStatistics getMembershipStatistics(
			String dateString);

	public abstract MemberPlaceStatistics getMemberPlaceStatistics(
			String dateString);

	public abstract MemberAgeStatistics getMemberAgeStatistics(String dateString);

	public abstract MemberSexStatistics getMemberSexStatistics(String dateString);

	public abstract void setUserDAO(UserDAOInterface userDAO);

	public abstract void setBankService(BankServiceInterface bankService);

	public abstract void setPaymentService(
			PaymentServiceInterface paymentService);

	public abstract void setDateChangeService(
			DateChangeServiceInterface dateChangeService);

	public abstract void setPassportChangeService(
			PassportChangeServiceInterface passportChangeService);

}