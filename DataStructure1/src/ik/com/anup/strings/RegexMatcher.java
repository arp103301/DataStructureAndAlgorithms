package ik.com.anup.strings;

/*Given a text string containing characters only from lowercase alphabetic characters and a pattern string containing characters only from lowercase alphabetic characters and two other special characters '.' and '*'.

Your task is to implement a pattern matching algorithm that returns true if pattern is matched with text otherwise returns false. The matching must be exact, not partial.

Explanation of the special characters:

'.' - Matches a single character from lowercase alphabetic characters.
'*' - Matches zero or more preceding character. It is guaranteed that '*' will have one preceding character which can be any lowercase alphabetic character or special character '.'. But '*' will never be the preceding character of '*'. (That means "**" will never occur in the pattern string.)
'.' = "a", "b", "c", ... , "z"
a* = "a", "aa", "aaa", "aaaa",... or empty string("")
ab* = "a", "ab", "abb", "abbb", "abbbb", ...
Example One
{
"text": "abbbc",
"pattern": "ab*c"
}
Output:

1
Given pattern string can match: "ac", "abc", "abbc", "abbbc", "abbbbc", ...

Example Two
{
"text": "abcdefg",
"pattern": "a.c.*.*gg*"
}
Output:

1
".*" in pattern can match "", ".", "..", "...", "....", ... . "g*" in pattern can match "", "g", "gg", "ggg", "gggg", ... .
Now, consider:
'.' at position 2 as 'b',
'.*' at position {4, 5} as "...",
'.*' at position {6,7} as "" and
[g*] at position {8,9} as "".
So, "a.c.*gg*" = "abc...g" where we can write "..." as "def". Hence, both matches.

Example Three
{
"text": "abc",
"pattern": ".ab*.."
}
Output:

0
If we take 'b*' as "" then also, length of the pattern will be 4 (".a.."). But, given text's length is only 3. Hence, they can not match.

Notes
Constraints:

0 <= text length, pattern length <= 1000
text string containing characters only from lowercase alphabetic characters.
pattern string containing characters only from lowercase alphabetic characters and two other special characters '.' and '*'.
In pattern string, It is guaranteed that '*' will have one preceding character which can be any lowercase alphabetic character or special character '.'. But '*' will never be the preceding character of '*'.*/
public class RegexMatcher {

    static boolean pattern_matcher(String text, String pattern) {
        boolean[][] memo = new boolean[text.length() + 1][pattern.length() + 1];
        memo[0][0] = true;
        for (int j = 1; j < memo[0].length; j++) {
            if (pattern.charAt(j - 1) == '*') {
                memo[0][j] = memo[0][j - 2];
            } else {
                memo[0][j] = false;
            }
        }
        for (int i = 1; i < memo.length; i++) {
            memo[i][0] = false;
        }
        for (int i = 1; i < memo.length; i++) {
            char tc = text.charAt(i - 1);
            for (int j = 1; j < memo[0].length; j++) {
                char pc = pattern.charAt(j - 1);
                if (pc == '*') {
                    memo[i][j] = memo[i][j - 1] || memo[i][j - 2]
                    || ((tc == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') && memo[i - 1][j]);
                } else {
                    memo[i][j] = pc == '.' || tc == pc ? memo[i - 1][j - 1] : false;
                }
            }
        }

        return memo[text.length()][pattern.length()];
    }
}


/*
 * optimal_solution.java This solution uses Dynamic Programming. In this method,
 * We build a dp[][] 2D boolean array from top to bottom such that dp[i][j]
 * indicates first i character of text string matches to first j character of
 * pattern string or not.
 * 
 * Here, 3 cases will arise, Case 1: dp[i][j - 1] is true. It means first i
 * character of text string matches with first j - 1 character of simplified
 * pattern string. So, dp[i][j] will be true if jth character of simplified
 * pattern string is '*', it means isStarChar[j] should be true.
 * 
 * Case 2: dp[i - 1][j - 1] is true. It means first i - 1 character of text
 * string matches with first j - 1 character of simplified pattern string. So,
 * dp[i][j] will be true if jth character of simplified pattern string matches
 * with ith character of text string. It can only be match if jth character of
 * pattern string is '.' or same as ith character of text string.
 * 
 * Case 3: dp[i-1][j] is true. It means first i - 1 character of text string
 * matches with first j character of simplified pattern string. So, dp[i][j]
 * will be true if jth character of simplified pattern string is '*' and can be
 * match with ith character of text string. It can only be match if jth
 * character of pattern string is '.' or same as ith character of text string.
 * 
 * Time Complexity O(len_simpl_pat * len_text + (len_simpl_pat + len_text)).
 * O(len_simpl_pat + len_text) for reading input and simplifying pattern string.
 * 
 * Auxiliary Space Used O(len_simpl_pat * len_text + (len_pat + len_text)). As
 * we are using boolean array of size (len_simpl_pat * len_text) to store dp
 * values, Char array of size len_pat to get simplified pattern string, boolean
 * array of size len_pat to store is that toStarChar or not.
 * 
 * Space Complexity O(len_simpl_pat * len_text + (len_pat + len_text)). As input
 * is O(len_pat + len_text) and auxiliary space used is O(len_simpl_pat *
 * len_text + (len_pat + len_text)). So, O(len_pat + len_text) + O(len_simpl_pat
 * * len_text + (len_pat + len_text)) = O(len_simpl_pat * len_text + (len_pat +
 * len_text)).
 */