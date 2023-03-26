/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Tests every method in the project.
 * Due: 3/26/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC203",30504,4,"HT301","Kevin Ferry");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC203",30504,4,"HT301","Kevin Ferry");
		dataMgr.add("CMSC203",30503,4,"HT301","Test Bot");
		dataMgr.add("CMSC204",30559,4,"HT301","Keyboard Teacher");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:30559 Credits:4 Instructor:Keyboard Teacher Room:HT301");
	 	assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Test Bot Room:HT301");
		assertEquals(list.get(2),"\nCourse:CMSC203 CRN:30504 Credits:4 Instructor:Kevin Ferry Room:HT301");
	}
	
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 HT301 Kevin Ferry");
			inFile.print("CMSC204 30503 4 HT301 Test Bot");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC203",dataMgr.get(30504).getID());
			assertEquals("CMSC204",dataMgr.get(30503).getID());
			assertEquals("HT301",dataMgr.get(30503).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
