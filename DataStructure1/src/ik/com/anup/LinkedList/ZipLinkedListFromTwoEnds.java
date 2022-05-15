package ik.com.anup.LinkedList;

//1. find midpint
//2. reverse the second half
//3. join the original front half with reverse second half


/*Given a linked list, zip it from its two ends in place, using constant extra 
 * space. The nodes in the resulting zipped linked list should go in this order: first, last, second, second last, and so on.

Follow up:

Implement functions to zip two linked lists and to unzip such that unzip(zip(L1, L2)) returns L1 and L2.

Example One
{
"head": [1, 2, 3, 4, 5, 6]
}
Output:

[1, 6, 2, 5, 3, 4]
Example Two
{
"head": [1, 2, 3, 4, 5]
}
Output:

[1, 5, 2, 4, 3]
Notes
The function has one parameter: head of the given linked list.
Return the head of zipped linked list.
Constraints:

0 <= number of nodes <= 100000
-2 * 109 <= node value <= 2 * 109*/
public class ZipLinkedListFromTwoEnds {
	
    //For your reference:
    class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }
    
    static LinkedListNode zip_given_linked_list(LinkedListNode head) {
        if(head == null){
            return head;
        }
        
        //finding mid and splitting list in 2 equal parts
        LinkedListNode head1 = null;
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        head1 = slow.next;// after step after mid =slow
        slow.next = null;
        
        //reverse a linked list
        LinkedListNode head2 = reverseList(head1);
        
        //join and return
        return zipLists(head, head2);
    }
    
    private static LinkedListNode zipLists(LinkedListNode head1, LinkedListNode head2){
        LinkedListNode node1 = head1;
        LinkedListNode node2 = head2;
        
        LinkedListNode next1 = null;
        LinkedListNode next2 = null;
        
        while(node2 != null){
        	//store next
            next1 = node1.next;
            next2 = node2.next;
            //flags swapped= zipped
            node1.next = node2;
            node2.next = next1;
            //iterate/move forward
            node1= next1;
            node2 = next2;
        }
        
        return head1;
    }
    
    private static LinkedListNode reverseList(LinkedListNode head){
        LinkedListNode prev = null;
      
        LinkedListNode nextNode = null;
        
        while(head != null){
            nextNode = head.next;// 1. Before changing next of current, // store next node 
            head.next = prev;// 2. Now change next of current // This is where actual reversing happens 
            
            prev = head;// 3. Move prev and head one step forward 
            head = nextNode;   
        }
        
        head = prev;// new head 
        
        return head;
    }
}
/*
 * We provided one solution:
 * 
 *1. Split the given list into halves so that, for example, 1 -> 2 -> 3 -> 4 -> 5
 * -> 6 -> NULL becomes 1 -> 2 -> 3 -> NULL and 4 -> 5 -> 6 -> NULL. 
 * 2. Reverse the second list. In this example the second list becomes 6 -> 5 -> 4 -> NULL. 
 * 3. Now merge the two lists by alternating the nodes from first and second lists.
 * Build the resulting list by updating the next pointers of the nodes.
 */