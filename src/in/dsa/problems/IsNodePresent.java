package in.dsa.problems;


public class IsNodePresent {

	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		//Your code goes here

		if(root == null) return false; 

		if(root.data == x) return true;

		boolean leftCheck = isNodePresent(root.left, x);
		boolean rightCheck = isNodePresent(root.right, x);

		return leftCheck || rightCheck;

	}

	class BinaryTreeNode<T> {
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
