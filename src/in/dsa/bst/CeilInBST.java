package in.dsa.bst;



public class CeilInBST {
	
	public static int findCeil(BinaryTreeNode<Integer> root, int key) {
		
		int ceil = -1;
		
		while(root != null) {
			
			if(root.data == key) {
				ceil = root.data;
				return ceil;
			}
			
			
			if(root.data > key) {
				ceil = root.data;
				root = root.left;
			}
			else {
				root = root.right;
			}
			
		}
		
		
		return ceil;
	}
	
	class BinaryTreeNode<T> 
	{ 
		T data; BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { this.data = data; } 

	}
}
