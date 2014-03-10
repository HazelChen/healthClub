package edu.nju.healthClub.services.impl;

import edu.nju.healthClub.services.UserNumberGenerateServiceInterface;

public class UserNumberGenerateService implements UserNumberGenerateServiceInterface {

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserNumberGenerateServiceInterface#generate()
	 */
	@Override
	public synchronized String generate() {
		String timeString = Long.toString(System.currentTimeMillis());
		String idNumber = "" + timeString.charAt(2) + timeString.charAt(4)
				+ timeString.charAt(6) + timeString.charAt(8) + timeString.charAt(9) + timeString.charAt(10);
		return idNumber;

	}
}
