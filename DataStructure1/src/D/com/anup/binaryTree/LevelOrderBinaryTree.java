package D.com.anup.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
 
public class LevelOrderBinaryTree {
	
	private TreeNode root;
	
	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data; // Can be any generic type
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void levelOrder() {
		if(root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);// first order
		
		while(!queue.isEmpty()) {
			//he peek() method of Queue Interface returns the element at the front the container.
			TreeNode temp = queue.peek();
			//TreeNode temp = queue.poll();// for root
			
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			if(temp.right != null) {
				queue.offer(temp.right);
			}
				temp = queue.poll();// for root
				System.out.print(temp.data + " ");
		}
	}
	
	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7);
		
		root = first;
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		third.left = sixth;
		third.right = seventh;
	}
 
	public static void main(String[] args) {
		LevelOrderBinaryTree bt = new LevelOrderBinaryTree();
		bt.createBinaryTree();
		bt.levelOrder();
	}
}