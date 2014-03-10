package edu.nju.healthClub.services;

import java.io.File;

public interface FileUploadServiceInterface {

	/**
	 * @return 文件名
	 */
	public abstract String activityImgUpload(File imgFile, String imgFileName,
			String activityId);

	/**
	 * @return 文件名
	 */
	public abstract String userImgUpload(File imgFile, String imgFileName,
			String userId);

}