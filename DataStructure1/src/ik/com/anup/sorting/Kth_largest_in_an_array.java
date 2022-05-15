package ik.com.anup.sorting;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Given an array of integers, find the k-th largest number in it.

Example One
{
"numbers": [5, 1, 10, 3, 2],
"k": 2
}
Output:

5

*
*
*/
public class Kth_largest_in_an_array {
	 
	static Integer kth_largest_in_an_array(ArrayList<Integer> numbers, Integer k) {
	      PriorityQueue<Integer> pq = new PriorityQueue<>();
	        
	        for(Integer num : numbers){
	            pq.offer(num);///>>> can use offer as well
	            if(pq.size() > k){// if element is greater than k value then remove(poll) it 
	                pq.poll();// 
	            }
	         }
	        
	        return pq.poll();// peek also works here as we dont need to remove(=poll) we can just get(=peek)
	    }




// alternate solution 
static Integer kth_largest_in_an_array1(ArrayList<Integer> numbers, Integer k) {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
 for(int i : numbers){
     pq.add(i);
     while(!pq.isEmpty() && pq.size() > k){
         pq.remove();
     }
 }
 return pq.peek();
}


}


/*
 * priority_queue_solution.java Another way to look at this is that if we have
 * the k largest elements of the array, we need the smallest of those k
 * elements. We will initially store the first k elements and while iterating
 * further from left to right, we will keep storing the k largest elements that
 * we have encountered so far. While encountering a new number, we will compare
 * it with the smallest of our stored numbers, let us call it x. If x is larger
 * than the new number, then we can safely discard the new number. Otherwise, we
 * will remove x from our storage and add the new number there.
 * 
 * Since we keep comparing the newly encountered numbers with the smallest
 * number of our storage, we will need a container that could get us the minimum
 * element as fast as possible. We will use a min-heap for that purpose.
 * 
 * While iterating, the following conditions may arise:
 * 
 * The current array element is greater than the top of the min-heap: We will
 * pop-out the top element from the min-heap and push the current array element.
 * The current array element is smaller than or equal to the top of the
 * min-heap: We will ignore the new element and move ahead. After this, the
 * min-heap will have only the k largest elements of the array. The top of it
 * will be the minimum of those k elements.
 * 
 * We can use a similar approach to solve this problem using a max-heap as well.
 * We basically need the maximum of the n - k + 1 smallest elements present in
 * the array. The smallest n - k + 1 elements can be computed in the same way as
 * above using a max-heap.
 * 
 * We can choose between the min-heap and max-heap based on the value of k. For
 * smaller values of k, extracting the largest k elements using a min-heap will
 * be more optimal whereas for larger values of k, extracting the smallest n - k
 * + 1 elements using a max-heap will be better.
 * 
 * Time Complexity O(k + (numbers_count - k) * log(k)).
 * 
 * Building a heap of first k elements will take O(k) time. Next, while
 * iterating through the rest numbers_count - k elements, we will do at most
 * numbers_count - k push and pop operations on the heap of size k. This takes
 * another O((numbers_count - k) * log(k)) time.
 * 
 * Auxiliary Space Used O(k).
 * 
 * We need this amount of space to maintain a heap of size k.
 * 
 * Space Complexity O(numbers_count).
 * 
 * Space used for input: O(numbers_count). Auxiliary space used: O(k). Space
 * used for output: O(1). So, total space complexity: O(numbers_count).
 */