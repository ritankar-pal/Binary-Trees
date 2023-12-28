package in.dsa.problems;


public class RemoveLeafNodes {
	
	public static Node removeLeaves(Node root) {
		
		if(root == null) return null;
		
		if(root.left == null && root.right == null) return null;
		
		root.left = removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		
		return root;
	}
	
	
	
	private static class Node{
		Node left;
		Node right;
		int data; 

		public Node(int data) {
			this.data = data;
		}

	}
}
