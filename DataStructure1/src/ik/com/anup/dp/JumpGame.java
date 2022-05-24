package ik.com.anup.dp;

import java.util.ArrayList;

/*Given a list of maximum jump lengths from different houses, determine if you can reach
 *  the last house in one or more jumps starting from the first one.

Maximum jump length of 2 from a house, for example, means that you can either jump to 
the next house or to the one after next.

Example One
{
"maximum_jump_lengths": [2, 3, 1, 0, 4, 7]
}
Output:

1
You can reach the last house in the following way:

Example one

Example Two
{
"maximum_jump_lengths": [3, 1, 1, 0, 2, 4]
}
Output:

0
You cannot make it past house at index 3. Maximum jump length of 0 from that house means that 
you cannot jump further from it.

LeetCode example
You are given an integer array nums. You are initially positioned 
at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. 
Its maximum jump length is 0, which makes it impossible to reach the last index.


Notes
Constraints:

0 <= jump length <= 105
1 <= number of houses <= 105*/
public class JumpGame {
	 
	static Boolean can_reach_last_house(ArrayList<Integer> maximum_jump_lengths) {
	        // Write your code here.
		//https://github.com/Eric-programming/CodeSolution/blob/master/src/DPDecisionMaking/JumpGame/JumpGame_Bottom_up.java
		//https://uplevel.interviewkickstart.com/resource/editorial/rc-codingproblem-167226-485511-57-1601	
			
		 //Greedy approach from the end ::::::::: if i+num_I  is greater than leftMost ; update lerftMost to i
	      int n = maximum_jump_lengths. size(), leftMost = n - 1;  
	      // n-1 is already good value so iteration starts from n-2
	        for(int i = n - 2; i >= 0; i--){
	           // if(i + nums[i] >= goal){
	        	if(i + maximum_jump_lengths.get(i) >= leftMost){
	        	leftMost = i;
	            }
	        }
	        return leftMost == 0;
	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*      int n = maximum_jump_lengths.size();
	        if (n == 1) return true;
	        
	        int maxReach = 0;
	        for (int i = 0; i < n; i++) {//see constraints
	        	
	            //no need to find the combination  hence only 1 for loop for input arraylist
	        	if (maxReach < i)  return false;
	        	
	            maxReach = Math.max( i + maximum_jump_lengths.get(i),maxReach);
	            
	            if (maxReach >= n - 1) return true;//end of the run
	        }
	        
	        return false; */	
		
	    }
	   
	 /*public class JumpGame2 {
		public int jump(int[] nums) {
			
			int [] jumps = new int[nums.length];
		  
		    jumps[0]=0;
		    for(int i=1;i<nums.length;i++)
		    {
		        for(int j=0;j<i;j++)
		        {
		            if(nums[j]>=i-j)
		                jumps[i] = Integer.min(jumps[i], jumps[j]+1);
		        }
		    }
		    return jumps[nums.length-1];
		}
	}*/
