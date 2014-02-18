package edu.nju.healthClub.factorys;

import edu.nju.healthClub.services.AdminPrePageChangeService;
import edu.nju.healthClub.services.PrePageChangeServiceInterface;
import edu.nju.healthClub.services.UserPrePageChangeService;

public class ServiceFactory {
	public static PrePageChangeServiceInterface getUserPrePageChangeService () {
		return UserPrePageChangeService.instance();
	}
	
	public static PrePageChangeServiceInterface getAdminPrePageChangeService () {
		return AdminPrePageChangeService.instance();
	}
}
