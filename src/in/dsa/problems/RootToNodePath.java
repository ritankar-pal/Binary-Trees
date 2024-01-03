package in.dsa.problems;

import java.util.ArrayList;
import java.util.List;


public class RootToNodePath {
	
	
	
	private boolean helper(Node root, List<Integer> list, int target) {
		
		if(root == null) return false;
		
		//Add the current node in the list:
		list.add(root.data);
		
		//if root == target, return true;
		if(root.data == target) return true;
		
		boolean left = helper(root.left, list, target);
		if(left) return true;
		
		boolean right = helper(root.right, list, target);
		if(right) return true;
		
		//if both left and right is false, then target node isn't present in either left or right so we remove the last elem:
		list.remove(list.size()-1);
		
		return false;
		
	}
	
	
	public List<Integer> getPath(Node root, int target){
		
		List<Integer> list = new ArrayList<>();
		
		if(root == null) return list;
		
		helper(root, list, target);
		
		return list;
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
