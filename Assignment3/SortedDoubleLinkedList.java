/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: An extension of BasicDoubleLinkedList and uses similar methods except its sorted in ascending order
 * Due: 2/24/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	private Comparator comparator;
	
	public SortedDoubleLinkedList(java.util.Comparator<T> compareableObject) {
		super();
		comparator = compareableObject;
	}
	
	public void add(T data) {
		Node temp = new Node(data), prevTemp;
		Node currentNode = super.head;
		
		if (super.head == null) {
			super.head = temp;
			super.tail = temp;
			super.size++;
			return;
		}
		
		while (currentNode != null) {
			if (comparator.compare(temp.data, currentNode.data) < 0) {
				if (currentNode.prev == null) {
					currentNode.prev = temp;
					temp.next = currentNode;
					super.head = temp;
					super.size++;
					return;
				}
				
				prevTemp = currentNode.prev;
				temp.next = currentNode;
				temp.prev = prevTemp;
				prevTemp.next = temp;
				currentNode.prev = temp;
				super.size++;
				return;
			}
			if (currentNode.next == null) { //if it wasnt a match anywhere but its end of linked list and needs to be added at end.
				currentNode.next = temp;
				temp.prev = currentNode;
				super.tail = temp;
				super.size++;
				return;
			}
			currentNode = currentNode.next;
		}
	}
	
	public void addToEnd(T data) throws java.lang.UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public void addToFront(T data) throws java.lang.UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public java.util.ListIterator<T> iterator() {
		return super.iterator();
	}
	
	public BasicDoubleLinkedList.Node remove(T data, java.util.Comparator<T> comparator) {
		return super.remove(data, comparator);
	}
}
