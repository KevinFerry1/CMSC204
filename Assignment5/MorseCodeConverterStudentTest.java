/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Tests the correctness of tree and methods working correctly.
 * Due: 4/9/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/ 

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Test;


public class MorseCodeConverterStudentTest {
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .--- .- ...- .-");
		assertEquals("hello java",converter1);
	}
	
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish("- .... .. ... / .. ... / .- / - . ... - / ... . -. - . -. -.-. .");
		assertEquals("this is a test sentence", converter1);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		File file = new File("src/Daisy.txt"); 
		try {
			assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
	

}
