package ik.com.anup.dp;

import java.util.Arrays;
import java.util.List;

/*120. Triangle
Medium

4835

380

Add to List

Share
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below.
 More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
///////////////// actually it leftside is restristed at index 0 so 2 on top of 3 on top of 6 etc*********
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-10^4 <= triangle[i][j] <= 10^4
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?*/
public class PascalTriagleMinPathSum {
	public int minimumTotal(List<List<Integer>> triangle) {
	    
	      int n = triangle.size();
	        int[][] dp = new int[n + 1][n + 1];
	        for(int i = 1; i <= n; i++) {
	            for (int j = 1; j <= i; j++) {
	                if(j == 1) {//downpath
	                    dp[i][j] = triangle.get(i - 1).get(j - 1) + dp[i - 1][j];
	                } else if (j == i) {//diagonalPath
	                    dp[i][j] = triangle.get(i - 1).get(j - 1) + dp[i - 1][j - 1];
	                } else {//min(diagPth,DOwnPath)
	                    dp[i][j] = triangle.get(i - 1).get(j - 1) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]); 
	                }
	            }
	        }
	        int min = Integer.MAX_VALUE;
	        for(int i = 1; i <= n; i++) {
	            min = Math.min(min, dp[n][i]);
	        }
	        return min;
	    
	    
	}
}

//  single O(n) extra space ..
  //public int minimumTotal(List<List<Integer>> triangle) {
//	  int[] A = new  int[triangle.size()+1]; //////////////////////////////////nice
	//  for(int i=triangle.size()-1;i>=0;i--){
	//	  for(intj=0;j<triangle.get(i).size();j++){ 
	//		  A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j); 
		//}
			//} 
	//  return A[0];
 // }


	/*
	 * 'Bottom-up' DP, on the other hand, is very straightforward: we start from the
	 * nodes on the bottom row; the min pathsums for these nodes are the values of
	 * the nodes themselves. From there, the min pathsum at the ith node on the kth
	 * row would be the lesser of the pathsums of its two children plus the value of
	 * itself, i.e.:
	 * 
	 * minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i]; 
	 * 
	 * Or
	 * even better, since the row minpath[k+1] would be useless after minpath[k] is
	 * computed, we can simply set minpath as a 1D array, and iteratively update
	 * itself:
	 * 
	 * For the kth level: minpath[i] = min( minpath[i], minpath[i+1]) +
	 * triangle[k][i];
	 */ 