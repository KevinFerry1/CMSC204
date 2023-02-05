/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Exception class that handles the error for no digits and sends a message.
 * Due: 2/05/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

public class NoDigitException extends Exception {
	public NoDigitException(String message) {
		super(message);
	}
}
