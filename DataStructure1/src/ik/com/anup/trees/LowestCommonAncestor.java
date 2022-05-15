package ik.com.anup.trees;

// if node has both leftchild and rightchild then this is LCA. otherwise whichever exists than that is LCA


/*Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

The LCA of nodes a and b in a tree is defined as the shared ancestor node of a and b that is located farthest from the root of the tree.

Example
Example one

a = 8, b = 9

Output:

5
There are three shared parents of 8 and 9 in this tree: 5, 2, 1. Of those three, the farthest from the root is 5.

Other examples:
LCA(2, 5) = 2
LCA(2, 3) = 1

Notes
A node is considered its own ancestor and its own descendant.
Return the value of the LCA node of the two given nodes.
Constraints:

1 <= number of nodes <= 100000
1 <= node value <= number of nodes
Node values are unique*/
public class LowestCommonAncestor {
    
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
   
    static Integer lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        BinaryTreeNode node = helper(root, a, b);
        return node.value;
    }
    
    static BinaryTreeNode helper(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        if (root == null) return null;
        
    	// it can be a or b or neither
        if (root.value == a.value || root.value == b.value) return root;
        
        
    	// head is not null AND head is not a or b
        BinaryTreeNode leftNode = helper(root.left, a, b);
        BinaryTreeNode rightNode = helper(root.right, a, b);
        
        if (leftNode != null && rightNode != null) return root;
        
        if (leftNode != null) return leftNode;
        
        if (rightNode != null) return rightNode;
        
        return null;
    }

}
