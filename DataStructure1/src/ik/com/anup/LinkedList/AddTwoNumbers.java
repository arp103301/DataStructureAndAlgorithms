package ik.com.anup.LinkedList;

//hint::::::::::::::::::::::::::::::::::: sum=carry+v1+v2 and   carrry=sum/10 and sum=sum%10


/*Write a function which adds two numbers a and b, represented as linked lists of size lenA and lenB respectively,
 and returns the sum of a and b in the form of a new linked list.

Ignoring the allocation of a new linked list, try to use constant memory when solving it.

A number is represented by a linked list, with the head of the linked list being the least significant digit. 
For example 125 is represented as 5->2->1, and 371 is represented as 1->7->3. Adding 5->2->1(125) and 1->7->3(371) 
should produce 6->9->4(496).

Example One
{
"l_a": [7, 5, 2],
"l_b": [2, 0, 3]
}
Output:

[9, 5, 5]
As l_a = 7->5->2 means number 257 and l_b = 2->0->3 means number 302. Sum of 257 and 302 is 559 so, result will represent 9->5->5.

Example Two
{
"l_a": [5, 8, 3],
"l_b": [9, 4, 1]
}
Output:

[4, 3, 5]
As l_a = 5->8->3 means number 385 and l_b = 9->4->1 means number 149. Sum of 385 and 149 is 534 so, result will represent 4->3->5.

Notes
There are two input parameters l_a and l_b, denoting linked lists representing numbers a and b respectively.
Output is the head node of resultant linked list representing the sum of two numbers a and b.
Constraints

1 <= length of the input linked lists <= 100000
0 <= linked list node value <= 9
Leading zeros will not appear in the input and will not be accepted in the output.
No negative numbers.*/
public class AddTwoNumbers {

    
    //For your reference:
     static class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }
    
    static LinkedListNode add_two_numbers(LinkedListNode l_a, LinkedListNode l_b) {
     
    	 LinkedListNode curr = new LinkedListNode(0);
         LinkedListNode result = curr; //l1= l_a, l2= l_b;
         int carry=0;int sum =0;
        
         while (l_a!=null || l_b!=null){
             int l1val= (l_a ==null) ? 0: l_a.value;
             int l2val= (l_b ==null) ? 0: l_b.value;
             
             sum = l1val +l2val +carry;
             
             carry = sum/10;
             
             //the sum in the correct 'ones' place>> new node is added to tail o the result
             result.next = new LinkedListNode(sum%10);
             result= result.next;
             
             //iterate the nodes to next ones
             if (l_a!=null) l_a= l_a.next;
             if (l_b!=null) l_b = l_b.next;
             
         }
      // If still carry is remaining then we add extra node at tail of linkedlist l_b.
         if (carry > 0 ) result.next = new LinkedListNode(carry);
         return curr.next;//since the list as given as reversed 
    }
}
