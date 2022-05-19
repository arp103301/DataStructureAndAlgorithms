package ik.com.anup.LinkedList;

// use hashmap :: hm(curr, new Node(curr.val)
//while { currClone, put/get:randomClone, put/get:nextClone
//curr.curr.Next  and return hm.get(head);

//HInt::create newNode(curr.val)

import java.util.HashMap;
import java.util.Map;

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

    
    /// hashmap will have oldNode and NewNode
    
    
    	  public  static Node cloneUsingHashmap(Node head) {
    		   //base case
    	        if(head == null) return null;
    	        //define table
    	        Map<Node, Node> hm = new HashMap<>();
    	        
    	        //define cur pointer = head
    	        Node cur = head;
    	        hm.put(cur, new Node(cur.value));
    	        
    	        //while cur pointer != null
    	        while(cur != null){
    	            //1. get the new node of the cur pointer
    	            Node curClone = hm.get(cur);
    	            
    	            //2. Build the random pointer if doesn't exists in the table
    	            if(cur.random != null && !hm.containsKey(cur.random)){
    	                hm.put(cur.random, new Node(cur.random.value));
    	            }
    	            Node randomClone = hm.get(cur.random);
    	            
    	            //3  get new cur node point to new random node
    	            curClone.random = randomClone;
    	            
    	            //4. Build the next node if doesn't exists in the table
    	            if(cur.next != null && !hm.containsKey(cur.next)){
    	                hm.put(cur.next, new Node(cur.next.value));
    	            }
    	            Node nexClone = hm.get(cur.next);
    	            //5. Get the new curNode point to the next new node
    	            curClone.next = nexClone;
    	            
    	            //6. cur pointer move the next node
    	            cur = cur.next;
    	        }
    	            
    	        
    	        //return the new head node from the table
    	        return hm.get(head);
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
