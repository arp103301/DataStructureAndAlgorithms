package ik.com.anup.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree, list the node values level by level from left to right.

Example One
Example one

Output:

[
[0],
[1],
[2],
[4],
[3]
]
Example Two
Example two

Output:

[
[2],
[5, 4],
[0, 1, 3, 6]
]
Notes
Constraints:

1 <= number of nodes in the given tree <= 20000
0 <= node value < number of nodes
Node values are unique*/
public class LevelOrderTraversalOfABinaryTree {
	
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
    
    static ArrayList<ArrayList<Integer>> level_order_traversal(BinaryTreeNode root) {
		if (root == null)
			return new ArrayList<ArrayList<Integer>>();
		
		//for leetcode above dont work so 
	    if(root == null) return new ArrayList<>();
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();//???Queue() will be abstract...
		queue.offer(root);
		int level = 0;///**

		while (!queue.isEmpty()) {
			
			result.add(new ArrayList<Integer>());
			
			  // The queue currently has all the nodes of a single level.
			int numOfNodes = queue.size();
			
			 // Processing the nodes from the current level.
			for (int i = 0; i < numOfNodes; i++) {
				
				//he peek() method of Queue Interface returns the element at the front the container.
				BinaryTreeNode current = queue.peek();
				
				//fill the current level 
				//result.get(level).add(current.value);//**
				
				if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}
				
					//now remove the node from the queue
					queue.poll();
				
				//fill the current level 
				result.get(level).add(current.value);//**
			}
			level++;///**outside of for loop since for loop is forcurrent level
		}

		return result;
	}
}
/*
* Asymptotic complexity in terms of total number of nodes in the given tree `n`:
* Time: O(n).
* Auxiliary space: O(n).
* Total space: O(n).
*/


//////////////////////peek it and put the child of current node in the queue before popping off the current node.