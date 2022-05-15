package ik.com.anup.dp;

import java.util.ArrayList;
import java.util.List;

/*Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30*/
public class PascalTriangle {

	 public static  List<List<Integer>> generate(int numRows) {
	        
		 List<List<Integer>> result = new ArrayList<>();
		  if  (numRows==0) return result;
		  
		  List<Integer> firstRow = new ArrayList<Integer>();
		  
		  firstRow.add(1);
		  //add the first row to result
		   result.add(firstRow);
		 
		   for (int i = 1; i <numRows; i++) {// since row 1 is already filled
			   List<Integer> prevRow = result.get(i-1);
			   
			   List<Integer> currRow = new ArrayList<Integer>();
			    currRow.add(1);
			    
			    for (int j = 1; j<i; j++) {// since row 1 is already filled
			    	// add the  top_prevRow and leftside_prevRow
			    	currRow.add(prevRow.get(j-1)+prevRow.get(j));
			    }
			    //add the final row 
			    currRow.add(1);
			     result.add(currRow);
			    // System.out.println("currRow is "+currRow+" "); 
		   }
		   
		   
		   
		
		 return result;
		 
	    }
	
	 
	 
	// Test it 
	 public static void main (String[] args) {
		 int rows = 5;
		// System.out.println("The pascal triangle of "+rows+" rows is");
		 List<List<Integer>> result = generate(rows);
		  // print the list<list>
		 for (int i = 0; i < result.size(); i++) {
	            for (int j = 0; j < result.get(i).size(); j++) {
	                System.out.print(result.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	 }
}
