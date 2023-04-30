/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Town tests
 * Due: 4/29/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {
	Town town;

	@BeforeEach
	void setUp() throws Exception {
		town = new Town("Clarksburg");
	}

	@AfterEach
	void tearDown() throws Exception {
		town = null;
	}

	@Test
	void testGetName() {
		assertEquals("Clarksburg", town.getName());
	}

	@Test
	void testCompareTo() {
		Town town2 = new Town("Clarksburg");
		assertEquals(0, town.compareTo(town2));
	}

	@Test
	void testToString() {
		assertEquals("Clarksburg", town.toString());
	}

	@Test
	void testEqualsObject() {
		Town town2 = new Town("Clarksburg");
		assertTrue(town.equals(town2));
	}

}
