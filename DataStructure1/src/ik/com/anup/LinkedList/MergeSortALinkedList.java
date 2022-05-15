package ik.com.anup.LinkedList;
// check the version2 for better clarity


//https://www.youtube.com/watch?v=pNTc1bM1z-4

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
public class MergeSortALinkedList {

    
   // For your reference:
    class LinkedListNode {
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
    
    private static LinkedListNode merge(LinkedListNode leftHead, LinkedListNode rightHead){
        LinkedListNode leftPointer = leftHead; 
        LinkedListNode rightPointer = rightHead;
        
        LinkedListNode mergeHead = null;
        LinkedListNode mergeTail = null;
        
        while(leftPointer != null && rightPointer != null){
            if(leftPointer.value < rightPointer.value){
                if(mergeHead == null){
                    mergeHead = leftPointer;
                    mergeTail = leftPointer;
                } else {
                    mergeTail.next = leftPointer;
                    mergeTail = mergeTail.next;
                }
                leftPointer = leftPointer.next;
            } else {//leftvalue>rightValue
                if(mergeHead == null){
                    mergeHead = rightPointer;
                    mergeTail = rightPointer;
                } else {
                    mergeTail.next = rightPointer;
                    mergeTail = mergeTail.next;
                }
                rightPointer = rightPointer.next;
            }
        }
        
        while(leftPointer != null){
            mergeTail.next = leftPointer;
            mergeTail = mergeTail.next;
            leftPointer = leftPointer.next;        
        }
        
        while(rightPointer != null){
            mergeTail.next = rightPointer;
            mergeTail = mergeTail.next;
            rightPointer = rightPointer.next;        
        }
        
        return mergeHead;
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

}
