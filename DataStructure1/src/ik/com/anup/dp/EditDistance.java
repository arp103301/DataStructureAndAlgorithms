package ik.com.anup.dp;
//https://leetcode.com/submissions/detail/676622574/

/*Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.*/
import java.util.Arrays;

public class EditDistance {
	public int minDistance(String word1, String word2) {
	      char a[] = word1.toCharArray();
	        char b[] = word2.toCharArray();
	        int n = a.length;
	        int m = b.length;

	        // Fill all values in table with a maximum value
	        int dp[][] = new int[n + 1][m + 1];
	        for (int i = 0; i <= n; i++) {
	            Arrays.fill(dp[i], n + m);
	        }
	        dp[0][0] = 0;
	        for (int i = 1; i <= n; i++) {
	            // If second string is empty, only option is to
	            // remove all characters of second string
	            dp[i][0] = i;
	        }
	        for (int i = 1; i <= m; i++) {
	            // If first string is empty, only option is to
	            // isnert all characters of second string
	            dp[0][i] = i;
	        }
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= m; j++) {
	                if (a[i - 1] == b[j - 1]) {
	                    // If last characters are same, ignore last char
	                    // and recur for remaining string
	                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
	                } else {
	                    // If the last character is different, consider all
	                    // possibilities and find the minimum
	                    dp[i][j] = Math.min(dp[i][j],
	                        1 + Math.min(dp[i - 1][j - 1], // Replace
	                            Math.min(dp[i - 1][j], // Remove
	                                dp[i][j - 1] // Insert
	                            )));
	                }
	            }
	        }
	        return dp[n][m];
	    }
}
