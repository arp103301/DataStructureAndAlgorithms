package ik.com.anup.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*Given an array of numbers with possible duplicates, return all of its permutations in any order.

Example
{
"arr": [1, 2, 2]
}
Output:

[
[1, 2, 2],
[2, 1, 2],
[2, 2, 1]
]
Notes
Constraints:

1 <= size of the input array <= 9
0 <= any array element <= 9*/
public class PermuteArrayOfIntegersDuplicatesAllowed {

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     // Sort the array so that we can avoid duplicate combinations
        Collections.sort(arr);
        
        permduplhelper(arr, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    public static void permduplhelper(ArrayList<Integer> arr, int startInd, 
    			ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result) {
        
        if (startInd == arr.size()) {
            result.add(new ArrayList<Integer>(arr));
            return;
            
        } else {
            for (int i = startInd; i < arr.size(); i++) {
                
            	

                Set<Integer> placed = new HashSet<>();

                // We are going to generate all such unique permutations where
                // arr[fixed_index] holds the value of arr[i] where i is any index
                // that lies in range [fixed_index, n - 1].
                
                if (!placed.contains(arr.get(i))) {// extra than unique permu
                	
                	placed.add(arr.get(i)); // extra than unique permu
                	
                	
                    swap(arr, startInd, i);
                    
                    permduplhelper(arr, startInd + 1, slate, result);
                    
                    swap(arr, startInd, i);
                }
                
                
            
                 
           
            }
        }
    }
    
    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
/*
Asymptotic complexity in terms of `n` = size of the input array:
* Time: O(n * n!).
* Auxiliary space: O(n^2).
* Total space: O(n * n!).
*/
