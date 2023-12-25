package in.dsa.problems;
import java.util.LinkedList;
import java.util.Queue;


public class PrintLevelWiseBinaryTree {
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root == null) return; 

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){

			BinaryTreeNode<Integer> temp = queue.poll();

			System.out.print(temp.data + ":");

			if(temp.left != null){
				System.out.print("L:" + temp.left.data + ",");
				queue.add(temp.left);
			}
			else{
				System.out.print("L:-1" + ",");
			}

			if(temp.right != null){
				System.out.print("R:" + temp.right.data);
				queue.add(temp.right);
			}
			else{
				System.out.print("R:-1");
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
