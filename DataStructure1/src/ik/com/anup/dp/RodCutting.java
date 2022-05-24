package ik.com.anup.dp;

//https://www.techiedelight.com/rod-cutting/


/*Given a rod of length n and a list of rod prices of length i, where 1 <= i <= n, 
find the optimal way to cut the rod into smaller rods to maximize profit*/


public class RodCutting {// for maximum profit

	  public static int bottomUpRodCutting(int price[], int n) {
	    int[] table = new int[n+1];
	    table[0] = 0;
		/*
		 * int[][] table;
		 * 
		 * 
		 * table= new int[price.length+1][n+1]; for(int i = 0; i < price.length + 1;
		 * i++) table[i][0] = 1;
		 */
		// consider a rod of length `i`
		for (int i = 1; i <= n; i++)
		{
			// divide the rod of length `i` into two rods of length `j` and `i-j` each and take maximum
			for (int j = 1; j <= i; j++) {
				table[i] = Integer.max(table[i], price[j - 1] + table[i - j]);
			}
		}
	    
		return table[n];
	    
		/*
		 * for(int i=1;i<price.length+1;i++) { for(int j=1;j<n+1;j++) { if( i <= j ) {
		 * table[i][j] = Math.max(table[i-1][j], price[i] + table[i][j-i]); } else {
		 * table[i][j] = table[i-1][j]; } } }
		 * 
		 * return table[price.length][n];
		 */
	  }

	  public static void main(String[] args) {
	    // array starting from 1, element at index 0 is fake
	    int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
	    System.out.println(bottomUpRodCutting(price, 5));
	  }
}


//https://github.com/Aegis2952/Rod-Cutting_Java_Solution/blob/main/Algorithm.java
//https://www.techiedelight.com/rod-cutting/