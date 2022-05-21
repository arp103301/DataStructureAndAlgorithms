package ik.com.anup.trees;

import java.util.ArrayList;

/*Given a linkedlist with elements sorted in ascending order, convert it into a height-balanced binary search tree.

Example One
Input

Output:

Output

Example Two
Input

Output:

Output

Notes
A binary tree is called height-balanced if for any node, the difference in the heights of its left and right subtree does not exceed one.
Input list does not contain duplicates.
Return the root node of the created hight-balanced BST.
Constraints:

1 <= length of the linked list <= 20000
-109 <= node value <= 109*/
public class ConvertSortedListToBinarySearchTree {
	
	
	   
    //For your reference:
    class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

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
    
    
    static BinaryTreeNode sorted_list_to_bst(LinkedListNode head) {
      
	 if (head == null) return null;
     
	 // Iterate LinkedList
     ArrayList<Integer> arrList = new ArrayList<>();
     
     LinkedListNode node = head;
     
     while (node != null) {
         arrList.add(node.value);
         node = node.next;
     }
      
     return helper(arrList, 0, arrList.size()-1);// send index parameter in helper method
 }
 
 static BinaryTreeNode helper(ArrayList<Integer> arrList, int start, int end) {
     if (start > end) return null;
     
     int middle = start+ (end-start)/2;
     BinaryTreeNode head = new BinaryTreeNode(arrList.get(middle));
     head.left = helper(arrList, start, middle-1);
     head.right = helper(arrList, middle+1, end);
     
     return head;
 }
}
