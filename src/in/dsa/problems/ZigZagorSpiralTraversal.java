package in.dsa.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ZigZagorSpiralTraversal {

	public static List<int[]> zigzagLevelOrder(Node root){
		
		List<int[]> list = new ArrayList<>();
		
		if(root == null) return list;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		boolean leftToRight = true;
		
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			int[] array = new int[size];
			
			for(int i = 0; i < size; i++) {
				
				Node node = queue.poll();
				
				//find the position to fill the array:
				int index = leftToRight ? i : (size-i-1);
				
				array[index] = node.data;
				
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
				
			}
			
			leftToRight = !leftToRight;
			list.add(array);
			
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
