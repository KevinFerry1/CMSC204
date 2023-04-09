/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Class consists of static methods that use the morse code tree to convert from morse code to english and also print out the tree.
 * Due: 4/9/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	public static java.lang.String printTree() {
		MorseCodeTree tree = new MorseCodeTree();
		String x = "";
		ArrayList<String> printList = new ArrayList<String>();
		printList = tree.toArrayList();
		
		for (int i = 0; i < printList.size() - 1; i++) {
			x += printList.get(i) + " ";
		}
		x += printList.get(printList.size() - 1);
		return x;
	}
	
	public static java.lang.String convertToEnglish(java.lang.String code) {
		String[] english = code.split(" ");
		MorseCodeTree tree = new MorseCodeTree();
		String x = "";
		
		for (int i = 0; i < english.length; i++) {
			if (english[i].contentEquals("/")) {
				x += " ";
				continue;
			}
			x += tree.fetch(english[i]);
		}
		return x;
	}
	
	public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException {
		Scanner reader = new Scanner(codeFile);
		String[] english = reader.nextLine().split(" ");
		MorseCodeTree tree = new MorseCodeTree();
		String x = "";
		
		for (int i = 0; i < english.length; i++) {
			if (english[i].contentEquals("/")) {
				x += " ";
				continue;
			}
			x += tree.fetch(english[i]);
		}
		return x;
	}
}
