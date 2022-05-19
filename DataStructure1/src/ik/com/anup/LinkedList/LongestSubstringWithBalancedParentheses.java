package ik.com.anup.LinkedList;

//hint::::::::::::::::::::::::::::::::::: if rightCount more than leftCount...restart he count for next forloop iteration 
//again double check with righttoleftScan 
// scans needed from both direction


/*Given a string brackets that only contains characters '(' and ')', find the length of the longest substring
 *  that has "balanced parentheses".

Example One
{
"brackets": "((((())(((()"
}
Output:

4
Because "(())" is the longest substring with balanced parentheses.

Example Two
{
"balanced": "()()()"
}
Output:

6
The entire string "()()()" has parentheses balanced.

Notes
A string is defined as having balanced parentheses if and only if it has an equal number of '(' and ')' 
and its every prefix has at least as many '('s as ')'s.
Constraints:

1 <= length of brackets <= 105*/
public class LongestSubstringWithBalancedParentheses {

    static Integer find_max_length_of_matching_parentheses(String brackets) {
        // Write your code here.
        char[] chars = brackets.toCharArray();
        int leftCount = 0;
        int rightCount = 0;
        int maxCount = 0;
        
        //Scan from left to right.
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            
            if(rightCount > leftCount) { // start fresh
                leftCount = 0;
                rightCount = 0;
            }
             else if(leftCount == rightCount) {
                maxCount = Math.max(maxCount, 2 * leftCount);//take count of close * 2, as we need to consider open also
            }//https://leetcode.com/problems/longest-valid-parentheses/discuss/2017506/Easy-O(1)-space-solution-O(n)-time
        }
    /*    """
        Consider '(((()))'.

        First 'left_count' becomes 4, then 'right_count' becomes 3. The "balance" of left_count==right_count
        is never reached, so answer is not found. A scan in the opposite direction is needed.
        """*/

       // # Scan from right to left.
        leftCount = 0;
        rightCount = 0;
        
        for(int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            
            if(leftCount > rightCount) { // start fresh
                leftCount = 0;
                rightCount = 0;
            } else if(leftCount == rightCount) {
                maxCount = Math.max(maxCount, 2 * leftCount);//take count of close * 2, as we need to consider open also
            }
        }
        return maxCount;// this is the finalMaxcount from both direction.
    }


}
