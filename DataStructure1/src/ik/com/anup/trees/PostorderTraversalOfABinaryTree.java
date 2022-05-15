package ik.com.anup.trees;

import java.util.ArrayList;

import ik.com.anup.trees.InorderTraversalOfABinaryTree.BinaryTreeNode;

/*Given a binary tree, find its postorder traversal.

Example One
Example one

Output:

[3, 4, 1, 2, 0]
Example Two
Example two

Output:

[3, 2, 1, 0]
Notes
The postorder traversal visits all the nodes of a binary tree by recursively visiting the left subtree, then the right subtree and finally visiting the root.

Constraints:

1 <= number of nodes in the tree <= 20000
0 <= node value < number of nodes
No two nodes have the same value*/
public class PostorderTraversalOfABinaryTree {
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
		  helper(root.right, result);
		  result.add(root.value);
	  }
}
