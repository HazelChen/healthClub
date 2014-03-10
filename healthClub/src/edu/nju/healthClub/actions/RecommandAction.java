package edu.nju.healthClub.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.services.ActivityServiceInterface;

/**
 * @author hazel
 * 首页推荐的活动
 */
public class RecommandAction extends BaseAction{
	private static final long serialVersionUID = 1574319825950215251L;
	
	private ArrayList<Activity> recommandActivities;
	
	private ActivityServiceInterface activityService;
	
	@Override
	public String execute () throws ServletException, IOException{
		this.recommandActivities = activityService.recommand();
		return SUCCESS;
	}

	public ArrayList<Activity> getRecommandActivities () {
		return recommandActivities;
	}

	public void setActivityService(ActivityServiceInterface activityService) {
		this.activityService = activityService;
	}
	
	
	
}
