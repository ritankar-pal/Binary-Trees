package in.dsa.problems;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT {

	public String serialize(BinaryTreeNode<Integer> root) {
		
		if(root == null) return "";
		
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		StringBuilder builder = new StringBuilder();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			BinaryTreeNode<Integer> node = queue.poll();
			
			if(node == null) {
				builder.append("# ");
				continue;
			}
			
			builder.append(node.data + " ");
			queue.add(node.left);
			queue.add(node.right);
			
		}
		
		return builder.toString();
	}
	
	
	public BinaryTreeNode<Integer> deSerialize(String data){
		
		if(data == "") return null;
		
		String[] values = data.split(" ");
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(Integer.parseInt(values[0]));
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		
		queue.add(root);
		
		for(int i = 1; i < values.length; i++ ) {
			
			BinaryTreeNode<Integer> node = queue.poll();
			
			if(!values[i].equals("#")) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(Integer.parseInt(values[i]));
				node.left = leftNode;
				queue.add(leftNode);
			}
			
			if(!values[++i].equals("#")) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(Integer.parseInt(values[i]));
				node.right = rightNode;
				queue.add(rightNode);
			}
			
		}
		return root;
	}
	
	
	
	private class BinaryTreeNode<T> { 
		T data; 
		BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { this.data = data; } 

	}


}
