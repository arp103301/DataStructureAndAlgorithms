package ik.com.anup.dp;

//import com.sun.jdi.Value;

//https://pencilprogrammer.com/algorithms/coin-change-problem-using-dp/ 
/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money
cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000*/
public class CoinChange2 {

	    public  static int coinChange2(int amount, int[] coins) {
	         // Declaring a 2-D array
	      // for storing solutions to subproblems:
	    	//int size = coins.length;
	    	int[][] table = new int[coins.length + 1][amount + 1];
	    	
	      // Initializing first column of array to 1
	      // because a sum of 0 can be made
	      // in one possible way: {0}
	    	for(int i = 0; i < coins.length + 1; i++)
	    		table[i][0] = 1;
	    	
	      // Applying the recursive solution:
	    	for(int i = 1; i < coins.length + 1; i++)//coins  for row 
	    		for(int j = 0; j < amount + 1; j++)//amount  for columns 
	    			if(coins[i - 1] > j)  // Cannot pick the highest coin: since it will be bigger than amount
	    				table[i][j] = table[i - 1][j];// now take previous row value 
	    			else  // Pick the highest coin:
	    				table[i][j] = table[i][j - coins[i - 1]] + table[i - 1][j];// leftvalue(get from input) plus previousROw Value
	    				//dpTable[i][j]=dpTable[i-1][j]+dpTable[i][j-coins[i-1]].
	    	
	    	// explantion for taking the maximum coin
	    	//1. First part is taking the coin in the row 
	    		//when you take the coin, the amount=j shold get reduced by that coin Value>> 
	    	//2. second part is not taking the coins
	    	
	    	return table[coins.length][amount];
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public static void main(String args[]) 
	    { 
	        int coins[] = {1, 2};  // Declaring array of coins
	        int sum = 5;  // The sum to be made

	        System.out.println("The possible ways in which " + sum
	        		+ " can be made is " + coinChange2(sum, coins));
	    } 
	}

	/*
	 * Size of dpTable is (number of coins +1)*(Total Sum +1) First column value is
	 * 1 because if total amount is 0, then is one way to make the change (we do not
	 * include any coin). Row: Number of coins. The 1st-row index is 0 means no coin
	 * is available. 2nd row is 1, it means only 1st coin is available, similarly,
	 * the 3rd-row value index is 2 means the first two coins are available to make
	 * to the total amount and so on.Row index represent index of coin in coins
	 * array not the coin value. Coulmn: Total Amount (sum). The 1st-column index is
	 * 0, it means sum value is 0. 2nd column index is 1 therefore combination of
	 * coins should make the sum of 1, similarly, 3rd column value is 2, means
	 * change of 2 is required and so on. Thus each table field is storing the
	 * solution of subproblems. For Example, dpTable[2][3]=2 means there are 2 ways
	 * to get the sum of 3 using the first two coins {1,2}.
	 * 
	 * The last column and last row value will give the final result.
	 * 
	 * Here We need to loop through all the indexes (except 1st row and 1st column)
	 * in the memo table and make use of previously stored solutions of the
	 * subproblems.
	 * 
	 * If coin value is greater than the dpSum, then do not consider the coin i.e
	 * dpTable[i][j]=dpTable[i-1][j]. If coin value is smaller than the dpSum we can
	 * consider the coin i.e
	 * dpTable[i][j]=dpTable[i-1][dpSum]+dpTable[i][j-coins[i-1]].
	 */

//row is coins and colm is amount in the 2D matrix >>>
//https://pencilprogrammer.com/algorithms/coin-change-problem-using-dp/
	//https://www.youtube.com/watch?v=DJ4a7cmjZY0