package in.dsa.bst;


public class CheckIfBTIsBST {

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	
	private static boolean isBST(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
		
		if(root == null) return true;
		
		if(root.data > minValue && root.data <= maxValue) {
			boolean left = isBST(root.left, minValue, root.data-1);
			boolean right = isBST(root.right, root.data, maxValue);
			
			return left && right;
		}
		
		return false;
	}


	@SuppressWarnings("unused")
	private class BinaryTreeNode<T> { 
		T data; 
		BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { 
			this.data = data; 
		} 

	}
}
