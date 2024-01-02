package in.dsa.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;






public class BottomView {

	//
	public List<Integer> bottomView(Node root){

		List<Integer> list = new ArrayList<>();

		if(root == null) return list;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue  = new LinkedList<>();

		queue.add(new Pair(root, 0));


		while(!queue.isEmpty()) {

			Pair pair = queue.poll();

			Node node = pair.node;
			Integer vertical = pair.vertical;
			
			map.put(vertical, node.data);
			
			if(node.left != null) queue.add(new Pair(node, vertical-1));
			if(node.right != null) queue.add(new Pair(node, vertical+1));

		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer value = entry.getValue();
			list.add(value);
		}

		return list;
	}



	private class Pair{
		Node node;
		Integer vertical;

		public Pair(Node node, Integer vertical) {
			this.node = node;
			this.vertical = vertical;  //line
		}
	}


	private class Node{
		Node left;
		Node right;
		int data; 

		public Node(int data) {
			this.data = data;
		}
	}
}	
