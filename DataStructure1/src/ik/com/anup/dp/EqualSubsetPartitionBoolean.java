package ik.com.anup.dp;
/***https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx  *************/

//LC416
public class EqualSubsetPartitionBoolean {


		  public boolean canPartition(int[] num) {
		    int n = num.length;
		    // find the total sum
		    int sum = 0;
		    for (int i = 0; i < n; i++)
		      sum += num[i];

		    // if 'sum' is a an odd number, we can't have two subsets with same total
		    if(sum % 2 != 0)
		      return false;

		    // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
		    sum = sum/2;

		    boolean[][] dp = new boolean[n][sum + 1];

		    // populate the sum=0 column, as we can always have '0' sum without including any element
		    for(int i=0; i < n; i++)
		      dp[i][0] = true;

		    // with only one number, we can form a subset only when the required sum is equal to its value
		    for(int s=1; s <= sum ; s++) {
		      dp[0][s] = (num[0] == s ? true : false);
		    }

		    // process all subsets for all sums
		    for(int i=1; i < n; i++) {
		      for(int s=1; s <= sum; s++) {
		       
				/*
				 * So, for each number at index ‘i’ (0 <= i < num.length) and sum ‘s’ (0 <= s <=
				 * S/2), we have two options:
				 * 
				 * 1.Exclude the number. In this case, we will see if we can get ‘s’ from the
				 * subset excluding this number: dp[i-1][s]
				 * 
				 * 2. Include the number if its value is
				 * not more than ‘s’. In this case, we will see if we can find a subset to get
				 * the remaining sum: dp[i-1][s-num[i]]
				 */
		    	  
		    	  
		        if(dp[i-1][s]) {// actually [s-num[i]] if num is not used then it becomes dp[i-1][s-nothing]=dp[i-1][s]
		          dp[i][s] = dp[i-1][s];//case 1// // if we can get the sum 's' without the number at index 'i'
		          ///::::: previosRowSameCol value
		       
		        } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
		          dp[i][s] = dp[i-1][s-num[i]];//case 2 
		          //prevRow_(sameCol-thatspecificNumbrFromList)
		        }
		      }//for sum
		    }//for num

		    // the bottom-right corner will have our answer.
		    return dp[n-1][sum];
		  }

		  public static void main(String[] args) {
			  EqualSubsetPartitionBoolean ps = new EqualSubsetPartitionBoolean();
		    int[] num = {1, 2, 3, 4};
		    System.out.println(ps.canPartition(num));
		    num = new int[]{1, 1, 3, 4, 7};
		    System.out.println(ps.canPartition(num));
		    num = new int[]{2, 3, 4, 6};
		    System.out.println(ps.canPartition(num));
		  }
		

}
/*
 * The above solution has time and space complexity of O(N*S), where ‘N’
 * represents total numbers and ‘S’ is the total sum of all the numbers.
 */


