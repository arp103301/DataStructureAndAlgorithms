package ik.com.anup.strings;

import java.util.ArrayList;
import java.util.Arrays;

/*Given a text and a pattern, find all occurrences of the pattern in the text. 
 * Return start indices of all occurrences in the ascending order.

The problem is named after the string-searching algorithm called KMP (Knuth Morris Pratt).

Example
{
"text": "Ourbusinessisourbusinessnoneofyourbusiness",
"pattern": "business"
}
Output:

[3, 16, 34]
Notes
Indices in the output are zero-based.
If the pattern does not occur in the text, return [-1].
Constraints:

1 <= length of the text <= 2 * 105
1 <= length of the pattern <= 2 * 105
Text and pattern may contain lowercase and uppercase letters and digits.*/
public class KMP {
    // Complete the KMP function below.
    // Complete the KMP function below.
    static ArrayList<Integer> match_pattern_in_text(String t, String p) {
        if(t.length() < p.length()) {
            return new ArrayList<>(Arrays.asList(-1));
        }
        
        int[] lps = buildLengthArray(p);
        
        int i =0;
        int j=0;
        ArrayList<Integer> result = new ArrayList<>();
        while(i< t.length() && j < p.length()) {
            if(t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                
                if(j == p.length()) {// at the end
                    result.add(i-j);
                    j = lps[j-1];////skip
                }
            } else {
                if( j > 0) {
                    j = lps[j-1];//skip 
                } else {
                    i++;
                }
            }
        }
        
        return result.size() == 0? new ArrayList<>(Arrays.asList(-1)): result;

    }
    
    
    
	/*
	 * To build lps array, for lps[i], we keep track of the length of the longest
	 * proper prefix suffix value for the previous index(let's call it len). We
	 * initialize lps[0] and len as 0. If pattern[len] and pattern[i] matches, we
	 * increment len by 1 and assign the incremented value to lps[i]. If pattern[i]
	 * and pattern[len] do not match and len is not 0, we update len to lps[len -
	 * 1]. See the implementation for better understanding. We use a value from
	 * lps[] to decide the next characters to be matched. As mentioned before, the
	 * idea is not to check a character that we know does match.
	 */
    
    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     *///https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=97s
    static int[] buildLengthArray(String p) {
        int[] lps = new int[p.length()];
        lps[0] = 0;
        int currlen = 0;
        for(int i=1; i< p.length();) {
            if(p.charAt(currlen) == p.charAt(i)) {
            	lps[i] = currlen;
            	currlen++;
            	i++;
            } else {
                if(currlen!= 0) {
                    currlen = lps[currlen-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
    



}
