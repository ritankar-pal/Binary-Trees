package in.dsa.bst;

public class SearchInBST {
	
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {

		if(root == null) return false;

		if(root.data == k) return true;


		if(k < root.data){
			return searchInBST(root.left, k);
		}

		return searchInBST(root.right, k);

	}
	
	
	private class BinaryTreeNode<T> { 
		T data; 
		BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { 
			this.data = data; 
		} 

	}
}
