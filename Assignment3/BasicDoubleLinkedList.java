/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Non Sorted double linked list that has various methods and classes used to perform iterations, removals, adds, and more.
 * Due: 3/5/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.util.ArrayList;
import java.util.ListIterator;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	protected Node head, tail;
	protected int size;
	
	public BasicDoubleLinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void addToEnd(T data) {
		Node temp = new Node(data); //makes new temp node
		
		if (head == null && tail == null) { //if empty then make one node and have head and tail point to it
			head = temp;
			tail = temp;
			size++;
			return;
		}
		
		tail.next = temp; //adds the new temp node to the end
		temp.prev = tail; //sets the new temp nodes prev field to the tail node
		tail = temp; //sets tail to be temp which is now the new tail
		size++;
	}
	
	public void addToFront(T data) {
		Node temp = new Node(data);
		
		if (head == null && tail == null) { //if empty then make one node and have head and tail point to it
			head = temp;
			tail = temp;
			size++;
			return;
		}
		
		head.prev = temp;
		temp.next = head;
		head = temp;
		size++;
	}
	
	public T getFirst() {
		return head.data;
	}
	
	public T getLast() {
		return tail.data;
	}
	
	public java.util.ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	public BasicDoubleLinkedList.Node remove(T targetData, java.util.Comparator<T> comparator) {
		Node currentNode = head;
		Node temp;
		
		while (currentNode != null) {
			if (comparator.compare(targetData, currentNode.data) == 0) {
				temp = currentNode;
				
				if (currentNode == head) { //if the match is the head, make new head the next one
					head = currentNode.next;
					size = size - 1;
					return temp;
				}
				if (currentNode == tail) { //if the match is the tail, make new tail the prev one
					tail = currentNode.prev;
					size = size - 1;
					return temp;
				}
				currentNode.prev.next = currentNode.next;
				currentNode.next.prev = currentNode.prev;
				size = size - 1;
				return temp;
			}
			currentNode = currentNode.next;
		}
		return null;
	}
	
	public T retrieveFirstElement() {
		if (head == null && tail == null) {
			return null;
		}
		
		T tempData = getFirst();
		head.next.prev = null;
		head = head.next;
		return tempData;
	}
	
	public T retrieveLastElement() {
		if (head == null && tail == null) {
			return null;
		}
		
		T tempData = getLast();
		tail.prev.next = null;
		tail = tail.prev;
		return tempData;
	}
	
	public java.util.ArrayList<T> toArrayList() {
		ArrayList<T> tempArrayList = new ArrayList<T>();
		ListIterator<T> iterator = iterator();
		
		while (iterator.hasNext()) {
			tempArrayList.add(iterator.next());
		}
		return tempArrayList;
	}
	
	/*
	 * Class: CMSC204 
	 * Instructor: Dr. Kuijt
	 * Description: Node class that deals with each individual node of linked list
	 * Due: 3/5/23
	 * Platform/compiler: Eclipse
	 * I pledge that I have completed the programming 
	 * assignment independently. I have not copied the code 
	 * from a student or any source. I have not given my code 
	 * to any student.
	   Print your Name here: Kevin Ferry
	*/
	//Inner Node Class
	protected class Node {
		protected T data;
		protected Node prev, next;
		
		public Node(T dataNode) {
			data = dataNode;
		}
	}
	
	/*
	 * Class: CMSC204 
	 * Instructor: Dr. Kuijt
	 * Description: Iterator for double linked list. Checks if their is a next or previous element and returns the next or previous element
	 * Due: 3/5/23
	 * Platform/compiler: Eclipse
	 * I pledge that I have completed the programming 
	 * assignment independently. I have not copied the code 
	 * from a student or any source. I have not given my code 
	 * to any student.
	   Print your Name here: Kevin Ferry
	*/
	//Inner Iterator
	protected class DoubleLinkedListIterator implements ListIterator<T> {
		private Node headNode, lastNode, firstNode;
		
		public DoubleLinkedListIterator() {
			headNode = head;
			lastNode = null;
			firstNode = null;
		}
		
		public boolean hasNext() {
			if (firstNode != null) {
				return true;
			}
			if (headNode == null) {
				return false;
			}
			return true;
		}
		
		public T next() throws java.util.NoSuchElementException {
			T tempData;
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			
			if (firstNode != null) {
				tempData = firstNode.data;
				headNode = firstNode.next;
				firstNode = null;
			}
			else {
				tempData = headNode.data;
				
				if (headNode.next == null) {
					lastNode = headNode;
				}
				else {
					lastNode = null;
				}
				headNode = headNode.next;
			}
			
			return tempData;
		}
		
		public boolean hasPrevious() {
			if (lastNode != null) {
				return true;
			}
			if (headNode.prev == null) {
				return false;
			}
			return true;
		}
		
		public T previous() throws java.util.NoSuchElementException {
			T tempData;
			if (!hasPrevious()) {
				throw new java.util.NoSuchElementException();
			}
			
			if (lastNode != null) {
				tempData = lastNode.data;
				headNode = lastNode;
				lastNode = null;
			}
			else {
				tempData = headNode.prev.data;
				
				if (headNode.prev == null) {
					firstNode = headNode;
				}
				else {
					firstNode = null;
				}
				headNode = headNode.prev;
			}
			
			return tempData;
		}
		
		public void remove() throws java.lang.UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public void add(T arg0) throws java.lang.UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public int nextIndex() throws java.lang.UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public int previousIndex() throws java.lang.UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public void set(T arg0) throws java.lang.UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}
}
