package D.com.anup.singlyLinkedList;

public class RemoveKeyFromSinglyLinkedList {
	 
	   private ListNode head;
	 
	   private static class ListNode {
	      private int data; // Can be a generic type
	      private ListNode next; // Reference to next ListNode in list
	 
	      public ListNode(int data) {
	         this.data = data;
	         this.next = null;
	      }
	   }
	 
	   public void printLinkedList() {
	      ListNode current = head;
	      while(current != null) {
	         System.out.print(current.data + " --> ");
	         current = current.next;
	      }
	      System.out.println("null");
	   }
	 
	   public void insertAtBeginning(int data) {
	      ListNode newNode = new ListNode(data);
	      newNode.next = head;
	      head = newNode;
	   }
	 
	   public void deleteNode(int key) {// key is data for that node
	      ListNode current = head;
	      ListNode temp = null;// need null node for deletion
	 
	      if(current != null && current.data == key){
	         head = current.next;
	         return;
	      }
	 
	      while(current != null && current.data != key){
	         temp = current;
	         current = current.next;
	      }
	 
	      if(current == null){
	         return;
	      }
	 
	      temp.next = current.next;// delete means nextPointer to null
	   }
	 
	   public static void main(String[] args) {
	      RemoveKeyFromSinglyLinkedList sll = new RemoveKeyFromSinglyLinkedList();
	      sll.insertAtBeginning(16);
	      sll.insertAtBeginning(11);
	      sll.insertAtBeginning(10);
	      sll.insertAtBeginning(8);
	      sll.insertAtBeginning(1);
	 
	      sll.printLinkedList();
	 
	      sll.deleteNode(11);
	 
	      sll.printLinkedList();
	   }
	}
