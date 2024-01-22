package in.dsa.problems;

import java.util.HashMap;
import java.util.Map;


public class BTFromPostAndInOrderTraversal {


	public BinaryTreeNode<Integer> buildTree(int[] inOrder, int[] postOrder){

		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

		//Hashing:
		for(int i = 0; i < inOrder.length; i++) {
			inMap.put(inOrder[i], i);
		}

		BinaryTreeNode<Integer> root = helperTree(inOrder, 0, inOrder.length-1, postOrder, 0, postOrder.length-1, inMap);

		return root;
	}


	private BinaryTreeNode<Integer> helperTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd,
			Map<Integer, Integer> map) {
		
		if(inStart > inEnd || postStart > postEnd) return null;
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postOrder[postEnd]);
		
		int inRoot = map.get(postOrder[postEnd]);
		
		int numsLeft = inRoot - inStart;
		
		
		root.left = helperTree(inOrder, inStart, inEnd - 1, postOrder, postStart, postStart + numsLeft - 1, map);
		root.right = helperTree(inOrder, inRoot + 1, inEnd, postOrder, postStart + numsLeft, postEnd - 1, map);
		
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
