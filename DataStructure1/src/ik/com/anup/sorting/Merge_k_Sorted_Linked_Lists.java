package ik.com.anup.sorting;

//https://leetcode.com/problems/merge-k-sorted-lists/

/*Given k linked lists where each one is sorted in the ascending order, 
 * merge all of them into a single sorted linked list.

Example
{
"lists": [
[1, 3, 5],
[3, 4],
[7]
]
}
Output:

[1, 3, 3, 4, 5, 7]
Notes
Constraints:

0 <= k <= 104
0 <= length of one given linked list <= 103
-109 <= node value <= 109
Sum of the lengths of all given lists won't exceed 105
*/

import java.util.ArrayList;

/*
For your reference:
class LinkedListNode {
    Integer value;
    LinkedListNode next;

    LinkedListNode(Integer value) {
        this.value = value;
        this.next = null;
    }
}
*/




public class Merge_k_Sorted_Linked_Lists {
	
	 static class LinkedListNode {
	    Integer value;
	    LinkedListNode next;

	    LinkedListNode(Integer value) {
	        this.value = value;
	        this.next = null;
	    }
	}

static LinkedListNode merge_k_lists(ArrayList<LinkedListNode> lists) {// list of LinkedListNode/////////////////
    
    if(lists == null || lists.size() == 0) return null;
    return helper(lists, 0, lists.size() -1 );//use the whole k lists as one to use the same as merge sort
}

static LinkedListNode helper(ArrayList<LinkedListNode> lists, int start, int end){
    
	if(start == end) return lists.get(start);
    
    int mid = start + (end - start)/2;
    LinkedListNode one = helper(lists, start, mid);
    LinkedListNode two = helper(lists, mid+1, end);
    
    return mergeTwoLists(one, two);
}

static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2){
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    
    LinkedListNode result = new LinkedListNode(0);
    LinkedListNode curr = result;
    
    while (l1 != null && l2 != null) {
    	
        if (l2.value <=l1.value) {
        	curr.next = l2;// first node is smaller will be L2// flag
        	curr = curr.next;//itr
            l2 = l2.next;//itr of l2
        }
        else {
        	curr.next = l1;
        	curr = curr.next;
            l1 = l1.next;
        }
    }//while
    //remaining left side
    if(l1 == null) curr.next = l2;
    //remaining right sides
    if(l2 == null) curr.next = l1;
    
    return result.next;
}

}
/*Throughout this editorial, we will refer to the input array of the linked lists as lists, its size as k 
and the total number of nodes in all the given linked lists as n.*/

//as example has k =3 and n=

//k == lists.length

//Example 1:

/*
 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] 
 * Explanation:
 * The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted
 * list: 1->1->2->3->4->4->5->6
 */


/*
 * Approach 5: Merge with Divide And Conquer Intuition & Algorithm
 * 
 * This approach walks alongside the one above but is improved a lot. We don't
 * need to traverse most nodes many times repeatedly
 * 
 * Pair up \text{k}k lists and merge each pair.
 * 
 * After the first pairing, \text{k}k lists are merged into k/2k/2 lists with
 * average 2N/k2N/k length, then k/4k/4, k/8k/8 and so on.
 * 
 * Repeat this procedure until we get the final sorted linked list.
 * 
 * Thus, we'll traverse almost NN nodes per pairing and merging, and repeat this
 * procedure about \log_{2}{k}log 2 ​ k times.
 */
//O(Nlogk) where \text{k}k is the number of linked lists.