package in.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class BTFromPreAndInOrderTraversal {
	
	
	public BinaryTreeNode<Integer> buildTree(int[] inOrder, int[] preOrder){
		
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
		
		//Hashing:
		for(int i = 0; i < inOrder.length; i++) {
			inMap.put(inOrder[i], i);
		}
		
		BinaryTreeNode<Integer> root = helperTree(inOrder, 0, inOrder.length-1, preOrder, 0, preOrder.length-1, inMap);
		
		return root;
	}
	
	
	public BinaryTreeNode<Integer> helperTree(int[] inOrder, int inStart, int inEnd, int[] preOrder , int preStart, int preEnd, 
			Map<Integer, Integer> inMap){
	
		if(preStart > preEnd || inStart > inEnd) return null;
		
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[preStart]);
		
		Integer inRoot = inMap.get(root.data);
		
		int numsLeft = inRoot - inStart; 
		
		root.left = helperTree(inOrder, inStart, inRoot - 1, preOrder, preStart + 1, preStart + numsLeft, inMap);
		root.right = helperTree(inOrder, inRoot + 1, inEnd, preOrder, preStart + numsLeft + 1, preEnd, inMap);
		
		return root;
	}
	
	
	
	private class BinaryTreeNode<T> 
	{ 
		T data; 
		BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { this.data = data; } 

	}
}
