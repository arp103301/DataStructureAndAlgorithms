package D.com.anup.binarySearchTree;

public class BinarySearchTree {
	
	private TreeNode root;
	
	private class TreeNode {
		private int data; // Generic type
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
}