package ik.com.anup.LinkedList;

// Hint:: 1.evenlist and oddlist.. if they are equal to null then add as head 
//2.if not add to the back after tail and move the tail itr forward 
// 3. reverse the boolean and move the head forward

import java.util.ArrayList;

/*Given a linked list, split it into two by alternating nodes: first node goes into the first list, 
 * second to second, third to first, fourth to second and so on.

Example
{
"head": [1, 2, 3, 4, 5]
}
Output:

[
[1, 3, 5],
[2, 4]
]
Notes
The function has one parameter, head of the given linked list.
Return a list that contains two heads of linked lists.
Empty linked list is represented by a NULL value in both input and output.
Constraints:

0 <= number of nodes in the given list <= 100000
1 <= value of any node <= 1000000000*/
public class AlternativeNodeSplit {
	
	  
   // For your reference:
   static class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }
  
	
	
	//Only need to add headNode to get the result of arraylist containing all nodes.. rules for all.

	 
	 
    static ArrayList<LinkedListNode> alternative_split(LinkedListNode head) {
        // Write your code here.
    	
		
		ArrayList<LinkedListNode> result = new ArrayList<>(); 
		
	    LinkedListNode evenListHead = null;
	    LinkedListNode evenListTail = null;
	    LinkedListNode oddListHead = null;;
	    LinkedListNode oddListTail = null;

	    boolean isEvenIndex = true; // We think zero-based. 0-th index is "even".
	    while(head!=null){
	        LinkedListNode currentNode = new LinkedListNode(head.value);
	        if(isEvenIndex){
	            // Append a new node to the "even" list.
	            if(evenListHead == null){
	                // If the list hasn't been initialized yet; initialize its head and tail.
	                evenListHead = currentNode;
	                evenListTail = currentNode;
	            } else {
	                evenListTail.next = currentNode;
	                evenListTail = evenListTail.next;
	            }
	        } else {
	            // Append a new node to the "odd" list.
	            if(oddListHead == null){
	                // If the list hasn't been initialized yet; initialize its head and tail.
	                oddListHead = currentNode;
	                oddListTail = currentNode;
	            } else {
	                oddListTail.next = currentNode;
	                oddListTail = oddListTail.next;
	            }
	        }
	        isEvenIndex = !isEvenIndex;///////***************************
	        head = head.next;//iterate
	    }
	   
	    result.add(evenListHead);
	    result.add(oddListHead);
	    return result;
	}
}
