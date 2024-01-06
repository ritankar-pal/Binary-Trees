package in.dsa.problems;


public class ChildrenSumProp {
	
	
	public static void changeTree(Node root) {
		
		if(root == null) return;
		
		int child = 0; 
		
		if(root.left != null) child = child + root.left.data;
		if(root.right != null) child = child + root.right.data;
		
		
		if(child >= root.data) root.data = child;
		else {
			if(root.left != null) root.left.data = child;
			if(root.right != null) root.right.data = child;
		}
		
		changeTree(root.left);
		changeTree(root.right);
		
		int total = 0;
		if(root.left != null) total = total + root.left.data;
		if(root.right != null) total = total + root.right.data;
		
		if(root.left != null || root.right != null) root.data = total;
		
	}
	

	
	class Node{
		Node left;
		Node right;
		int data; 

		public Node(int data) {
			this.data = data;
		}
	}
}
