package ik.com.anup.trees;

// create two inorder list and merge them and then create BST from that mergedList

import java.util.ArrayList;

/*Given two Binary Search Trees (BSTs), merge them into a single height-balanced BST.

Example One
Example1 input

Output:

Example1 output

Example Two
Example2 input

Output:

Example2 output

Notes
A node with value equal to the value of the root node can be inserted either in the left or right subtree.
A binary tree is called height-balanced if for each node the following property is satisfied:
The difference in the heights of its left and right subtrees differ by at most 1.
Constraints:

1 <= number of nodes in the given BSTs <= 104
-109 <= node value <= 109*/
public class MergeTwoBSTs {

    
   // For your reference:
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
    
    
    static BinaryTreeNode merge_two_binary_search_trees(BinaryTreeNode root1, BinaryTreeNode root2) {
        // Write your code here.
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>(); 
        ArrayList<Integer> mergeArr = new ArrayList<>(); 
        inorder(root1, arr1);
        inorder(root2, arr2);
        mergeList(arr1, arr2, mergeArr);
        return constructBST(mergeArr, 0, mergeArr.size() - 1);
    }
    
    
    static void inorder(BinaryTreeNode node, ArrayList<Integer> arr){
        if(node == null){
            return;
        }
        inorder(node.left, arr);
        arr.add(node.value);
        inorder(node.right, arr);
    }

    static void mergeList(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3){
        int i = 0; int j = 0;
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                arr3.add(arr1.get(i));
                i++;
            }else{
                arr3.add(arr2.get(j));
                j++;
            }
        }
        while(i < arr1.size()){
            arr3.add(arr1.get(i));
            i++;
        }
        while(j < arr2.size()){
            arr3.add(arr2.get(j));
            j++;
        }
    }
    
    static BinaryTreeNode constructBST(ArrayList<Integer> arr, int start, int end){
        if(start>end){
            return null;
        }
        if(start==end){
            return new BinaryTreeNode(arr.get(start));
        }
        int mid = start + (end - start)/2;
        BinaryTreeNode root = new BinaryTreeNode(arr.get(mid));
        root.left = constructBST(arr, start, mid - 1);
        root.right = constructBST(arr, mid+1, end);
        return root;
    }
}
/*
 * In this solution, we will be using the fact that the in-order traversal of a
 * binary search tree visits the nodes in the sorted order of their values. We
 * will be extracting the nodes of the two trees in the sorted order of their
 * values and then merging them into a single sorted array. Finally, we will use
 * that array to form a height-balanced binary search tree.
 * 
 * Our approach will be:
 * 
 * Store the in-order traversal of the nodes of the first tree in the array
 * called inorder1 and of the second tree in inorder2. Merge inorder1 and
 * inorder2 into a single array such that the final array has all the nodes in
 * the sorted order of their values. That array is named merged_inorder. The
 * size of merged_inorder equals to node_count1 + node_count2. We merge inorder1
 * and inorder2 by traversing the two arrays once. Our approach for merging: Say
 * we are at index1 of inorder1 and index2 of inorder2. Initially both index1
 * and index2 equal to 0. We compare the values of nodes inorder1[index1] and
 * inorder2[index2] and push the node with the smaller value to the end of
 * merged_inorder. If values are equal, we can push any node. After this we
 * increment the index of the array whose node was added. We perform this until
 * we completely traverse at least one of the arrays. Then we push the remaining
 * nodes of the other array to the end of merged_inorder. After storing all the
 * nodes in a sorted form of their values in merged_inorder, we break the
 * connections of all the nodes with their respective child nodes. This is
 * important because parent-child connections in the resulting tree may be
 * different from that of the given trees. Finally, we use merged_inorder to
 * construct a height-balanced BST. To do it, we have to ensure two things:
 * First, for any node in the BST, the left and right subtrees must be
 * height-balanced. Second, the difference in the number of nodes in the left
 * and right subtrees must be at most 1. Our approach for this will be: Initiate
 * a process that takes merged_inorder and its first and last indices as
 * parameters. Let us call the starting and ending indices low and high
 * respectively. These must be initialized to 0 and (node_count1 + node_count2 -
 * 1) respectively. Get the middle of the current range of nodes and make it the
 * root node for the current subtree. This will ensure that the number of nodes
 * in the left and right subtrees of the current node differ by at most 1.
 * Initiate a process to build the left and right subtree of the current node.
 * For this, we will pass the index ranges as [low, root node index - 1] and
 * [root node index + 1, high] respectively. Finally, we return the root node of
 * the current subtree.
 */