package ik.com.anup.trees;

import java.util.ArrayList;
import java.util.List;

/*Given the root node of a binary tree, convert it into a circular doubly linked list in-place. The left and the right pointers in nodes are to be used as previous and next pointers, respectively, in the structure that you return.

Returned list should follow the in-order traversal order of the given tree.

The "root" node that you return should be the first node in the in-order traversal order. That "root" node should be connected with the last node in the in-order traversal as if "root" node goes after the last node and last node goes before the "root" node.

Example
Example input

Output:

Example output

Notes
Constraints:

1 <= number of nodes <= 105
-109 <= node value <= 109
Description of the text format of the test cases

You might need this for debugging your solution on IK UpLevel platform.

Input file contains the given tree in the usual binary tree format.

Output file lists node values of the returned data structure:

starting from the returned node,
following right pointers until we reach the last node in the list,
then following left pointers until we come back to the root node.
Example output

Example output

is represented by

[1, 2, 3, 4, 5, 4, 3, 2, 1]
If the returned data structure is not circular or otherwise incorrect, the output may contain the correct portion of it, and you will find an error message in the ERROR field.*/
public class ConvertABinaryTreeIntoACircularDoublyLinkedList {

    
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
	* Asymptotic complexity in terms of number of nodes `n` in the given graph:
	* Time: O(n).
	* Auxiliary space: O(n).
	* Total space: O(n).
	*/

	

    static BinaryTreeNode binary_tree_to_cdll(BinaryTreeNode root) {
	    
		if (root == null) {
	        return root;
	    }

	    List<BinaryTreeNode> inorderList = new ArrayList<>();
	    //recursive call
	    get_inorder(root, inorderList);

	    int num_of_nodes = inorderList.size();

	    // Making a Doubly Linked List of all the nodes.
	    for (int i = 0; i < num_of_nodes - 1; ++i) {
	    	inorderList.get(i).right = inorderList.get(i + 1);
	    	inorderList.get(i + 1).left = inorderList.get(i);
	    }

	    // Connecting the first and the last node to make the list circular.
	    inorderList.get(num_of_nodes - 1).right = inorderList.get(0);
	    inorderList.get(0).left = inorderList.get(num_of_nodes - 1);

	    return inorderList.get(0);//head of the list
	}
	
	
	// Function to perform In-Order traversal of the
	// tree and store the nodes in a List
    static void get_inorder(BinaryTreeNode root, List<BinaryTreeNode> inorderL) {
	    if (root == null) {
	        return;
	    }
	    
	    get_inorder(root.left, inorderL);
	    inorderL.add(root);
	    get_inorder(root.right, inorderL);
	}
}
/*
 * store_and_link_solution.cpp A very straightforward approach for this is to
 * first store the in-order traversal of the tree in an array and then connect
 * all the adjacent nodes such that they form a circular doubly linked list.
 * This will form a doubly linked list of the nodes. Finally, to make it
 * circular, we will connect the first and the last nodes in the same way as we
 * connected all the adjacent nodes.
 */