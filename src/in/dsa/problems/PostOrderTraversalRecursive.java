package in.dsa.problems;


public class PostOrderTraversalRecursive {

	public void postOrder(Node node) {

		if(node == null) return;

		postOrder(node.left);
		postOrder(node.right);
		
		System.out.println(node.value);
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
