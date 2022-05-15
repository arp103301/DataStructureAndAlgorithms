package ik.com.anup.trees;

//alsmost same as levle order instread of queue we use stack here

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*Given a binary tree, find its post-order traversal without using recursion.

Example
Example one

Output:

[400, 500, 200, 300, 100]
Notes
Constraints:

1 <= number of nodes <= 105
-109 <= value in a node <= 109*/
public class PostOrderTraversalWithoutRecursion {
	  
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
    
    static ArrayList<Integer> postorder_traversal(BinaryTreeNode root) {
        // Write your code here.
        
        ArrayList<Integer> results = new ArrayList();
        
        postOrderTraversalWithOutRecursion(root, results);
        
        return results;
    }


    static void postOrderTraversalWithOutRecursion(BinaryTreeNode root, ArrayList<Integer> results){
        
        Stack<BinaryTreeNode> stck = new Stack();
        
        stck.push(root);
        
        BinaryTreeNode node = null;
        
        while(!stck.isEmpty()) {
            
            node = stck.pop();
            
            results.add(node.value);
            
            if(node.left != null) stck.push(node.left);
            if(node.right != null) stck.push(node.right);
        }
		/*
		 * In the pre-order traversal, the node is processed before both of its child
		 * nodes. The general ordering is:
		 * 
		 * Current node -> Process the left subtree -> Process the right subtree.
		 * 
		 * In the pre-order traversal, a node has to be processed when it is encountered
		 * and the processing for its left and right child is done only after this.
		 * Therefore, we do not need to keep a track of whether the left or right child
		 * of the node has been processed or not.
		 * 
		 * So, if we somehow are able to convert the pre-order traversal of the tree
		 * into post-order, we are done!
		 * 
		 * Consider the following modified pre-order traversal:
		 * 
		 * Current node -> Process the right subtree -> Process the left subtree.>>>>>>>>>>>>>>>>>>>>>>>>>preorder
		 * 
		 * If we reverse such a traversal, we get:
		 * 
		 * Process the left subtree -> Process the right subtree -> Current node.>>>>>>>>>>>>>reverse preorder= postorder*************
		 * 
		 * This is the post-order traversal and that is what we want!
		 * 
		 * Therefore, if we find such a modified pre-order traversal of the tree,
		 * reversing it will give us the post-order traversal of that tree.
		 */
        Collections.reverse(results);// see above for reVERSE reason 
    }
}
