package ik.com.anup.strings;

public class WildCardCharMatchingDP {

	// Function that matches an input string with a given wildcard pattern
    public static boolean isMatch(String word, String pattern)
    {
        // get length of string and wildcard pattern
        int n = word.length();
        int m = pattern.length();
 
        // create a DP lookup table
        boolean[][] T = new boolean[n+1][m+1];
 
        // if both pattern and string are empty: match
        T[0][0] = true;
 
        // handle empty string case (i == 0)
        for (int j = 1; j <= m; j++)
        {
            if (pattern.charAt(j - 1) == '*') {
                T[0][j] = T[0][j - 1];
            }
        }
 
        // build a matrix in a bottom-up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (pattern.charAt(j-1) == '*') {
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                }
                else if (pattern.charAt(j-1) == '?' ||
                        word.charAt(i-1) == pattern.charAt(j-1)) {
                    T[i][j] = T[i - 1][j - 1];
                }
            }
        }
 
        // last cell stores the answer
        return T[n][m];
    }
 
    // Wildcard Pattern Matching Implementation in Java
    public static void main(String[] args)
    {
        String word = "xyxzzxy";
        String pattern = "xy***x*";//x****x?
 
        if (isMatch(word, pattern)) {
            System.out.print("Match");
        }
        else {
            System.out.print("No Match");
        }
    }
}

