package D.com.anup.singlyLinkedList;

public class SinglyListSearchElement {
	
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
	
	public boolean find(int searchKey) {
		if(head == null) {
			return false;
		}
		
		ListNode current = head;
		while(current != null) {
			if(current.data == searchKey) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		SinglyListSearchElement sll = new SinglyListSearchElement();
		sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		// Now we will connect them together to form a chain
		sll.head.next = second; // 10 --> 1
		second.next = third; // 10 --> 1 --> 8
		third.next = fourth; // 10 --> 1 --> 8 --> 11 --> null
		
		sll.display();
		
		if(sll.find(1)) {
			System.out.println("Search Key found !!!");
		} else {
			System.out.println("Search Key not found !!!");
		}
	}
}
