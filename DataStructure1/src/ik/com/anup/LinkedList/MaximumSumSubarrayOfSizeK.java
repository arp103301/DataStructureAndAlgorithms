package ik.com.anup.LinkedList;
//https://www.youtube.com/watch?v=KtpqeN0Goro

//1. initialization of calculation 
//2. j increase until window size.. 
//3. inside this window size do the calculation
//4. move both pntr


public class MaximumSumSubarrayOfSizeK {

	
	private static int slidingWindowMaxSum(int[] arr, int k) {
		int n = arr.length;
		int left = 0, right = 0, max = Integer.MIN_VALUE, sum = 0;
		while (right < n) {
			//1.initialization of calculation
			sum += arr[right];
			
			//2. increase right until we reached the window size
			if (right-left+1<k)	right++;
			else if (right-left+1==k) {//now the window size is reached , do the main calculation inside the window size 
				
				max = Math.max(max, sum);
				sum -= arr[left];// remove the first index value from sum so that it is ready for next window
			}
			
			//4. move the window forward
			left++;
			right++;
	
		}
		return max;
	}
	
	
	public static void main(String[] args) {
	    int[] arr= new int[]{14,11,41,2,5,55,9,28,10,12};
	    System.out.println("Max sum of three consecutive numbers "+slidingWindowMaxSum(arr,3));
	}
}
