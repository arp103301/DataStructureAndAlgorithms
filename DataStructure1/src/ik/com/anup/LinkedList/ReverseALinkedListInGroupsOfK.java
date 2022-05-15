package ik.com.anup.LinkedList;

/*Given a linked list, reverse every group of k nodes. If there is a remainder (a group of less than
 *  k nodes) in the end, reverse that last group, too.

Example One
{
"head": [1, 2, 3, 4, 5, 6],
"k": 3
}
Output:

[3, 2, 1, 6, 5, 4]
Input list consists of two whole groups of three. In the output list the first three and last three nodes are reversed.

Example Two
{
"head": [1, 2, 3, 4, 5, 6, 7, 8],
"k": 3
}
Output:

[3, 2, 1, 6, 5, 4, 8, 7]
There are two whole groups of three and one partial group (a remainder that consists of just two nodes). Each of the three groups is reversed in the output.

Notes
The function has two parameters: head of the given linked list and k.
Return the head of the linked list after reversing the groups of nodes in it.
Constraints:

1 <= number of nodes in the list <= 100000
-2 * 109 <= node value <= 2 * 109
1 <= k <= number of nodes
Cannot use more than constant extra space*/
public class ReverseALinkedListInGroupsOfK {
	
   static class  LinkedListNode {
        int val;
        LinkedListNode next;
    };
   
    static LinkedListNode reverse_linked_list_in_groups_of_k(LinkedListNode head, int k) {
        LinkedListNode curr = head;
        LinkedListNode dummy = new LinkedListNode();
        LinkedListNode tail = dummy;
        
        
        while(curr != null) {
            LinkedListNode prev =null;//prev
            LinkedListNode temp = curr;
            int index=0;
            
            while(curr != null && index < k){
                LinkedListNode next = curr.next;
                curr.next = prev; //**************** same as 'prev' class ReverseAlInkedList
                prev = curr;
                curr = next;
                index++;//**************** 1 more steps than class ReverseAlInkedList
            }
            
            tail.next = prev;
            tail= temp;
        }
        
        return dummy.next;
    }
    
    
    
    /*
    Asymptotic complexity in terms of length of given linked list `n`:
    * Time: O(n).
    * Auxiliary space: O(1).
    * Total space: O(n).
    */
}

/*
 * We reverse the first k nodes of the linked list. While reversing, we keep
 * track of the first and last node of the k-reversed linked list using the join
 * and tail pointer. After reversing the k nodes of the linked list, we join the
 * nodes pointed by the tail pointer and
 */
///join pointer and update them. We repeat this process until all groups of nodes are reversed.