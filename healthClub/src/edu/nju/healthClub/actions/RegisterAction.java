package edu.nju.healthClub.actions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.BankService;
import edu.nju.healthClub.services.FileUploadPathService;
import edu.nju.healthClub.services.UserPrePageChangeService;
import edu.nju.healthClub.services.UserService;


public class RegisterAction extends BaseAction{
	private static final long serialVersionUID = 8034555455451599580L;
	
	private UserPrePageChangeService userPrePageChangeService;
	private FileUploadPathService fileUploadPathService;
	private UserService userService;
	
	private String prePage;
	private String id;
	private File headerImgFile;
	private String headerImgFileFileName;
	
	@Override
	public String execute() {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String type = request.getParameter("type");
		user.setType(type);
		if (type.equals("family")) {
			id = "F" + System.currentTimeMillis();
			int childCount = Integer.parseInt(request.getParameter("childCount"));
			user.setChildCount(childCount);
		} else {
			id = "P" + System.currentTimeMillis();
		}
		user.setId(id);
		userService.save(user);
		
		session.put("userid", id);
		
		return SUCCESS;
	}
	
	public String submitCardId () {
		String id = (String) session.get("userid");
		User user = userService.find(id);
		String cardId = request.getParameter("cardId");
		userService.activate(user, cardId);
		return SUCCESS;
	}
	
	public String change() {
		User user = new User();
		String userId = (String)session.get("userid");
		user.setId(userId);
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setChildCount(Integer.parseInt(request.getParameter("childCount")));
		user.setType(request.getParameter("type"));
		Bank bank = new Bank();
		bank.setId(request.getParameter("bank"));
		user.setBank(bank);
		
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
	
	public String cancel() {
		return SUCCESS;
	}
	
	public String getId() {
		return id;
	}
	public String getPrePage() {
		String url = (String) session.get("prePage");
		String queryUrl = (String) session.get("queryUrl");
		prePage = userPrePageChangeService.change(url, queryUrl);
		return prePage;
	}
	
	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}

	public void setUserPrePageChangeService(
			UserPrePageChangeService userPrePageChangeService) {
		this.userPrePageChangeService = userPrePageChangeService;
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
}
