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
	    
	      int n=triangle.size();
	        int[][] dp=new int[n][n];
	        
	        
			for(int i=0;i<n;i++){
				dp[n-1][i]=triangle.get(n-1).get(i);
			}
			
			// triangle loop from bottom while DP loop from top 
			for(int i=n-2;i>=0;i--){
				for(int j=0;j<=i;j++){
					// take the min between the down path versus the diagonal path 
					//dp[i][j]=Math.min(dp[i+1][j]+triangle.get(i).get(j),dp[i+1][j+1]+triangle.get(i).get(j));
					dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
					// add triangle to  min between currentRow and DiagonalUp
				}
			}
			return dp[0][0];
	    
	    
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