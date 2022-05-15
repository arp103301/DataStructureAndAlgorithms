package D.com.anup.singlyLinkedList;

public class InserInSortedSinglyLinkedList {
	 
	private ListNode head;
 
	private static class ListNode {
		private int data; // Can be a generic type
		private ListNode next; // Reference to next ListNode in list
 
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
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
	
	public ListNode insertInSortedList(int value) {
		ListNode newNode = new ListNode(value);
		
		if(head == null) {
			return newNode;
		}
		
		ListNode current = head;
		ListNode temp = null;
		
		while (current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		
		newNode.next = current;
		temp.next = newNode;
		return head;
	}
 
	public static void main(String[] args) {
		InserInSortedSinglyLinkedList sll = new InserInSortedSinglyLinkedList();
		sll.insertFirst(16);
		sll.insertFirst(10);
		sll.insertFirst(8);
		sll.insertFirst(1);
		
		sll.insertInSortedList(11);
		sll.display();
	}
}
