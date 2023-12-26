package in.dsa.problems;

public class HeightOfTrees {
	
	
	public static int height(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root == null) return 0; 

		int leftHeight = height(root.left);
	 	int rightHeight = height(root.right);

		return 1 + Math.max(leftHeight, rightHeight);

	}
	
	
	private class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
