package edu.nju.healthClub.actions;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.DateChangeServiceInterface;
import edu.nju.healthClub.services.FileUploadServiceInterface;
import edu.nju.healthClub.services.PrePageService;
import edu.nju.healthClub.services.UserNumberGenerateServiceInterface;
import edu.nju.healthClub.services.UserServiceInterface;
import edu.nju.healthClub.services.impl.AdminPrePageChangeService;
import edu.nju.healthClub.services.impl.UserPrePageChangeService;


public class RegisterAction extends BaseAction{
	private static final long serialVersionUID = 8034555455451599580L;
	
	private PrePageService prePageService;
	private FileUploadServiceInterface fileUploadService;
	private UserNumberGenerateServiceInterface userNumberGenerateService;
	private DateChangeServiceInterface dateChangeService;
	private UserServiceInterface userService;
	
	private String prePage;
	private String id;
	private File headerImgFile;
	private String headerImgFileFileName;
	
	/** (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * 得到表单里的用户数据并保存
	 */
	@Override
	public String execute() {
		prePageService = UserPrePageChangeService.instance();
		
		String type = request.getParameter("type");
		if (type.equals("family")) {
			id = "F" + userNumberGenerateService.generate();
		} else {
			id = "P" + userNumberGenerateService.generate();
		}
		User user = getSimpleUserFromForm(id);
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		user.setNewDate(date);
		userService.save(user);
		
		session.put("userid", id);
		
		return SUCCESS;
	}
	
	public String userSubmitCardId() {
		prePageService = UserPrePageChangeService.instance();
		String id = (String) session.get("userid");
		return submitCardId(id);
	}
	
	public String adminSubmitCardId() {
		prePageService = AdminPrePageChangeService.instance();
		String id = request.getParameter("userId");
		return submitCardId(id);
	}
	
	/**
	 * @return 当用户选择暂时不激活，可以返回前一个页面
	 */
	public String notActive () {
		prePageService = UserPrePageChangeService.instance();
		return SUCCESS;
	}
	
	public String userChange() {
		prePageService = UserPrePageChangeService.instance();
		String userId = (String)session.get("userid");
		return change(userId);
	}
	
	public String adminChange() {
		prePageService = AdminPrePageChangeService.instance();
		String userId = request.getParameter("id");
		return change(userId);
	}
	
	public String userCancel () {
		prePageService = UserPrePageChangeService.instance();
		String userId = (String) session.get("userid");
		return cancel(userId);
	}
	
	public String adminCancel () {
		prePageService = AdminPrePageChangeService.instance();
		String userId = request.getParameter("userId");
		return cancel(userId);
	}
	
	public String getId() {
		return id;
	}
	
	
	public String getPrePage() {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePage = prePageService.change(url, queryUrl);
		return prePage;
	}
	
	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}

	public void setUserService(UserServiceInterface userService) {
		this.userService = userService;
	}

	public void setFileUploadService(FileUploadServiceInterface fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	public File getHeaderImgFile() {
		return headerImgFile;
	}

	public void setHeaderImgFile(File headerImgFile) {
		this.headerImgFile = headerImgFile;
	}

	public String getHeaderImgFileFileName() {
		return headerImgFileFileName;
	}

	public void setHeaderImgFileFileName(String headerImgFileFileName) {
		this.headerImgFileFileName = headerImgFileFileName;
	}

	public void setUserNumberGenerateService(
			UserNumberGenerateServiceInterface userNumberGenerateService) {
		this.userNumberGenerateService = userNumberGenerateService;
	}
	
	public void setDateChangeService(DateChangeServiceInterface dateChangeService) {
		this.dateChangeService = dateChangeService;
	}

	private String change(String userId) {
		User user = getSimpleUserFromForm(userId);
		userComplementFormForm(user);
		
		if(headerImgFile !=null ){  
			String fileName = fileUploadService.userImgUpload(headerImgFile, headerImgFileFileName, userId);
            user.setHeaderUrl(fileName);
        } else {
        	user.setHeaderUrl(request.getParameter("headerUrl"));
        }
		userService.update(user);
		return SUCCESS;
	}
	
	private String submitCardId (String userId) {
		User user = userService.find(userId);
		String cardId = request.getParameter("cardId");
		userService.activate(user, cardId);
		return SUCCESS;
	}
	
	private String cancel(String userId) {
		User user = userService.find(userId);
		user.setBank(null);
		userService.update(user);
		return SUCCESS;
	}
	
	private User getSimpleUserFromForm(String userId) {
		User user = new User();
		user.setId(userId);
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setType(request.getParameter("type"));
		String childCountString = request.getParameter("childCount");
		if (childCountString!= null && !childCountString.equals("")) {
			user.setChildCount(Integer.parseInt(request.getParameter("childCount")));
		}
		return user;
	}
	
	private void userComplementFormForm(User user) {
		user.setUsername(request.getParameter("username"));
		String bankIdSaved = request.getParameter("bank");
		if (!bankIdSaved.equals("")) {
			Bank bank = new Bank();
			bank.setId(request.getParameter("bank"));
			user.setBank(bank);
		}
		Date newDate = dateChangeService.StringToNormalDate(request.getParameter("newDate"));
		user.setNewDate(newDate);
		Date suspendDate = dateChangeService.StringToNormalDate(request.getParameter("suspendDate"));
		user.setSuspendDate(suspendDate);
		Date stopDate = dateChangeService.StringToNormalDate(request.getParameter("stopDate"));
		user.setStopDate(stopDate);
	}
}
