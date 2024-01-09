package in.dsa.bst;

public class ReplaceSumWithGreaterNodes {
	
	public static int helper(BinaryTreeNode<Integer> root, int sum){

		if(root == null) return sum;

		int right = helper(root.right, sum);

		root.data = root.data + right;

		int left = helper(root.left, root.data);

		return left;

	}

	
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		// Write your code here
		helper(root, 0);
	}
	
	class BinaryTreeNode<T> 
	{ 
		T data; BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { this.data = data; } 

	}
}
