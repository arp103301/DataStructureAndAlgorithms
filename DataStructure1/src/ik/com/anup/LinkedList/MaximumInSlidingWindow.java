/*
 * package ik.com.anup.LinkedList;
 * 
 * //check the version2 solution for more clarity
 * :::::::::::::::::MaximumsubArrayOfSizeK2
 * 
 * //https://www.youtube.com/watch?v=xFJXtB5vSmM
 * 
 * 
 * // use deque to check peeklast for inserting within the window.. use 2 for
 * loops ..one from 0 to w-1 and another from w to n
 * 
 * 
 * import java.util.ArrayList; import java.util.Deque; import
 * java.util.LinkedList;
 * 
 * Given an array of integers arr of size n and an integer w, find maximum
 * number in all subarrays of arr of length w.
 * 
 * Imagine that n is very large and a sliding window of a smaller size w is
 * moving through arr from left to right. We need to find the maximum in every
 * position of the sliding window.
 * 
 * Example { "arr": [1, 3, -1, -3, 5, 3, 6, 7], "w": 3 } Output:
 * 
 * [3, 3, 5, 5, 6, 7] Size of arr is 8 and so the size of the output array is n
 * - w + 1 = 8 - 3 + 1 = 6.
 * 
 * Here are all the 6 positions of the sliding window and the corresponding
 * maximum values:
 * 
 * [1 3 -1] -3 5 3 6 7. Maximum is 3. 1 [3 -1 -3] 5 3 6 7. Maximum is 3. 1 3 [-1
 * -3 5] 3 6 7. Maximum is 5. 1 3 -1 [-3 5 3] 6 7. Maximum is 5. 1 3 -1 -3 [5 3
 * 6] 7. Maximum is 6. 1 3 -1 -3 5 [3 6 7]. Maximum is 7. Notes Function must
 * return an array of integers of length n - w + 1. i-th value in the returned
 * array must be the maximum among arr[i], arr[i + 1], ..., arr[i + w - 1].
 * Constraints:
 * 
 * 1 <= n <= 105 -2 * 109 <= arr[i] <= 2 * 109 1 <= w <= n public class
 * MaximumInSlidingWindow {
 * 
 * static ArrayList<Integer> max_in_sliding_window(ArrayList<Integer> arr,
 * Integer w) { if (w == 1) return (ArrayList<Integer>) arr; ArrayList<Integer>
 * result = new ArrayList<>(); // Create a Double Ended Queue, Qi // that will
 * store indexes of array elements // The queue will store indexes of // useful
 * elements in every window and it will // maintain decreasing order of values
 * // from front to rear in Q, i.e., // arr[Q.front[]] to arr[Q.rear()] // are
 * sorted in decreasing order Deque<Integer> q = new LinkedList<>(); 1. Process
 * first w (or first window) elements of array for (int i = 0; i < w; i++) { if
 * (q.isEmpty()) { q.offer(arr.get(i)); } else { // For every element, the
 * previous // smaller elements are useless so****************************** //
 * remove them from Q while (!q.isEmpty() && q.peekLast() < arr.get(i)) //
 * Remove from rear q.removeLast(); // Add new element at rear of queue
 * q.offer(arr.get(i)); } } // First element in the deque is the greatest of all
 * withing that window, by design.-- only one reamining on the deque
 * result.add(q.peekFirst());
 * 
 * //2. Process rest of the elements, i.e., from arr[w] to arr[n-1] for (int i =
 * w; i < arr.size(); i++) { // Remove the elements which // are out of this
 * window // Making sure there isn't an out-of-window element in the deque.
 * //********** This is the only reason deque stores indices and not actual
 * elements of arr.************************ if (q.peekFirst() == arr.get(i - w))
 * q.removeFirst(); ///////////////////////////////////**************see above
 * while (!q.isEmpty() && q.peekLast() < arr.get(i)) // Remove all elements
 * smaller // than the currently // being added element (remove // useless
 * elements) q.removeLast(); // Add current element at the rear of Qi
 * q.offer(arr.get(i)); // First element in the deque is the greatest of all, by
 * design. result.add(q.peekFirst()); }
 * 
 * return result; }
 * 
 * }
 * 
 * We provided one sample solution which has even better time complexity, O(n).
 * It uses data structure called deque which can be implemented as a doubly
 * linked list (or you can use your favorite language's standard library
 * implementation). ***********************Elements can be added or removed from
 * either end of a deque*********************** in constant time,
 * optimal_solution takes advantage of that property
 * 
 * 
 * 
 * Function must return an array of integers of length n - w + 1.
 */