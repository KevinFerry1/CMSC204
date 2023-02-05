/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Tests for PasswordCheckerUtility
 * Due: 2/05/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasswordCheckerUtilityTestStudent {
	
	private java.util.ArrayList<String> test; 

	@Before
	public void setUp() throws Exception {
		test = new java.util.ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void testIsValidLength() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("sfsd"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
			System.out.println("line 49");
		}
	}

	@Test
	public void testHasUpperAlpha() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("klsdlfksdjflksf"));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaExcepetion",false);
			System.out.println("line 49");
		}
	}

	@Test
	public void testHasLowerAlpha() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("a1A#b1Bc1Cd1D"));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
			System.out.println("line 49");
		}
	}

	@Test
	public void testHasDigit() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("nNzZ!bfd"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
			System.out.println("line 49");
		}
	}

	@Test
	public void testHasSpecialChar() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("abAB1zd"));
		}
		catch(NoSpecialCharacterException e)
		{
			assertTrue("Successfully threw a NoSpecialCharacterException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoSpecialCharacterException",false);
			System.out.println("line 49");
		}
	}

	@Test
	public void testNoSameCharInSequence() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("a1A#b1Bc1Cd1D"));
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
			System.out.println("line 49");
		}
	}


}
