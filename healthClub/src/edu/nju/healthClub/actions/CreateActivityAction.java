package edu.nju.healthClub.actions;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.services.ActivityService;
import edu.nju.healthClub.services.DateChangeService;
import edu.nju.healthClub.services.FileUploadPathService;

public class CreateActivityAction extends BaseAction{
	
	private static final long serialVersionUID = -7748387898106500093L;
	
	private Activity activity;
	
	private File imgFile;
	private String imgFileFileName;
	
	private ActivityService service;
	private DateChangeService dateChangeService;
	private FileUploadPathService fileUploadPathService;
	
	public String create() {
		Activity activity = getFormActivity();
		service.save(activity);
		return SUCCESS;
	}
	
	public String change() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1992, 01, 01);
		activity = new Activity(calendar.getTime(), 
				"【微软通过Android获16亿美元年收入】最新报告显示，Android系统每年给微软带来了巨额授权收入。由于谷歌和微软之间的授权协议，微软通过每台Android设备获得约5美元的授权收入，而微软的授权协议已覆盖70%市场。而Windows Phone相同财年给微软带来的利润是3.47亿美元。", 
				"微软and安卓", 
				"微博", 
				"机器人");
		return SUCCESS;
	}
	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public void setDateChangeService(DateChangeService dateChangeService) {
		this.dateChangeService = dateChangeService;
	}

	public void setService(ActivityService service) {
		this.service = service;
	}
	
	public void setFileUploadPathService(FileUploadPathService fileUploadPathService) {
		this.fileUploadPathService = fileUploadPathService;
	}

	private Activity getFormActivity () {
		String id = "A" + System.currentTimeMillis();
		String title = request.getParameter("title");
		String place = request.getParameter("place");
		String coach = request.getParameter("coach");
		String dateString = request.getParameter("date");
		Date date = dateChangeService.StringToDate(dateString);
		String paragraph = request.getParameter("paragraph");
		
		int extensionPos = imgFileFileName.lastIndexOf( "." );
		String fileName = id + imgFileFileName.substring(extensionPos);
		String realPath = fileUploadPathService.getActivityPath() + fileName;
        System.out.println(realPath);  
        if(imgFile !=null ){  
            File destFile = new File(realPath);//根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。  
            try {
				FileUtils.copyFile(imgFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}  
        }
        Activity activity = new Activity(id, date, fileName, paragraph, title, place, coach);
        return activity;
	}
	
}
