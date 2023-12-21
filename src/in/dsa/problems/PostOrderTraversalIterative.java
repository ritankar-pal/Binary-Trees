package in.dsa.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PostOrderTraversalIterative {
	
	
	public List<Integer> postOrder(Node root){
		
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		
		List<Integer> list = new ArrayList<>();
		
		//Adding the root to stack1::
		stack1.add(root);
		
		while(!stack1.isEmpty()) {
			
			root = stack1.pop(); //1
			stack2.push(root);
			
			if(root.left != null) stack1.push(root.left);
			if(root.right != null) stack1.push(root.right);
			
		}
		
		while(!stack2.isEmpty()) {
			list.add(stack2.pop().value);
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
