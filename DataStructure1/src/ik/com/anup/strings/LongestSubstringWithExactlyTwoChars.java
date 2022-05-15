package ik.com.anup.strings;

/*Longest Substring With Exactly Two Distinct Characters
Given a string s of length n, find the length of the longest substring that contains exactly two distinct characters.

Example
{
"s": "ecebaaaaca"
}
Output:

6
"aaaaca" is the largest substring with exactly 2 distinct characters.

Notes
If there are no such substrings, return 0.
Constraints:

1 <= n <= 105
s may contain English letters and digits.*/
public class LongestSubstringWithExactlyTwoChars {
	 
	static int get_longest_substring_length_with_exactly_two_distinct_chars(String s) {

	        boolean secondDistinct = false;
	        int j=-1;
	        int i=0;
	        int maxLength = 0;

	        for(int k=1; k<s.length(); k++){
	            if(s.charAt(k) == s.charAt(k-1))
	                continue;
	            else
	                secondDistinct = true;
	            if(j>=0 && s.charAt(j) != s.charAt(k)){
	                maxLength = Math.max(k-i, maxLength);
	                i=j+1;
	            }
	            j=k-1;
	        }

	        if(!secondDistinct)
	            return 0;

	        return Math.max(s.length()-i, maxLength);
	    }

}
