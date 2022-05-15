package ik.com.anup.dp;

public class LongestCommonSubsequence {
	 
	public int longestCommonSubsequence(String text1, String text2) {
	        
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		
		for (int i = 0; i < text1.length(); ++i) {
			for (int j = 0; j < text2.length(); ++j) {

				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;// 1 plus diagonal
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);// max of prevRow or PrevColm
				}

			}
	        }

	        return dp[text1.length()][text2.length()]; 
	        
	        // LEetcode failed with buffering on both row and col with zeros so try the above ones 
		//int m = text1.length();
		//int n = text2.length();
		//int table [][] = new int [m+1][n+1];
		
		// DP table has both firstrow and first column filled with zeros 
		//hence need to start with index 1 on both loops -- check Bari's videos
		//for (int i =1; i<m;i++) {
		//	for (int j =1; j<n; j++) {
		//		if (text1.charAt(i-1)==text2.charAt(j-1)) {
			//		table[i][j]=1+table[i-1][j-1];// 1+ previous_digonal 
			//	}else {
			//		table[i][j]=Math.max(table[i-1][j], table[i][j-1]);// max(prevRow, PrevCol)
			//	}
			//}
		//}
		//return table[m][n];
	    }
}
//https://www.youtube.com/watch?v=sSno9rV8Rhg

//https://medium.com/@greekykhs/leetcode-longest-common-subsequence-39a2d86c6aae#:~:text=Given%20two%20strings%20text1%20and,order%20of%20the%20remaining%20characters.