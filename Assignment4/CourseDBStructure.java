/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Database structure that is a hashtable implemented with buckets. Makes a hashtable with the size as a 4k+3 prime to make less collisions and a more efficient add and retrieval for all courses.
 * Due: 3/26/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.util.LinkedList;
import java.io.IOException;
import java.util.ArrayList;

public class CourseDBStructure implements CourseDBStructureInterface {
	private Node[] hashTable;
	private int tableSize;
	
	public CourseDBStructure(int n) {
		int counter = (int)(n / 1.5);
		counter++;
		
		while (((counter - 3) % 4) != 0 || !isPrime(counter)) {
			counter++;
		}
		
		hashTable = new Node[counter];
		tableSize = counter;
	}
	
	public CourseDBStructure(String test, int n) {
		hashTable = new Node[n];
		tableSize = n;
	}
	
	public void add(CourseDBElement element) {
		int index = element.getCRN() % tableSize;
		Node iterator;
		
		if (hashTable[index] == null) {
			hashTable[index] = new Node(element);
			return;
		}
		
		iterator = hashTable[index];
		if (iterator.data.compareTo(element) == 0) {
			return;
		}
		if (iterator.data.getCRN() == element.getCRN()) {
			hashTable[index].setData(element);
			return;
		}
		
		while (iterator.next != null) {
			iterator = iterator.next;
			if (iterator.data.compareTo(element) == 0) {
				return;
			}
			if (iterator.data.getCRN() == element.getCRN()) {
				iterator.setData(element);
				return;
			}
		}
		iterator.next = new Node(element);
	}
	
	public CourseDBElement get(int crn) throws IOException {
		int index = crn % tableSize;
		Node iterator;
		
		if (hashTable[index] == null) {
			throw new IOException();
		}
		
		if (hashTable[index].data.getCRN() == crn) {
			return hashTable[index].data;
		}
		
		iterator = hashTable[index];
		
		while (iterator.next != null) {
			iterator = iterator.next;
			
			if (iterator.data.getCRN() == crn) {
				return iterator.data;
			}
		}
		throw new IOException();
	}
	
	public ArrayList<String> showAll() {
		ArrayList<String> fullList = new ArrayList<String>();
		Node iterator;
		
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] == null) {
				continue;
			}
			
			iterator = hashTable[i];
			fullList.add(iterator.data.toString());
			
			while (iterator.next != null) {
				iterator = iterator.next;
				fullList.add(iterator.data.toString());
			}
		}
		return fullList;
	}
	
	public int getTableSize() {
		return tableSize;
	}
	
	public boolean isPrime(int n)
    {
        if (n <= 1) {
        	return false;
        }
            
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
            	return false;
            }
        }     
        return true;
    }
	
	
	protected class Node {
		protected CourseDBElement data;
		protected Node next;
		
		public Node(CourseDBElement dataNode) {
			data = dataNode;
		}
		
		public void setData(CourseDBElement x) {
			data = x;
		}
	}
}
