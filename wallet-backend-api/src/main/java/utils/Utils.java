package utils;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

	public static String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return dtf.format(LocalDateTime.now());
		
	}

	public static String generateSecureId() {
		try {

			SecureRandom number = SecureRandom.getInstance("SHA1PRNG");

			return String.valueOf(number.nextInt());

		} catch (Exception e) {
			return String.valueOf(System.currentTimeMillis());
		}
	}

}
