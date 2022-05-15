package ik.com.anup.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import ik.com.anup.trees.LevelOrderTraversalOfABinaryTree.BinaryTreeNode;

/*Given a tree, list node values level by level from left to right.

Example One
Example one

Output:

[
[1],
[3, 4, 2],
[5, 6]
]
Example Two
Example two

Output:

[
[1],
[2],
[4],
[3]
]
Notes
Constraints:

1 <= number of nodes <= 20000
1 <= value in a node <= number of nodes
Node values are unique
Root node's value is 1
*/public class LevelOrderTraversalOfATree {
	 //For your reference:
    class TreeNode {
        Integer value;
        ArrayList<TreeNode> children;

        TreeNode(Integer value) {
            this.value = value;
            this.children = new ArrayList(3);
        }
    }
    
    static ArrayList<ArrayList<Integer>> level_order_traversal(TreeNode root) {
		if (root == null)
			return new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;///**

		while (!queue.isEmpty()) {
			
			result.add(new ArrayList<Integer>());
			
			
			int numOfNodes = queue.size();
			for (int i = 0; i < numOfNodes; i++) {
				
				TreeNode current = queue.poll();
				
				result.get(level).add(current.value);//**
				
			/*	if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}*/
				
				// Same code as binary except left/right changed to each children NODE
				 if (current.children != null) {
	                    for (int j = 0; j < current.children.size(); j++) {
	                        queue.add(current.children.get(j));
	                    }
	                }
				
				
				
			}
			level++;///**
		}

		return result;
	}
}


