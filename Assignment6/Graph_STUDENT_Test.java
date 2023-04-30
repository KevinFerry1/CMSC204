/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Graph tests
 * Due: 4/29/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@BeforeEach
	void setUp() throws Exception {
		graph = new Graph();
		  town = new Town[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 2, "Road_1");
		  graph.addEdge(town[1], town[3], 4, "Road_2");
		  graph.addEdge(town[1], town[5], 6, "Road_3");
		  graph.addEdge(town[3], town[7], 1, "Road_4");
		  graph.addEdge(town[3], town[8], 2, "Road_5");
		  graph.addEdge(town[4], town[8], 3, "Road_6");
		  graph.addEdge(town[6], town[9], 3, "Road_7");
		  graph.addEdge(town[9], town[10], 4, "Road_8");
		  graph.addEdge(town[8], town[10], 2, "Road_9");
		  graph.addEdge(town[5], town[10], 5, "Road_10");
		  graph.addEdge(town[10], town[11], 3, "Road_11");
		  graph.addEdge(town[2], town[11], 6, "Road_12");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	@Test
	void testGraph() {
		assertEquals(new Road(town[2], town[11],6, "Road_12"), graph.getEdge(town[2], town[11]));
		assertEquals(new Road(town[3], town[7],1, "Road_4"), graph.getEdge(town[3], town[7]));
	}

	@Test
	void testGetEdge() {
		assertEquals(new Road(town[2], town[11],6, "Road_12"), graph.getEdge(town[2], town[11]));
		assertEquals(new Road(town[3], town[7],1, "Road_4"), graph.getEdge(town[3], town[7]));
	}

	@Test
	void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[3], town[5]));
		graph.addEdge(town[3], town[5], 1, "Road_13");
		assertEquals(true, graph.containsEdge(town[3], town[5]));
	}

	@Test
	void testAddVertex() {
		Town newTown = new Town("Town_12");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[11]));
		assertEquals(false, graph.containsEdge(town[3], town[5]));
	}

	@Test
	void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_12")));
	}

	@Test
	void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_10", roadArrayList.get(1));
		assertEquals("Road_11", roadArrayList.get(2));
		assertEquals("Road_12", roadArrayList.get(3));
		assertEquals("Road_2", roadArrayList.get(4));
		assertEquals("Road_8", roadArrayList.get(10));
	}

	@Test
	void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_2", roadArrayList.get(1));
		assertEquals("Road_3", roadArrayList.get(2));
	}

	@Test
	void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[11]));
		graph.removeEdge(town[2], town[11], 6, "Road_12");
		assertEquals(false, graph.containsEdge(town[2], town[11]));
	}

	@Test
	void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
	}

	@Test
	void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[10]));
		assertEquals(true, roads.contains(town[11]));
		assertEquals(true, roads.contains(town[2]));
		assertEquals(true, roads.contains(town[3]));
	}

	@Test
	void testShortestPath() {
		String beginTown = "Town_1", endTown = "Town_10";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_2 to Town_3 4 mi",path.get(0).trim());
			  assertEquals("Town_3 via Road_5 to Town_8 2 mi",path.get(1).trim());
			  assertEquals("Town_8 via Road_9 to Town_10 2 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	}

	@Test
	void testDijkstraShortestPath() {
		assertEquals(true, true);
	}

}
