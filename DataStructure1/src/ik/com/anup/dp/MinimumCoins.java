package ik.com.anup.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a variety of coin types defining a currency system, find 
 * the minimum number of coins required to express a given amount of money.
 *  Assume infinite supply of coins of every type.

Example
{
"coins": [1, 3, 5],
"value": 9
}
Output:

3
Here are all the unique ways to express 9 as a sum of coins 1, 3 and 5:

1, 1, 1, 1, 1, 1, 1, 1, 1
1, 1, 1, 1, 1, 1, 3
1, 1, 1, 1, 5
1, 1, 1, 3, 3
1, 3, 5
3, 3, 3
Last two ways use the minimal number of coins, 3.

Notes
There will be no duplicate coin types in the input.

Constraints:

1 <= number of coin types <= 102
1 <= coin value <= 102
1 <= amount of money to express <= 104*/
public class MinimumCoins {
	   static Integer minimum_coins(ArrayList<Integer> coins, Integer amount) {
	        // Write your code here.
		   int[] dp = new int[amount + 1];

		    // Initialize the dp table
		    Arrays.fill(dp, amount + 1);  

		    /*
		      The answer to making change with minimum coins for 0
		      will always be 0 coins no matter what the coins we are
		      given are
		    */
		    dp[0] = 0;

		    
		    
		    
			/*
			 * Base case: dp[0] = 0, other values in the array are set to the positive
			 * infinity.
			 * 
			 * We use 2 loops:
			 * 
			 * The 1st loop(i) iterates over 1..value. The 2nd loop(j) iterates over the
			 * given coin types. For every value of i and coins[j] we check if that i
			 * (current value to be expressed) is greater than or equals to the coin value,
			 * i.e. i >= coins[j]. If yes, then we update 
			 * dp[i] = min(dp[i], 1 + dp[i -coins[j]]).
			 * 
			 * After the dp table has been constructed, dp[value] will give us our answer.
			 */
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    // Solve every subproblem from 1 to amount
		    for (int i = 1; i <= amount; i++) {
		    	   System.out.println("Amount[i] is ::::"+i );
		      // For each coin we are given
		      for (int j = 0; j < coins.size(); j++) {
		        // If it is less than or equal to the sub problem amount
		        if (coins.get(j) <= i) {//new coin cant be greater than amount:::
		          // Try it. See if it gives us a more optimal solution
		          dp[i] = Math.min(dp[i], dp[i - coins.get(j)] + 1);// plus one  since we taking at least 1 coin 
		          // second part is :::: amount minus this specific coin plus one(see above)
		          
		          
		          System.out.println("Dp[i] is ::::"+dp[i] );
		       
		        }
		      }
		    }

		    /*
		      dp[amount] has our answer. If we do not have an answer then dp[amount]
		      will be amount + 1 and hence dp[amount] > amount will be true. We then
		      return -1.

		      Otherwise, dp[amount] holds the answer
		    */
		    return dp[amount] > amount ? -1 : dp[amount];// leetcode was failing due to negative case :: BE very careful
	    }

	   
	// Driver program
	    public static void main (String[] args)
	    {
	        int coinsA[] = {9, 6, 5, 1};   ArrayList <Integer> arList = new ArrayList<Integer>(); 
	        for (int i = 0; i < coinsA.length; i++) {
	        	arList.add(coinsA[i]);
	        }
	        int m = arList.size();
	        int V = 115;
			
			  System.out.println ( "Minimum coins required is " + minimum_coins(arList, V));
			 
	    }
}


//T(a.k)=O(ak)
//S(a,k)=O(a)