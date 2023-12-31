package in.dsa.problems;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalPrint {

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root == null) return;

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

		//Adding root in the queue:
		queue.add(root);

		while(!queue.isEmpty()){

			int size = queue.size(); //1 2

			for(int i = 0; i < size; i++){
				BinaryTreeNode<Integer> node = queue.poll(); //10 20 30

				System.out.print(node.data + " ");

				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}

			System.out.println();

		}
	}
	
	
	private static class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
