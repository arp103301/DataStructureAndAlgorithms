package ik.com.anup.trees;

//https://www.techiedelight.com/count-subtrees-value-nodes-binary-tree/

/*Given a binary tree, find the number of unival subtrees. 
 * An unival (single value) tree is a tree that has the same value in every node.

Example One
Example one

Output:

6
The input tree has a total of 6 nodes. Each node is a root of a subtree. All those 6 subtrees are unival trees.

Example Two
Example two

Output:

5
The input tree has a total of 7 nodes, so there are 7 subtrees. Of those 7, 
all but two subtrees are unival. The two non-unival subtrees are:

The one rooted in the root node and
The one rooted in the root's right child.
Notes
Constraints:

0 <= number of nodes in the tree <= 105
-109 <= node value <= 109*/
public class SingleValueTree {
    
	BinaryTreeNode root;
	 
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
    
	/*
	* Asymptotic complexity in terms of number of nodes in the given tree `n`:
	* Time: O(n).
	* Auxiliary space: O(n).
	* Total space: O(n).
	*/
    
/*    static int count = 0;
    
    
    static Integer find_single_value_trees(BinaryTreeNode root){
	    int count = 0;
	    helper(root);
	    return count;
	}
    
    static boolean helper(BinaryTreeNode root){

        if(root.left == null && root.right == null ){
            count++;
            return true;
        }

        boolean uniVal = true;// single node has to be univalue 
        int nodeVal = root.value;
       
        if(root.left != null){

            boolean left = helper(root.left);

            uniVal =  left && (root.left.value == nodeVal);
        }
        if(root.right != null){

            boolean right = helper(root.right);

            uniVal =  right && uniVal && (root.right.value == nodeVal) ;

        }

        if(uniVal) count++;
        return uniVal;

    }*/
	
    
    
  ///////////////////   base case =leafnode return root.val  and increase count
     /////postorder ; call left and right helper
     //check the current node 
     static int countSubtrees(BinaryTreeNode root, int count)
    {
        // base case: empty tree
        if (root == null) {
            return Integer.MIN_VALUE;
        }
     
        // if the root is a leaf node, increase the count and return rootVal
        if (root.left == null && root.right == null)
        {
            count++;
            return root.value;
        }
     
        // recur for the left and right subtree
        int left = countSubtrees(root.left, count);
        int right = countSubtrees(root.right, count);
     
        // 1. The left subtree is empty, and the right subtree data matches the root
        // 2. The right subtree is empty, and the left subtree data matches the root
        // 3. Both left and right subtrees are non-empty, and their data matches the root
     
        // root matches with left|| right||  both***************************** increase count and return rootVal
        if ((left == Integer.MIN_VALUE && right == root.value) ||
            (right == Integer.MIN_VALUE && left == root.value) ||
            (left == right && left == root.value))
        {
            // increase the count and return root node data
            count++;
            return root.value;
        }
     
        // return infinity if root's data doesn't match with left or right subtree
        return Integer.MAX_VALUE;
    }
    
    
    
    // Driver program to test above functions
    public static void main(String args[])
    {
           /* Let us construct the below tree
                5
              /   \
            4      5
          /  \      \
         4    4      5
          			  \
          			  5
         */
    	BinaryTreeNode root = new BinaryTreeNode(5);
      
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(5);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(5);
        root.right.right.right = new BinaryTreeNode(5);
  
        System.out.println("The count of single valued sub trees is : "
                                            + countSubtrees(new BinaryTreeNode(5),0));
    }
}
