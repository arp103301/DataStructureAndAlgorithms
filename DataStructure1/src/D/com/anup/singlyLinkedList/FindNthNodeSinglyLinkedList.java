package D.com.anup.singlyLinkedList;

public class FindNthNodeSinglyLinkedList {
	
	private ListNode head;
	
	private static class ListNode {
		private int data; // Can be a generic type
		private ListNode next; // Reference to next ListNode in list
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public int length() {
		if(head == null) {
			return 0;
		}
		int count = 0;
		ListNode current = head;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	public void display() {
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public void insertFirst(int data) {
		ListNode new_node = new ListNode(data); 
        new_node.next = head;
        head = new_node; 
	}
	
	public ListNode getNthNodeFromEnd(int n) {
		if(head == null) {
			return null;
		}
		
		if(n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}
		
		ListNode mainPtr = head;
		ListNode refPtr = head;
		
		int count = 0;
		
		while(count < n) {
			if(refPtr == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			refPtr = refPtr.next;
			count++;
		}
		
		while(refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}
	
	public static void main(String[] args) {
		FindNthNodeSinglyLinkedList sll = new FindNthNodeSinglyLinkedList();
//		sll.head = new ListNode(10);
//		ListNode second = new ListNode(1);
//		ListNode third = new ListNode(8);
//		ListNode fourth = new ListNode(11);
//		
//		// Now we will connect them together to form a chain
//		sll.head.next = second; // 10 --> 1
//		second.next = third; // 10 --> 1 --> 8
//		third.next = fourth; // 10 --> 1 --> 8 --> 11 --> null
		
		sll.insertFirst(11);
		sll.insertFirst(1);
		sll.insertFirst(8);
		sll.insertFirst(10);
		
		sll.display();
		
		ListNode nthNodeFromEnd = sll.getNthNodeFromEnd(3);
		System.out.println("Nth node from end is - " + nthNodeFromEnd.data);
	}
}