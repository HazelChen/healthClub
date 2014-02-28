package edu.nju.healthClub.actions;

import java.io.IOException;

import javax.servlet.ServletException;

public class UserBarAction extends BaseAction{
	private static final long serialVersionUID = 5144563963912658234L;
	
	private String id;

	@Override
	public String execute () throws ServletException, IOException {
		String id = (String) session.get("userid");
		if (id == null) {
			return "notLogon";
		} else {
			this.id = id;
			return "logon";
		}
		
	}
	
	public String getId () {
		return id;
	}
}
