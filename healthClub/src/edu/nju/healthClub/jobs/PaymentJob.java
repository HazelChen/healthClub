package edu.nju.healthClub.jobs;

import edu.nju.healthClub.services.UserServiceInterface;

public class PaymentJob {
	private UserServiceInterface service;
	
	public void pay() {
		service.pay();
	}

	public void setService(UserServiceInterface service) {
		this.service = service;
	}
	
	
}
