/*
 * package ik.com.anup.LinkedList;
 * 
 * 
 * //https://www.youtube.com/watch?v=xFJXtB5vSmM >> check comment from Himanshu
 * Malik
 * 
 * 
 * import java.util.Deque; import java.util.LinkedList;
 * 
 * //1. initialization of calculation 2. j increase until window size.. 3. do
 * the calculation in window size 4. move bothpointr
 * 
 * 
 * 239. Sliding Window Maximum Hard
 * 
 * 9671
 * 
 * 342
 * 
 * Add to List
 * 
 * Share You are given an array of integers nums, there is a sliding window of
 * size k which is moving from the very left of the array to the very right. You
 * can only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7] Explanation:
 * Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5
 * 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3
 * -1 -3 5 [3 6 7] 7 Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 -104 <= nums[i] <= 104 1 <= k <= nums.length
 * 
 * 
 * 
 * public class MaximumsubArrayOfSizeK2 { class Solution { public int[]
 * maxSlidingWindow(int[] nums, int k) { int result[] = new int[nums.length - k
 * + 1]; Deque<Integer> q = new LinkedList<>();
 * 
 * int i = 0; int j = 0;
 * 
 * while(j < nums.length){ //1. initialization of calculation if(q.size() == 0){
 * q.add(nums[j]); } else{ // For every element, the previous // smaller
 * elements are useless so****************************** // remove them from Q
 * while(q.size() > 0 && q.peekLast() < nums[j]){ q.removeLast(); }
 * q.add(nums[j]);// add the maximum one } // 2. j increase until window sizenow
 * move j pointer if(j - i + 1 < k) j++; // if we hit the window size else if(j
 * - i + 1 == k){//3. //now the window size is reached , do the main calculation
 * inside the window size // answer -> calculation; result[i] = q.peek();//
 * queue first element is max of the 1st window hence add to resultset
 * 
 * if(nums[i] == q.peek()) { q.removeFirst();// remove the queue with previous
 * element so that its contribution is not included in the next window
 * calculation } // //4. move the window forward i++; j++; } } return result; }
 * 
 * } }
 */