package ik.com.anup.recursion;

import java.util.ArrayList;

/*Find All Well-formed Brackets
Given a positive integer n, return ALL strings of length 2 * n with well-formed round brackets.

Example
{
"n": 3
}
Output:

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]
Any array containing these five strings in any order is a correct output.

Notes
Order of strings in the returned array is insignificant, e.g. for n = 2 both ["(())", "()()"] and ["()()", "(())"] will be accepted.
Constraints:

1 <= n <= 12
Only use round brackets. '(' and ')'*/
public class AllWelformedBrackets {
	 static ArrayList<String> find_all_well_formed_brackets(Integer n) {
			// Write your code here.
			ArrayList<String> results = new ArrayList<>();

			helper((int) n, 0, 0, results, new StringBuilder(""));

			return results;
	    }

	private static ArrayList<String> helper( int n, int openLocation, int closeLocation, 
			ArrayList<String> results,StringBuilder  sb) {
		// TODO Auto-generated method stub
		// Base case

		if (openLocation == closeLocation && openLocation == n) {
			results.add(sb.toString());
			return results;

		}

		// Recursion
		else {
			if (openLocation < n) {

				helper(n, openLocation + 1, closeLocation, results, sb.append('('));
			}
			if (closeLocation < openLocation) {
				helper(n, openLocation, closeLocation + 1, results, sb.append(')'));
			}
		}
		return results;
	}
	
	
	/*--best solution 4 from uplevel 
	static ArrayList<String> find_all_well_formed_brackets(Integer n) {
	    ArrayList<String> result = new ArrayList<>(); 
	    backtrack(result, new StringBuilder(), 0, 0, n);
	    return result;
	}
	
	
	static void backtrack(ArrayList<String> result, StringBuilder sb, int o, int c, int n) {
	    if (sb.length() == 2 * n) {
	        result.add(new String(sb));
	    } else {
	        if (o < n) {
	            sb.append("("); 
	            backtrack(result, sb, o + 1, c, n);
	            sb.deleteCharAt(sb.length() -1);
	        } 
	        
	        if (c < o) {
	            sb.append(")"); 
	            backtrack(result, sb, o, c+1, n); 
	            sb.deleteCharAt(sb.length() -1);
	        }
	    }
	}*/
	 
}
