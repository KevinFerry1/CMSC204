/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Queue that is used in Notation class. Implements using ArrayList treated as an Array with generics.
 * Due: 2/24/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	private ArrayList<T> myQueue;
	private final int DEFAULT_SIZE = 31;
	private int maxSize;
	private int frontIndex, backIndex;
	
	public MyQueue(int x) {
		myQueue = new ArrayList<T>();
		
		//treats ArrayList as an array and makes it available to use set later on
		for (int i = 0; i < x; i++) {
			myQueue.add(null);
		}
		
		frontIndex = -1;
		backIndex = -1;
		maxSize = x;
	}
	
	public MyQueue() {
		myQueue = new ArrayList<T>(DEFAULT_SIZE);
		
		//treats ArrayList as an array and makes it available to use set later on
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			myQueue.add(null);
		}
		
		frontIndex = -1;
		backIndex = -1;
		maxSize = DEFAULT_SIZE;
	}
	
	public boolean isEmpty() {
		if (frontIndex == -1) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if (frontIndex == 0 && backIndex == maxSize - 1) {
			return true;
		}
		
		if (frontIndex == backIndex + 1) {
			return true;
		}
		return false;
	}
	
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T temp = myQueue.get(frontIndex);
		
		if (frontIndex == backIndex) { //if its going to be empty after this dequeue
			frontIndex = -1;
			backIndex = -1;
			return temp;
		}
		
		frontIndex = (frontIndex + 1) % maxSize;
		return temp;
	}
	
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		
		if (isFull()) {
			return maxSize;
		}
		
		if (backIndex < frontIndex) {
			return maxSize - ((frontIndex - backIndex) - 1);
		}
		
		return (backIndex - frontIndex) + 1;
	}
	
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		
		if (frontIndex == -1) {
			frontIndex = 0;
		}
		
		backIndex = (backIndex + 1) % maxSize; // % maxSize is so it goes from size-1 to 0
		myQueue.set(backIndex, e);
		
		return true;
	}
	
	public String toString() {
		String string = "";
		
		for (int i = frontIndex; i != backIndex; i = (i + 1) % maxSize) {
			string += myQueue.get(i).toString();
		}
		string += myQueue.get(backIndex).toString();
		return string;
	}
	
	public String toString(String delimiter) {
		String string = "";
		
		for (int i = frontIndex; i != backIndex; i = (i + 1) % maxSize) {
			string += myQueue.get(i).toString();
			string += delimiter;
		}
		string += myQueue.get(backIndex).toString();
		return string;
	}
	
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		ArrayList<T> listCopy = new ArrayList<T>(list);
		frontIndex = -1;
		backIndex = -1;
		
		for (int i = 0; i < list.size(); i++) {
			if (isFull()) {
				throw new QueueOverflowException();
			}
			
			enqueue(listCopy.get(i));
		}
	}
}
