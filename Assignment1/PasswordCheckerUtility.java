/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Utility class that has methods to test password various ways and throw exceptions if password is not valid in that way.
 * Due: 2/05/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	public PasswordCheckerUtility() {
		
	}
	
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException {
		if (password.contentEquals(passwordConfirm)) {
			throw new UnmatchedException("The passwords do not match");
		}
	}
	
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		if (password.contentEquals(passwordConfirm)) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidLength(java.lang.String password) throws LengthException {
		if (password.length() >= 6) {
			return true;
		}
		throw new LengthException("The password must be at least 6 characters long");
	}
	
	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i)) == true) {
				return true;
			}
		}
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}
	
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i)) == true) {
				return true;
			}
		}
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	}
	
	public static boolean hasDigit(java.lang.String password) throws NoDigitException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i)) == true) {
				return true;
			}
		}
		throw new NoDigitException("The password must contain at least one digit");
	}
	
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
		Matcher matcher = pattern.matcher(password);
		
		if (matcher.matches()) {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
		
		return true;
	}
	
	public static boolean NoSameCharInSequence(java.lang.String password) throws InvalidSequenceException {
		if (password.length() <= 2) {
			return true;
		}
		
		if (password.charAt(0) == password.charAt(1) && password.charAt(0) == password.charAt(2)) {
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
		}
		
		return PasswordCheckerUtility.NoSameCharInSequence(password.substring(1));
	}
	
	public static boolean isValidPassword​(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		PasswordCheckerUtility.isValidLength(password);
		PasswordCheckerUtility.hasUpperAlpha(password);
		PasswordCheckerUtility.hasLowerAlpha(password);
		PasswordCheckerUtility.hasDigit(password);
		PasswordCheckerUtility.hasSpecialChar(password);
		PasswordCheckerUtility.NoSameCharInSequence(password);
		
		return true;
	}
	
	public static boolean hasBetweenSixAndNineChars(java.lang.String password) {
		if (password.length() >= 6 && password.length() <= 9) {
			return true;
		}
		return false;
	}
	
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException {
		try {
			PasswordCheckerUtility.isValidPassword​(password);
			
			if (PasswordCheckerUtility.hasBetweenSixAndNineChars(password)) {
				throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
			}
			return false;
		}
		catch(Exception x) {
			return false;
		}
	}
	
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords) {
		java.util.ArrayList<String> test = new java.util.ArrayList<String>();
		
		for (int i = 0; i < passwords.size(); i++) {
			try {
				PasswordCheckerUtility.isValidPassword​(passwords.get(i));
			}
			catch(Exception x) {
				test.add(passwords.get(i) + " -> " + x.getMessage());
			}
		}
		
		return test;
	}
}
