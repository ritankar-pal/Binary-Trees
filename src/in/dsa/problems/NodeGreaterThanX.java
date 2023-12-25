package in.dsa.problems;

public class NodeGreaterThanX {

	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		//Your code goes here

		if(root == null) return 0; 

		int countLeft = countNodesGreaterThanX(root.left, x);
		int countRight = countNodesGreaterThanX(root.right, x);

		if(root.data > x) return 1 + countLeft + countRight;
		else return countLeft + countRight;

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
