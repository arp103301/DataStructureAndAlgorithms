package D.com.anup.queue;

public class EnqueueOfQueue {
	
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
	
	public EnqueueOfQueue() {
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
	
	public void enqueue(int data) {
		ListNode temp = new ListNode(data);
		if(isEmpty()) {
			front = temp;
		} else {
			rear.next = temp;
		}
		
		rear = temp;
		length++;
	}
	
	public void print() {
		if(isEmpty()) {
			return;
		}
		
		ListNode current = front;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		EnqueueOfQueue queue = new EnqueueOfQueue();
		queue.enqueue(10);
		queue.enqueue(15);
		queue.enqueue(20);
		
		queue.print();
	}
}