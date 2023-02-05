/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Exception class that handles the error for no lowercase letters and sends a message.
 * Due: 2/05/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException(String message) {
		super(message);
	}
}
