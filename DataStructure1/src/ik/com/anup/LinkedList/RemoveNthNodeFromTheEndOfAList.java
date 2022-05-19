package ik.com.anup.LinkedList;

//find the total number of nodes
// use single poiner(=prev) to find the target index= total-distfromEnd
//-- no need for second pointr since only one node is to be worked-on
////connect prev to next node by doing prev.next=curr.next

/*Remove n-th node from the end of the given linked list. Return the head of the modified list.

Example One
{
"n": 2,
"head": [0, 1, 10, 5, 7]
}
Output:

[0, 1, 10, 7]
Example Two
{
"n": 1,
"head": [7]
}
Output:

[]
Notes
Constraints:

1 <= length of the list <= 105
1 <= n <= length of the list
-109 <= value in a list node <= 109*/
public class RemoveNthNodeFromTheEndOfAList {
    
    //For your reference:
    class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }
    
	static LinkedListNode remove_nth_node_from_end(Integer n, LinkedListNode head) {

        LinkedListNode curr = head;
        LinkedListNode prev = null;
        int len = 0;
     
        while (curr != null) {
            len++;//total nodes in the list
            curr = curr.next;
        }
     // number of hops needed for reaching to the node which has to be deleted
        // starting from the head of the given linked list.
        curr = head;
        int targetIndex = len - n;/********** since n is given wrt to end of the list*******************/
        // As the given linked list is not doubly linked, we need to keep track of the previous node
        // in order to delete a node.
        for (int i = 0; i < targetIndex; i++) {
            prev = curr;
            curr = curr.next;
        }
     // curr now points to the node to be deleted.
        // previous_node points to the node before that.
        if (prev == null) {
            return curr.next;
        } else {//connect prev to next node
            prev.next = curr.next;
            return head;
        }
    }

}
