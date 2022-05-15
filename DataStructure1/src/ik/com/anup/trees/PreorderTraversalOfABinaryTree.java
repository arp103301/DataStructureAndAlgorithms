package ik.com.anup.trees;

import java.util.ArrayList;

/*Given a binary tree, return node values in the preorder traversal order.

Example One
Example one

Output:

[0, 1, 3, 4, 2]
Example Two
Example two

Output:

[0, 1, 2, 3]
Notes
The preorder traversal processes all the nodes of a binary tree by first visiting the root, then recursively visiting its left and right subtrees respectively.

Constraints:

1 <= number of nodes in the given tree <= 20000
0 <= node value < number of nodes
Node values are unique*/
public class PreorderTraversalOfABinaryTree {
	
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
    
	  static ArrayList<Integer> preorder(BinaryTreeNode root) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        
	        if(root == null) 
	        	return new ArrayList<Integer>(root.value);
	        
	        helper(root, result);
	        return result;
	    }
	  
	  private static void helper(BinaryTreeNode root,ArrayList<Integer> result) {
		  
		  if(root == null) return;

		  result.add(root.value);
		  
		  helper(root.left, result);
		  helper(root.right, result);
	  }
}
