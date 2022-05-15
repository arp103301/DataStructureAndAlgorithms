package ik.com.anup.trees;

import java.util.ArrayList;

/*Given a binary tree, return all paths from root to leaf.

Example One
Example one

Output:

[
[1, 2, 4],
[1, 2, 5],
[1, 3, 6],
[1, 3, 7]
]
There are four leafs in the given graph, so we have four paths: from the root to every leaf. Each path is a list of the values from the tree nodes on the path, and we have four lists. They can go in any order.

Example Two
Example two

Output:

[
[10, 20, 40],
[10, 20, 50],
[10, 30]
]
There are 3 paths in the tree.

The leftmost path contains values: 10 -> 20 -> 40

The rightmost path contains values: 10 -> 30

The other path contains values: 10 -> 20 -> 50

The order of the paths (order of the lists in the outer list) does not matter, so [[10, 30], [10, 20, 40], [10, 20, 50]] is another correct answer.

Notes
Return a list of integer lists, where each list is representing a path.
The order of the paths (order of the lists in the outer list) does not matter.
Constraints:

0 <= number of nodes in the given tree <= 105
-109 <= value in a node <= 109*/
public class PrintAllPathsOfATree {

    
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
    
    static ArrayList<ArrayList<Integer>> all_paths_of_a_binary_tree(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root != null)
            helper(root, new ArrayList<Integer>(), result);
        return result;
    }
    
    private static void helper(BinaryTreeNode root, ArrayList<Integer> slate, 
                                                    ArrayList<ArrayList<Integer>> result) {
        slate.add(root.value);
        if(root.left == null && root.right == null) {
            result.add(new ArrayList(slate));//we could have any condition check for this before adding it:::::::::::::::::::::::::::::::: such as target is 0 now at last
            slate.remove(slate.size()-1);
            return;
        }
        if(root.left!=null)
        helper(root.left, slate, result);
        if(root.right!= null)
        helper(root.right,slate, result);
        
        slate.remove(slate.size()-1);
    }

}
