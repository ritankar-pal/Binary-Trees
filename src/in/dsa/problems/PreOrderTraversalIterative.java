package in.dsa.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PreOrderTraversalIterative {
	
	public List<Integer> preOrderTraversal(Node root){
		
		List<Integer> list = new ArrayList<>();
	
		Stack<Node> stack = new Stack<>();
		
		//adding the root to the stack:: 
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			root = stack.pop();
			list.add(root.value);
			
			if(root.right != null) stack.push(root.right);
			if(root.left != null) stack.push(root.left);
		}
		
		return list;
		
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
