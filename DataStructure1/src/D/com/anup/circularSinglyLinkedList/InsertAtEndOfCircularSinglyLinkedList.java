package D.com.anup.circularSinglyLinkedList;

public class InsertAtEndOfCircularSinglyLinkedList {
	private ListNode last;//###################################3
	private int length;
	
	private class ListNode {
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public InsertAtEndOfCircularSinglyLinkedList() {
		last = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void createCircularLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(15);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		
		last = fourth;
	}
	
	public void display() {
		if(last == null) {
			return;
		}
		
		ListNode first = last.next;
		while(first != last) {
			System.out.print(first.data + " --> ");
			first = first.next;
		}
		System.out.println(first.data);
	}
	
	public void insertFirst(int data) {
		ListNode temp = new ListNode(data);
		if(last == null) {
			last = temp;
		} else {
			temp.next = last.next;
		}
		last.next = temp;
		length++;
	}
	
	public void insertLast(int data) {
		ListNode temp = new ListNode(data);
		if(last == null) {
			last = temp;
			last.next = last;
		} else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		length++;
	}
	
	public static void main(String[] args) {
		InsertAtEndOfCircularSinglyLinkedList cll = new InsertAtEndOfCircularSinglyLinkedList();
		cll.insertLast(1);
		cll.insertLast(8);
		cll.insertLast(10);
		cll.display();
	}
}