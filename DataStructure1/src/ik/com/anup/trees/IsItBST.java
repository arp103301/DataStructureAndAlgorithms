package ik.com.anup.trees;

//root val and low ,left node   and similar on rightside call

/*Given a binary tree, check if it is a binary search tree (BST). A valid BST does not have to be complete or balanced.

Consider this definition of a BST:

All nodes values of left subtree are less than or equal to parent node value.
All nodes values of right subtree are greater than or equal to parent node value.
Both left subtree and right subtree must be BSTs.
NULL tree is a BST.
Single node trees (including leaf nodes of any tree) are BSTs.
Example One
Example one

Output:

0
Left child value 200 is greater than the parent node value 100; violates the definition of BST.

Example Two
Example two

Output:

1
Notes
Return true if the input tree is a BST or false otherwise.
Constraints:

0 <= number of nodes <= 100000
-109 <= values stored in the nodes <= 109*/
public class IsItBST {
	   
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
    
    
    //1. root value and left node with low :: 2.rootwavlue with right node with high 
    static Boolean helper(BinaryTreeNode root,Integer low, Integer high){
        if(root==null){
            return true;
        }
        // current node value is not within valid range
        if((low!=null && low>root.value) || (high!=null && high<root.value)){
                 return false;
            }
        
        //boolean left = helper(root.left,low,root.value);
        //boolean right = helper(root.right,root.value,high);
     
        // true when both left and right subtrees are valid BST
        return helper(root.right,root.value,high) && helper(root.left,low,root.value);// root.val in bothside recuRRRRsion
    }
   
    
    static Boolean is_bst(BinaryTreeNode root) {
        return helper(root,null,null);
    }


}
