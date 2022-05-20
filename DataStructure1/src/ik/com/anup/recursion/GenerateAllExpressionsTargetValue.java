package ik.com.anup.recursion;


//282. Expression Add Operators

import java.util.ArrayList;
import java.util.List;

/*Given a string s that consists of digits ("0".."9") and target, a non-negative integer, 
 * find all expressions that can be built from string s that evaluate to the target.

When building expressions, you have to insert one of the following operators between 
each pair of consecutive characters in s: join or * or +. For example, by inserting different operators 
between the two characters of string "12" we can get either 12 (1 joined with 2 or "12") or 2 ("1*2") or 3 ("1+2").

Other operators such as - or ÷ are NOT supported.

Expressions that evaluate to the target but only utilize a part of s do not count: entire s has to be consumed.

Precedence of the operators is conventional: join has the highest precedence, * – medium and + 
has the lowest precedence. For example, 1 + 2 * 34 = (1 + (2 * (34))) = 1 + 68 = 69.

You have to return ALL expressions that can be built from string s and evaluate to the target.

Example
{
"s": "202",
"target": 4
}
Output:

["2+0+2", "2+02", "2*02"]
Same three strings in any other order are also a correct output.

Notes
Order of strings in the output does not matter.
If there are no expressions that evaluate to target, return an empty list.
Returned strings must not contain spaces or any characters other than "0",..., "9", "*", "+".
All returned strings must start and end with a digit.
Constraints:

1 <= length of s <= 13
1 <= target <= 1013*/
public class GenerateAllExpressionsTargetValue {
	
	
/*	  static ArrayList<String> generate_all_expressions(String s, Long target) { //
	 // Write your code here. 
	  ArrayList<String> result = new ArrayList<>();
	  
	  if(s == null) return result;
	  
	  generateExpressions(result, s, "", target, 0, 0, 0);
	  
	  return result; 
	  }

	static void generateExpressions(ArrayList<String> result, String input,
	  String slate, long target, int startInd, long curVal, long lastVal) { if
	  (startInd == input.length()) { if (curVal == target) { result.add(slate); } }
	  
	  for (int i = startInd; i < input.length(); i++) {// possible length=13
	  
	  String partVal = input.substring(startInd, i + 1); long curNum =
	  Long.parseLong(partVal);
	  
	  if( startInd == 0) {// no need to add or multiply 
		  generateExpressions(result,
	  input, (slate + partVal), target,i + 1, curNum, curNum); } 
	  else {// firstelement is not 0 
		  generateExpressions(result, input, (slate + "+" + partVal),target,i + 1, (curVal + curNum), curNum);
		  generateExpressions(result, input,(slate + "*" + partVal), target,i + 1, (curVal-lastVal) + (lastVal * curNum),
	  (lastVal * curNum));
		  } 
	  } 
	  }
	 
	*/
	
	
	
	
	
	
	
	
	
	//https://zhuhan0.blogspot.com/2017/08/leetcode-282-expression-add-operators.html	
	static ArrayList<String> generate_all_expressions(String s, Long target) {
        // Write your code here.
		ArrayList<String> list = new ArrayList<>();
		exprHelper(s, target, 0, 0, "", list);
        return list;
    }

	 static private void exprHelper(String num, long target, int start,
			 long prevVal, String slate, ArrayList<String> result) {
        if (target == 0 && start == num.length()) {
            result.add(slate);
            return;
        }
        
        for (int i = start; i < num.length(); i++) {
            if (i > start && num.charAt(start) == '0') {//can not do anything with string starting with zero
                return;
            }
            
            long currVal = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
            	exprHelper(num, target - currVal, i + 1, currVal, slate + currVal, result);
            } else {
            	// target and slate changed with i+1
            	exprHelper(num, target - currVal, i + 1, currVal, slate + "+" + currVal, result);
            	exprHelper(num, target + currVal, i + 1, -currVal, slate + "-" + currVal, result);
            	 //  In other words: 4 - 3 + (3 * 4) = 13. And in terms of the parameters:
            	exprHelper(num, target + prevVal - prevVal * currVal, i + 1, prevVal * currVal, slate + "*" + currVal, result);
            	
            	//prevVal = 4-3+3 and currentVal 4 hence>>>>>>>>>>>> target -prevval+prevVal * currVal
            }
        }
    }
	///////////////////////// The overall time complexity is O(4^n).
}

/*
 * //time complexity // for add and sum ::Let us try to count those calls. We
 * won't group them by level in the recursion tree (as that's usually done) but
 * by number of digits in the expression:
 * 
 * there are 3n-1 distinct expressions made of n digits (as we established in
 * the very beginning) 3n-2 expressions made of n-1 digits 31=3 expressions made
 * of 2 digits 30=1 expression made of 1 digit The above are the first n terms
 * of the geometric series with first element a1=1 and ratio r=3. Their sum: Sn
 * = (a1 * (1 - rn)) / (1 - r) = (1 * (1 - 3n)) / (1 - 3) = (3n) / 2 - ½
 * 
 * We could add 1 for the root recursive call to get exact number of nodes in
 * the recursion tree, but asymptotically that won't matter. Overall we have
 * O(3n) recursive calls each taking O(n) time. Total time complexity is O(n *
 * 3n).
 * 
 * 
 * 
 * 
 * for all three operators Time complexity: For each character, there are four
 * cases of the character that follows: +, -, *, and nothing. Say the length of
 * the string is n. The overall time complexity is O(4^n).
 */