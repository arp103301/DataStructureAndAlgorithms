package ik.com.anup.sorting;
/*Given an array sorted in non-decreasing order and a target number, 
find the indices of the two values from the array that sum up to the given target number.
{
"numbers": [1, 2, 3, 5, 10],
"target": 7
}
Output:

[1, 3]
Sum of the elements at index 1 and 3 is 7.

Notes
In case when no answer exists, return an array of size two with both values equal to -1, i.e., [-1, -1].
In case when multiple answers exist, you may return any of them.
The order of the indices returned does not matter.
A single index cannot be used twice.
Constraints:

2 <= Array Size <= 105.
-105 <= Array Elements <= 105.
-105 <= Target Number <= 105.
Array can contain duplicate elements.
*/

import java.util.ArrayList;



public class IndicesForSumOfTwoSortedArrays {
	 static ArrayList<Integer> pair_sum_sorted_array(ArrayList<Integer> numbers, Integer target) {
	        // Write your code here.
	        ArrayList<Integer> result = new ArrayList<>();
	        int i = 0;
	        int j = numbers.size()-1;
	        while (i<j){
	            int sum = numbers.get(i) + numbers.get(j);
	            if (sum==target)
	            {
	                result.add(i);
	                result.add(j);
	                return result;
	            }
	            else if(sum<target){ // sum is less than target then move pointer to higher value(=index as it is sorted array)
	              
	                i++;
	            }
	            else{
	               
	                j--;// sum is grrater than target hence trying to avoid the largets from the pair
	            }
	            
	        }
	        //if after the loop  target is not found then return [-1,-1] 
	        result.add(-1);
	        result.add(-1);
	        return result;
	    
}	
}

// since it is sorted we can use two pointers from the two end to scan