package in.dsa.problems;



public class InOrderTraversalRecursive {

	public void inOrder(Node node) {
		
		if(node == null) return;
		
		inOrder(node.left);
		
		System.out.println(node.value);
		
		inOrder(node.right);
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
