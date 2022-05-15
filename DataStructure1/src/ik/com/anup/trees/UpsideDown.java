package ik.com.anup.trees;







//root.left is now new root so modify its children
//(root.left).left = rooot.right>> >> old rightchild moved to left
//(root.left).right= root>> old root is now ar rhs









/*Given a binary tree where every node has either 0 or 2 children and every right node is a leaf node, flip it upside down turning it into a binary tree where all left nodes are leafs.

Example One
Example one input

Output:

Example one output

Example Two
Example two input

Output:

Example two output

The same output tree oriented differently:

Example two alternative output

Notes
Return the root of the output tree.
Constraints:

0 <= number of nodes <= 100000
1 <= node value <= 100000*/




//original root becomes right child
// original left child becomes root
//original right child becomes left child 
//turn all nodes clockwise for visualization>>>>>https://www.youtube.com/watch?v=JjaJQi77984





//Below is the main rotation code of a subtree 

//root->left->left = root->right;
//root->left->right = root;
//root->left = NULL;
//root->right = NULL; 

public class UpsideDown {
    
    /////////////////////////////////////////////////////////////////////////////For your reference:
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
    
    static BinaryTreeNode flip_upside_down(BinaryTreeNode root) {
        // Write your code here.
        if (root == null)
            return root;
        if (root.left == null && root.right ==null)
            return root;
 
        //  recursively call the same method
        BinaryTreeNode flippedRoot=flip_upside_down(root.left);//call dfs on leftchild
 
        //  rearranging main root Node after returning
        // from recursive call
        root.left.left=root.right;// this is the main rotation>>> old rightchild becomes new leftchild
        root.left.right=root;
        root.left=null;
        root.right=null;
        return flippedRoot;
    }
}

