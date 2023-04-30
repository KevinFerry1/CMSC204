/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Road tests
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

class Road_STUDENT_Test {
	Road road;

	@BeforeEach
	void setUp() throws Exception {
		road = new Road(new Town("Test1"), new Town("Test2"), 3, "Road1");
	}

	@AfterEach
	void tearDown() throws Exception {
		road = null;
	}

	@Test
	void testContains() {
		assertTrue(road.contains(new Town("Test1")));
	}

	@Test
	void testToString() {
		assertEquals("Road Name: Road1 From Test1 To Test2", road.toString());
	}

	@Test
	void testGetName() {
		assertEquals("Road1", road.getName());
	}

	@Test
	void testGetDestination() {
		assertEquals(new Town("Test2"), road.getDestination());
	}

	@Test
	void testGetSource() {
		assertEquals(new Town("Test1"), road.getSource());
	}

	@Test
	void testCompareTo() {
		Road road2 = new Road(new Town("Test1"), new Town("Test2"), 3, "Road1");
		assertEquals(0, road.compareTo(road2));
	}

	@Test
	void testGetWeight() {
		assertEquals(3, road.getWeight());
	}

	@Test
	void testEqualsObject() {
		Road road2 = new Road(new Town("Test1"), new Town("Test2"), 3, "Road1");
		assertTrue(road.equals(road2));
	}

}
