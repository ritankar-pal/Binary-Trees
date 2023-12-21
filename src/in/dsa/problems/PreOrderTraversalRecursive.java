package in.dsa.problems;



public class PreOrderTraversalRecursive {

	
	public void preOrder(Node node) {
		
		if(node == null) return;
		
		System.out.print(node.value + " ");
		
		preOrder(node.left);
		preOrder(node.right);
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
