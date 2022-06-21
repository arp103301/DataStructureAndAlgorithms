package Z.com.anup.companiesSamples;
// A Simple Java program to count anagrams of a
// pattern in a text.
import java.io.*;
import java.util.*;
public class CountAnagramsInText {


	 
	
	 
	    // Function to find if two strings are equal
	    static boolean isAnagram(String s1,
	                              String s2)
	    {
	        // converting strings to char arrays
	        char[] ch1 = s1.toCharArray();
	        char[] ch2 = s2.toCharArray();
	 
	        // sorting both char arrays
	        Arrays.sort(ch1);
	        Arrays.sort(ch2);
	 
	        // Check for equality of strings
	        if (Arrays.equals(ch1, ch2))
	            return true;
	        else
	            return false;
	    }
	 
	    static int countAnagrams(String text, String word)
	    {
	        int N = text.length();
	        int n = word.length();
	 
	        // Initialize result
	        int res = 0;
	 
	        for (int i = 0; i <= N - n; i++) {
	 
	            String s = text.substring(i, i + n);
	 
	            // Check if the word and substring are
	            // anagram of each other.
	            if (isAnagram(word, s))
	                res++;
	        }
	     
	        return res;
	    }
	 
	    // Driver code
	    public static void main(String args[])
	    {
	        String text ="for in tow rof while orf  forq" ;//"forxxorfxdofr";
	        String word1 = "for";
	        boolean result = false;
	        int count = 0;
	 
	        
	        
	        
			/*
			 * StringTokenizer st = new StringTokenizer("my name is khan"," "); while
			 * (st.hasMoreTokens()) { System.out.println(st.nextToken()); }
			 */
	        String[] words = text.split("\\W+");// word regex
	        
	        for (String word :words) {
	        	result = isAnagram(word1, word);
	        	System.out.println("Result for "+word);
	        	if ( result) count++;
	        	System.out.println("Count is "+count);
	        	
	        }
	    }
	
}
