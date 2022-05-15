package ik.com.anup.LinkedList;
//https://www.youtube.com/watch?v=KtpqeN0Goro

//1. initialization of calculation 2. j increase until window size.. 3. do the calculation in window size  4. move bothpointr
public class MaximumSumSubarrayOfSizeK {

	
	private static int slidingWindowMaxSum(int[] arr, int k) {
		int n = arr.length;
		int i = 0, j = 0, max = Integer.MIN_VALUE, sum = 0;
		while (j < n) {
			//1.initialization of calculation
			sum += arr[j];
			
			//2. increase j until we reached the window size
			if (j-i+1<k)	j++;
			else if (j-i+1==k) {//now the window size is reached , do the main calculation inside the window size 
				
				max = Math.max(max, sum);
				sum -= arr[i];// remove the first index value from sum so that it is ready for next window
			}
			
			//4. move the window forward
			i++;
			j++;
	
		}
		return max;
	}
	
	
	public static void main(String[] args) {
	    int[] arr= new int[]{14,11,41,2,5,55,9,28,10,12};
	    System.out.println("Max sum of three consecutive numbers "+slidingWindowMaxSum(arr,3));
	}
}
