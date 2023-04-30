/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: The towns on the end of the roads.
 * Due: 4/29/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

public class Town implements Comparable<Town> {
	private String townName;
	
	public Town(String name) {
		townName = name;
	}
	
	public Town(Town templateTown) {
		townName = templateTown.getName();
	}
	
	public String getName() {
		return townName;
	}
	
	public int compareTo(Town o) {
		if (townName.contentEquals(o.getName())) {
			return 0;
		}
		return townName.compareTo(o.getName());
	}

	public String toString() {
		return townName;
	}
	
	public int hashCode() {
		return townName.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Town r = (Town) obj;
		if (r.getName().contentEquals(townName)) {
			return true;
		}
		return false;
	}
}
