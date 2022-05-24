package ik.com.anup.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*Given a dictionary of words and a string txt, find the number of ways the 
 * string can be broken down into the dictionary words. Return the answer modulo 109 + 7.

Example
{
"dictionary": ["kick", "start", "kickstart", "is", "awe", "some", "awesome"],
"txt": "kickstartisawesome"
}
Output:

4
Here are all four ways to break down the string into the dictionary words:

kick start is awe some
kick start is awesome
kickstart is awe some
kickstart is awesome
4 % 1000000007 = 4 so the correct output is 4.

Notes
Constraints:

1 <= number of words in the dictionary <= 2 * 105
1 <= length of any dictionary word <= 102
1 <= length of the string txt <= 2 * 103
Dictionary words and the string txt all consist of lowercase latin characters only (no whitespace, in particular).
*/
public class WordBreakCount {
	 static Integer word_break_count(ArrayList<String> dictionary, String txt) {
	        int maxLen = txt.length()+1;//txt is broken into  valid single letter( exists in dictonary)
	        int mod = 1000000007;
	        int n = txt.length();
	        Set<String> dict = new HashSet<>(dictionary);/*******************************/
	        
	        int[] dpTable = new int[n+1];
	        
	        dpTable[0] = 1;// whole string can be "valid" segmentation  otherwise entire string cant be segemented
	        
	     
	        /// taking the string 1 charater from last and going forward like simple enumeration problem
	        
	   
	       for(int i=0; i<=n; i++){
	        
	           for(int j=i+1; j<=n; j++){// maxLen is not necessary per IK compiletool
	            	
	                String subString = txt.substring(i, j);
	                if(dict.contains(subString)){// if the boolen check of LC 139:: need additionchekc dp[i]is true*******\
	                	
	                    dpTable[j] += dpTable[i];// recurrence relation :::: f(j)= f(i)+f(i-1);
	                    dpTable[j] = dpTable[j] % mod;// requiremtn ::::Return the answer modulo 10^9 + 7.
	                }
	            }
	        }
	        
	        
	        return dpTable[n];
	    }
}
