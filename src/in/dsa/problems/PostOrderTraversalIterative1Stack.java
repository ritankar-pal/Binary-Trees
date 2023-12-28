package in.dsa.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class PostOrderTraversalIterative1Stack {
	
	
	public static List<Node> postOrderUsing1Stack(Node root){
		
		if(root == null) return null;
		
		Node curr = root;
		
		//Empty Stack::
		Stack<Node> stack = new Stack<>();
		
		List<Node> list = new ArrayList<>();
		
		while(curr != null || !stack.isEmpty()) {
			
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			else {
				
				Node temp = stack.peek().right;
				
				if(temp == null) {
					
					temp = stack.pop();
					
					//Adding to the list::
					list.add(temp);
					
					while(!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						list.add(temp);
					}
					
				}
				else
					curr = temp;
				
			}
			
		}
		
		return list;
	}
	
	
	
	
	
	private static class Node{
		Node left;
		Node right; 
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
