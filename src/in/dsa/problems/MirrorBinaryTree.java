package in.dsa.problems;


public class MirrorBinaryTree {
	
	//void return type::
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here

		if(root == null) return; 

		if(root.left == null && root.right == null) return;

		BinaryTreeNode<Integer> leftNode = root.left;
		
		root.left = root.right; 
		root.right = leftNode;

		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);

	}
	
	//root return type::
	public static BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> root){

		if(root == null) return null; 

		BinaryTreeNode<Integer> leftNode = helper(root.left);
		BinaryTreeNode<Integer> rightNode = helper(root.right);

		root.left = rightNode;
		root.right = leftNode;

		return root;
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
