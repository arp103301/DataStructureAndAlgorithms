package D.com.anup.binaryTree;

public class RecursivePreorderBinaryTree {
	
	private TreeNode root;
	
	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data; // Can be any generic type
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
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
		RecursivePreorderBinaryTree bt = new RecursivePreorderBinaryTree();
		bt.createBinaryTree();
		bt.preOrder(bt.root);
	}
}
