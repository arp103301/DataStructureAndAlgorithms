package ik.com.anup.strings;

public class WildCardCharMatching {

	
	// The main function that checks if
	// two given strings match. The pattern string may contain wildcard characters
	static boolean match(String inputString, String pattern)
	{
	 
	    // If we reach at the end of both strings, we are done
	    if (pattern.length() == 0 && inputString.length() == 0)
	        return true;
	 
	    // Make sure that the characters after '*'
	    // are present in input string.
	    // This function assumes that the pattern
	    // string will not contain two consecutive '*'
	    if (pattern.length() > 1 && pattern.charAt(0) == '*' && inputString.length() == 0)
	        return false;
	 //////////////////////////////////////////////////////////////////////
		/*
		 * // If the first string contains '?', // or current characters of both strings
		 * match if ((pattern.length() > 1 && pattern.charAt(0) == '?') ||
		 * (pattern.length() != 0 && inputString.length() != 0 && pattern.charAt(0) ==
		 * inputString.charAt(0))) return match(pattern.substring(1),
		 * inputString.substring(1));
		 */
	    
	    //////////////////////////////////////////////////////////////
	    // If there is *, then there are two possibilities
	    // a) We consider current character of inputString
	    // b) We ignore current character of inputString.
	    if (pattern.length() > 0 && pattern.charAt(0) == '*')
	        return match( inputString,pattern.substring(1)) || match( inputString.substring(1),pattern);
	    return false;
	}
	// A function to run test cases
	static void test( String input, String pattern)
	{
	    if (match(input, pattern))
	        System.out.println("Yes");
	    else
	        System.out.println("No");
	}
	
	public static void main(String[] args)
	{
	    test( "geeks","g*ks"); // Yes
	   // test( "geeksforgeeks","ge?ks*"); // Yes
	    test( "gee","g*k"); // No because 'k' is not in second
	    test("pqrst","*pqrs"); // No because 't' is not in first
	    test("abcdhghgbcd","abc*bcd"); // Yes
	   // test( "abcd","abc*c?d"); // No because second must have 2
	                            // instances of 'c'
	    test( "abcd","*c*d"); // Yes
	   // test( "abcd","*?c*d"); // Yes
	}
}
