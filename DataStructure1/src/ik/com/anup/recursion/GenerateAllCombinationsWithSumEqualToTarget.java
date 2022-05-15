package ik.com.anup.recursion;

import java.util.ArrayList;
import java.util.Collections;

/*Given an integer array, generate all the unique combinations of the array numbers that sum up to a given target value.

Example One
{
"arr": [1, 2, 3],
"target": 3
}
Output:

[
[3],
[1, 2]
]
Example Two
{
"arr": [1, 1, 1, 1],
"target": 2
}
Output:

[
[1, 1]
]
Notes
Each number in the array can be used exactly once.
All the returned combinations must be different. Two combinations are considered different if their sorted version is different.
The order of combinations and the order of the numbers inside a combination does not matter.
Constraints:

1 <= size of the input array <= 25
1 <= value in the array <= 100
1 <= target value <= 2500*/
public class GenerateAllCombinationsWithSumEqualToTarget {
	/*
	 * static ArrayList<ArrayList<Integer>>
	 * generate_all_combinations(ArrayList<Integer> arr, Integer target) {
	 * ArrayList<ArrayList<Integer>> results = new ArrayList<>();
	 * 
	 * Collections.sort(arr); helper(arr, target, results, new ArrayList<Integer>(),
	 * 0, 0); // Write your code here. return results; }
	 * 
	 * 
	 * private static void helper(ArrayList<Integer> input, int target,
	 * ArrayList<ArrayList<Integer>> results, ArrayList<Integer> slate, int index,
	 * int currVal) {
	 * 
	 * if (currVal == target) { results.add(new ArrayList<>(slate)); return; }
	 * 
	 * if (index >= input.size()) { return; }
	 * 
	 * Integer prevValue = null; for (int i = index; i < input.size(); i++) {
	 * Integer nextValue = input.get(i);
	 * 
	 * if (prevValue == null || !prevValue.equals(nextValue)) { prevValue =
	 * nextValue;
	 * 
	 * slate.add(nextValue);
	 * 
	 * helper(input, target, results, slate, i + 1, currVal + nextValue);
	 * 
	 * slate.remove(slate.size() - 1); } }
	 * 
	 * return; }
	 */
	   public static ArrayList<ArrayList<Integer>> generate_all_combinations(ArrayList<Integer> arr, int target) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	        ArrayList<Integer> slate = new ArrayList<>();
	        Collections.sort(arr);
	        combinationHelper(arr, slate, 0, target, result);
	        return result;
	    }

	    public static void combinationHelper(ArrayList<Integer> input, ArrayList<Integer> slate, int idx, int target, ArrayList<ArrayList<Integer>> result)
	    {
	       if(target<0)
	        {
	            return;
	        }
	        if(target==0)
	        {
	            result.add(new ArrayList(slate));
	            return;
	        }
	         if(idx >= input.size())
	        {
	            return;
	        }

	        for(int i = idx;i<input.size();i++)/// need to combination 
	        {
	            int currValue = input.get(i);
	            
	            //1.  // Check if it is repeated or not
	            if(i>idx && currValue==input.get(i-1))
	               continue;
	            
	            // Take the element into the combination
	            
	           slate.add(currValue);
	        // Recursive call with index+1
	           combinationHelper(input, slate, i+1, target-currValue, result);
	           
	           // Remove element from the combination
	           slate.remove(slate.size()-1);
	        }
	    }

}
