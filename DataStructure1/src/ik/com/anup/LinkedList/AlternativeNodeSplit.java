package ik.com.anup.LinkedList;

// Hint:: 1.evenlist and oddlist.. if they are equal to null then add as head 
//2.if not add to the back after tail and move the tail itr forward 
// 3. reverse the boolean and move the head forward


//LC 328

import java.util.ArrayList;

import ik.com.anup.LinkedList.SplitLinkedListInParts.ListNode;

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

	 
//  top attempt:: need head and tail pointer for both list and this absolutely needs NEW NODES oddHead and 
   
    static ArrayList<LinkedListNode> alternative_split(LinkedListNode head) {
        // Write your code here.
    	
		
		ArrayList<LinkedListNode> result = new ArrayList<>(); 
		
        LinkedListNode oddHead = head, //new LinkedListNode(0),
        evenHead = head.next,//new LinkedListNode(0),
        oddTail = oddHead,
        evenTail = evenHead,
        curr = null;
        int idx = 1;
       
        /// while loops takes tails only for this solution as well as inplace solution
        while(head!=null) {
            curr = head;
            head = head.next;
            curr.next = null;
            if(idx%2==1) {
                oddTail.next = curr;//flag
                oddTail = oddTail.next;//itr
            }else {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }
            idx++;
        }
        
        result.add(oddHead.next);
        result.add(evenHead.next);
        
        return result;
	}


//iN place solution https://leetcode.com/problems/odd-even-linked-list/solution/

    /*A well-formed LinkedList need two pointers head and tail to support operations at both ends.
    The variables head and odd are the head pointer and tail pointer of one LinkedList we call oddList; 
    the variables evenHead and even
    are the head pointer and tail pointer of another LinkedList we call evenList.*/


/*
    public ListNode oddEvenList(ListNode head) 
	
	if (head ==null) return null;
	
    ListNode odd = head;// LC gave firstNode is odd 
    ListNode evenHead =head.next;
    ListNode even = evenHead;
	
	while (even!=null &&  even.next!=null) {
		odd.next=even.next;// flag
		odd =odd.next; //itr
		even.next= odd.next;//flag
		even = even.next;//itr
	}
	odd.next= evenHead;// joining tail of odd to evenHead
	return head;   
	
	
}
	
*/

}