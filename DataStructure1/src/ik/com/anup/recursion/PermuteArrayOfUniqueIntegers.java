package ik.com.anup.recursion;


//LC 46

//https://www.tutorialcup.com/leetcode-solutions/leetcode-permutations.htm   for figure on swapping
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



/*Given an array of unique numbers, return in any order all its permutations.

Example
{
"arr": [1, 2, 3]
}
Output:

[
[1, 2, 3],
[1, 3, 2],
[2, 1, 3],
[2, 3, 1],
[3, 2, 1],
[3, 1, 2]
]
Notes
Constraints:

1 <= size of the input array <= 9
*/
public class PermuteArrayOfUniqueIntegers {
    /*
     * Complete the function below.
     */
	 /*
    Asymptotic complexity in terms of `n` =  size of the input array:
    * Time: O(n * n!).
    * Auxiliary space: O(n).
    * Total space: O(n * n!).
    */

 	static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		helper(arr, result, 0, arr);
		return result;
	}

	private static void helper(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> result, int idx,
			ArrayList<Integer> slate) {
		if (idx == input.size()) {
			result.add(new ArrayList<Integer>(slate));
			
			 // Print this permutation
            for (int i = 0; i < input.size(); i++) {
                System.out.print(input.get(i) + " ");
            }
            System.out.println();
            
            
			return;
		}

		for (int i = idx; i < input.size(); i++) {
			// Fix an element at index l
			swap(input, idx, i);
			 // Recur for index l + 1 to r
			helper(input, result, idx + 1, slate);
		    // Back track
			swap(input, i, idx);
		}
	   
		
	
	}


    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
	public static void main(String[] args) {
        // Example
        Integer arr[] = {1, 2, 3};
        ArrayList<Integer> numlist = new ArrayList<Integer>(Arrays.asList(arr));
        int n = arr.length;
        // Generate permutations from index 0 to n - 1
        get_permutations(numlist);
    }
}
