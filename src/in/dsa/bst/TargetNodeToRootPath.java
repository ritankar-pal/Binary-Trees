package in.dsa.bst;

import java.util.ArrayList;

public class TargetNodeToRootPath {

	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		
		if(root == null) return null;


		if(root.data == data){
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.data);
			return list;
		}


		if(root.data > data){
			ArrayList<Integer> left = getPath(root.left, data);

			if(left != null){
				left.add(root.data);
				return left;
			}

		}
		else{
			ArrayList<Integer> right = getPath(root.right, data);

			if(right != null){
				right.add(root.data);
				return right;
			}
		}

		return null;

	}


	private static class BinaryTreeNode<T> { 
		T data; 
		BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;
		public BinaryTreeNode(T data) 
		{ 
			this.data = data; 
		}
	}

}
