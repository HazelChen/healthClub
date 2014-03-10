package edu.nju.healthClub.services.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import edu.nju.healthClub.services.FileUploadServiceInterface;

public class FileUploadService implements FileUploadServiceInterface {
	public static final String ACTIVITY_IMG_PATH = "D:\\healthClubImg\\activity\\";
	public static final String USER_IMG_PATH = "D:\\healthClubImg\\user\\";
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.FileUploadServiceInterface#activityImgUpload(java.io.File, java.lang.String, java.lang.String)
	 */
	@Override
	public String activityImgUpload(File imgFile, String imgFileName, String activityId) {
		String imgPath = ACTIVITY_IMG_PATH;
		String fileName = imgUpload(imgFile, imgFileName, activityId, imgPath);
		return fileName;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.FileUploadServiceInterface#userImgUpload(java.io.File, java.lang.String, java.lang.String)
	 */
	@Override
	public String userImgUpload(File imgFile, String imgFileName, String userId) {
		String imgPath = USER_IMG_PATH;
		String fileName = imgUpload(imgFile, imgFileName, userId, imgPath);
		return fileName;
	}
	
	private String imgUpload (File imgFile, String imgFileName, String id, String imgPath) {
		int extensionPos = imgFileName.lastIndexOf(".");
		String fileName = id + imgFileName.substring(extensionPos);
		String realPath = imgPath + fileName;
        File destFile = new File(realPath);//根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。  
        try {
			FileUtils.copyFile(imgFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return fileName;
	}
}
