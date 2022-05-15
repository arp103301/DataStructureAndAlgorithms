package ik.com.anup.trees;

import java.util.ArrayList;

/*Given a binary tree, return the inorder traversal of its node values.

Example One
Example one

Output:

[3, 1, 4, 0, 2]
Example Two
Example two

Output:

[1, 3, 2, 0]
Notes
The inorder traversal of a binary tree first visits the left subtree, then the root and finally the right subtree.

Constraints:

1 <= number of nodes in the given tree <= 20000
0 <= node value < number of nodes
Node values are unique*/
public class InorderTraversalOfABinaryTree {
    
   // For your reference:
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
    
    static ArrayList<Integer> inorder(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<Integer>();
	        
	        if(root == null) 
	        	return new ArrayList<Integer>(root.value);
	        
	        helper(root, result);
	        return result;
	    }
	  
	  private static void helper(BinaryTreeNode root,ArrayList<Integer> result) {
		  
		  if(root == null) return;
		  helper(root.left, result);
		   result.add(root.value);
		  helper(root.right, result);
	  }
}
