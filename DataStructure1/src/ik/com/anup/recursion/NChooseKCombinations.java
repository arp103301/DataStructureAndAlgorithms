package ik.com.anup.recursion;

import java.util.ArrayList;

/*Given two integers n and k, find all the possible unique combinations of k numbers in range 1 to n.

Example One
{
"n": 5,
"k": 2
}
Output:

[
[1, 2],
[1, 3],
[1, 4],
[1, 5],
[2, 3],
[2, 4],
[2, 5],
[3, 4],
[3, 5],
[4, 5]
]
Example Two
{
"n": 6,
"k": 6
}
Output:

[
[1, 2, 3, 4, 5, 6]
]
Notes
The answer can be returned in any order.

Constraints:

1 <= n <= 20
1 <= k <= n*/
public class NChooseKCombinations {
    static ArrayList<ArrayList<Integer>> find_combinations(Integer n, Integer k) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        helper(n, k,1,  new ArrayList(),result);
        return result;
    }
    
    static void helper( Integer n, Integer k,int indx,ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result) {
        if(slate.size() == k) {/// difference between generate permuation of string
            result.add(new ArrayList(slate));
            return;
        } 
        if(indx > n) {
            return;
        } 
          
        //  Two choices
        //1. do not include the character
        	helper(n, k, indx + 1, slate, result);
        	//2. include the character  and call the recursive method
            slate.add(indx);
            helper(n, k, indx + 1, slate, result);
          //2.b.need to remove that added number for next stage for not-including case:::-)
            slate.remove(slate.size() - 1);
        
    }
}
//
/*
 * Time Complexity O(nCk * k).
 * 
 * The total number of combinations = nCk. To push nCk combination each of size
 * k, we will require O(nCk * k) time in total.
 */