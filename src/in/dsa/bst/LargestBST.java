package in.dsa.bst;


public class LargestBST {
	
	public static Triple helper(BinaryTreeNode<Integer> root){

		if(root == null){
			return new Triple(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		}

		//For Leaf Node: the height is 1, max and min value will be the node value itself:
		if(root.left == null && root.right == null){
			return new Triple(root.data, root.data, 1);
		}

		//Post Order Traversal:
		Triple left = helper(root.left);
		Triple right = helper(root.right);

		//For a BST: root value > max from left subtree and root value < min from right subtree:
		if(root.data > left.maxNode && root.data < right.minNode){
			return new Triple(Math.max(root.data, right.maxNode), 
										Math.min(root.data, left.minNode), 1 + Math.max(left.height, right.height));
		}

		//If it's not a BST:
		return new Triple(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.height, right.height));


	}


	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		// Write your code here
		return helper(root).height;

	}
	
	class BinaryTreeNode<T> 
	{ 
		T data; BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { this.data = data; } 

	}


	private static class Triple{

		int maxNode;
		int minNode;
		int height;

		public Triple(int maxNode, int minNode, int height){
			this.maxNode = maxNode;
			this.minNode = minNode;
			this.height = height;
		}


	}
}
