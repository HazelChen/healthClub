package edu.nju.healthClub.actions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.services.impl.ActivityService;
import edu.nju.healthClub.services.impl.DateChangeService;
import edu.nju.healthClub.services.impl.FileUploadPathService;

public class CreateActivityAction extends BaseAction{
	
	private static final long serialVersionUID = -7748387898106500093L;
	
	private Activity activity;
	
	private File imgFile;
	private String imgFileFileName;
	
	private ActivityService service;
	private DateChangeService dateChangeService;
	private FileUploadPathService fileUploadPathService;
	
	public String create() {
		String id = "A" + System.currentTimeMillis();
		Activity activity = getFormActivityAndSaveImg(id);
		service.save(activity);
		return SUCCESS;
	}
	
	public String change() {
		String id = request.getParameter("id");
		activity = service.findById(id);
		
		return SUCCESS;
	}
	
	public String changeSave() {
		String id = request.getParameter("id");
		Activity activity = getFormActivityAndSaveImg(id);
		service.update(activity);
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

	private Activity getFormActivityAndSaveImg (String id) {
		Activity activity = new Activity();
		activity.setId(id);
		activity.setTitle(request.getParameter("title"));
		activity.setPlace(request.getParameter("place"));
		activity.setCoach(request.getParameter("coach"));
		
		String dateString = request.getParameter("date");
		Date date = dateChangeService.StringToDate(dateString);
		activity.setDate(date);
		activity.setParagraph(request.getParameter("paragraph"));
		
		if(imgFile !=null ){  
			int extensionPos = imgFileFileName.lastIndexOf(".");
			String fileName = id + imgFileFileName.substring(extensionPos);
			String realPath = fileUploadPathService.getActivityPath() + fileName;
            File destFile = new File(realPath);//根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。  
            try {
				FileUtils.copyFile(imgFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
            activity.setImageUrl(fileName);
        } else {
        	activity.setImageUrl(request.getParameter("imageUrl"));
        }
        return activity;
	}
	
}
