/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: The database element(individual course) that holds all the info of the course. Has a method that converts it into string format which is used in the other two classes. Able to get and set each attribute in class.
 * Due: 3/26/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

public class CourseDBElement implements Comparable<CourseDBElement> {
	private String courseID;
	private int CRN;
	private int numberOfCredits;
	private String roomNumber;
	private String instructorName;
	
	public CourseDBElement(String id, int crn, int numOfCreds, String room, String instructor) {
		courseID = id;
		CRN = crn;
		numberOfCredits = numOfCreds;
		roomNumber = room;
		instructorName = instructor;
	}
	
	public CourseDBElement() {
		
	}

	public String getID() {
		return courseID;
	}
	
	public int getCRN() {
		return CRN;
	}
	
	public int getNumOfCreds() {
		return numberOfCredits;
	}
	
	public String getRoomNum() {
		return roomNumber;
	}
	
	public String getInstructorName() {
		return instructorName;
	}
	
	public void setID(String x) {
		courseID = x;
	}
	
	public void setCRN(int x) {
		CRN = x;
	}
	
	public void setNumOfCreds(int x) {
		numberOfCredits = x;
	}
	
	public void setRoomNum(String x) {
		roomNumber = x;
	}
	
	public void setInstructorName(String x) {
		instructorName = x;
	}
	
	public String toString() {
		return String.format("\nCourse:%s CRN:%d Credits:%d Instructor:%s Room:%s", courseID, CRN, numberOfCredits, instructorName, roomNumber);
	}

	public int compareTo(CourseDBElement x) {
		if (x.getID().contentEquals(courseID) && x.getCRN() == CRN && x.getNumOfCreds() == numberOfCredits && x.getRoomNum().contentEquals(roomNumber) && 
				x.getInstructorName().contentEquals(instructorName)) {
			return 0;
		}
		return 1;
	}
}
