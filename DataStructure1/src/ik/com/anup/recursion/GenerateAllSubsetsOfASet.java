package ik.com.anup.recursion;

import java.util.ArrayList;

/*Generate ALL possible subsets of a given set. The set is given in the form of a string s 
 * containing distinct lowercase characters 'a' - 'z'.

Example
{
"s": "xy"
}
Output:

["", "x", "y", "xy"]
Notes
Any set is a subset of itself.
Empty set is a subset of any set.
Output contains ALL possible subsets of given string.
Order of strings in the output does not matter. E.g. s = "a", arrays ["", "a"] and ["a", ""] both will be accepted.
Order of characters in any subset must be same as in the input string. For s = "xy",
 array ["", "x", "y", "xy"] will be accepted, but ["", "x", "y", "yx"] will not be accepted.
Constraints:
0 <= length of s <= 19
s only contains distinct lowercase English letters.*/
public class GenerateAllSubsetsOfASet {
	
    static ArrayList<String> generate_all_subsets(String s) {
        ArrayList<String> result = new ArrayList<>();
        helper(s, 0, new StringBuilder(), result);
        return result;
    }
    
    static void helper(String s, int startInd, StringBuilder slate, ArrayList<String> result) {
        
        //base - left worker node
        if(startInd == s.length()) {
            result.add(slate.toString());/////////////////////
            return;
        }
        
        //recursive - AAAAarbirary worker node
        
        //  Two choices
        //1. do not include the character
        helper(s, startInd + 1, slate, result);
        
        //2. include the character and call the recursive method
        slate.append(s.charAt(startInd));
        helper(s, startInd + 1, slate, result);
        
        //2.b.need to remove that added number for next stage for not-including case:::-)
        slate.deleteCharAt(slate.length() - 1);
    }

}
