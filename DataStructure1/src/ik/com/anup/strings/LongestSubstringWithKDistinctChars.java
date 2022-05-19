package ik.com.anup.strings;

import java.util.HashMap;
import java.util.Map;

///https://www.youtube.com/watch?v=chKR9PwSMf4
//https://github.com/Eric-programming/CodeSolution/tree/master/src/SlidingWindow
	
//Hint :: 1. charArr, 2. L and R pointer,  3.sliding window with hashmap <character, freq> 
//4. while( mapPut ); while(k<mapsize (decrease window); move left pointer
//5. Math.max(maxLen, R-L+1)


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
public class LongestSubstringWithKDistinctChars {
	//static int get_longest_substring_length_with_K_distinct_chars(String s, int k) {
	static int get_longest_substring_length_with_exactly_two_distinct_chars(String s) {

		Map<Character, Integer> map = new HashMap<>();//Map( character,freq)

		char[] arr = s.toCharArray();
		int left = 0, right = 0, n = arr.length;
		int longestLen = 0;

		while (right < n) {
			// Expand the window to the right
			map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);// default is 0 and add 1 if it already exits

			// Shrink the window from left if window size exceeds the k distinct characters
			while (2 < map.size()) {// replace 2 with K when the kth distinct character is asked ???????????????
				if (map.get(arr[left]) == 1) {// only 1 char in the left
					map.remove(arr[left]);
				} else { // more than 1 char in the left so need to substract 1
					map.put(arr[left], map.get(arr[left]) - 1);
				}
				left++; // move the left pointer
			}

			// Update the longest length
			longestLen = Math.max(longestLen, right - left + 1);// R-L+1

			right++;
		}

		return longestLen;
	}

}
