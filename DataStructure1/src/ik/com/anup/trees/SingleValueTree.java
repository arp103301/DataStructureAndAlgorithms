package ik.com.anup.trees;

/*Given a binary tree, find the number of unival subtrees. An unival (single value) tree is a tree that has the same value in every node.

Example One
Example one

Output:

6
The input tree has a total of 6 nodes. Each node is a root of a subtree. All those 6 subtrees are unival trees.

Example Two
Example two

Output:

5
The input tree has a total of 7 nodes, so there are 7 subtrees. Of those 7, all but two subtrees are unival. The two non-unival subtrees are:

The one rooted in the root node and
The one rooted in the root's right child.
Notes
Constraints:

0 <= number of nodes in the tree <= 105
-109 <= node value <= 109*/
public class SingleValueTree {
    
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
    
	/*
	* Asymptotic complexity in terms of number of nodes in the given tree `n`:
	* Time: O(n).
	* Auxiliary space: O(n).
	* Total space: O(n).
	*/
    
    static int count = 0;
    
    
    static Integer find_single_value_trees(BinaryTreeNode root){
	    int count = 0;
	    helper(root);
	    return count;
	}
    
    static boolean helper(BinaryTreeNode root){

        if(root.left == null && root.right == null ){
            count++;
            return true;
        }

        boolean uniVal = true;// single node has to be univalue 
        int nodeVal = root.value;
       
        if(root.left != null){

            boolean left = helper(root.left);

            uniVal =  left && (root.left.value == nodeVal);
        }
        if(root.right != null){

            boolean right = helper(root.right);

            uniVal =  right && uniVal && (root.right.value == nodeVal) ;

        }

        if(uniVal) count++;
        return uniVal;

    }
	
}
