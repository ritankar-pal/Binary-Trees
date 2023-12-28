package in.dsa.problems;

import java.util.ArrayList;
import java.util.List;



public class AntiClockwiseBoundaryTraversal {
	
	public List<Integer> boundaryAnticlockwise(Node root){
		
		List<Integer> list = new ArrayList<>();
		
		if(root == null) return list;
		
		list.add(root.data);
		
		leftTraversal(root.left, list);
		rightTraversal(root.right, list);
		
		return list;
	}
	
	private void rightTraversal(Node node, List<Integer> list) {
		
		if(node == null) return;
		
		rightTraversal(node.left, list);
		rightTraversal(node.right, list);
		
		list.add(node.data);
	}

	private void leftTraversal(Node node, List<Integer> list) {
		
		if(node == null) return;
		
		list.add(node.data);
		
		leftTraversal(node.left, list);
		leftTraversal(node.right, list);
		
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
