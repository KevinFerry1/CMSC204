/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Exception class if queue is overflowed.
 * Due: 2/24/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

public class QueueOverflowException extends Exception {
	QueueOverflowException() {
		super("Queue Overflow");
	}
}
