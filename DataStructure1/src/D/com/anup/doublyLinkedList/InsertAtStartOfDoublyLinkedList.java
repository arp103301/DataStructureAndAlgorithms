package D.com.anup.doublyLinkedList;

public class InsertAtStartOfDoublyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int length;
	
	private class ListNode {
		private int data; // Can be any generic type
		private ListNode next;
		private ListNode previous;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public InsertAtStartOfDoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0; // or head == null
	}
	
	public int length() {
		return length;
	}
	
	public void displayForward() {
		if(head == null) {
			return;
		}
		
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	public void displayBackward() {
		if(head == null) {
			return;
		}
		
		ListNode temp = tail;
		while(temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.previous;
		}
		System.out.println("null");
	}
	
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		if(isEmpty()) {
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}
	
	public static void main(String[] args) {
		InsertAtStartOfDoublyLinkedList dll = new InsertAtStartOfDoublyLinkedList();
		dll.insertFirst(1);
		dll.insertFirst(2);
		dll.insertFirst(3);
		
		dll.displayForward();
		dll.displayBackward();
	}
}
