package edu.nju.healthClub.jobs;

import edu.nju.healthClub.services.UserService;

public class PaymentJob {
	private UserService service;
	
	public void pay() {
		service.pay();
		System.out.println("开始工作");
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	
}
