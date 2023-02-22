/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Stack that is used in Notation class. Implements using ArrayList treated as an Array with generics.
 * Due: 2/24/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	private ArrayList<T> myStack;
	private final int DEFAULT_SIZE = 31;
	private int maxSize;
	private int count;
	
	public MyStack() {
		myStack = new ArrayList<T>();
		
		//treats ArrayList as an array and makes it available to use set later on
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			myStack.add(null);
		}
		
		count = 0;
		maxSize = DEFAULT_SIZE;
	}
	
	public MyStack(int x) {
		myStack = new ArrayList<T>();
		
		//treats ArrayList as an array and makes it available to use set later on
		for (int i = 0; i < x; i++) {
			myStack.add(null);
		}
				
		maxSize = x;
		count = 0;
	}
	
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if (count == maxSize) {
			return true;
		}
		return false;
	}
	
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		
		T temp = myStack.get(size() - 1);
		myStack.set(size() - 1, null);
		count = count - 1;
		
		return temp;
	}
	
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		
		return myStack.get(size() - 1);
	}
	
	public int size() {
		return count;
	}
	
	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		
		myStack.set(count, e);
		count++;
		return true;
	}
	
	public String toString() {
		String string = "";
		
		for (int i = 0; i < count; i++) {
			string += myStack.get(i).toString();
		}
		return string;
	}
	
	public String toString(String delimiter) {
		String string = "";
		
		for (int i = 0; i < count - 1; i++) {
			string += myStack.get(i).toString();
			string += delimiter;
		}
		string += myStack.get(count - 1).toString();
		return string;
	}
	
	public void fill(ArrayList<T> list) throws StackOverflowException {
		ArrayList<T> listCopy = new ArrayList<T>(list);
		count = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (isFull()) {
				throw new StackOverflowException();
			}
			
			push(listCopy.get(i));
		}
	}
}
