package ik.com.anup.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import ik.com.anup.trees.LevelOrderTraversalOfABinaryTree.BinaryTreeNode;

/*Given a binary tree, return the bottom-up level order traversal of the node values listing each level from left to right.

Example One
Example one

Output:

[
[3, 4],
[1, 2],
[0]
]
Example Two
Example two

Output:

[
[3],
[2],
[1],
[0]
]
Notes
Constraints:

1 <= number of nodes in the given tree <= 20000
0 <= node value < number of nodes
Node values are unique*/
public class ReverseLevelOrderTraversalOfABinaryTree {
	  
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
   
    // each level will have its list of elements
    static ArrayList<ArrayList<Integer>> reverse_level_order_traversal(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
          
          result.add(new ArrayList<Integer>());// add levellist inside resultlist

        
          int numOfNodes = queue.size();
          for(int i = 0; i < numOfNodes; ++i) {
            
        	  BinaryTreeNode currentNode = queue.remove();

            // fill current level
            result.get(level).add(currentNode.value);

            
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
          }
          // increment the level
          level++;
        }
        Collections.reverse(result);// main difference between the origianl travsrse and this reverse order.
        return result;
        }
	}


