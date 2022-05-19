package ik.com.anup.LinkedList;

//Hint:..  prev, curr and next; store nextOfCurr, currNextFlag and move prev and curr forward

import java.util.LinkedList;
//https://github.com/Eric-programming/CodeSolution/blob/master/src/LinkedList/ReverseLinkedList/ReverseLinkedList.java


public class ReverseALinkedList {

	// Java program for reversing the linked list
	 
	
	 
	    static ListNode head;
	 
	    static class ListNode {
	 
	        int data;
	        ListNode next;
	 
	        ListNode(int d)
	        {
	            data = d;
	            next = null;
	        }
	    }
	 
	    /* Function to reverse the linked list */
	    ListNode reverse(ListNode head)
		{
			// Base Case
			if (head == null || head.next == null)
				return head;

			ListNode pre = null, cur = head;

			// Traverse the list
			while (cur != null) {
				ListNode nex = cur.next;// store nextOFCurr
				cur.next = pre;
				pre = cur;
				cur = nex;
			}
			return pre;
		}
	 
	    // prints content of double linked list
	    void printList(ListNode node)
	    {
	        while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }
	 
	    // Driver Code
	    public static void main(String[] args)
	    {
	    	ReverseALinkedList list = new ReverseALinkedList();
	        list.head = new ListNode(85);
	        list.head.next = new ListNode(15);
	        list.head.next.next = new ListNode(4);
	        list.head.next.next.next = new ListNode(20);
	 
	        System.out.println("Given Linked list");
	        list.printList(head);
	        head = list.reverse(head);
	        System.out.println("");
	        System.out.println("Reversed linked list ");
	        list.printList(head);
	    }
	
}
