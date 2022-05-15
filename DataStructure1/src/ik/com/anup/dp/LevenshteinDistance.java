package ik.com.anup.dp;
// EDit distance 
import java.util.Arrays;

/*Given two words word1 and word2, find the minimum number of steps required to 
 * convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
The minimum number of steps required to convert word1 to word2 with the given set of 
allowed operations is called edit distance. e.g. Minimum edit distance between the words 'kitten' and 'sitting', is 3.

kitten → sitten (substitution of "s" for "k")
sitten → sittin (substitution of "i" for "e")
sittin → sitting (insertion of "g" at the end)
Read more about edit distance here.

Example One
{
"word1": "cat",
"word2": "bat"
}
Output:

1
Example Two
{
"word1": "qwe",
"word2": "q"
}
Output:

2
Notes
Constraints:

1 <= length of the strings word1 and word2 <= 105
word1 and word2 contains lower case alphabets from 'a' to 'z'.*/
public class LevenshteinDistance {
	/*
    Asymptotic complexity in terms of length of the input word strings:
    * Time: O(length(word1) * length(word2)).
    * Total space: O(length(word1) * length(word2)).
    */

    static Integer levenshtein_distance(String word1, String word2) {
        char a[] = word1.toCharArray();
        char b[] = word2.toCharArray();
        int n = a.length;
        int m = b.length;

        // Fill all values in table with a maximum value
        int dp[][] = new int[n + 1][m + 1];
        
       
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], n + m);//fill with len1+len2 on all cells
        }
        dp[0][0] = 0;
        
        //fill the  top row 
        for (int i = 1; i <= a.length; i++) {
            // If second string is empty, only option is to
            // remove all characters of second string
            dp[i][0] = i;
        }
        //fill the  leftmost column
        for (int i = 1; i <= b.length; i++) {
            // If first string is empty, only option is to
            // insert all characters of second string
            dp[0][i] = i;
        }
        
        //middle of the matrix
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
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
