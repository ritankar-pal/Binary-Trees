package in.dsa.problems;



public class PrintNodesAtDepthK {
	
	public void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
		
		if(root == null) return;
		
		if(k == 0) {
			System.out.println(root.data);
			return; 
		}
		
		printAtDepthK(root.left, k-1);
		printAtDepthK(root.right, k-1);
		
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
