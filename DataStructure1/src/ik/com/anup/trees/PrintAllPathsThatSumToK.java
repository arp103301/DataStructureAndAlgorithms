package ik.com.anup.trees;

import java.util.ArrayList;
import java.util.Arrays;

/*Given a binary tree and an integer k, find all the root to leaf paths that sum to k.

Example One
Example one

k = 80

Output:

[
[10, 25, 45]
[10, 30, 40]
]
Example Two
Example two

k = 10

Output:

[
[5, 5],
[5, 5]
]
Notes
In case there is no root to leaf path with a sum equal to k, return [[-1]].
The order of the paths (order of the lists in the outer list) does not matter.
Constraints:

1 <= number of nodes <= 104
-105 <= value in a node <= 105
-109 <= k <= 109*/
public class PrintAllPathsThatSumToK {
    
    //For your reference:
    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    static ArrayList<ArrayList<Integer>> all_paths_sum_k(BinaryTreeNode root, Integer k) {
        // Write your code here.
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	if(root == null){
    	    ArrayList<Integer> emptyList = new ArrayList<>(Arrays.asList(-1));
    	    result.add(emptyList);
    	    return result;
    	}
    	
    	helper(root,new ArrayList(), result, k);
    	
    	if(result.isEmpty()){
    	    ArrayList<Integer> emptyList = new ArrayList<>(Arrays.asList(-1));
    	    result.add(emptyList);
    	    return result;
    	}
    	
        return result;
    }


	private static void helper(BinaryTreeNode node, ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result, int target) {
		
		slate.add(node.value);	
			
		// traverse to leaf 
		if(node.left ==null && node.right ==null){
	            
	            if(target == node.value){// now target is reduced to null after final recursion 
	                result.add(new ArrayList<>(slate));
	            }
	            slate.remove(slate.size()-1);/// this is needed so that we can find another path from  root to leaf.
	            return;
	        }
	        
	        if(node.left!=null){
	        	helper(node.left, slate, result, target-node.value);
	        }
	        
	        if(node.right!=null){
	        	helper(node.right, slate, result, target-node.value);
	        }
	        //if by now the target is not found we need to remove th
	        slate.remove(slate.size()-1);
	}

}
