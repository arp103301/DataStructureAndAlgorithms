package D.com.anup.binaryTree;

import java.util.Stack;

public class IterativePreOrderBinaryTree {
	
	private TreeNode root;
	
	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data; // Can be any generic type
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void preOrder() {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);//first- root step
		
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();/// pop is for root-parent
			System.out.print(temp.data + " ");
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
	
	public void createBinaryTree() {
		TreeNode first = new TreeNode(9);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		
		root = first; // root ---> first
		first.left = second;
		first.right = third; // second <--- root ---> third
		
		second.left = fourth;
	}
 
	public static void main(String[] args) {
		IterativePreOrderBinaryTree bt = new IterativePreOrderBinaryTree();
		bt.createBinaryTree();
		bt.preOrder();
	}
}