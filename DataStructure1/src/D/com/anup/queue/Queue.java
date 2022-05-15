package D.com.anup.queue;

public class Queue {
	
	private ListNode front;
	private ListNode rear;
	private int length;
	
	private class ListNode {
		private int data; // Can be a generic type
		private ListNode next; // Reference to next ListNode in list
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Queue() {
		front = null;
		rear = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
}