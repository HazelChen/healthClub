package edu.nju.healthClub.actions;

import java.io.File;
import java.util.Date;

import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.services.ActivityServiceInterface;
import edu.nju.healthClub.services.DateChangeServiceInterface;
import edu.nju.healthClub.services.FileUploadServiceInterface;

public class CreateActivityAction extends BaseAction{
	
	private static final long serialVersionUID = -7748387898106500093L;
	
	private Activity activity;
	
	private File imgFile;
	private String imgFileFileName;
	
	private ActivityServiceInterface service;
	private DateChangeServiceInterface dateChangeService;
	private FileUploadServiceInterface fileUploadService;
	
	public String create() {
		String id = service.generateId();
		Activity activity = getFormActivityAndSaveImg(id);
		service.save(activity);
		return SUCCESS;
	}
	
	/**
	 * 浏览器发出修改请求，得到activity用以显示
	 */
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

	public void setDateChangeService(DateChangeServiceInterface dateChangeService) {
		this.dateChangeService = dateChangeService;
	}

	public void setService(ActivityServiceInterface service) {
		this.service = service;
	}
	
	public void setFileUploadService(FileUploadServiceInterface fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	private Activity getFormActivityAndSaveImg (String id) {
		Activity activity = new Activity();
		activity.setId(id);
		activity.setTitle(request.getParameter("title"));
		activity.setPlace(request.getParameter("place"));
		activity.setCoach(request.getParameter("coach"));
		
		String dateString = request.getParameter("date");
		Date date = dateChangeService.StringToNormalDate(dateString);
		activity.setDate(date);
		activity.setParagraph(request.getParameter("paragraph"));
		
		if(imgFile !=null ){  
			String fileName = fileUploadService.activityImgUpload(imgFile, imgFileFileName, id);
            activity.setImageUrl(fileName);
        } else {
        	activity.setImageUrl(request.getParameter("imageUrl"));
        }
        return activity;
	}
	
}
