package ik.com.anup.LinkedList;


// Dobly linkedlist with HashMap

//https://www.youtube.com/watch?v=NDpwj0VWz1U

// HInt 
//1. get only modify linkedlist
//2.put.. needs to modify LL on both node!=null and node==null cases and adding to map only in node==null
// 3. addMethod will use a. frontsentinel and node  then 2.  head and node flags 
//4. remove just needs the two nodes on either side of the node

//https://www.youtube.com/watch?v=S6IfqDXWa10  for figure for dummyhead/dummyTail

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

	Node head = new Node();
	Node tail = new Node();
	Map<Integer, Node> cachedMap;
	int cachedCapacity;

	// class Node
	class Node {
		int key;
		int val;
		Node prev;
		Node next;

	}

	public void LRUCache2(int capacity) {
		cachedMap = new HashMap(capacity);
		this.cachedCapacity = capacity;
		head.next = tail;
		tail.prev = head;

	}

	public int get(int key) {
		int result = -1;
		Node node = cachedMap.get(key);
		if (node != null) {
			result = node.val;
			remove(node);// remove it from its current position
			add(node); // add will be automatic in the front
		}
		return result;
	}

	public void put(int key, int value) {
		Node node = cachedMap.get(key);

		if (node != null) {//siMilar to get
			remove(node);// remove from back
			node.val = value;// set the value
			add(node);// add to the front
		} else {
			if (cachedMap.size() == cachedCapacity) {
				cachedMap.remove(tail.prev.key);
				remove(tail.prev);
			}
			// now the new addition :: create
			Node newNode = new Node();
			newNode.key = key;
			newNode.val = value;
			// add
			cachedMap.put(key, newNode);
			add(newNode);//add to front

		}

	}

	public void add(Node node) {
		// between the node and frontsentinel
		Node frontsentinel = head.next;//just after head where we want to insert 
		node.next = frontsentinel;
		head.next.prev = node;// head.next is frontsentinel so need to map its prev to this newNode
		// between the head and node:::flags of node and head 
		head.next = node;
		node.prev = head;

	}

	public void remove(Node node) {
		// find the two nodes on either side
		Node nextNode = node.next;
		Node prevNode = node.prev;
		// now the removal part by changing flags of two sides nodes
		nextNode.prev = prevNode;
		prevNode.next = nextNode;

	}

	/**
	 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
	 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
	 */
}
