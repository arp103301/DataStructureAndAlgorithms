package ik.com.anup.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Given a list of numbers, the task is to insert these numbers into a stream and 
 * find the median of the stream after each insertion. If the median is a non-integer, consider it’s floor value.

The median of a sorted array is defined as the middle element when the number of 
elements is odd and the mean of the middle two elements when the number of elements is even.

Example
{
"stream": [3, 8, 5, 2]
}
Output:

[3, 5, 5, 4]*/


public class Online_median {
	
	static ArrayList<Integer> online_median(ArrayList<Integer> stream) {
        if (stream == null || stream.size() <= 1) return stream;
        ArrayList<Integer> result = new ArrayList<>(stream.size());

        //1. MIn Heap and MaxHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();// // To store the larger half of the input numbers.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());// // To store the smaller half of the input numbers.
        
        
        //2. balance the heap while adding num
        
        // Balancing heaps to make sure
        // - smaller half of input numbers are always in the max heap
        // - larger half of input numbers are always in the min heap
        for (int num : stream) {
            if (maxHeap.isEmpty()) {
                maxHeap.offer(num);
            } else if (maxHeap.peek() >= num) {
                 maxHeap.offer(num);
                if (maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
               
            } else {
                minHeap.offer(num);
                if (minHeap.size() > maxHeap.size() + 1) maxHeap.offer(minHeap.poll());
            }
            
            
            //3. calculate the median
            if (minHeap.size() > maxHeap.size())
                result.add(minHeap.peek());//add the larger size one
            
            else if (maxHeap.size() > minHeap.size())
                result.add(maxHeap.peek());//add the larger size one
            
            else   // If number of elements in the stream is even.
                result.add((minHeap.peek() + maxHeap.peek())/2);
        }        
        
        return result;
    }

}
