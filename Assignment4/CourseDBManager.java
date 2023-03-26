/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Data manager that can read files or manually input course strings and put the courses in a hashtable that you can retrive or see a full list of all courses.
 * Due: 3/26/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure dataStructure;
	
	public CourseDBManager() {
		dataStructure = new CourseDBStructure(20);
	}
	
	
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		dataStructure.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}
	
	public CourseDBElement get(int crn) {
		try {
			return dataStructure.get(crn);
		} 
		catch (IOException e) {
			return null;
		}
	}
	
	public void readFile(File input) throws FileNotFoundException {
		String currentLine;
		String[] lineSplit;
		Scanner reader = new Scanner(input);
		
		while (reader.hasNextLine()) {
			currentLine = reader.nextLine();
			lineSplit = currentLine.split(" ", 5);
			add(lineSplit[0], Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]), lineSplit[3], lineSplit[4]);
		}
	}
	
	public ArrayList<String> showAll() {
		return dataStructure.showAll();
	}
}
