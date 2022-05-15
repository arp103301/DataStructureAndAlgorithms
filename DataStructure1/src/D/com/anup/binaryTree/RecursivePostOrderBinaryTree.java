package D.com.anup.binaryTree;

public class RecursivePostOrderBinaryTree {
	
	private TreeNode root;
	
	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data; // Can be any generic type
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
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
		RecursivePostOrderBinaryTree bt = new RecursivePostOrderBinaryTree();
		bt.createBinaryTree();
		bt.postOrder(bt.root);
	}
}