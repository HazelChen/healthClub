package edu.nju.healthClub.actions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.PrePageService;
import edu.nju.healthClub.services.impl.AdminPrePageChangeService;
import edu.nju.healthClub.services.impl.FileUploadPathService;
import edu.nju.healthClub.services.impl.UserNumberGenerateService;
import edu.nju.healthClub.services.impl.UserPrePageChangeService;
import edu.nju.healthClub.services.impl.UserService;


public class RegisterAction extends BaseAction{
	private static final long serialVersionUID = 8034555455451599580L;
	
	private PrePageService prePageService;
	private FileUploadPathService fileUploadPathService;
	private UserNumberGenerateService userNumberGenerateService;
	private UserService userService;
	
	private String prePage;
	private String id;
	private File headerImgFile;
	private String headerImgFileFileName;
	
	@Override
	public String execute() {
		prePageService = UserPrePageChangeService.instance();
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String type = request.getParameter("type");
		user.setType(type);
		if (type.equals("family")) {
			id = "F" + userNumberGenerateService.generate();
			int childCount = Integer.parseInt(request.getParameter("childCount"));
			user.setChildCount(childCount);
		} else {
			id = "P" + userNumberGenerateService.generate();
		}
		user.setId(id);
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
	
	public String notActive () {
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

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setFileUploadPathService(FileUploadPathService fileUploadPathService) {
		this.fileUploadPathService = fileUploadPathService;
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
			UserNumberGenerateService userNumberGenerateService) {
		this.userNumberGenerateService = userNumberGenerateService;
	}
	
	private String change(String userId) {
		User user = new User();
		user.setId(userId);
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		String childCountString = request.getParameter("childCount");
		if (childCountString!= null && !childCountString.equals("")) {
			user.setChildCount(Integer.parseInt(request.getParameter("childCount")));
		}
		user.setType(request.getParameter("type"));
		String bankIdSaved = request.getParameter("bank");
		if (!bankIdSaved.equals("")) {
			Bank bank = new Bank();
			bank.setId(request.getParameter("bank"));
			user.setBank(bank);
		}
		
		if(headerImgFile !=null ){  
			int extensionPos = headerImgFileFileName.lastIndexOf(".");
			String fileName = userId + headerImgFileFileName.substring(extensionPos);
			String realPath = fileUploadPathService.getUserPath() + fileName;
            File destFile = new File(realPath);//根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。  
            try {
				FileUtils.copyFile(headerImgFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
}
