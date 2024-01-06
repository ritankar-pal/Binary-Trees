package in.dsa.problems;

import java.util.LinkedList;
import java.util.Queue;



public class MaxWidthOfBT {
	
	public int widthOfBinaryTree(Node root) {
		
		if(root == null) return 0;
		
		int ans = 0;
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			int minIndex = queue.peek().index;
			int first = 0, last = 0;
			
			for(int i = 0; i < size; i++) {
				
				Pair pair = queue.poll();
				Node node = pair.node;
				int currId = pair.index - minIndex;
				
				if(i == 0) first = currId;
				if(i == size-1) last = currId;
				
				if(node.left != null)
					queue.add(new Pair(node.left, currId*2 + 1));
				
				if(node.right != null)
					queue.add(new Pair(node.right, currId*2 + 2));
			}
			
			ans = Math.max(ans, last-first+1);
			
		}
		return ans;
	}




	class Pair{
		Node node;
		int index;

		public Pair(Node node, int index) {
			this.node = node;
			this.index = index;  //line
		}
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
