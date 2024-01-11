package in.dsa.bst;


public class FloorInBST {
	
	public static int findCeil(BinaryTreeNode<Integer> root, int key) {
		
		int floor = -1;
		
		while(root != null) {
			
			if(root.data == key) {
				floor = root.data;
				return floor;
			}
			
			if(root.data > key) {
				root = root.left;
			}
			else {
				floor = root.data;
				root = root.right;
			}
			
		}
		
		return floor;
	}

	
	class BinaryTreeNode<T> 
	{ 
		T data; BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { this.data = data; } 

	}
}
