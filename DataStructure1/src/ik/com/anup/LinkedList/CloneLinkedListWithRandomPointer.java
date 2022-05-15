package ik.com.anup.LinkedList;

//https://thecodingsimplified.com/clone-linked-list-with-next-random-pointer/



/*You are given a linked list with the continuous sequence of the natural numbers, i.e., 1, 2, ..., n. 
 * Apart from the standard pointer to the next node, each node also has another one pointing to a random node in the list.
 *  Any of these two pointers may be empty (null, nil). The random pointer may point to the node 
 *  itself or any other node in the list.

Clone the list in an efficient manner, both in terms of time and memory usage.

Example
Example

Output:

Return the head of a new list that is identical to the given list, 
but includes (reuses) none of the nodes from the original list: you must create all nodes of the new list.

Notes
Constraints:

1 <= n <= 105
Description of the text format of the test cases

You might need this for debugging your solution on IK UpLevel platform.

The linked list is represented by a two-dimensional JSON array in both input and output.

Each inner list has three values that mean
[node.value, node.next.value, node.random.value]

Number -1 represents null pointers in the second and third columns: for the next and random pointers, respectively.*/
public class CloneLinkedListWithRandomPointer {
	  
    //For your reference:
     static class LinkedListNode {
        public Integer value;
        public LinkedListNode next;
        public LinkedListNode random;

        LinkedListNode(Integer node_data) {
            this.value = node_data;
            this.next = null;
            this.random = null;
        }
    };

/*
* Asymptotic complexity in terms of length of given linked list `n`:
* Time: O(n).
* Auxiliary space: O(1).
* Total space: O(n).
*/
    static LinkedListNode clone_linked_list(LinkedListNode head) {
    // Step 1:
    // inserting duplicate nodes between the consecutive nodes of
    // original linked list
    // initial list:
    //  1 -- 2 -- 3 -- 4 -- null  (with some random links at each node)
    // after inserting new duplicate nodes
    //  1 -- {1} -- 2 -- {2} -- 3 -- {3} -- 4 -- {4} -- null
    LinkedListNode tmpHead = head;
    while(tmpHead!= null) {
        LinkedListNode tmpNext = tmpHead.next;
        tmpHead.next = new LinkedListNode(tmpHead.value);
        tmpHead.next.next = tmpNext;
        tmpHead = tmpNext;//iterate
    }

    // Step 2:
    // linking the random nodes for cloned nodes corresponding TO its original node
    tmpHead = head;
    while(tmpHead!= null) {
        // getting the corresponding current node of the cloned list;
        // through out the iteration the "next" node of the current original
        // node tmpHead will give the current node of cloned list
        LinkedListNode currentClonedNode = tmpHead.next;

        // getting the random linked node from the original list node
        LinkedListNode tmpRandomLinkedNode = tmpHead.random;

        if(tmpRandomLinkedNode != null) {
        // getting the corresponding random linked node for the cloned node;
        // as the "next" node of the tmpHead->random will point to the
        // corresponding the random link node for the current cloned node
        tmpRandomLinkedNode = tmpRandomLinkedNode.next;
        }

        // linking the random pointed node for the current cloned node
        currentClonedNode.random = tmpRandomLinkedNode;// only copied nodes relation

        // moving to next node of original linked list by jumping
        // two steps odd indexed nodes are original nodes (1-based indexing)
        tmpHead = tmpHead.next.next;// jump two steps since single step is copied value//iteration
    }

    // Step 3:
    // detaching the cloned node from the original list and restoring the original list. also extracting the cloned 
    //list nodes and forming the cloned linked list.
    tmpHead = head;
    LinkedListNode clonedListHead = null;
    LinkedListNode clonedListTail = null;
    while (tmpHead!=null)
    {
        // getting corresponding cloned node to tmpHead
        LinkedListNode currentClonedNode = tmpHead.next;

        // detaching the cloned node and restoring original "next" node
        tmpHead.next = currentClonedNode.next;

        // building/chaining the cloned nodes to form separate linkedlist
        if(clonedListHead == null) {
            clonedListHead = currentClonedNode;
            clonedListTail = clonedListHead;
        }
        else {
            clonedListTail.next = currentClonedNode;
            clonedListTail = clonedListTail.next;
        }

        // moving to next node of original linked list by jumping
        // one step as we have restored original configuration till this node
        tmpHead = tmpHead.next;
    }

    return clonedListHead;
}


}





//
//to clone the regular list>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>...https://www.youtube.com/watch?v=tnYc8eOPw8g
//MyLinkedList copy = new MyLinkedList ();
//for (E e :this) {
	//copy.add(e);
//}
//return copy;
