package in.dsa.problems;

public class DiameterOfBinaryTree {
	
	//initially dia[0] = 0;
	public static int diameter(Node root, int[] dia) {
		
		if(root == null) return 0; 
		
		int leftHeight = diameter(root.left, dia);
		int rightHeight = diameter(root.right, dia);
		
		dia[0] = Math.max(dia[0], leftHeight + rightHeight);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	
	//wherever we are calling the diameter function, we will return dia[0]
	
	
	private static class Node{
		Node left;
		Node right;
		int data; 
		
		public Node(int data) {
			this.data = data;
		}
	}
}
