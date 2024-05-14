package utilities;

import java.security.SecureRandom;

public class RandomStringGenerator {

	public enum TYPE {
		N, A, AN;
	}

	private static final String NUMERIC = "0123456789";
	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String ALPHANUMERIC = ALPHA + NUMERIC;

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
