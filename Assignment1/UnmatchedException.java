/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Exception class that handles the error for unmatched password retype and sends a message.
 * Due: 2/05/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

public class UnmatchedException extends Exception {
	public UnmatchedException(String message) {
		super(message);
	}
}
