/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Manages the graph and calls graph methods but does some work to make things in string form when returned.
 * Due: 4/29/23
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
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {
	private Graph graph = new Graph();

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Road temp = graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		if (temp != null) {
			return true;
		}
		return false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Road temp = graph.getEdge(new Town(town1), new Town(town2));
		if (temp == null) {
			return null;
		}
		return temp.getName();
	}

	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		return new Town(name);
	}

	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	@Override
	public ArrayList<String> allRoads() {
		Set<Road> temp = graph.edgeSet();
		
		ArrayList<String> returnList = new ArrayList<String>();
		
		for (Road x : temp) {
			returnList.add(x.getName());
		}
		returnList.sort(String::compareToIgnoreCase);
		return returnList;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Road temp = graph.removeEdge(new Town(town1), new Town(town2), 1, road);
		if (temp == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	@Override
	public ArrayList<String> allTowns() {
		Set<Town> temp = graph.vertexSet();
		ArrayList<String> returnList = new ArrayList<String>();
		
		for (Town x : temp) {
			returnList.add(x.getName());
		}
		returnList.sort(String::compareToIgnoreCase);
		return returnList;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException {
		Scanner reader = new Scanner(selectedFile);
		String temp;
		String[] regexTemp, regexTemp2;
		
		while (reader.hasNextLine()) {
			temp = reader.nextLine();
			regexTemp = temp.split(";");
			regexTemp2 = regexTemp[0].split(",");
			graph.addEdge(new Town(regexTemp[1]), new Town(regexTemp[2]), Integer.parseInt(regexTemp2[1]), regexTemp2[0]);
		}
		reader.close();
	}

}
