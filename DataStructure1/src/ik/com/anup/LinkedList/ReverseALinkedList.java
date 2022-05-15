package ik.com.anup.LinkedList;

import java.util.LinkedList;
////https://www.geeksforgeeks.org/reverse-a-linked-list/
////////////4 steps :store nextNode, changePointer and move the prev/curr node forward 

/*Iterative Method 
Initialize three pointers prev as NULL, curr as head and next as NULL.
Iterate through the linked list. In loop, do following. 
// Before changing next of current, store next node 
next = curr->next
// Now change next of current . This is where actual reversing happens 
curr->next = prev /******************main ponter change******************
// Move prev and curr one step forward 
prev = curr 
curr = next*/



public class ReverseALinkedList {

	// Java program for reversing the linked list
	 
	
	 
	    static Node head;
	 
	    static class Node {
	 
	        int data;
	        Node next;
	 
	        Node(int d)
	        {
	            data = d;
	            next = null;
	        }
	    }
	 
	    /* Function to reverse the linked list */
	    Node reverse(Node node)
	    {
	        Node prev = null;
	        Node current = node;
	        Node next = null;
	        while (current != null) {
	            next = current.next;//store
	            current.next = prev;// actual reverse
	            prev = current;//itr prev
	            current = next;//itr curr
	        }
	        node = prev;/// is it neccessary??? yes seee below
	       return node;///
	        //return current;>>>> this does not work since loop only stops when current is null... hence we need to save the current just before final assign
	    }
	 
	    // prints content of double linked list
	    void printList(Node node)
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
	        list.head = new Node(85);
	        list.head.next = new Node(15);
	        list.head.next.next = new Node(4);
	        list.head.next.next.next = new Node(20);
	 
	        System.out.println("Given Linked list");
	        list.printList(head);
	        head = list.reverse(head);
	        System.out.println("");
	        System.out.println("Reversed linked list ");
	        list.printList(head);
	    }
	
}
