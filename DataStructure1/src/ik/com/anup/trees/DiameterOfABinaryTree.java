package ik.com.anup.trees;

/*Given a binary tree, find its diameter.

Example One
Example one

Output:

3
Example Two
Example two

Output:

4
Notes
Diameter of a binary tree is the length of the longest path between any two nodes of the tree.
Length between any two nodes is equal to the number of edges traversed to reach one node from the other.
Constraints:

1 <= number of nodes in the given tree <= 105
0 <= node value < number of nodes
Node values are unique*/
public class DiameterOfABinaryTree {

	
	  
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
    
    static  int result = 0;// if helper method is not static no need to make it static jus regular gloabal will do ::::::::::::::::::for leetcode success 
    static Integer binary_tree_diameter(BinaryTreeNode root) {
        // Write your code here.
    	 if (root == null) {
    	        return 0;
    	    }

    	   // int result = 0;
    	    helper(root); 

    	    return result;
    }

	//private static int helper(BinaryTreeNode currentNode, int result) {
		private static int helper(BinaryTreeNode currentNode) {
		// TODO Auto-generated method stub
		if (currentNode == null) {
	        return 0;
	    }
		
	    int left_subtree_height = helper(currentNode.left);
	    int right_subtree_height = helper(currentNode.right);

	    result = Integer.max(result, left_subtree_height + right_subtree_height);

	    return 1 + Integer.max(left_subtree_height, right_subtree_height);// add 1 to calculated result::::::(plus one for the edge between the current node and its child node).
		
	}
}
/// add 1 to calculated result::::::(plus one for the edge between the current node and its child node).


//eetcode prefers static int rather than passing  result in helper method ::::::::::::::::::::::::::
