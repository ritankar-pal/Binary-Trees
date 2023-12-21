package in.dsa.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class LevelOrderTraversalRecursive {

	public List<List<Integer>> levelOrder(Node root){
		
		Queue<Node> queue = new LinkedList<>();
		
		List<List<Integer>> wrapList = new ArrayList<>();
		
		if(root == null) return wrapList;
		
		//Adding the root node first in the queue::
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			int levelNum = queue.size();  //1 2
			
			List<Integer> subList = new ArrayList<>();
			
			for(int i = 0; i < levelNum; i++) {
				
				if(queue.peek().left != null) queue.add(queue.peek().left);
				if(queue.peek().right != null) queue.add(queue.peek().right);
				
				subList.add(queue.poll().value);
			}
			
			wrapList.add(subList);
		}
		
		return wrapList;

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
