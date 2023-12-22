package in.dsa.problems;



public class CountTotalNodes {

	public int countNodes(Node root) {
		
		if(root == null) return 0;
		
		int left = countNodes(root.left);
		int right = countNodes(root.right);
		
		return 1 + left + right;
	}
	
	private static class Node {

		int value; 
		Node left;
		Node right; 

		public Node(int elem) {
			this.value = elem;
		}
	}
}
