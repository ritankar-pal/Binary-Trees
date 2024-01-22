package in.dsa.problems;


public class CountCompleteTreeNodes {

	public int countNodes(BinaryTreeNode<Integer> root) {

		if(root == null) return 0;

		//Find the left and right height:
		int left = getLeftHeight(root);
		int right = getRightHeight(root);
		
		if(left == right) return (int) (Math.pow(2, left) - 1);

		return 1 + countNodes(root.left) + countNodes(root.right);
	}



	private int getRightHeight(BinaryTreeNode<Integer> root) {

		if(root == null) return 0;

		int count = 0;

		while(root != null) {

			count++;
			root = root.left;
		}

		return count;
	}



	private int getLeftHeight(BinaryTreeNode<Integer> root) {
		
		if(root == null) return 0;

		int count = 0;

		while(root != null) {
			count++;
			root = root.right;
		}

		return count;
	}



	private class BinaryTreeNode<T> 
	{ 
		T data; 
		BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { this.data = data; } 

	}
}
