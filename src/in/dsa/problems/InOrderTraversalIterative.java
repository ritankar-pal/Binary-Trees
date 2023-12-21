package in.dsa.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterative {
	
	public List<Integer> inOrderTraversal(Node root){
		
		List<Integer> list = new ArrayList<>();
		
		Stack<Node> stack = new Stack<>();
		
		//pushing the root in the stack::
		Node node = root;
		
		while(true) {
			
			if(node != null) {
				stack.push(node);
				node = node.left;
			}
			else {
				
				if(stack.isEmpty()) break;
				
				node = stack.pop();
				
				list.add(node.value);
				
				node = node.right;
			}
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
