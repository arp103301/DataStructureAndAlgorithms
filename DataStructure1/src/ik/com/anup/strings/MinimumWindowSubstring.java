package ik.com.anup.strings;

/*You are given alphanumeric strings s and t. Find the minimum window (substring) in s which contains all the characters of t.

Example One
{
"s": "AYZABOBECODXBANC",
"t": "ABC"
}
Output:

"BANC"
The minimum window is "BANC", which contains all letters - 'A' 'B' and 'C'. We cannot find a window of smaller length than "BANC".

Example Two
{
"s": "BACRDESDFBAER",
"t": "BAR"
}
Output:

"BACR"
Here, we can see that there are 2 smallest windows - "BACR" and "BAER". However, the output is "BACR" because it is the leftmost one.

Notes
If no such window exists, return "-1".
If there are multiple minimum windows of the same length, return the leftmost window.
Constraints:

1 <= length of s <= 100000
1 <= length of t <= 100000*/
public class MinimumWindowSubstring {
    /*
    * Asymptotic complexity in terms of length of `s` `n` and length of `t` `m`:
    * Time: O(n).
    * Auxiliary space: O(1).
    * Total space: O(n + m).
    */

 
	static String minimum_window(String s, String t) {
        // Write your code here.
       String result = "";

        if(t.length() > s.length()) {
            return "-1";
        }

        int n = s.length(), m = t.length();
        int freqs[] = new int[128]; 
        int freqt[] = new int[128]; 
        for (char c : t.toCharArray()) {
            freqt[c]++;
        }
        int left = 0, len = n + 1;///s.lengthplus one
        int cnt = 0;
     
        for (int i = 0; i < n ; i++){
            char temp = s.charAt(i);
            freqs[temp]++;////[0,0,0...1,1,1...0,0,0]
            // If a character is present in string t we increment the count of cnt variable.
            if (freqt[temp] != 0 && freqs[temp] <= freqt[temp]) {
                cnt++;
            }
            // If we match all the characters present in string t, we try to find the minimum window possible
            if (cnt == m) {
                // if any character is occuring more than the required times, we try to remove it
                // from the starting and also try to remove the unwanted characters that are
                // not a part of string t from the starting. We check the remainder string if it
                // can become the smallest window.
                while (freqs[s.charAt(left)] > freqt[s.charAt(left)] || freqt[s.charAt(left)] == 0) {
                    if (freqs[s.charAt(left)] > freqt[s.charAt(left)]) {
                        freqs[s.charAt(left)]--;
                    }
                    left++;
                }
                //check if this can become the smallest window and update the result accordingly.>>> window is i-k
                if (len > i - left + 1) {//if len is less than intialized value then  it is valid
                    len = i - left + 1;
                    result = s.substring(left, left + len);//first substring is ADOBEC
                }
            }
        }
        return (result.length() == 0 ? "-1" : result);
    }
	public static void main(String[] args)
	{
	    String s = "AZADOBECODEBANC";
	    String t = "ABC";
	     
	      System.out.print("-->Smallest window that contain all character : ");
	     System.out.print(minimum_window(s, t));
	 
	}
	
}
/*
 * In this approach, we create an array named frequency to keep a count of
 * occurrences of each character in string t. Now we start traversing the string
 * s and keep a variable cnt which increases whenever we encounter a character
 * present in string t. When the value of count reaches the length of t, this
 * substring contains all the characters present in string t. We try removing
 * extra characters as well as unwanted characters from the beginning of the
 * obtained string. The resultant string is checked whether it can become the
 * minimum window, and the answer is updated accordingly.
 * 
 * This algorithm uses the 2 pointer method, which is widely used in solving
 * various problems.
 * 
 * Time Complexity O(n). Since each character of string s is traversed at most 2
 * times, the time complexity of the algorithm is O(n) + O(m).
 * 
 * Auxiliary Space Used O(1). We are creating 2 frequency arrays of size 128,
 * hence it is O(1).
 * 
 * Space Complexity O(n + m). For storing input it will take O(n + m), as we are
 * storing two strings of length n and length m and the auxiliary space used is
 * O(1) hence total complexity will be O(n + m).
 * 
 * Note: We could use an array of length 62 (with some mapping) instead of 128,
 * but this is a general solution which works for the input string containing
 * any ASCII characters.
 */