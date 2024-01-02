package in.dsa.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
	Node node;
	int vertical;
	
	public Pair(Node node, int vertical) {
		this.node = node;
		this.vertical = vertical;  //line
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



public class TopViewOfBT {

	public static List<Integer> topView(Node root){
		
		List<Integer> list = new ArrayList<>();
		
		if(root == null) return list;
		
		
		Queue<Pair> queue = new LinkedList<>();
		 
		Map<Integer, Integer> map = new TreeMap<>();  //map<vertical, node>
		
		//Adding the root in the queue:
		queue.add(new Pair(root, 0));
		
		
		while(!queue.isEmpty()) {
			
			Pair pair = queue.poll();
		
			Node node = pair.node;  //value
			Integer vertical = pair.vertical;  //key
			
			//if the vertical (line) i.e. key doesn't exist in map we will add it:
			if(map.get(vertical) == null) map.put(vertical, node.data);
			
			
			if(node.left != null) queue.add(new Pair(node.left, vertical-1));
			if(node.right != null) queue.add(new Pair(node.right, vertical+1));
			
		}
		
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer value = entry.getValue();
			list.add(value);
		}

		
		return list;
	}

}
