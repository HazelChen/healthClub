package edu.nju.healthClub.jobs;

import edu.nju.healthClub.services.impl.UserService;

public class PaymentJob {
	private UserService service;
	
	public void pay() {
		service.pay();
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	
}
