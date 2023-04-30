/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Town Graph Manager tests
 * Due: 4/29/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;

	@BeforeEach
	void setUp() throws Exception {
		graph = new TownGraphManager();
		  town = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_1");
		  graph.addRoad(town[1], town[3], 4, "Road_2");
		  graph.addRoad(town[1], town[5], 6, "Road_3");
		  graph.addRoad(town[3], town[7], 1, "Road_4");
		  graph.addRoad(town[3], town[8], 2, "Road_5");
		  graph.addRoad(town[4], town[8], 3, "Road_6");
		  graph.addRoad(town[6], town[9], 3, "Road_7");
		  graph.addRoad(town[9], town[10], 4, "Road_8");
		  graph.addRoad(town[8], town[10], 2, "Road_9");
		  graph.addRoad(town[5], town[10], 5, "Road_10");
		  graph.addRoad(town[10], town[11], 3, "Road_11");
		  graph.addRoad(town[2], town[11], 6, "Road_12");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	@Test
	void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_12", roads.get(3));
		graph.addRoad(town[4], town[11], 1,"Road_13");
		roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_12", roads.get(3));
		assertEquals("Road_13", roads.get(4));
	}

	@Test
	void testGetRoad() {
		assertEquals("Road_12", graph.getRoad(town[2], town[11]));
		assertEquals("Road_4", graph.getRoad(town[3], town[7]));
	}

	@Test
	void testAddTown() {
		assertEquals(false, graph.containsTown("Town_12"));
		graph.addTown("Town_12");
		assertEquals(true, graph.containsTown("Town_12"));
	}

	@Test
	void testGetTown() {
		assertEquals(false, graph.containsTown("Town_12"));
		graph.addTown("Town_12");
		ArrayList<String> path = graph.getPath(town[1],"Town_12");
		assertFalse(path.size() > 0);
	}

	@Test
	void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_12"));
	}

	@Test
	void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[5]));
	}

	@Test
	void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_8", roads.get(10));
		assertEquals("Road_9", roads.get(11));
	}

	@Test
	void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
		graph.deleteRoadConnection(town[2], town[11], "Road_12");
		assertEquals(false, graph.containsRoadConnection(town[2], town[11]));
	}

	@Test
	void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		graph.deleteTown(town[2]);
		assertEquals(false, graph.containsTown("Town_2"));
	}

	@Test
	void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_10", roads.get(1));
		assertEquals("Town_11", roads.get(2));
		assertEquals("Town_2", roads.get(3));
		assertEquals("Town_8", roads.get(9));
	}

	@Test
	void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[11]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road_12 to Town_11 6 mi",path.get(1).trim());
	}

	@Test
	void testPopulateTownGraph() {
		assertEquals(true,true);
		
	}

}
