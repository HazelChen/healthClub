package edu.nju.healthClub.services.impl;

import java.util.HashMap;
import java.util.Map;

import edu.nju.healthClub.services.PassportChangeServiceInterface;

public class PassportChangeService implements PassportChangeServiceInterface {
	private Map<Integer, String> passportAndResidence;
	
	public PassportChangeService() {
		initPassportMap();
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.PassportChangeServiceInterface#getResidence(java.lang.String)
	 */
	@Override
	public String getResidence(String passcode) {
		int residenceCode = Integer.parseInt(passcode.substring(0,2));
		String residence = passportAndResidence.get(residenceCode);
		return residence;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.PassportChangeServiceInterface#getSex(java.lang.String)
	 */
	@Override
	public String getSex(String passcode) {
		int sexCode = Integer.parseInt(String.valueOf(passcode.charAt(16)));
		if (sexCode % 2 == 0) {
			return "女";
		} else {
			return "男";
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.PassportChangeServiceInterface#getBirth(java.lang.String)
	 */
	@Override
	public int getBirth (String passcode) {
		String yearString = passcode.substring(5,10);
		int year = Integer.parseInt(yearString);
		return year;
	}
	
	private void initPassportMap() {
		passportAndResidence = new HashMap<Integer, String>();
		passportAndResidence.put(11, "北京");
		passportAndResidence.put(12, "天津");
		passportAndResidence.put(13, "河北");
		passportAndResidence.put(14, "山西");
		passportAndResidence.put(15, "内蒙古");
		passportAndResidence.put(21, "辽宁");
		passportAndResidence.put(22, "吉林");
		passportAndResidence.put(23, "黑龙江");
		passportAndResidence.put(31, "上海");
		passportAndResidence.put(32, "江苏");
		passportAndResidence.put(33, "浙江");
		passportAndResidence.put(34, "安徽");
		passportAndResidence.put(35, "福建");
		passportAndResidence.put(36, "江西");
		passportAndResidence.put(37, "山东");
		passportAndResidence.put(41, "河南");
		passportAndResidence.put(42, "湖北");
		passportAndResidence.put(43, "湖南");
		passportAndResidence.put(44, "广东");
		passportAndResidence.put(45, "广西");
		passportAndResidence.put(46, "海南");
		passportAndResidence.put(50, "重庆");
		passportAndResidence.put(51, "四川");
		passportAndResidence.put(52, "贵州");
		passportAndResidence.put(53, "云南");
		passportAndResidence.put(54, "西藏");
		passportAndResidence.put(61, "陕西");
		passportAndResidence.put(62, "甘肃");
		passportAndResidence.put(63, "青海");
		passportAndResidence.put(64, "宁夏");
		passportAndResidence.put(65, "新疆");
		passportAndResidence.put(71, "台湾");
		passportAndResidence.put(81, "香港");
		passportAndResidence.put(82, "澳门");
	}
}
