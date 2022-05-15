package ik.com.anup.trees;

import java.util.ArrayList;

/*Construct a Binary Search Tree whose preorder traversal matches the given list.

Example One
{
"preorder": [1, 0, 2]
}
Output:

Example1

Example Two
{
"preorder": [2, 0, 1, 3, 5, 4]
}
Output:

Example1

Notes
Constraints:

1 <= size of the given list <= 105
-109 <= number in the list <= 109
Numbers in the given list are unique*/
public class ConstructABinarySearchTreeFromItsPreorderTraversal {
    
    //For your reference:
   static class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    static int index;// keeping track of the preorder list index such that we traverse lineraly 
    // static BinaryTreeNode root;
     static BinaryTreeNode build_binary_search_tree(ArrayList<Integer> preorder) {
         // Write your code here.
         if(preorder == null || preorder.size() == 0)
             return null;
         
         index = 0;
         //root = null;
        
         
         return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);// passing the index in the helper wont work as i will be the same:: pass by value 
     }
     
     static BinaryTreeNode helper(ArrayList<Integer> preorder, int lb, int ub){
         if(index == preorder.size()){
             return null;
         }
         
         int val = preorder.get(index);/***********************************//////////////////////// this  zeroth 
         
         if(val < lb || val > ub)
             return null;
             
         BinaryTreeNode root = new BinaryTreeNode(val);
       
         root.left = helper(preorder, lb, val);// check lower bound for left side
         root.right = helper(preorder, val , ub);// check upper bound for right side
         index++;
         return root;
     }
        
        
        
	/*
	 * int size = preorder.size(); return helper(preorder, size, Integer.MIN_VALUE,
	 * Integer.MAX_VALUE); }
	 * 
	 * static int idx = 0;
	 * 
	 * private static BinaryTreeNode helper(ArrayList<Integer> preorder, int size,
	 * int lower, int upper) { if (idx == size) return null;
	 * 
	 * int value = preorder.get(idx);
	 * 
	 * if (value < lower || value > upper) return null;
	 * 
	 * idx++; BinaryTreeNode root = new BinaryTreeNode(value); root.left =
	 * helper(preorder, size, lower, value); root.right = helper(preorder, size,
	 * value, upper); return root; }
	 */
        
        
        
        
        
		/*
		 * // Finding the first value greater than preorder[low]. int index = -1;
		 * for(int i=1;i<preorder.size();i++){ if(preorder.get(0)<preorder.get(i)){
		 * index=i; break; } }
		 * 
		 * // If all values towards the right of preorder[low] are less than
		 * preorder[low], // it means that all the values are to be inserted in the left
		 * subtree. if (index == -1) { newNode.left = helper(preorder, low + 1, high);
		 * return newNode; }
		 * 
		 * // Inserting the smaller values in the left subtree and the larger values in
		 * the right subtree. newNode.left = helper(preorder, low + 1, index - 1);
		 * newNode.right = helper(preorder, index, high);
		 * 
		 * return newNode;
		 */
    
}
/*
 * Depending on the position of a node in the BST, we can define a strict lower
 * and upper limit of its value. We will keep track of the permissible range for
 * a node value that can be inserted at a given position and will use those
 * ranges to build a valid binary search tree.
 * 
 * Our approach will be:
 * 
 * We will build the nodes in the order as they appear in preorder. Let us call
 * the current index in preorder as index. index would be initially set to 0 and
 * it would be passed by reference in every recursive call. Initiate a recursive
 * process which takes preorder, index and the permissible lower and upper limit
 * of the node value as its parameters. Let us call the limits as range_min and
 * range_max respectively. Initially, range_min is -inf and range_max is inf. If
 * preorder[index] does not lie in the allowed range, this means that we are not
 * at a valid position to insert the node with this value. So we return NULL.
 * This is the base case of the function. At this point, it may not make much
 * sense. But it would make sense once we look at the next steps. Otherwise, the
 * function will create a node with the value equal to preorder[index] and
 * increment index by 1. After that, it would recursively call itself two times.
 * Once for building the left subtree and once for building the right one. The
 * left subtree would have values between range_min to preorder[index] - 1 and
 * the right subtree would have values between preorder[index] + 1 to range_max.
 * We would make those calls with these ranges and without changing the value of
 * index. Upon the termination of the first call (which would finish building
 * the left subtree), index will be containing the index of the root of the
 * right subtree as per our design. So we will make the second call of the same
 * function with appropriate ranges and it will return us the root of the right
 * subtree. Finally, we will link the returned root of the left and right
 * subtree with the parent node and return the root of this newly built tree.
 * Time Complexity O(n).
 * 
 * We build n nodes and do a constant amount of work while building each node.
 * 
 * Auxiliary Space used O(n).
 * 
 * There will be O(n) number of recursive calls on the call stack in the worst
 * case.
 * 
 * Space Complexity O(n).
 * 
 * Space used for input: O(n). Auxiliary space used: O(n). Space used for
 * output: O(n). So, total space complexity: O(n).
 */


//https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/>>>n2 for recrusive