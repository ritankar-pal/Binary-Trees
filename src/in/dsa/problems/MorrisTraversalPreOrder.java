package in.dsa.problems;

import java.util.ArrayList;
import java.util.List;

//Pre-Order:
public class MorrisTraversalPreOrder {

	public static List<Integer> getPreOrder(BinaryTreeNode<Integer> root){

		List<Integer> list = new ArrayList<>();
		BinaryTreeNode<Integer> curr = root;

		while(curr != null) {

			if(curr.left == null) {
				list.add(curr.data);
				curr = curr.right;
			}
			else {

				BinaryTreeNode<Integer> prev = curr.left;

				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}

				if(prev.right == null) {
					prev.right = curr;
					list.add(curr.data);
					curr = curr.left;
				}
				else {
					prev.right = null;
					curr = curr.right;
				}

			}

		}

		return list;
	}


	private class BinaryTreeNode<T> { 
		T data; 
		BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { this.data = data; } 

	}
}
