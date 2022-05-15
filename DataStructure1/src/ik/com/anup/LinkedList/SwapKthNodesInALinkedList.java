package ik.com.anup.LinkedList;

// two pointers, one starts from head and once Kth node from start is found we again run the ptr2 from start to find the kth from end
// needs two pointers to track the two nodes to be worked on .. 

/*Given a linked list and an integer k, swap k-th (1-indexed) node from the beginning, with k-th node from the end.

Note that you have to swap the actual nodes, not just their values.

Example
{
"head": [1, 2, 3, 4, 7, 0],
"k": 2
}
Output:

[1, 7, 3, 4, 2, 0]
Notes
The function has two parameters: head of the given linked list and k.
Return the head of the linked list after swapping k-th nodes of given linked list.
Constraints:

1 <= number of nodes in the given list <= 100000
-2 * 109 <= node value <= 2 * 109
1 <= k <= number of nodes
Try to access nodes of the given list as little as possible*/
public class SwapKthNodesInALinkedList {
	
	 class LinkedListNode {
	        Integer value;
	        LinkedListNode next;

	        LinkedListNode(Integer value) {
	            this.value = value;
	            this.next = null;
	        }
	    }
	 
	 LinkedListNode swap_nodes(LinkedListNode head, int k)
	 {
	/*1. find the kth node
    ptr1 will point to kth node from beginning and prev1 will point to its previous node.
    If ptr1 is head then prev1 will be NULL.
    */
    LinkedListNode prev1 = null;//previous node of prt1
    LinkedListNode ptr1 = head;
    while(k>1)
    {
        prev1 = ptr1;
        ptr1 = ptr1.next;// kth node from beginning is found 
        k--;
    }
    /*
    ptr2 will point to kth node from end and prev2 will point to its previous node.
    If ptr2 is head then prev2 will be NULL.

    If we set temp at kth node from beginning and ptr2 at head,
    and we keep on increasing both till temp reaches last node,
    then ptr2 will be at the kth node from end.

    Let's understand why? -
    When we started distance between ptr2 and temp is k - 1 links.
    We have incremented both temp and ptr2 same no of times, hence at the end also distance
    between ptr2 and
    temp will be k - 1 links.
    Now temp is at last node hence ptr2 will be at kth node from end!

    Try few examples to understand it clearly.
    */
    
    // 2. find the kth node from the end 
    LinkedListNode curr= ptr1;
    LinkedListNode prev2 = null;// previous node of ptr2
    LinkedListNode ptr2 = head;
    while (curr.next!=null)// as soon as curr is at the end // by the time curr reaches end , ptr2 is k away from end as well*************************
    {
        curr = curr.next;
        prev2 = ptr2;
        ptr2 = ptr2.next;// kth  node from end is found
    }
    
    //3. edge case of given node=curr=ptr1 is head
    if (prev1 != null)
    {
        // Link previous node of ptr1 to ptr2.
        prev1.next = ptr2;
    }
    else
    {
        // prev1 == NULL means ptr1 is head hence after swap, ptr2 will become head.
        head = ptr2;
    }
   
    
    //4. edge case that ptr2 is head
    if (prev2 != null)
    {
        // Link previous node of ptr2 to ptr1.
        prev2.next = ptr1;
    }
    else
    {
        // prev2 == NULL means ptr2 is head hence after swap, ptr1 will become head.
        head = ptr1;
    }
    // Swap next pointers of ptr1 and ptr2.
    curr = ptr1.next;
    ptr1.next = ptr2.next;
    ptr2.next = curr;
    return head;
}
}

// find the prev for both kth nodes( from begin and end ) and changes the next pointer accordingly.