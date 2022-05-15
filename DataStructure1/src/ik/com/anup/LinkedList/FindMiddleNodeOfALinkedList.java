package ik.com.anup.LinkedList;

/*Given a linked list, find its middle element.

If the list has even number of nodes, return the second of the two middle nodes.

Example One
{
"head": [1, 2, 3, 4, 5]
}
Output:

3
Example Two
{
"head": [1, 2, 3, 4]
}
Output:

3
Notes
Constraints:

0 <= number of nodes <= 105
-2 * 109 <= node value <= 2 * 109
Do it in one pass over the list
If given linked list is empty, return null.*/
public class FindMiddleNodeOfALinkedList {
   
    //For your reference:
    class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }
   
    static LinkedListNode find_middle_node(LinkedListNode head) {
        // Write your code here.
        // 1, 2s, 3s, 4 -- f
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast!= null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
