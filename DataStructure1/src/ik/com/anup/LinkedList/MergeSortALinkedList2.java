package ik.com.anup.LinkedList;

// HInt:: for mergeMethod we need new DUmmyHeadNode and its pointers ;;; 
//use flags for temp and return Merge as that is head of tempNode;

//https://www.geeksforgeeks.org/merge-sort-for-linked-list/

//hint::
//1. find mid node using slow and fastpointer
//2. pass mid and mid.Next to recursive call.
//3. pass leftHead and rightHead to the mergeMethod, use mergedHead and mergeTail

/*Given a linked list, sort it in the ascending order using the Merge Sort algorithm.

Example One
{
"head": [0, 1, 10, 7]
}
Output:

[0, 1, 7, 10]
Example Two
{
"head": [1, 2, 3]
}
Output:

[1, 2, 3]
Notes
Return the head of the sorted linked list.

Constraints:

1 <= length of the list <= 105
-109 <= value in a linked list node <= 109*/
public class MergeSortALinkedList2 {

    
   // For your reference:
     static class  LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }
    
    static LinkedListNode merge_sort(LinkedListNode head) {
        if(head == null || head.next == null){// only single element .. no sorting necessary
            return head;
        }
        
        return mergeSort(head);
    }
    
    private static LinkedListNode mergeSort(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        LinkedListNode midNode = findMid(head);
        
        LinkedListNode midNodeNext = midNode.next;// mid+1 
        
        //to separate the two section while looping inside same single while loop
        midNode.next = null;
        
        LinkedListNode leftSide = mergeSort(head);
        LinkedListNode rightSide = mergeSort(midNodeNext);
        
        LinkedListNode newHead = merge(leftSide, rightSide);
        return newHead;
    }
    
    private static LinkedListNode merge(LinkedListNode head1, LinkedListNode head2){

		/*
		 * merge(head1, head2):
		 * 
		 * Take a pointer say merged to store the merged list in it and store a dummy
		 * node in it.
		 *  Take a pointer temp and assign merge to it. 
		 *  	If the data of head1
		 * is less than the data of head2, then, store head1 in next of temp & move
		 * head1 to the next of head1. 
		 * Else store head2 in next of temp & move head2 to
		 * the next of head2. Move temp to the next of temp. Repeat steps 3, 4 & 5 until
		 * head1 is not equal to null and head2 is not equal to null. Now add any
		 * remaining nodes of the first or the second linked list to the merged linked
		 * list. Return the next of merged(that will ignore the dummy and return the
		 * head of the final merged linked list)
		 */
    	
    	LinkedListNode merged = new LinkedListNode(-1);//do it
    	LinkedListNode temp = merged;// do it.
       
        // While head1 is not null and head2
        // is not null
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                temp.next = head1;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
       
        // While head1 is not null
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
       
        // While head2 is not null
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;//returning the dummyHead.next 
    }
    
    private static LinkedListNode findMid(LinkedListNode node){
        LinkedListNode slow = node; 
        LinkedListNode fast = node;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    
    
    
    
    
    
    
    
    // Function to print list
    static void printList(LinkedListNode head)
    {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
    
    // Driver Code
    public static void main(String[] args)
    {
    	// nead head and temp and use temp flags for adding newNodes
    	LinkedListNode head = new LinkedListNode(7);// do it
    	LinkedListNode temp = head;
        temp.next = new LinkedListNode(10);
        temp = temp.next;
        temp.next = new LinkedListNode(5);
        temp = temp.next;
        temp.next = new LinkedListNode(20);
        temp = temp.next;
        temp.next = new LinkedListNode(3);
        temp = temp.next;
        temp.next = new LinkedListNode(2);
        temp = temp.next;
 
        // Apply merge Sort
        head = mergeSort(head);
        System.out.print("\nSorted Linked List is: \n");
        printList(head);
    }
}
