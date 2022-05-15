package ik.com.anup.trees;

// this is different than print all sum to K as this only is only returing boolean for only 1 path 



/*Given a binary tree and an integer k, check whether the tree has a root to leaf path with a sum of values equal to k.

Example One
Example one

k = 4

Output:

1
Path 0 -> 1 -> 3 has the sum of node values equal to 4.

Example Two
Example two

k = 10

Output:

0
Notes
Constraints:

1 <= number of nodes in the tree <= 105
-105 <= node value <= 105
-109 <= k <= 109*/
public class RootToLeafPathSumEqualToK {
	  
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
    
    static Boolean path_sum(BinaryTreeNode root, Integer k) {
        // Write your code here.
    	 if(root == null){
             return false;
         }
         
         boolean result = helper(root, k);
         return result;
    }
    static boolean helper(BinaryTreeNode node, int target){
        if(node == null){
            return false;
        }
        
        //at the leaf level the sum-node.value is 0 
        if(node.left == null && node.right == null && target-node.value == 0){
            return true;
        }
        
        if(node.left != null){
            if(helper(node.left, target-node.value)){
                return true;
            }
        }
        
        if(node.right != null){
           if (helper(node.right, target-node.value)){
               return true;
           }
        }
        
        return false;
        
    }
}
/*
Time comlexity : O(N) since we visit each node once
Space : O(Height) O(N) in worst case and O(logN) in avg case
*/