package ik.com.anup.LinkedList;

public class SplitLinkedListInParts {
	
	
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
	   
	    public ListNode[] splitListToParts(ListNode head, int k) {
	       ListNode[] ans = new ListNode[k];
		    //final int length = getLength(root);
	        int length = 0;
		    for (ListNode curr = head; curr != null; curr = curr.next)
		      ++length;
	        
		    final int segment = length / k;
		    int rem = length % k;

		    ListNode prev = null;
		    ListNode curr = head;

		    for (int i = 0; i < k; ++i, --rem) {///
		      ans[i] = curr;
		      for (int j = 0; j < segment + (rem > 0 ? 1 : 0); ++j) {///
		        //iterate
		    	  prev = curr;
		        curr = curr.next;
		      }
		      if (prev != null)
		        prev.next = null;
		    }

		    return ans;
		  }

		  
	    
	}
}
