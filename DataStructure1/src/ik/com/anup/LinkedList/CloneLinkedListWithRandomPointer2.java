package ik.com.anup.LinkedList;

// use hashmap 

import java.util.HashMap;

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
public class CloneLinkedListWithRandomPointer2 {
	  
    //For your reference:
     static class Node {
        public Integer value;
        public Node next;
        public Node random;

        Node(Integer node_data) {
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
    static Node clone_linked_list(Node node) {
    	if (node == null) {
    	      return node;
    	    }

    	    Node first = node;
    	    Node next = null;
// 1. insert newNode(s) after the old node
    	    while (node != null) {
    	      Node newNode = new Node(node.value);
    	      next = node.next;
    	      //
    	      node.next = newNode;
    	      newNode.next = next;
    	      //move the itr
    	      node = next;
    	    }

    	    node = first;

    	    while (node != null) {
    	      node.next.random = node.random.next;
    	      node = node.next != null ? node.next.next : node.next;
    	    }

    	    node = first;
    	    Node copy = node.next;
    	    Node tempCopy = copy;

    	    while (node != null && copy != null) {
    	      node.next = node.next != null ? node.next.next : node.next;
    	      copy.next = copy.next != null ? copy.next.next : copy.next;

    	      node = node.next;
    	      copy = copy.next;
    	    }

    	    return tempCopy;
    	  }

    
    
    
    
    	  public  static Node cloneUsingHashmap(Node firstHead) {
    	    if (firstHead == null) {
    	      return null;
    	    }

    	    HashMap<Node, Node> m = new HashMap<>();///*****************************
    	    Node secondHead = null, secondNode = null;
    	    Node firstNode = firstHead;

    	    while (firstNode != null) {
    	      Node newNode =  new Node(firstNode.value);
    	      if (secondHead == null) {
    	        secondHead = newNode;
    	        secondNode = secondHead;
    	      } else {
    	        secondNode.next = newNode;
    	        secondNode = newNode;
    	      }

    	      m.put(firstNode, secondNode);
    	      firstNode = firstNode.next;
    	    }

    	    firstNode = firstHead;
    	    secondNode = secondHead;

    	    while (firstNode != null) {
    	      if (firstNode.random != null) {
    	        secondNode.random = m.get(firstNode.random);
    	      }

    	      firstNode = firstNode.next;
    	      secondNode = secondNode.next;
    	    }

    	    return secondHead;
    	  }
    	








   

    	  public static void main(String[] args) {

    	   

    	    Node head =  new Node(1);
    	    head.next =  new Node(2);
    	    head.next.next =   new Node(3);
    	    head.next.next.next =  new Node(4);
    	    head.next.next.next.next =  new Node(5);

    	    head.random = head.next.next;
    	    head.next.random = head;
    	    head.next.next.random = head.next.next.next.next;
    	    head.next.next.next.random = head.next.next.next.next;
    	    head.next.next.next.next.random = head.next;

    	    // Node clone = a.clone(head);
    	    Node clone2 = cloneUsingHashmap(head);
    	  }

}








//
//to clone the regular list>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>...https://www.youtube.com/watch?v=tnYc8eOPw8g
//MyLinkedList copy = new MyLinkedList ();
//for (E e :this) {
	//copy.add(e);
//}
//return copy;
