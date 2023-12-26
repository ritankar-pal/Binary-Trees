package in.dsa.problems;

public class ReplaceNodeWithDepth {

	public static void helper(BinaryTreeNode<Integer> root, int depth){

		if(root == null) return;

		root.data = depth; 

		helper(root.left, depth+1);
		helper(root.right, depth+1);


	}

	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
		//Your code goes here

		helper(root, 0);

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
