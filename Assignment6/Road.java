/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Road class that has a Town on both sides, a distance, and name followed with many operations.
 * Due: 4/29/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

public class Road implements Comparable<Road> {
	private Town townSource;
	private Town townDestination;
	private int roadDistance;
	private String roadName;
	
	public Road(Town source, Town destination, int degrees, String name) {
		townSource = source;
		townDestination = destination;
		roadDistance = degrees;
		roadName = name;
	}
	
	public Road(Town source, Town destination, String name) {
		townSource = source;
		townDestination = destination;
		roadDistance = 1;
		roadName = name;
	}
	
	public boolean contains(Town town) {
		if (townSource.equals(town) || townDestination.equals(town)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return String.format("Road Name: %s From %s To %s", roadName, townSource.toString(), townDestination.toString());
	}
	
	public String getName() {
		return roadName;
	}
	
	public Town getDestination() {
		return new Town(townDestination);
	}
	
	public Town getSource() {
		return new Town(townSource);
	}
	
	public int compareTo(Road o) {
		if (roadName.contentEquals(o.getName())) {
			return 0;
		}
		return roadName.compareTo(o.getName());
	}
	
	public int getWeight() {
		return roadDistance;
	}
	
	@Override
	public boolean equals(Object r) {
		Road x = (Road) r;
		if (x.getSource().equals(townSource) && x.getDestination().equals(townDestination)) {
			return true;
		}
		if (x.getSource().equals(townDestination) && x.getDestination().equals(townSource)) {
			return true;
		}
		return false;
	}
}
