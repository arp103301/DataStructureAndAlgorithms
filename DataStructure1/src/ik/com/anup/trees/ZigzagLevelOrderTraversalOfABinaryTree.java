package ik.com.anup.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

/*Given a binary tree, return the zigzag level order traversal of the node values listing the odd levels from left to right and the even levels from right to left.

Example One
Example one

Output:

[
[0],
[2, 1],
[3, 4]
]
Example Two
Example two

Output:

[
[0],
[1],
[2],
[3]
]
Notes
Root node is considered to be at the level 1.

Constraints:

1 <= number of nodes in the given tree <= 20000
0 <= node value < number of nodes
Node values are unique*/
public class ZigzagLevelOrderTraversalOfABinaryTree {
	
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
    
    static ArrayList<ArrayList<Integer>> zigzag_level_order_traversal(BinaryTreeNode root) {
        if(root==null){
            return null;
        }
        
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
       
        Queue<BinaryTreeNode> queue=new ArrayDeque<>();
       
        queue.offer(root);
       
        boolean isflip=false;// first try needs to be left to right so false
        
        while(!queue.isEmpty()){
           
        	int numOfNodes=queue.size();
            ArrayList<Integer> levelValues=new ArrayList<>();
           
            for(int i=0;i<numOfNodes;i++){
               
            	BinaryTreeNode currentNode=queue.poll();
                
                levelValues.add(currentNode.value);// fill the current level
                
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            if(isflip){
                Collections.reverse(levelValues);
            }
            
            result.add(levelValues);
            isflip=!isflip;//reverse it once the values are added to the result/////////////after every level we flip it 
        }
        return result;
    }
}

// instead of int level we do the boolean flip in regular level order traversal