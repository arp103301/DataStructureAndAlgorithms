package ik.com.anup.sorting;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Given an initial list along with another list of numbers to be appended with
 *  the initial list and an integer k, return an array consisting of the k-th largest 
 *  element after adding each element from the first list to the second list.

Example
{
"k": 2,
"initial_stream": [4, 6],
"append_stream": [5, 2, 20]
}
Output:

[5, 5, 6]
*/
public class Kth_largest {
	 static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {
	        // Write your code here.
	          ArrayList<Integer> result = new ArrayList<>();

	          // Priority queue's internal implementation is the same as a binary heap.
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	        for(Integer ele: initial_stream) {
	            pq.offer(ele);
	         // Make sure that the heap size does not exceed K.
	            if (pq.size() > k) {
	                pq.poll();// Remove the element smaller than the K largest elements.
	            }
	        }

	        for(Integer ele: append_stream) {
	            pq.offer(ele);
	            // Make sure that the heap size does not exceed K.
	            if(pq.size() > k) {
	                pq.poll();// Remove the element smaller than the K largest elements.
	            }
	            // Adding current Kth largest element.
	            result.add(pq.peek());
	        }


	        return result;
	    }

}


/*
heap_solution.cpp
The idea is to keep track of only the k largest elements of the stream.
 Create a min-heap storing the k largest elements from initial_stream. 
 To create such a heap, we can sort the initial_stream and push k largest elements
  in the heap but this will require O(n * log(n)). Instead, we will directly push elements
   from initial_stream to min-heap to achieve a complexity of O(n * log(k)). While pushing
    the elements we will keep a check such that the size of min-heap does not exceed k which 
    can be achieved by popping the top element of the heap when its size becomes k + 1.

How to process a new element of the append_stream?

If the new element is smaller than the top element of the heap, ignore it.
else remove the topmost element of the heap and insert the new element in the heap. 
To remove or insert a new element, the time complexity is O(log(k)).
The top element of the heap is always the k-th largest element of the current stream.

Note: It is possible to get a solution using a max-heap also instead of a min-heap,
 but would require some extra handling i.e. maintaining a max-heap of 
 size number_of_elements_at_time - k + 1 to get the k-th largest element.
*/