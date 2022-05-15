package ik.com.anup.recursion;

//palndrome check for input from startIndex uotp current index 

import java.util.ArrayList;

/*Find all palindromic decompositions of a given string s.

A palindromic decomposition of string is a decomposition of the string into substrings
, such that all those substrings are valid palindromes.

Example
{
"s": "abracadabra"
}
Output:

["a|b|r|a|c|ada|b|r|a", "a|b|r|aca|d|a|b|r|a", "a|b|r|a|c|a|d|a|b|r|a"]
Notes
Any string is its own substring.
Output should include ALL possible palindromic decompositions of the given string.
Order of decompositions in the output does not matter.
To separate substrings in the decomposed string, use | as a separator.
Order of characters in a decomposition must remain the same as in the given string.
 For example, for s = "ab", return ["a|b"] and not ["b|a"].
Strings in the output must not contain whitespace. For example, ["a |b"] or ["a| b"] is incorrect.
Constraints:

1 <= length of s <= 20
s only contains lowercase English letters.*/
public class PalindromicDecompositionOfAString {
	  static ArrayList<String> generate_palindromic_decompositions(String s) {
	        // Write your code here.
	        ArrayList<String> output = new ArrayList<>();
	        char[] slate = new char[s.length()*2];
	        helper(s.toCharArray(), 0, 0, slate, output);
	        return output;
	    }
	    
	  
	  // one more pointer to check for palindrome start
	    static void helper(char[] input, int startInd, int j, char[] slate, ArrayList<String> result) {
	        
	        
	        if(startInd == input.length) {
	       
	            result.add(new String(slate, 0, j-1));
	            return;
	        }
	        
	        for(int i=startInd; i< input.length; i++) {
	            slate[j] = input[i];// first create partial solu
	            j++;//move partial solution index 1 more to check if that becomes palindrome
	            
	            if(isPalindrome(input, startInd, i)) {/// palindrome check always with startInd upto the currentInd
	                slate[j] = '|';// add partiotion only if palindrome
	                
	                
	                helper(input, i+1, j+1, slate, result);//call helper after the partiton is done on the remaining ones
	            }
	        }
	        
	    }

	    static private boolean isPalindrome(char[] input, int left, int right) {

	        while(left <= right) {
	            if (input[left++] != input[right--]) {
	                return false;
	            }
	        }
	        return true;
	    }
}
