package utilities;

import java.security.SecureRandom;

public class RandomStringGenerator {

	// ----------------String type enum if you want to generate numeric type string
	// select 'N', for alphabatic type string select 'A' and for alphanumeric type
	// string select 'AN'
	public enum TYPE {
		N, A, AN;
	}

	// -------------assign value to variables of contants type
	private static final String NUMERIC = "0123456789";
	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String ALPHANUMERIC = ALPHA + NUMERIC;

	/**
	 * This Method will generate randomString bases on given length and type
	 * 
	 * @param length
	 * @param type   select from enum
	 * @return random string
	 */
	public static String generateRandomString(int length, TYPE type) {

		StringBuilder stringBuilder = new StringBuilder(length);
		SecureRandom random = new SecureRandom();

		switch (type) {
		case N:
			for (int i = 0; i < length; i++) {
				stringBuilder.append(NUMERIC.charAt(random.nextInt(NUMERIC.length())));
			}
			break;
		case A:
			for (int i = 0; i < length; i++) {
				stringBuilder.append(ALPHA.charAt(random.nextInt(ALPHA.length())));
			}
			break;
		case AN:
			for (int i = 0; i < length; i++) {
				stringBuilder.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid type. Choose 'numeric', 'alpha', or 'alphanumeric'.");
		}

		return stringBuilder.toString();
	}

}
