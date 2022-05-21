package ik.com.anup.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import ik.com.anup.trees.LevelOrderTraversalOfABinaryTree.BinaryTreeNode;

/*Given a binary tree, imagine yourself standing on the right side of it and return a list of the node values that you can see from the top to the bottom.

Example One
Example one input

Output:

[0, 2, 4]
From the right side, the tree will look like below:

Example one output

Example Two
Example two input

Output:

[0, 1, 2, 3]
Notes
Constraints:

1 <= number of nodes in the tree <= 20000
0 <= node value < number of nodes in the tree
Node values are unique*/
public class RightSideViewOfABinaryTree {

    
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
    
    static ArrayList<Integer> right_view(BinaryTreeNode root) {
        // Write your code here.

		if (root == null)
			return new ArrayList<Integer>();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		
		int rightNodeVal = 0;
		while (!queue.isEmpty()) {
			
			//result.add(new ArrayList<Integer>());
			
			
			int numOfNodes = queue.size();
			for (int i = 0; i < numOfNodes; i++) {
				
				BinaryTreeNode currentNode = queue.peek();
				 
				//pushing left and then right nodes will help us in getting right one first when popping off.
				rightNodeVal = currentNode.value;//
			
				
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
				
				queue.poll();
			}
			result.add(rightNodeVal);// only add rightNode in the result..
		}

		return result;
	
}
}//class