package in.dsa.problems;

//Finding LCA of p and q:

public class LCAOf2Nodes {
	
	public Node lowestCommonAncestor(Node root, Node p, Node q) {
		
		if(root == null) return null;
		
		if(root == p || root == q) return root;
		
		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);
		
		if(left == null || right == null) {
			if(left == null) return right;
			else return left;
		}
	
		//if both left and right are not null:
		return root;
	}
	
	
	
	
	private class Node{
		Node left;
		Node right;
		int data; 

		public Node(int data) {
			this.data = data;
		}
	}
}
