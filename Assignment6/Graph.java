/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: The graph with the main methods that deals with all the roads and towns. Gets shortest path between towns and can do various adding or removing of towns and roads.
 * Due: 4/29/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {
	private Set<Town> townSet;
	private Set<Road> roadSet;
	private HashMap<Town, Integer> shortestDistance; 
	private HashMap<Town, Town> previousNode;
	private PriorityQueue<Road> minimumQueue;
	
	public Graph() {
		townSet = new HashSet<Town>();
		roadSet = new HashSet<Road>();
	}

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Iterator<Road> roadIterator = roadSet.iterator();
		Road temp;
		Road compare = new Road(sourceVertex, destinationVertex, "x");
		
		if (sourceVertex == null || destinationVertex == null) {
			return null;
		}
		
		while (roadIterator.hasNext()) {
			temp = roadIterator.next();
			if (temp.equals(compare)) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		
		//if towns are not already in graph, add them
		if (!containsVertex(sourceVertex)) {
			townSet.add(sourceVertex);
		}
		if (!containsVertex(destinationVertex)) {
			townSet.add(destinationVertex);
		}
		
		if (!townSet.contains(sourceVertex) || !townSet.contains(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		
		Road temp = new Road(sourceVertex, destinationVertex, weight, description);
		roadSet.add(temp);
		return temp;
	}

	@Override
	public boolean addVertex(Town v) {
		Iterator<Town> townIterator = townSet.iterator();
		Town temp;
		
		if (v == null) {
			throw new NullPointerException();
		}
		
		while (townIterator.hasNext()) {
			temp = townIterator.next();
			if (!temp.equals(v)) {
				townSet.add(v);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		if (getEdge(sourceVertex, destinationVertex) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		Iterator<Town> townIterator = townSet.iterator();
		Town temp;
		
		if (v == null) {
			return false;
		}
		
		while (townIterator.hasNext()) {
			temp = townIterator.next();
			if (temp.equals(v)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		return roadSet;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> tempSet = new HashSet<Road>();
		Iterator<Road> roadIterator = roadSet.iterator();
		Road temp;
		
		if (vertex == null) {
			throw new NullPointerException();
		}
		if (!containsVertex(vertex)) {
			throw new IllegalArgumentException();
		}
		
		while (roadIterator.hasNext()) {
			temp = roadIterator.next();
			if (temp.contains(vertex)) {
				tempSet.add(temp);
			}
		}
		return tempSet;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road tempRoad;
		tempRoad = getEdge(sourceVertex, destinationVertex);
		
		if (weight < 1 || description == null || tempRoad == null) {
			return null;
		}
		
		roadSet.remove(tempRoad);
		return tempRoad;
	}

	@Override
	public boolean removeVertex(Town v) {
		Set<Road> tempSet;
		tempSet = edgesOf(v);
		
		if (tempSet != null) {
			roadSet.removeAll(tempSet);
			townSet.remove(v);
			return true;
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		return townSet;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		ArrayList<String> returnString = new ArrayList<String>();
		String edgeName, path;
		dijkstraShortestPath(sourceVertex);
		Town currentTown = destinationVertex;
		Town previousTown = previousNode.get(currentTown);
		
		if (previousTown == null) {
			return returnString;
		}
		while (currentTown.compareTo(sourceVertex) != 0) {
			edgeName = getEdge(currentTown, previousTown).getName();
			path = previousTown.getName() + " via " + edgeName + " to " + currentTown.getName() + " " + getEdge(currentTown,previousTown).getWeight() + " mi";
			returnString.add(0, path);
			currentTown = previousTown;
			previousTown = previousNode.get(currentTown);
		}
		
		return returnString;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Set<Road> tempSet = new HashSet<Road>();
		HashSet<Town> startTownSet = new HashSet<Town>();
		startTownSet.add(sourceVertex);
		Set<Town> visitedNodes = new HashSet<Town>();
		shortestDistance = new HashMap<Town, Integer>(); 
		previousNode = new HashMap<Town, Town>();
		
		Comparator<Road> comparator = new Comparator<Road>() {
			@Override
			public int compare(Road x, Road y) {
				return x.getWeight() - y.getWeight();
			}
		};
		minimumQueue = new PriorityQueue<Road>(comparator);
		
		shortestDistance.put(sourceVertex, 0);
		visitedNodes.add(sourceVertex);
		minimumQueue.addAll(edgesOf(sourceVertex));
		
		while (!minimumQueue.isEmpty()) {
			Town source, destination;
			Road smallestRoad = minimumQueue.remove();
			source = smallestRoad.getSource();
			destination = smallestRoad.getDestination();
			
			if (!visitedNodes.contains(source)) {
				visitedNodes.add(source);
				
				for (Road x : edgesOf(source)) {
					if (!minimumQueue.contains(x)) {
						minimumQueue.add(x);
					}
				}
				
				previousNode.put(source, destination);
				shortestDistance.put(source, shortestDistance.get(destination) + smallestRoad.getWeight());
			}
			if (!visitedNodes.contains(destination)) {
				visitedNodes.add(destination); 
				
				for (Road x : edgesOf(destination)) {
					if (!minimumQueue.contains(x)) {
						minimumQueue.add(x);
					}
				}
				
				previousNode.put(destination, source);
				shortestDistance.put(destination, shortestDistance.get(source) + smallestRoad.getWeight());
			}
			if (visitedNodes.contains(source)) {
				if (shortestDistance.get(destination) + smallestRoad.getWeight() < shortestDistance.get(source)) {
					shortestDistance.put(source, shortestDistance.get(destination) + smallestRoad.getWeight());
					previousNode.put(source, destination);
				}
			}
			if (visitedNodes.contains(destination)) {
				if (shortestDistance.get(source) + smallestRoad.getWeight() < shortestDistance.get(destination)) {
					shortestDistance.put(destination, shortestDistance.get(source) + smallestRoad.getWeight());
					previousNode.put(destination, source);
				}
			}
		  }
		}
	}

