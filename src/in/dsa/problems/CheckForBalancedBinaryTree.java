package in.dsa.problems;


public class CheckForBalancedBinaryTree {
	
	public boolean isBalanced(Node root) {
		return helper(root) != -1;
	}
	
	
	private int helper(Node root) {
		
		if(root == null) return 0;
		
		int leftHeight = helper(root.left);
		if(leftHeight == -1) return -1;
		
		int rightHeight = helper(root.right);
		if(rightHeight == -1) return -1;
		
		
		if(Math.abs(leftHeight - rightHeight) > 1) return -1;
		
		return 1 + Math.max(leftHeight, rightHeight);
	}



	private static class Node{
		Node left;
		Node right; 
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
}
